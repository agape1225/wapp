package com.test.mapper;

import com.test.dto.BannerDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface BannerMapper {
//    void insertBanner(@Param("img") String img,
//                      @Param("count") String count,
//                      @Param("regDate") String regDate,
//                      @Param("title") String title,
//                      @Param("content") String content);

    void insertBanner(@Param("bannerDto") BannerDto bannerDto);

    void deleteBanner(@Param("banNo") String banNo);

    void updateBanner(@Param("banNo") String banNo, @Param("updateDto") BannerDto bannerDto);

    ArrayList<BannerDto> readBasicDataList();
    BannerDto readBasicDataByBanNo(@Param("banNo") String banNo);

    void countUpdate(@Param("banNo") String banNo);

}
