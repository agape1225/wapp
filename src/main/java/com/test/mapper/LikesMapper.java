package com.test.mapper;

import com.test.dto.LikesDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface LikesMapper {
    void insertLikes(@Param("userNo") String userNo,
                     @Param("lecNo") String lecNo,
                     @Param("likeDate") String likeDate);
    void deleteLikes(@Param("userNo") String userNo,
                     @Param("lecNo") String lecNo);
    ArrayList<LikesDto> readLikesListsOrderByLikeDateDesc();

    LikesDto readBasicDataByUserNoNLecNo(@Param("userNo") String userNo, @Param("lecNo") String lecNo);
}
