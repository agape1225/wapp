package com.test.dao;

import com.test.dto.BannerDto;
import com.test.mapper.BannerMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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

    public ArrayList<BannerDto> readBasicDataList(){
        try {
            System.out.println("calling Banner list do");
            BannerMapper bannerMapper = sqlSession.getMapper(BannerMapper.class);
            ArrayList<BannerDto> bannerInfoList = bannerMapper.readBasicDataList();
            System.out.println("calling Banner list end");
            return bannerInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BannerDto readBasicDataByBanNo(String banNo){
        try {
            System.out.println("calling Banner do");
            BannerMapper bannerMapper = sqlSession.getMapper(BannerMapper.class);
            BannerDto banner = bannerMapper.readBasicDataByBanNo(banNo);
            System.out.println("calling Banner end");
            return banner;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
