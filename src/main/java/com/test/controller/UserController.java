package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.service.lecture.LectureService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;

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
            System.out.println("Start main");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();
            ArrayList<LectureDto> newLectureList = lectureService.readBasicDataByRegDateDesc();
            ArrayList<LectureDto> popularLectureList = lectureService.readBasicDataByPopularity();
            model.addAttribute("lectureList", lectureList);
            model.addAttribute("newLectureList", newLectureList);
            model.addAttribute("popularLectureList", popularLectureList);
            System.out.println("End main");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("admin/user/data-table")
    public String user_manage(Model model){
        try{
            System.out.println("Start manage_user");
            ArrayList<UserDto> userList =  userService.readUserInfoList();

            model.addAttribute("userList", userList);
            System.out.println("end manageUser");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/user/data-table";
    }


    @GetMapping("/admin/user/delete")
    public String delete_lec(@RequestParam(value = "userNo") String userNo) {
        System.out.println("Start delUser");

        try {
            System.out.println("userNo: \n\n\n" + userNo);
            userService.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/user/data-table";
    }

    @GetMapping("/baro")
    public String barohome(Model model, @RequestParam(value = "category", defaultValue = "all") String category,
                           @RequestParam(value = "sort", defaultValue = "latest") String sortKey) {
        System.out.println("바로수강페이지");
        System.out.println(category);
        System.out.println(sortKey);

        try {
            if (category.equals("all")){ // 모든강의 보기
                ArrayList<LectureDto> sortedList = lectureService.readAllLectureSortedByRegDate();

                switch (sortKey){
                    case "latest": // 최신순 정렬
                        // default: 최신순 정렬한 데이터 보내주기.
                        break;
                    case "popular": // 인기순 정렬
                        sortedList = lectureService.readAllLectureSortedByLikes();
                        break;
                    default:
                        break;
                }
                model.addAttribute("lectureList", sortedList);

            } else { // 카테고리별 보기
                ArrayList<LectureDto> sortedList = lectureService.readLectureSortedByRegDate(category);
                switch (sortKey){
                    case "latest": // 최신순 정렬
                        // default로 최신순 정렬한 데이터 보내주기.
                        break;
                    case "popular": // 인기순 정렬
                        sortedList = lectureService.readLectureSortedByLikes(category);
                        break;
                    default:
                        break;
                }
                model.addAttribute("lectureList", sortedList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedSortkey", sortKey);
        return "baro";
    }
}
