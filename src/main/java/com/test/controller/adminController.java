package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.service.adminLogin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class adminController {


    @Autowired
    AdminLoginService adminloginService;

    @GetMapping("/admin")
    public String main(Model model){
        try{
            System.out.println("Start adminLogin");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "adminLogin";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(Model model, @RequestParam(value = "id") String id, @RequestParam(value = "password") String password){
        try{
            System.out.println("id: " + id);
            System.out.println("password: " + password);
            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            AdminLoginDto result = loginInfo.get(0);

            //model.addAttribute("img", "/resources/img/test.png");

            if(id.equals(result.getId()) && password.equals(result.getPassword())){
                return "admin";
            }else{
                return "adminLogin";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "adminLogin";
        }
    }




}
