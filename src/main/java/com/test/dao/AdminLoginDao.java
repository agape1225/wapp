package com.test.dao;

import com.test.dto.AdminLoginDto;
import com.test.dto.CategoryDto;
import com.test.mapper.AdminLoginMapper;
import com.test.mapper.categoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdminLoginDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<AdminLoginDto> getLoginImfo(){
        try{
            AdminLoginMapper adminLoginMapper = sqlSession.getMapper(AdminLoginMapper.class);
            ArrayList<AdminLoginDto> loginImfo = adminLoginMapper.getLoginImfo();
            return loginImfo;

        }catch (Exception e){
            return null;
        }
    }
}
