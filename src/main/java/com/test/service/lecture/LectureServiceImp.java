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
    public void insertLecture(LectureDto lectureDto) {
        System.out.println("lecture service");
        lectureDao.insertLecture(lectureDto);
    }

    @Override
    public ArrayList<LectureDto> readBasicDataList() {
        System.out.println("reading lecture List");
        return lectureDao.readBasicDataList();
    }

    @Override
    public ArrayList<LectureDto> readBasicDatListByUserNo(String userNo) {
        System.out.println("reading lecture List By UserNo");
        return lectureDao.readBasicDataListByUserNo(userNo);
    }

    @Override
    public ArrayList<LectureDto> readBasicDataListNotInRec() {
        return lectureDao.readBasicDataListNotInRec();
    }

    @Override
    public ArrayList<LectureDto> readBasicDataListInRec() {
        return lectureDao.readBasicDataListInRec();
    }

    @Override
    public void deleteLecture(String lecNo) {
        System.out.println("service delete " + lecNo);
        lectureDao.deleteLecture(lecNo);
    }

    @Override
    public LectureDto readBasicDataByLecNo(String lecNo) {
        return lectureDao.readBasicDataByLecNo(lecNo);
    }

    @Override
    public ArrayList<LectureDto> readBasicDataByLecName(String lecName) {
        return lectureDao.readBasicDataByLecName(lecName);
    }

    @Override
    public ArrayList<LectureDto> readBasicDataByLecCategory(String lecCategory) {
        return lectureDao.readBasicDataByLecCategory(lecCategory);
    }

    public ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice) {
        return lectureDao.readBasicDataByLecPrice(minPrice, maxPrice);
    }

    public void updateLecture(String lecNo, LectureDto updateDto) {
        System.out.println("service update " + lecNo);
        lectureDao.updateLecture(lecNo, updateDto);
    }

    @Override
    public ArrayList<LectureDto> readBasicDataByRegDateDesc() {
        return lectureDao.readBasicDataListByRegDateDesc();
    }

    @Override
    public ArrayList<LectureDto> readBasicDataByPopularity() {
        return lectureDao.readDataListByPopularity();
    }
}
