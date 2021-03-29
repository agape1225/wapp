package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.dto.PopupDto;
import com.test.service.adminLogin.AdminLoginService;
import com.test.service.popup.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class adminController {


    @Autowired
    AdminLoginService adminloginService;
    @Autowired
    PopupService popupService;


    @GetMapping("/admin")
    public String main(Model model){
        try{
            System.out.println("Start adminLogin");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "adminLogin";
    }


    @GetMapping("admin/login/admin-page")
    public String admin_page(Model model){
        try{
            System.out.println("Start admin_page");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/admin-page";
    }


    @GetMapping("admin/login/manage-banner")
    public String manage_banner(Model model){
        try{
            System.out.println("Start manage_banner");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-banner";
    }

    @GetMapping("admin/login/manage-category")
    public String manage_category(Model model){
        try{
            System.out.println("Start manage_category");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-category";
    }

    //@GetMapping("admin/manage-lecture")

    @GetMapping("admin/login/manage-lecture")

    public String manage_lecture(Model model){
        try{
            System.out.println("Start manage_lecture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-lecture";
    }

    @GetMapping("admin/login/manage-popup")
    public String manage_popup(Model model){
        try{
            System.out.println("Start manage_popup");
            ArrayList<PopupDto> popupList;
            popupList = popupService.getPopupList();
            System.out.println(popupList.get(0).getImg());
            model.addAttribute("popupList", popupList);


        }catch (Exception e){
            e.printStackTrace();
        }
        return "template/demo_1/manage-popup";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String adminLogin(Model model,
                             @RequestParam(value = "id") String id,
                             @RequestParam(value = "password") String password,
                             HttpServletRequest request,
                             HttpSession session){
        try{
            System.out.println("id: " + id);
            System.out.println("password: " + password);
            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            AdminLoginDto result = loginInfo.get(0);
            //model.addAttribute("img", "/resources/img/test.png");

            if(id.equals(result.getId()) && password.equals(result.getPassword())){
                session.setAttribute("adminLogin",result);
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
