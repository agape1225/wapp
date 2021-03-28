package com.test.dao;

import com.test.dto.AdminLoginDto;
import com.test.mapper.AdminLoginMapper;
import com.test.mapper.LectureMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdminLoginDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<AdminLoginDto> getLoginInfo() {
        try {
            AdminLoginMapper adminLoginMapper = sqlSession.getMapper(AdminLoginMapper.class);
            ArrayList<AdminLoginDto> loginInfo = adminLoginMapper.getLoginInfo();
            return loginInfo;

        } catch (Exception e) {
            return null;

        }
    }

    public void registerLoginInfo(String id, String password){
        try {
            AdminLoginMapper adminLoginMapper = sqlSession.getMapper(AdminLoginMapper.class);
            //TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            adminLoginMapper.registerLoginInfo(id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}