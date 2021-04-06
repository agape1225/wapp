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
            model.addAttribute("lectureList",lectureList);
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
    public String barohome(Model model, @RequestParam(value = "category", defaultValue = "all") String categoty,
                           @RequestParam(value = "sort", defaultValue = "latest") String sortKey) {
        System.out.println("바로수강페이지");
        System.out.println(categoty);
        System.out.println(sortKey);
        try {
            if (categoty.equals("all")){
                ArrayList<LectureDto> sortedList = lectureSort(lectureService.readBasicDataList(), sortKey);
                model.addAttribute("lectureList", sortedList);
            } else {
                ArrayList<LectureDto> sortedList = lectureSort(lectureService.readBasicDataByLecCategory(categoty), sortKey);
                model.addAttribute("lectureList", sortedList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "baro";
    }

    private ArrayList<LectureDto> lectureSort(ArrayList<LectureDto> lectureList, String sortKey) {
        if (sortKey.equals("latest")) {
            lectureList.sort((l1, l2) -> {
                String RegDate1 = l1.getLecRegDate().replace("-", "");
                String RegDate2 = l2.getLecRegDate().replace("-", "");
                int Date1 = Integer.parseInt(RegDate1);
                int Date2 = Integer.parseInt(RegDate2);
                return Date2 - Date1; // 최신순
            });
        } else if (sortKey.equals("popular")) { // 인기순으로 정렬하기 (미구현)

        }

        return lectureList;
    }


}
