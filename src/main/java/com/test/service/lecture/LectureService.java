package com.test.service.lecture;

import com.test.dto.LectureDto;

import java.util.ArrayList;

public interface LectureService {
    ArrayList<LectureDto> readBasicDataList();
    void insertLecture(LectureDto lectureDto);

    ArrayList<LectureDto> readBasicDatListByUserNo(String userNo);

    void deleteLecture(String lecNo);

    LectureDto readBasicDataByLecNo(String lecNo);

    ArrayList<LectureDto> readBasicDataByLecName(String lecName);

    ArrayList<LectureDto> readBasicDataByLecCategory(String lecCategory);

    ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice);

    void updateLecture(String lecNo, LectureDto updateDto);

}
