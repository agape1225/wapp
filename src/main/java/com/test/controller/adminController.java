package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.service.adminLogin.AdminLoginService;
import com.test.service.lecture.LectureService;
import com.test.service.popup.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class adminController {


    @Autowired
    AdminLoginService adminloginService;
    @Autowired
    PopupService popupService;
    @Autowired
    LectureService lectureService;


    @GetMapping("/admin")
    public String main(Model model, HttpSession session){
        try{
            System.out.println("Start adminLogin");
            Object loginInfo = session.getAttribute("adminLogin");
            if (loginInfo != null) {// 로그인정보가 이미 있으면 바로 홈으로 보내주기
                return "redirect:/admin/login/home";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "adminLogin";
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam(value = "id") String id,
                             @RequestParam(value = "password") String password,
                             HttpSession session){
        try{
            System.out.println("id: " + id);
            System.out.println("password: " + password);
            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            AdminLoginDto result = loginInfo.get(0);

            if(id.equals(result.getId()) && password.equals(result.getPassword())){
                session.setAttribute("adminLogin",result);
                return "redirect:/admin/login/home";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/login/home")
    public String admin_home(Model model){
        try{
            System.out.println("welcome admin home");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/home";
    }

    /////////////////////////////////////////////// 배너
    @GetMapping("admin/login/banner/form")
    public String manage_banner(Model model){
        try{
            System.out.println("Start manage_banner");


        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/form";
    }

    @GetMapping("admin/login/banner/data-table")
    public String banner_manage(Model model){
        try{
            System.out.println("Start manage_banner");


        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/data-table";
    }
}
