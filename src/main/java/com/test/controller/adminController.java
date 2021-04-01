package com.test.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.test.dto.AdminLoginDto;
import com.test.dto.LectureDto;
import com.test.dto.PopupDto;
import com.test.service.adminLogin.AdminLoginService;
import com.test.service.lecture.LectureService;
import com.test.service.popup.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Controller
public class adminController {


    @Autowired
    AdminLoginService adminloginService;
    @Autowired
    PopupService popupService;
    @Autowired
    LectureService lectureService;


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


    @GetMapping("admin/login/banner/form.do")
    public String manage_banner(Model model){
        try{
            System.out.println("Start manage_banner");


        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/form";
    }

    @GetMapping("admin/login/banner/data-table.do")
    public String banner_manage(Model model){
        try{
            System.out.println("Start manage_banner");


        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/data-table";
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

    @GetMapping("admin/login/lecture/form.do")
    public String manage_lecture(Model model){
        try{
            System.out.println("Start manage_lecture");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();

            if(lectureList.size() > 4){
                while(lectureList.size() > 4){
                    lectureList.remove(0);
                }
            }

            Collections.reverse(lectureList);

            model.addAttribute("lectureList", lectureList);
            System.out.println("end manageLecture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/lecture/form";
    }

    @GetMapping("admin/login/lecture/data-table.do")
    public String lecture_manage(Model model){
        try{
            System.out.println("Start manage_lecture");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();

            if(lectureList.size() > 4){
                while(lectureList.size() > 4){
                    lectureList.remove(0);
                }
            }

            Collections.reverse(lectureList);

            model.addAttribute("lectureList", lectureList);
            System.out.println("end manageLecture");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/lecture/data-table";
    }

    @GetMapping("admin/login/popup/form.do")
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
        return "admin/popup/form";
    }

    @GetMapping("admin/login/popup/data-table.do")
    public String popup_manage(Model model){
        try{
            System.out.println("Start manage_popup");
            ArrayList<PopupDto> popupList;
            popupList = popupService.getPopupList();
            System.out.println(popupList.get(0).getImg());
            model.addAttribute("popupList", popupList);


        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/popup/data-table";
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
                return "admin/home";
            }else{
                return "adminLogin";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "adminLogin";
        }
    }




}
