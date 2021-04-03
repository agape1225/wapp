package com.test.mapper;

import com.test.dto.LectureDto;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface LectureMapper {
    ArrayList<LectureDto> readBasicDataList();
    void insertLecture(@Param("lectureDto") LectureDto lectureDto);
    void deleteLecture(@Param("lecNo") String lecNo);
    LectureDto readBasicDataByLecNo(@Param("lecNo") String lecNo);
    ArrayList<LectureDto> readBasicDataByLecName(@Param("lecName") String lecName);
    ArrayList<LectureDto> readBasicDataByLecCategory(@Param("lecCategory") String lecCategory);
    ArrayList<LectureDto> readBasicDataByLecPrice(@Param("minPrice") String minPrice, @Param("maxPrice") String maxPrice);

    void updateLecture(@Param("lecNo") String lecNo, @Param("updateDto") LectureDto updateDto);
    ArrayList<LectureDto> readBasicDataListByUserNo(@Param("userNo") String userNo);

}
