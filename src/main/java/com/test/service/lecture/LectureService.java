package com.test.service.lecture;

import com.test.dto.LectureDto;

import java.util.ArrayList;

public interface LectureService{
<<<<<<< HEAD
    void insertLecture(String category, String name, String price, String date);
    ArrayList<LectureDto> readBasicData();
=======
    void insertLecture(String category, String name, String price, String date, String img);
    void deleteLecture(String lecNo);

>>>>>>> main
}
