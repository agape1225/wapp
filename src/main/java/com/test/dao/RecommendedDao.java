package com.test.dao;

import com.test.dto.PopupDto;
import com.test.dto.RecommendedDto;
import com.test.mapper.PopupMapper;
import com.test.mapper.RecommendedMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendedDao {
    @Autowired
    SqlSession sqlSession;

    public void insertRecommended(String lecNo){
        try{
            RecommendedMapper recommendedMapper = sqlSession.getMapper(RecommendedMapper.class);
            recommendedMapper.insertRecommended(lecNo);
            System.out.println("dao: " + lecNo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteRecommended(String lecNo){
        try{
            RecommendedMapper recommendedMapper = sqlSession.getMapper(RecommendedMapper.class);
            System.out.println("recommended dao delete start");
            recommendedMapper.deleteRecommended(lecNo);
            System.out.println("recommended dao delete end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
