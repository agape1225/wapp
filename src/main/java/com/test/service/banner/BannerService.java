package com.test.service.banner;

import com.test.dto.BannerDto;

import java.util.ArrayList;

public interface BannerService {
//    void insertBanner(String img, String count, String getDate,
//                      String title, String content);

    void insertBanner(BannerDto bannerDto);
    ArrayList<BannerDto> readBasicDataList();

    void deleteBanner(String banNo);

    BannerDto readBasicDataByBanNo(String banNo);

}
