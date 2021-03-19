package com.test.mapper;

import com.test.dto.AdminLoginDto;

import java.util.ArrayList;

public interface AdminLoginMapper {
    ArrayList<AdminLoginDto> getLoginInfo();
}
