package com.test.service.banner;

import com.test.dao.BannerDao;
import com.test.dao.LectureDao;
import com.test.dto.BannerDto;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public ArrayList<BannerDto> readBasicDataList() {
        return bannerDao.readBasicDataList();
    }

    @Override
    public BannerDto readBasicDataByBanNo(String banNo) {
        return bannerDao.readBasicDataByBanNo(banNo);
    }
}
