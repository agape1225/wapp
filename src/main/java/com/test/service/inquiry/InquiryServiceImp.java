package com.test.service.inquiry;

import com.test.dao.InquiryDao;
import com.test.dto.InquiryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InquiryServiceImp implements InquiryService {
    @Autowired
    InquiryDao inquiryDao;

    @Override
    public void insertInquiry(InquiryDto inquiryDto) {
        System.out.println("inquiry service");
        inquiryDao.insertInquiry(inquiryDto);
    }

    @Override
    public ArrayList<InquiryDto> readInquiryDataList() {
        System.out.println("reading lecture List");
        return inquiryDao.readInquiryDataList();
    }

    @Override
    public void deleteInquiry(String inqNo) {
        System.out.println("service delete " + inqNo);
        inquiryDao.deleteInquiry(inqNo);
    }

    @Override
    public void updateInquiry(String inqNo, InquiryDto updateInqDto) {
        System.out.println("service update " + inqNo);
        inquiryDao.updateInquiry(inqNo, updateInqDto);
    }

    @Override
    public InquiryDto readInquiryDataByInqNo(String inqNo) {
        return null;
    }

}