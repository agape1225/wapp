package com.test.service.user;

import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;

import  java.util.ArrayList;

public interface UserService {

    void deleteUser(String userNo);
    ArrayList<UserDto> readUserInfoList();
    UserDto readUserInfoListByUserNo(String userNo);
    UserDto readUserInfoListByUserEmail(String userEmail);
    void insertUser(UserInsertDto userDto);

}
