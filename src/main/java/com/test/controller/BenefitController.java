package com.test.controller;

import com.test.dto.BenefitDto;
import com.test.service.benefit.BenefitService;
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
public class BenefitController {
    @Autowired
    BenefitService benefitService;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;
    @Autowired
    ServletContext servletContext;

    private final String relativePath = "/files/benefitImage/";
    private final SimpleDateFormat dateForServer = new SimpleDateFormat("yyyyMMddHHmmss_");
    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    /////////////////////////////////////////////// CREATE
    @GetMapping("admin/benefit/form")
    public String manage_benefit(Model model){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/benefit/form";
    }

    @PostMapping("admin/benefit/form")
    public String add_benefit(BenefitDto benefitDto, MultipartFile benImage, HttpServletRequest request){
        try{
            Date currentTime = new Date();
            String regDateForDB = dateForDB.format(currentTime);
            String regDateForServer = dateForServer.format(currentTime);
            String fullName = relativePath + regDateForServer + benImage.getOriginalFilename();

            benefitDto.setBenRegDate(regDateForDB); // 새로운 이미지이름 저장
            benefitDto.setBenImg(fullName); // 새로운 이미지이름 저장

            benefitService.addItem(benefitDto); //DB에 저장
            saveImageOnServer(request, benImage, fullName); //서버에 저장

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/benefit/data-table";
    }

    /////////////////////////////////////////////// READ
    @GetMapping("admin/benefit/data-table")
    public String benefit_manage(Model model){
        try{
            System.out.println("Start manage_benefit");
            ArrayList<BenefitDto> benefitList = benefitService.getBenefitList();
            model.addAttribute("benefitList", benefitList);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/benefit/data-table";
    }

    /////////////////////////////////////////////// DELETE
    @GetMapping("admin/benefit/delete")
    public String delete(@RequestParam(value = "benNo") String benNo){
        try{
            System.out.println(benNo);
            BenefitDto dbBenefit = benefitService.selectItem(benNo); // benNo로 삭제할 강의 정보 가져오기
            String dirPath = servletContext.getRealPath("/"); // 경로 가져오기
            File targetFile = new File(dirPath + dbBenefit.getBenImg()); // 삭제할 파일선언
            String delName = targetFile.getName(); // 삭제할 파일 이름 변수에 저장
            if (targetFile.delete()) { // 파일 삭제
                System.out.println("Deleted the file: " + delName);
            } else {
                System.out.println("Failed to delete the file.");
            }
            benefitService.deleteItem(benNo); //DB에서 이벤트 삭제
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/benefit/data-table";
    }

    /////////////////////////////////////////////// UPDATE
    @GetMapping("/admin/benefit/edit") // 수정 폼
    public String editForm(@RequestParam(value = "benNo") String benNo, Model model){
        try{
            System.out.println("benNo: " + benNo);
            BenefitDto benefit = benefitService.selectItem(benNo);
            model.addAttribute("benefit", benefit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/benefit/edit";
    }

    @RequestMapping(value = "/admin/editBenefit", method = {RequestMethod.POST, RequestMethod.GET}) // 수정
    public String editBenefit(@Param("benNo") String benNo, BenefitDto benefitDto, MultipartFile benImage, HttpServletRequest request){
        try{
            System.out.println("start edit");
            System.out.println(benNo);
            BenefitDto dbBenefit = benefitService.selectItem(benNo); // benNo로 db에있는 배너 가져오기

            String filename = benImage.getOriginalFilename();
            if (filename.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItem Without Img");
                benefitDto.setBenImg(dbBenefit.getBenImg()); // db에 있던 배너이미지를 그대로 넣어주기
            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItem With Img");

                File targetFile = new File(servletContext.getRealPath("/") + dbBenefit.getBenImg()); // 서버에있는 삭제할 배너파일 지정
                String delName = targetFile.getName(); // 삭제될 배너파일이름
                if (targetFile.delete()) { // 삭제 성공시
                    System.out.println("Deleted the file: " + delName);
                } else { // 삭제 실패시
                    System.out.println("Failed to delete the file.");
                }

                String regDateForServer = dateForServer.format(new Date());
                String fullName = relativePath + regDateForServer + benImage.getOriginalFilename();
                benefitDto.setBenImg(fullName); // 새로운 이미지이름 저장
                saveImageOnServer(request, benImage, fullName); // 서버에 파일 저장
            }
            benefitService.editItem(benefitDto); // db에 저장
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/benefit/data-table";
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
