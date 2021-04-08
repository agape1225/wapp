package com.test.service.inquiry;

import com.test.dto.InquiryDto;

import java.util.ArrayList;

public interface InquiryService {
    ArrayList<InquiryDto> readInquiryDataList();
    void insertInquiry(InquiryDto inquiryDto);
    void deleteInquiry(String inqNo);
    void updateInquiry(String inqNo, InquiryDto updateInqDto);
    InquiryDto readInquiryDataByInqNo(String inqNo);
}
