package com.test.service.adminLogin;

import com.test.dto.AdminLoginDto;

import java.util.ArrayList;

public interface AdminLoginService {
    ArrayList<AdminLoginDto> getLoginInfo();
    void registerLoginInfo(String id, String password);
}
