package com.test.dao;

import com.test.mapper.BannerMapper;
import com.test.mapper.lectureMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BannerDao {
    @Autowired
    SqlSession sqlSession;


    public void insertBanner(String img, String count, String getDate,
                             String title, String content){
        try{
            BannerMapper bannerMapper = sqlSession.getMapper(BannerMapper.class);

            System.out.println("dao: " + count + "," + getDate + "," + title + "," + content + "," + img );
            bannerMapper.insertBanner(img, count, getDate, title, content);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBanner(String banNo) {
        try{
            BannerMapper bannerMapper = sqlSession.getMapper(BannerMapper.class);
            System.out.println("dao: " + banNo );
            bannerMapper.deleteBanner(banNo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
