package com.test.service.lecture;

import com.test.dao.LectureDao;
import com.test.dto.LectureDto;
import com.test.dto.LectureUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LectureServiceImp implements LectureService {
    @Autowired
    LectureDao lectureDao;

    @Override
    public void insertLecture(String category, String name, String price, String date, String img) {
        System.out.println("service" + category + "," + name + "," + price + "," + date + "," + img);
        lectureDao.insertLecture(category, name, price, date, img);
    }

    @Override
    public ArrayList<LectureDto> readBasicData() {
        System.out.println("reading lecture List");
        return lectureDao.readBasicData();
    }

    @Override
    public void deleteLecture(String lecNo) {
        System.out.println("service delete " + lecNo);
        lectureDao.deleteLecture(lecNo);
    }

    @Override
    public void updateLecture(String lecNo, LectureUpdateDto updateDto) {
        System.out.println("service update " + lecNo);
        //lectureDao.updateLecture(lecNo, updateDto.getLecName(), updateDto.getLecCategory(), updateDto.getLecImg(), updateDto.getLecPrice());
    }
}
