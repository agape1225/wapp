package com.test.mapper;

import com.test.dto.AdminLoginDto;
import com.test.dto.CategoryDto;

import java.util.ArrayList;

public interface AdminLoginMapper {
    ArrayList<AdminLoginDto> getLoginImfo();
}
