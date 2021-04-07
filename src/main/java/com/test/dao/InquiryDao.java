package com.test.dao;

import com.test.dto.InquiryDto;
import com.test.mapper.InquiryMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class InquiryDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<InquiryDto> readInquiryDataList() {
        try {
            System.out.println("calling Lecture list do");
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            ArrayList<InquiryDto> inquiryInfoList = inquiryMapper.readInquiryDataList();
            System.out.println("calling Lecture list end");
            return inquiryInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertInquiry(InquiryDto inqDto) {
        try {
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            System.out.println("inquiry dao");
            inquiryMapper.insertInquiry(inqDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteInquiry(String inqNo) {
        try {
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            System.out.println("dao: " + inqNo);
            inquiryMapper.deleteInquiry(inqNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InquiryDto readInquiryDataByInqNo(String inqNo) {
        try {
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            System.out.println("dao: " + inqNo);
            return inquiryMapper.readInquiryDataByInqNo(inqNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateInquiry(String inqNo, InquiryDto updateInqDto) {
        try {
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            System.out.println("dao: " + inqNo);
            inquiryMapper.updateInquiry(inqNo, updateInqDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
