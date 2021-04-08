package com.test.mapper;

import org.apache.ibatis.annotations.Param;

public interface RecommendedMapper {
    void insertRecommended(@Param("lecNo") String lecNo);
    void deleteRecommended(@Param("lecNo") String lecNo);
}
