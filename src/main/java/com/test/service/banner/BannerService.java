package com.test.service.banner;

import com.test.dto.BannerDto;

import java.util.ArrayList;

public interface BannerService {
    void insertBanner(String img, String count, String getDate,
                      String title, String content);
    ArrayList<BannerDto> readBasicDataList();

    BannerDto readBasicDataByBanNo(String banNo);
}
