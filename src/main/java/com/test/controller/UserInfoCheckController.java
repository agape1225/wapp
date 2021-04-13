package com.test.controller;

import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserInfoCheckController {

    @Autowired
    UserService userService;

    @RequestMapping("/register_check_userEmail")
    public int userIdCheck(@RequestBody Map<String, String> userEmail){
        String email = userEmail.get("userEmail");
        System.out.println("Written Email : " + email);
        int result = userService.checkUserEmailExists(email);
        System.out.println("is This Email Exist? : " + result);

        return result;
    }
}
