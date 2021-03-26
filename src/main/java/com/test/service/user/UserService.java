package com.test.service.user;

import com.test.dto.UserDto;
import  java.util.ArrayList;

public interface UserService {

    void deleteUser(String userNo);
    ArrayList<UserDto> readUserInfoList();
    UserDto readUserInfoListByUserNo(String userNo);

}
