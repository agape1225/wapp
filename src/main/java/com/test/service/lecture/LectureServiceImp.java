package com.test.service.lecture;

import com.test.dao.LectureDao;
import com.test.dto.LectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LectureServiceImp implements LectureService {
    @Autowired
    LectureDao lectureDao;

    @Override
    public void insertLecture(String category, String name, String price, String date){
        System.out.println("service" +  category + "," + name + "," + price + "," + date);
        lectureDao.insertLecture(category, name, price, date);
    }

    @Override
    public ArrayList<LectureDto> readBasicData() {
        System.out.println("reading lecture List");
        return lectureDao.readBasicData();
    }
}
