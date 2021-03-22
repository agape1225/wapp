package com.test.mapper;

import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    void insertBanner(@Param("img") String img,
                      @Param("count") String count,
                      @Param("regDate") String regDate,
                      @Param("title") String title,
                      @Param("content") String content);

    void deleteBanner(@Param("banNo") String banNo);
}
