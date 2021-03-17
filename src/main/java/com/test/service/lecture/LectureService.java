package com.test.service.lecture;

import com.test.dto.LectureDto;

import java.util.ArrayList;

public interface LectureService{
    void insertLecture(String category, String name, String price, String date);
    ArrayList<LectureDto> readBasicData();
}
