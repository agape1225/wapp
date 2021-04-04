package com.test.dao;

import com.test.mapper.LectureMapper;
import com.test.mapper.LikesMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikesDao {
    @Autowired
    SqlSession sqlSession;

    public void insertLikes(String userNo, String lecNo) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            System.out.println("dao: " + userNo + "," + lecNo);
            likesMapper.insertLikes(userNo, lecNo);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteLikes(String userNo, String lecNo) {
        try {
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);
            System.out.println("dao: " + userNo + lecNo);
            likesMapper.deleteLikes(userNo, lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
