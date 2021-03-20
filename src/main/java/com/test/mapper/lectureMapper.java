package com.test.mapper;

import com.test.dto.LectureDto;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface lectureMapper {
    ArrayList<LectureDto> readBasicData();
    void insertLecture(@Param("category") String category,
                       @Param("name") String name,
                       @Param("price") String price,
                       @Param("regDate") String regDate,
                       @Param("lecImg") String lecImg);

    void deleteLecture(@Param("lecNo") String lecNo);

    void updateLecture(@Param("lecNo") String lecNo,
                       @Param("lecName")String lecName,
                       @Param("lecCategory")String lecCategory,
                       @Param("lecImg")String lecImg,
                       @Param("lecPrice")String lecPrice);
}
