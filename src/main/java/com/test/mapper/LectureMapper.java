package com.test.mapper;

import com.test.dto.LectureDto;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
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
    ArrayList<LectureDto> readAllLectureSortedByLikes();
    ArrayList<LectureDto> readAllLectureSortedByRegDate();
    ArrayList<LectureDto> readLectureSortedByLikes(@Param("category") String category);
    ArrayList<LectureDto> readLectureSortedByRegDate(@Param("category") String category);



    ArrayList<LectureDto> readBasicDataListByRegDateDesc();

    void updateLike(@Param("lecNo") String lecNo,
                    @Param("lecLike") String lecLike);

    ArrayList<LectureDto> readBasicDataListNotInRec();

    ArrayList<LectureDto> readBasicDataListInRec();

    ArrayList<LectureDto> readBasicDataListBySearch(@Param("strQueries") String[] strQueries,
                                                   @Param("categories") String[] categories,
                                                   @Param("sortKey") String sortKey);
}
