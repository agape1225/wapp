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

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("admin/admin-page")
    public String admin_page(Model model){
        try{
            System.out.println("Start manageLcture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/admin-page";
    }

    @GetMapping("admin/manage-banner")
    public String manage_banner(Model model){
        try{
            System.out.println("Start manageLcture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-banner";
    }

    @GetMapping("admin/manage-category")
    public String manage_category(Model model){
        try{
            System.out.println("Start manageLcture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-category";
    }


    @GetMapping("admin/manage-lecture")
    public String manage_lecture(Model model){
        try{
            System.out.println("Start manageLcture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-lecture";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(Model model, @RequestParam(value = "id") String id,
                             @RequestParam(value = "password") String password,
                             HttpServletRequest request){
        try{
            System.out.println("id: " + id);
            System.out.println("password: " + password);
            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            AdminLoginDto result = loginInfo.get(0);


            //model.addAttribute("img", "/resources/img/test.png");

            if(id.equals(result.getId()) && password.equals(result.getPassword())){
                return "template/demo_1/admin-page";
            }else{
                return "adminLogin";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "adminLogin";
        }
    }




}
