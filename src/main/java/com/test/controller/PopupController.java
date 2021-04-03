package com.test.controller;

import com.test.dto.PopupDto;
import com.test.service.popup.PopupService;
import com.test.util.firebase.FirebaseMessagingSnippets;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class PopupController {
    @Autowired
    PopupService popupService;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;
    @Autowired
    ServletContext servletContext;

    private final String relativePath = "/files/popupImage/";
    private final SimpleDateFormat dateForServer = new SimpleDateFormat("yyyyMMddHHmmss_");
    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    /////////////////////////////////////////////// CREATE
    @GetMapping("admin/login/popup/form")
    public String manage_popup(Model model){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/popup/form";
    }

    @PostMapping("admin/login/popup/form")
    public String add_popup(PopupDto popupDto, MultipartFile popImage, HttpServletRequest request){
        try{
            Date currentTime = new Date();
            String regDateForDB = dateForDB.format(currentTime);
            String regDateForServer = dateForServer.format(currentTime);
            String fullName = relativePath + regDateForServer + popImage.getOriginalFilename();

            popupDto.setPopRegDate(regDateForDB); // 새로운 이미지이름 저장
            popupDto.setPopImg(fullName); // 새로운 이미지이름 저장

            popupService.addItem(popupDto); //DB에 저장
            saveImageOnServer(request, popImage, fullName); //서버에 저장

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/login/popup/data-table";
    }

    /////////////////////////////////////////////// READ
    @GetMapping("admin/login/popup/data-table")
    public String popup_manage(Model model){
        try{
            System.out.println("Start manage_popup");
            ArrayList<PopupDto> popupList = popupService.getPopupList();
            model.addAttribute("popupList", popupList);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/popup/data-table";
    }

    /////////////////////////////////////////////// DELETE
    @GetMapping("admin/login/popup/delete")
    public String delete(@RequestParam(value = "popNo") String popNo){
        try{
            PopupDto dbPopup = popupService.selectItem(popNo); // popNo로 삭제할 강의 정보 가져오기
            String dirPath = servletContext.getRealPath("/"); // 경로 가져오기
            File targetFile = new File(dirPath + dbPopup.getPopImg()); // 삭제할 파일선언
            String delName = targetFile.getName(); // 삭제할 파일 이름 변수에 저장
            if (targetFile.delete()) { // 파일 삭제
                System.out.println("Deleted the file: " + delName);
            } else {
                System.out.println("Failed to delete the file.");
            }
            popupService.deleteItem(popNo); //DB에서 팝업 삭제
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/login/popup/data-table";
    }

    /////////////////////////////////////////////// UPDATE
    @GetMapping("/admin/login/popup/edit") // 수정 폼
    public String editForm(@RequestParam(value = "popNo") String popNo, Model model){
        try{
            System.out.println("popNo: " + popNo);
            PopupDto popup = popupService.selectItem(popNo);
            model.addAttribute("popup", popup);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/popup/edit";
    }

    @RequestMapping(value = "/admin/login/editPopup", method = {RequestMethod.POST, RequestMethod.GET}) // 수정
    public String editPopup(@Param("popNo") String popNo, PopupDto popupDto, MultipartFile popImage, HttpServletRequest request){
        try{
            System.out.println("start edit");
            System.out.println(popNo);
            PopupDto dbPopup = popupService.selectItem(popNo); // popNo로 db에있는 배너 가져오기

            String filename = popImage.getOriginalFilename();
            if (filename.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItem Without Img");
                popupDto.setPopImg(dbPopup.getPopImg()); // db에 있던 배너이미지를 그대로 넣어주기
            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItem With Img");

                File targetFile = new File(servletContext.getRealPath("/") + dbPopup.getPopImg()); // 서버에있는 삭제할 배너파일 지정
                String delName = targetFile.getName(); // 삭제될 배너파일이름
                if (targetFile.delete()) { // 삭제 성공시
                    System.out.println("Deleted the file: " + delName);
                } else { // 삭제 실패시
                    System.out.println("Failed to delete the file.");
                }

                String regDateForServer = dateForServer.format(new Date());
                String fullName = relativePath + regDateForServer + popImage.getOriginalFilename();
                popupDto.setPopImg(fullName); // 새로운 이미지이름 저장
                saveImageOnServer(request, popImage, fullName); // 서버에 파일 저장
            }
            popupService.editItem(popupDto); // db에 저장
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/login/popup/data-table";
    }

    private static void saveImageOnServer(HttpServletRequest request, MultipartFile Image, String fullName){
        String root_path = request.getSession().getServletContext().getRealPath("/");
        File saveFile = new File(root_path + fullName);
        try {
            Image.transferTo(saveFile); // 서버에 파일 저장
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("saveName: "+ root_path + fullName);
    }
}
