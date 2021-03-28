package com.test.service.user;

import com.test.dao.UserDao;
import com.test.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;



    @Override
    public void deleteUser(String userNo) {userDao.deleteUser(userNo);}

    @Override
    public ArrayList<UserDto> readUserInfoList() {
        return userDao.readUserInfoList();
    }

    @Override
    public UserDto readUserInfoListByUserNo(String userNo) {
        return null;
    }


}
