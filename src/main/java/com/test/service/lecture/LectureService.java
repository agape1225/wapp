package com.test.service.lecture;

import com.test.dto.LectureDto;

import java.util.ArrayList;

public interface LectureService {
    ArrayList<LectureDto> readBasicDataList();
    void insertLecture(LectureDto lectureDto);

    ArrayList<LectureDto> readBasicDatListByUserNo(String userNo);

    ArrayList<LectureDto> readBasicDataListNotInRec();

    ArrayList<LectureDto> readBasicDataListInRec();

    void deleteLecture(String lecNo);

    LectureDto readBasicDataByLecNo(String lecNo);

    ArrayList<LectureDto> readBasicDataByLecName(String lecName);

    ArrayList<LectureDto> readBasicDataByLecCategory(String lecCategory);

    ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice);

    void updateLecture(String lecNo, LectureDto updateDto);


    ArrayList<LectureDto> readAllLectureSortedByLikes();
    ArrayList<LectureDto> readAllLectureSortedByRegDate();
    ArrayList<LectureDto> readLectureSortedByLikes(String category);
    ArrayList<LectureDto> readLectureSortedByRegDate(String category);

    ArrayList<LectureDto> readBasicDataByRegDateDesc();

    ArrayList<LectureDto> readBasicDataByPopularity();

    ArrayList<LectureDto> readBasicDataListBySearch(String[] strQueries, String[] categories, String sortKey);
}
