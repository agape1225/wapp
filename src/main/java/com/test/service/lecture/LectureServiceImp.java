package com.test.service.lecture;

import com.test.dao.LectureDao;
import com.test.dao.TestDao;
import com.test.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.misc.ReflectUtil;

import java.util.ArrayList;

@Service
public class LectureServiceImp implements LectureService {
    @Autowired
    LectureDao lectureDao;

    @Override
    public void insertLecture(String category, String name, String price, String date, String img){
        System.out.println("service" +  category + "," + name + "," + price + "," + date + "," + img);
        lectureDao.insertLecture(category, name, price, date, img);
    }

    @Override
    public void deleteLecture(String lecNo) {
        System.out.println("service delete " + lecNo);
        lectureDao.deleteLecture(lecNo);
    }
}
