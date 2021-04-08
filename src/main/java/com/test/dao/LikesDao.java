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

    public void insertLikes(String userNo, String lecNo, String likeDate) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + userNo + "," + lecNo);
            ArrayList<LikesDto> likesDtos = likesMapper.readLikesListsOrderByLikeDateDesc();

            if(likesDtos.size() != 0) {
                boolean isAlreadyAdded = false;
                for (LikesDto likesDto : likesDtos) {
                    if (likesDto.getLecNo().equals(lecNo) && likesDto.getUserNo().equals(userNo)) { // 이미 동일 사용자가 동일 강의를 찜했을 때
                        System.out.println("이미 동일 사용자가 찜한 강의입니다.");
                        isAlreadyAdded = true;
                        break;
                    }
                }
                if(!isAlreadyAdded) {
                    likesMapper.insertLikes(userNo, lecNo, likeDate);
                    LectureDto lectureDto = lectureMapper.readBasicDataByLecNo(lecNo);
                    int addition = Integer.parseInt(lectureDto.getLecLike()) + 1;
                    System.out.println("like result : " + addition);
                    lectureMapper.updateLike(lecNo, Integer.toString(addition));
                }
            }else{ // 전체 찜 목록이 비어있을 경우 겹치는 경우 없음.
                likesMapper.insertLikes(userNo, lecNo, likeDate);
                LectureDto lectureDto = lectureMapper.readBasicDataByLecNo(lecNo);
                int addition = Integer.parseInt(lectureDto.getLecLike()) + 1;
                System.out.println("like result : " + addition);
                lectureMapper.updateLike(lecNo, Integer.toString(addition));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteLikes(String userNo, String lecNo) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + userNo + lecNo);
            likesMapper.deleteLikes(userNo, lecNo);
            LectureDto lectureDto = lectureMapper.readBasicDataByLecNo(lecNo);
            int subtraction = Integer.parseInt(lectureDto.getLecLike()) - 1;
            System.out.println("like result : " + subtraction);
            lectureMapper.updateLike(lecNo, Integer.toString(subtraction));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
