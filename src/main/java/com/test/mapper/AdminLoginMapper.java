package com.test.mapper;

import com.test.dto.AdminLoginDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AdminLoginMapper {
    ArrayList<AdminLoginDto> getLoginInfo();
}
