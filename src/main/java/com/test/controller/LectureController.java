package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class LectureController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    private final String relativePath = "/files/lectureImage/";
    private final SimpleDateFormat dateForServer = new SimpleDateFormat("yyyyMMddHHmmss_");
    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    //////////////////////////////////////// CREATE
    @GetMapping("admin/lecture/form")
    public String manage_lecture(Model model){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/lecture/form";
    }

    @PostMapping("/admin/addLecture")
    public String insert(LectureDto lectureDto, MultipartFile lecImage) throws IOException {

        Date currentTime = new Date();
        String regDateForDB = dateForDB.format(currentTime);
        String regDateForServer = dateForServer.format(currentTime);
        String fullName = relativePath + regDateForServer + lecImage.getOriginalFilename();

        lectureDto.setLecRegDate(regDateForDB); // 현재시간 저장
        lectureDto.setLecImg(fullName); // 이미지이름 저장
        lectureDto.setLecLike("0");

        String root_path = servletContext.getRealPath("/");
        String filename_server = root_path + fullName;

        System.out.println(lectureDto.getLecCategory());
        System.out.println(lectureDto.getLecName());
        System.out.println(lectureDto.getLecPrice());
        System.out.println(regDateForDB);
        System.out.println(fullName);

        FileCopyUtils.copy(lecImage.getBytes(), new File(filename_server)); // 서버에 저장
        lectureService.insertLecture(lectureDto); // DB에 저장

        return "redirect:/admin/lecture/data-table";
    }

    //////////////////////////////////////// READ
    @GetMapping("admin/lecture/data-table")
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
    @GetMapping("/admin/lecture/edit")
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

    @RequestMapping(value = "/admin/editLecture", method = {RequestMethod.POST, RequestMethod.GET})
    public String update_lecture(@RequestParam(value = "lecNo") String lecNo, LectureDto lectureDto, MultipartFile lecImage, Model model) {

        System.out.println("Start update lecture");

        try {
            LectureDto lectureInDb = lectureService.readBasicDataByLecNo(lecNo);
            System.out.println(lectureInDb.getLecName());
            String filename = lecImage.getOriginalFilename();
            if (filename.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItemWithoutImg");

                lectureDto.setLecImg(lectureInDb.getLecImg()); // db에 있던 배너이미지를 그대로 넣어주기
            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItemWithImg");

                String root_path = servletContext.getRealPath("/");
                File targetFile = new File(root_path + lectureInDb.getLecImg()); // 서버에있는 삭제할 강의파일 지정
                String delName = targetFile.getName(); // 삭제될 강의파일이름
                if (targetFile.delete()) {
                    System.out.println("Deleted file : " + delName);
                } else {
                    System.out.println("Failed to delete the file.");
                }

                Date currentTime = new Date();
                String regDateForServer = dateForServer.format(currentTime);
                String fullName = relativePath + regDateForServer + filename;
                lectureDto.setLecImg(fullName); // 이미지이름 저장


                String filename_server = root_path + fullName;
                FileCopyUtils.copy(lecImage.getBytes(), new File(filename_server)); // 서버에 저장
            }
            lectureDto.setLecCategory(lectureInDb.getLecCategory());
            System.out.println(lectureDto.getLecCategory());
            System.out.println(lectureDto.getLecName());
            System.out.println(lectureDto.getLecPrice());
            System.out.println(lectureDto.getLecImg());
            lectureService.updateLecture(lecNo, lectureDto); // db에 저장


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/lecture/data-table";
    }

    //////////////////////////////////////// DELETE
    @GetMapping("/admin/lecture/delete")
    public String delete_lec(@RequestParam(value = "lecNo") String lecNo) {
        System.out.println("Start delLecture");

        try {
            System.out.println("lecNo: \n\n\n" + lecNo);
            lectureService.deleteLecture(lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/lecture/data-table";
    }

}
