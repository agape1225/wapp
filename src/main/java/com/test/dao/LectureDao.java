package com.test.dao;

import com.test.dto.LectureDto;
import com.test.dto.TestDto;
import com.test.mapper.TestMapper;
import com.test.mapper.lectureMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LectureDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<LectureDto> readBasicData(){
        try{
            System.out.println("calling Lecture list do");
            lectureMapper lMapper = sqlSession.getMapper(lectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicData();
            System.out.println("calling Lecture list end");
            return lectureInfoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
