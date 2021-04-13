package com.test.controller;

import com.test.dto.BannerDto;
import com.test.dto.BenefitDto;
import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.service.banner.BannerService;
import com.test.service.benefit.BenefitService;
import com.test.service.lecture.LectureService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    @Autowired
    BannerService bannerService;

    @Autowired
    BenefitService benefitService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main(Model model){
        try{

            System.out.println("Start main");

            ArrayList<BannerDto> bannerList = bannerService.readBasicDataList();
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataListInRec();
            ArrayList<LectureDto> newLectureList = lectureService.readBasicDataByRegDateDesc();
            ArrayList<BenefitDto> benefitList = benefitService.getBenefitList();
            ArrayList<LectureDto> popularLectureList = lectureService.readBasicDataByPopularity();
            model.addAttribute("bannerList", bannerList);
            model.addAttribute("lectureList", lectureList);
            model.addAttribute("newLectureList", newLectureList);
            model.addAttribute("benefitList", benefitList);
            model.addAttribute("popularLectureList", popularLectureList);
            System.out.println("End main");
        }catch (Exception e){
            e.printStackTrace();
            return "404";
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
            return "404";
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
            return "404";
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
            return "404";
        }
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedSortkey", sortKey);
        return "baro";
    }

    @GetMapping("/user/myPage")
    public String getLectureListByUserNo(HttpServletRequest request, Model model) {
        try{
            HttpSession session = request.getSession();
            UserDto userInfo = (UserDto) session.getAttribute("userLogin");
            ArrayList<LectureDto> lectureList = lectureService.readBasicDatListByUserNo(userInfo.getUserNo());
            for (LectureDto lectureDto : lectureList) {
                System.out.println(lectureDto.getLecNo()
                        + lectureDto.getLecCategory()
                        + lectureDto.getLecName()
                        + lectureDto.getLecPrice()
                        + lectureDto.getLecRegDate()
                        + lectureDto.getLecImg());
            }
            model.addAttribute("userInfo", userInfo);
            model.addAttribute("lectureList", lectureList);
        } catch (Exception e) {
            System.out.println("!!!getLectureListByUserNo Error!!!");
            e.printStackTrace();
            return "404";
        }
        return "myPage";
    }
}
