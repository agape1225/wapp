package com.test.controller;

import com.test.dto.LectureDto;
import com.test.service.lecture.LectureService;
import com.test.service.recommended.RecommendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class RecommendedController {
    @Autowired
    RecommendedService recommendedService;

    @Autowired
    LectureService lectureService;

    @GetMapping("admin/recommended/form")
    public String recommendedForm(Model model){
        try{
            System.out.println("Start manage lecture to be recommended");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataListNotInRec();

            model.addAttribute("lectureList", lectureList);
            System.out.println("end manage Lecture");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/recommended/form";
    }

    @GetMapping("admin/recommended/insert")
    public String insertRecommended(@RequestParam(value = "lecNo") String lecNo){
        recommendedService.insertRecommended(lecNo);
        return "redirect:/admin/recommended/form";
    }

    @GetMapping("admin/recommended/data-table")
    public String recommendedDataTable(Model model){
        try{
            System.out.println("Start manage_lecture");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataListInRec();

            model.addAttribute("lectureList", lectureList);
            System.out.println("end manageLecture");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/recommended/data-table";
    }

    @GetMapping("/admin/recommended/delete")
    public String deleteRecommended(@RequestParam(value = "lecNo") String lecNo) {
        try {
            System.out.println("lecNo: \n\n\n" + lecNo);
            recommendedService.deleteRecommended(lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/recommended/data-table";
    }
}
