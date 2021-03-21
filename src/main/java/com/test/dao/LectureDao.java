package com.test.dao;

import com.test.dto.LectureDto;
import com.test.mapper.lectureMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LectureDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<LectureDto> readBasicDataList() {
        try {
            System.out.println("calling Lecture list do");
            lectureMapper lMapper = sqlSession.getMapper(lectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataList();
            System.out.println("calling Lecture list end");
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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

    public LectureDto readBasicDataByLecNo(String lectureNo){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            System.out.println("dao: " + lectureNo);
            return lecMapper.readBasicDataByLecNo(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecName(String lectureName){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            System.out.println("dao: " + lectureName);
            return lecMapper.readBasicDataByLecName(lectureName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecCategory(String lectureCategory){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            System.out.println("dao: " + lectureCategory);
            return lecMapper.readBasicDataByLecCategory(lectureCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice){
        try{
            lectureMapper lecMapper = sqlSession.getMapper(lectureMapper.class);
            System.out.println("dao: " + minPrice + "~" + maxPrice);
            return lecMapper.readBasicDataByLecPrice(minPrice, maxPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
