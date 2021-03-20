package com.test.dao;

import com.test.dto.TestDto;
import com.test.mapper.TestMapper;
import com.test.mapper.lectureMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LectureDao {
    @Autowired
    SqlSession sqlSession;


    public void insertLecture(String category, String name, String price, String regDate, String img){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            //TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            System.out.println("dao: " + category + "," + name + "," + price + "," + regDate + "," + img );
            lecMapper.insertLecture(category, name, price, regDate, img);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteLecture(String lectureNo){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            System.out.println("dao: " + lectureNo);
            lecMapper.deleteLecture(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}