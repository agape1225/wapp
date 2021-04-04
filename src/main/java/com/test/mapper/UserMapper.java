package com.test.mapper;

import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserMapper {
    ArrayList<UserDto> readUserInfoList();
    void deleteUser(@Param("userNo") String userNo);

    ArrayList<UserDto> readUserInfoListByUserName(@Param("lecName") String userName);

    UserDto readUserInfoListByUserNo(@Param("userNo") String userNo);
    UserDto readUserInfoListByUserEmail(@Param("userEmail") String userEmail);
    void insertUser(UserInsertDto userDto);
}
