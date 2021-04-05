package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.service.adminLogin.AdminLoginService;
import com.test.service.banner.BannerService;
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
    BannerService bannerService;


    @GetMapping("/admin")
    public String main(Model model){
        try{
            System.out.println("welcome admin home");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/home";
    }

    @GetMapping("/admin/login")
    public String loginForm(){
        try{
            System.out.println("Start adminLogin");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/login";
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
                return "redirect:/admin";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/login";
    }



    @GetMapping("admin/logout")
    public String logout(HttpSession session){
        try{
            System.out.println("admin logout");
            session.removeAttribute("adminLogin");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/login";
    }
}
