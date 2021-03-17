package com.test.controller;

import com.test.dto.LectureDto;
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

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/admin/login/lecture_list")
    public String test(Model model){
        try{
            ArrayList<LectureDto> lectureList = lectureService.readBasicData();
            model.addAttribute("lectureList", lectureList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "lecture_list";
    }


    /*@RequestMapping(value = "/post.do", method = RequestMethod.POST)
    public String post(@RequestParam(value = "data") String data){
        try{
            System.out.println("post방식 data: " + data);
            testService.addItem(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/test.do";
    }*/


}
