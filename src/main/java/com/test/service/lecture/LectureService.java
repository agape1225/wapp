package com.test.service.lecture;

import com.test.dto.LectureDto;
import com.test.dto.TestDto;

import java.util.ArrayList;

public interface LectureService{
    ArrayList<LectureDto> readBasicData();
    void insertLecture(String category, String name, String price, String date, String img);
    void deleteLecture(String lecNo);

}
