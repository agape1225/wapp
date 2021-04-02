package com.test.controller;

import com.test.dto.LectureDto;
import com.test.service.lecture.LectureService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LectureController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    //////////////////////////////////////// CREATE
    @GetMapping("admin/login/lecture/form.do")
    public String manage_lecture(Model model){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/lecture/form";
    }

    @PostMapping("/admin/login/addLecture.do")
    public String insert(LectureDto lectureDto, MultipartFile lecImage, RedirectAttributes redirect) throws IOException {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder =  "/files/img/";
        System.out.println(webappRoot + relativeFolder);
        String filename = webappRoot + relativeFolder + lecImage.getOriginalFilename();
        String lecFileName = relativeFolder + lecImage.getOriginalFilename();

        System.out.println(lectureDto.getLecCategory());
        System.out.println(lectureDto.getLecName());
        System.out.println(lectureDto.getLecPrice());
        System.out.println(date);
        System.out.println(lecFileName);

        lectureDto.setLecRegDate(date);
        lectureDto.setLecImg(lecFileName);

        FileCopyUtils.copy(lecImage.getBytes(), new File(filename));

        lectureService.insertLecture(lectureDto);

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("id", "root");
        map.put("password", "1234");
        redirect.addFlashAttribute("vo", map);

        return "redirect:/admin/login/lecture/data-table.do";
    }

    //////////////////////////////////////// READ
    @GetMapping("admin/login/lecture/data-table.do")
    public String lecture_manage(Model model){
        try{
            System.out.println("Start manage_lecture");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();

            model.addAttribute("lectureList", lectureList);
            System.out.println("end manageLecture");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/lecture/data-table";
    }

    //////////////////////////////////////// UPDATE
    @GetMapping("/admin/login/lecture/edit.do")
    public String update_lecture_form(@RequestParam(value = "lecNo") String lecNo,  Model model) {
        System.out.println("Start update lecture form");

        try {
            LectureDto lecDto = lectureService.readBasicDataByLecNo(lecNo);
            model.addAttribute("lecture",lecDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/lecture/edit";
    }

    @RequestMapping(value = "/admin/login/editLecture.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String update_lecture(@RequestParam(value = "lecNo") String lecNo, LectureDto lectureDto, MultipartFile lecImage, Model model) {
        System.out.println("Start update lecture");

        try {
            LectureDto lectureInDb = lectureService.readBasicDataByLecNo(lecNo);

            String filename = lecImage.getOriginalFilename();
            if (filename.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItemWithoutImg");

                lectureDto.setLecImg(lectureInDb.getLecImg()); // db에 있던 배너이미지를 그대로 넣어주기
            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItemWithImg");

                File targetFile = new File(servletContext.getRealPath("/") + lectureInDb.getLecImg()); // 서버에있는 삭제할 배너파일 지정
                String delName = targetFile.getName(); // 삭제될 배너파일이름
                if (targetFile.delete()) {
                    System.out.println("Deleted file : " + delName);
                } else {
                    System.out.println("Failed to delete the file.");
                }

                // 서버에 사진 저장
                String rootPath = servletContext.getRealPath("/");
                String relativeFolder =  "/files/img/";
                System.out.println(rootPath + relativeFolder);

                String serverFile = rootPath + relativeFolder + filename;

                FileCopyUtils.copy(lecImage.getBytes(), new File(serverFile)); // 서버에 이미지 저장

                lectureDto.setLecImg("/files/img/" + filename); // 새로운 이미지이름으로 dto객체의 이미지이름 저장
            }
            System.out.println(lectureDto.getLecCategory());
            System.out.println(lectureDto.getLecName());
            System.out.println(lectureDto.getLecPrice());
            System.out.println(lectureDto.getLecImg());
            lectureService.updateLecture(lecNo, lectureDto); // db에 저장


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login/lecture/data-table.do";
    }

    //////////////////////////////////////// DELETE
    @GetMapping("/admin/login/lecture/delete.do")
    public String delete_lec(@RequestParam(value = "lecNo") String lecNo) {
        System.out.println("Start delLecture");

        try {
            System.out.println("lecNo: \n\n\n" + lecNo);
            lectureService.deleteLecture(lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login/lecture/data-table.do";
    }

    @GetMapping("/user/login/myPage")
    public String getLectureListByUserNo(HttpServletRequest request, Model model) {
        try{
            HttpSession session = request.getSession();
            UserDto userLogin = (UserDto) session.getAttribute("userLogin");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDatListByUserNo(userLogin.getUserNo());
            for (LectureDto lectureDto : lectureList) {
                System.out.println(lectureDto.getLecNo()
                        + lectureDto.getLecCategory()
                        + lectureDto.getLecName()
                        + lectureDto.getLecPrice()
                        + lectureDto.getLecRegDate()
                        + lectureDto.getLecImg());
            }
            model.addAttribute("lectureList", lectureList);
        } catch (Exception e) {
            System.out.println("!!!getLectureListByUserNo Error!!!");
            e.printStackTrace();
        }
        return "myPage";
    }
}
