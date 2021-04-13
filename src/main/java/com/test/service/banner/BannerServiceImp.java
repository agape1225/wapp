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
    public void insertBanner(BannerDto bannerDto){
        System.out.println("Start insert banner service");
        bannerDao.insertBanner(bannerDto);
        System.out.println("End insert banner service");
    }

    @Override
    public void deleteBanner(String banNo) {
        bannerDao.deleteBanner(banNo);
    }

    @Override
    public ArrayList<BannerDto> readBasicDataList() {
        return bannerDao.readBasicDataList();
    }

    @Override
    public BannerDto readBasicDataByBanNo(String banNo) {
        return bannerDao.readBasicDataByBanNo(banNo);
    }

    @Override
    public void updateBanner(String banNo, BannerDto bannerDto){
        bannerDao.updateBanner(banNo, bannerDto);
    }

    @Override
    public void countUpdate(String banNo) {
        bannerDao.countUpdate(banNo);
    }
}
