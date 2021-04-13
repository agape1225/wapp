package com.test.controller;


import com.test.dto.UserDto;
import com.test.service.email.EmailService;
import com.test.service.likes.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class LikesController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    EmailService emailService;

    @Autowired
    LikesService likesService;

    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/user/likes/insert")
    public boolean insert(@RequestBody Map<String, String> lecNo, // 찜 추가
                          HttpServletRequest request) {
        System.out.println(lecNo.isEmpty());
        String no = lecNo.get("lecNo");
        System.out.println(no);

        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userLogin");


        System.out.println(userDto.getUserEmail());

        Date currentTime = new Date();
        String likeDateForDB = dateForDB.format(currentTime);


        boolean result = likesService.insertLecture(userDto.getUserNo(), no, likeDateForDB);
        System.out.println("Success insert likes " + userDto.getUserNo() + " " + no);


        emailService.sendMail(userDto,no, likeDateForDB);

        likesService.insertLecture(userDto.getUserNo(), no, likeDateForDB);

        System.out.println("Success insert likes " + userDto.getUserNo() + " " + no);

        return result;

    }

    @RequestMapping("/user/likes/delete")
    public boolean delete(@RequestBody Map<String, String> lecNo, // 찜 해제
                          HttpServletRequest request) {
        System.out.println(lecNo.isEmpty());
        String no = lecNo.get("lecNo");
        System.out.println(no);

        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userLogin");


        likesService.deleteLecture(userDto.getUserNo(), no);
        System.out.println("Success delete likes " + userDto.getUserNo() + " " + lecNo);

        boolean result = likesService.deleteLecture(userDto.getUserNo(), no);
        System.out.println("Success delete likes " + userDto.getUserNo() + " " + no);

        return result;

    }

}
