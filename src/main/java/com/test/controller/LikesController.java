package com.test.controller;

import com.test.dto.UserDto;
import com.test.service.likes.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LikesController {

    @Autowired
    LikesService likesService;

    @RequestMapping(value = "/user/login/likes/insert", method = RequestMethod.POST)
    public String insert(@RequestParam(value = "lecNo")String lecNo,
                         HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userLogin");

        likesService.insertLecture(userDto.getUserNo(), lecNo);
        System.out.println("Success insert likes " + userDto.getUserNo() + " " + lecNo);

        return "redirect:/";
    }

    @RequestMapping(value = "/user/login/likes/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "lecNo")String lecNo,
                         HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userLogin");

        likesService.deleteLecture(userDto.getUserNo(), lecNo);
        System.out.println("Success delete likes " + userDto.getUserNo() + " " + lecNo);

        return "redirect:/";
    }
}
