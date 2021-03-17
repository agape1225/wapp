package com.test.mapper;

import com.test.dto.AdminLoginDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface lectureMapper {
    void insertLecture(@Param("category") String category,
                       @Param("name") String name,
                       @Param("price") String price,
                       @Param("regDate") String regDate);
}
