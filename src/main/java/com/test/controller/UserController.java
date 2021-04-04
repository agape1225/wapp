package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.service.lecture.LectureService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main(Model model){
        try{
            System.out.println("Start main");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();
            model.addAttribute("lectureList",lectureList);
            System.out.println("End main");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("admin/user/data-table.do")
    public String user_manage(Model model){
        try{
            System.out.println("Start manage_user");
            ArrayList<UserDto> userList =  userService.readUserInfoList();

            model.addAttribute("userList", userList);
            System.out.println("end manageUser");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/user/data-table";
    }


    @GetMapping("/admin/user/delete.do")
    public String delete_lec(@RequestParam(value = "userNo") String userNo) {
        System.out.println("Start delUser");

        try {
            System.out.println("userNo: \n\n\n" + userNo);
            userService.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/user/data-table.do";
    }

    @GetMapping("/baro")
    public String barohome(Model model, @RequestParam(value = "category", defaultValue = "취미") String categoty) {
        System.out.println("바로수강페이지");
        System.out.println(categoty);
        try {
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataByLecCategory(categoty);
            model.addAttribute("lectureList", lectureList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "baro";
    }


}
