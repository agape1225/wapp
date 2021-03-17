package com.test.controller;

import com.test.dto.TestDto;
import com.test.service.lecture.LectureService;
import com.test.service.test.TestService;
import com.test.util.firebase.FirebaseMessagingSnippets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class LectureController {

    @Autowired
    LectureService lectureService;


    @GetMapping("/admin/login/insert")
    public String main(Model model){
        try{

            String category = "testCategory";
            String name = "testName";
            String price = "1111";

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String date = sdf.format(d);

            lectureService.insertLecture(category, name, price, date);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/";
    }
  
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "lecNo") String lecNo){
        try{
            System.out.println("lecNo: " + lecNo);
            lectureService.deleteLecture(lecNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
