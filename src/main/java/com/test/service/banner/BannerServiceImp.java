package com.test.service.banner;

import com.test.dao.BannerDao;
import com.test.dao.LectureDao;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImp implements BannerService {
    @Autowired
    BannerDao bannerDao;

    @Override
    public void insertBanner(String img,    String count, String getDate,
                             String title, String content) {
        System.out.println("banner " +  img + "," + count + "," +
                                        getDate + "," + title + "," + content);
        bannerDao.insertBanner(img,count,getDate,title,content);
    }

    @Override
    public void deleteBanner(String banNo) {
        bannerDao.deleteBanner(banNo);
    }
}
