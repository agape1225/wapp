package com.test.service.email;

import com.test.dto.AdminLoginDto;
import com.test.dto.UserDto;

import java.util.ArrayList;

public interface EmailService {
    public void sendMail(UserDto userInfo, String lecNo, String likesTime);
}
