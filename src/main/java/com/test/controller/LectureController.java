package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.TestDto;
import com.test.service.lecture.LectureService;
import com.test.service.test.TestService;
import com.test.util.firebase.FirebaseMessagingSnippets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/admin/login/insert")
    public String main(Model model){
        try{

            String category = "testCategory";
            String name = "testName";
            String price = "1111";

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String date = sdf.format(d);



        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/";
    }
<<<<<<< HEAD

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
=======
  
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "lecNo") String lecNo){
>>>>>>> main
        try{
            System.out.println("lecNo: " + lecNo);
            lectureService.deleteLecture(lecNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/login/upload", method = RequestMethod.POST)
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

        return "admin";
    }

}
