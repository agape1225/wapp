package com.test.dao;

import com.test.dto.BannerDto;
import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;
import com.test.mapper.BannerMapper;
import com.test.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public void deleteUser(String userNo) {
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println("dao: " + userNo);
            userMapper.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserDto> readUserInfoList(){
        try {
            System.out.println("calling User list do");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            ArrayList<UserDto> UserInfoList = userMapper.readUserInfoList();
            System.out.println("calling User list end");
            return UserInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserDto readUserInfoListByUserNo(String userNo){
        try {
            System.out.println("calling User  do");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserDto user = userMapper.readUserInfoListByUserNo(userNo);
            System.out.println("calling User do");
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserDto readBasicDataByUserEmail(String userEmail) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto userInfo = userMapper.readUserInfoListByUserEmail(userEmail);
        return userInfo;
    }

    public void insertUser(UserInsertDto userDto) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(userDto);
    }

}
