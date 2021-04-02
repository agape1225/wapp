package com.test.mapper;

import org.apache.ibatis.annotations.Param;

public interface LikesMapper {
    void insertLikes(@Param("userNo") String userNo,
                     @Param("lecNo") String lecNo);
    void deleteLikes(@Param("userNo") String userNo,
                     @Param("lecNo") String lecNo);
}
