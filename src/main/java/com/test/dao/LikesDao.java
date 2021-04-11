package com.test.dao;

import com.test.dto.LectureDto;
import com.test.dto.LikesDto;
import com.test.mapper.LectureMapper;
import com.test.mapper.LikesMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LikesDao {
    @Autowired
    SqlSession sqlSession;

    public boolean insertLikes(String userNo, String lecNo, String likeDate) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            System.out.println("dao: " + userNo + "," + lecNo);

            if (likesMapper.readBasicDataByUserNoNLecNo(userNo, lecNo) != null) { // 중복 데이터 있음
                System.out.println("이미 동일 사용자가 찜한 강의입니다.");
                return false;
            }
            // 중복 데이터 없음
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            likesMapper.insertLikes(userNo, lecNo, likeDate);
            LectureDto lectureDto = lectureMapper.readBasicDataByLecNo(lecNo);
            int addition = Integer.parseInt(lectureDto.getLecLike()) + 1;
            System.out.println("like result : " + addition);
            lectureMapper.updateLike(lecNo, Integer.toString(addition));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteLikes(String userNo, String lecNo) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            if(likesMapper.readBasicDataByUserNoNLecNo(userNo, lecNo) == null)
                return false;
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + userNo + lecNo);
            likesMapper.deleteLikes(userNo, lecNo);
            LectureDto lectureDto = lectureMapper.readBasicDataByLecNo(lecNo);
            int subtraction = Integer.parseInt(lectureDto.getLecLike()) - 1;
            System.out.println("like result : " + subtraction);
            lectureMapper.updateLike(lecNo, Integer.toString(subtraction));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
