package com.test.controller;

import com.test.dao.LectureDao;
import com.test.dto.LectureDto;
import com.test.dto.LectureUpdateDto;
import com.test.dto.TestDto;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class LectureController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    @GetMapping("/admin/login/lecture_list")
    public String test(Model model) {
        try {
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();
            model.addAttribute("lectureList", lectureList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "lecNo") String lecNo) {

        try {
            System.out.println("lecNo: " + lecNo);
            lectureService.deleteLecture(lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/login/lecUpload", method = RequestMethod.POST)
    public String insert(@RequestParam(value = "lecCategory") String lecCategory,
                         @RequestParam(value = "lecName") String lecName,
                         @RequestParam(value = "lecPrice") String lecPrice,
                         @RequestParam("lecImg") MultipartFile file,
                         HttpServletRequest request) throws IOException {

        // String path = new
        // ClassPathResource("/src/main/resources/uploads").getPath();

        // FileCopyUtils.copy(file.getBytes(), new File(path));

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        System.out.println(lecCategory);
        System.out.println(lecName);
        System.out.println(lecPrice);
        System.out.println(date);

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder = File.separator + "resources" + File.separator + "lectureImg" + File.separator;
        System.out.println(webappRoot);
        System.out.println(relativeFolder);

        String filename = webappRoot + relativeFolder + file.getOriginalFilename();
        String lecFileName = relativeFolder + file.getOriginalFilename();

        System.out.println(lecCategory);
        System.out.println(lecName);
        System.out.println(lecPrice);
        System.out.println(date);
        System.out.println(lecFileName);

        FileCopyUtils.copy(file.getBytes(), new File(filename));

        lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);

        return "redirect:/admin";
    }

    @GetMapping("/admin/login/update/{lecNo}")
    public String lectureUpdate(@PathVariable String lecNo, Model model) {
        LectureDto lectureDto = lectureService.readBasicDataByLecNo(lecNo);
        model.addAttribute("lecture", lectureDto);

        return "lecture-update";
    }

    @GetMapping("/admin/login/detail")
    public String detail(@RequestParam(value = "lecNo") String lecNo,
                         Model model)
    {
        try {
            LectureDto lectureDetail = lectureService.readBasicDataByLecNo(lecNo);
            model.addAttribute("Lecture_Detail", lectureDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin";
    }

    @GetMapping("/admin/login/specific_search")
    public String specificSearch(@RequestParam(value = "LecName", required = false) String lecName,
                                 @RequestParam(value = "minPrice", required = false) String minPrice,
                                 @RequestParam(value = "maxPrice", required = false) String maxPrice,
                                 @RequestParam(value = "LecCategory", required = false) String lecCategory,
                                 Model model)
    {
        try {
            if(lecName != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecName(lecName);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else if(lecCategory != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecCategory(lecCategory);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else if(minPrice != null && maxPrice != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecPrice(minPrice, maxPrice);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else{
                //검색어가 없을 때의 경우 : 웹에서 검색을 할 때 아무것도 입력하지 않으면 or 가격 범위를 제대로 설정하지 않으면 이 함수 자체에 들어오지 않도록 구현해야합니다.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin";
    }

    @RequestMapping(value = "/admin/login/update/{lecNo}", method = RequestMethod.POST)
    public String lectureUpdateComplete(@PathVariable String lecNo,
                                        @RequestParam(value = "lecName") String lecName,
                                        @RequestParam(value = "lecCategory") String lecCategory,
                                        @RequestParam(value = "lecImg") String lecImg,
                                        @RequestParam(value = "lecPrice") String lecPrice) {
        try{
            LectureUpdateDto updateDto = new LectureUpdateDto(lecName, lecCategory, lecImg, lecPrice);
            lectureService.updateLecture(lecNo, updateDto);
            return "admin";
        } catch (Exception e) {
            e.printStackTrace();
            return "admin";
        }
    }
}
