package com.test.mapper;

import com.test.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserMapper {
    void deleteUser(@Param("userNo") String userNo);

    ArrayList<UserDto> readUserInfoList();
    UserDto readUserInfoListByUserNo(@Param("userNo") String userNo);
}
