package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.service.lecture.LectureService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

            System.out.printf("Start main");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();
            System.out.println(lectureList.size());
            for(int i = 0; i < lectureList.size(); i++){
                System.out.println(lectureList.get(i).getLecName());
            }
            model.addAttribute("lectureList",lectureList);
            System.out.printf("End main");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/user/login/userDetlete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "userNo") String userNo) {

        try {
            System.out.println("userNo: " + userNo);
            userService.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }

    @GetMapping(value = "/user/login/userList")
    public String readUserInfoList(Model model){
        ArrayList<UserDto> userList =  userService.readUserInfoList();
        model.addAttribute("userList", userList);

        return "user/login/userList";
    }

    @GetMapping(value = "/user/login/user_data")
    public String readUserInfoListByUserNo(@RequestParam(value = "userNo") String userNo, Model model){
        UserDto user =  userService.readUserInfoListByUserNo(userNo);
        model.addAttribute("user_detail", user);

        return "user/login/user_data";
    }
}
