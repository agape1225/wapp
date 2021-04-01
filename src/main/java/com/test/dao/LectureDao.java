package com.test.dao;

import com.test.dto.LectureDto;
import com.test.mapper.LectureMapper;
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
            LectureMapper lMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataList();
            System.out.println("calling Lecture list end");
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertLecture(LectureDto lectureDto) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("lecture dao");
            lecMapper.insertLecture(lectureDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteLecture(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            lecMapper.deleteLecture(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LectureDto readBasicDataByLecNo(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            return lecMapper.readBasicDataByLecNo(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecName(String lectureName) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureName);
            return lecMapper.readBasicDataByLecName(lectureName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecCategory(String lectureCategory) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureCategory);
            return lecMapper.readBasicDataByLecCategory(lectureCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + minPrice + "~" + maxPrice);
            return lecMapper.readBasicDataByLecPrice(minPrice, maxPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateLecture(String lecNo, LectureDto updateDto) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lecNo);
            lecMapper.updateLecture(lecNo, updateDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}