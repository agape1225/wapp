package com.test.mapper;

import com.test.dto.InquiryDto;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface InquiryMapper {
    ArrayList<InquiryDto> readInquiryDataList();
    void insertInquiry(@Param("inquiryDto") InquiryDto inquiryDto);
    void deleteInquiry(@Param("inqNo") String inqNo);
    InquiryDto readInquiryDataByInqNo(@Param("inqNo") String inqNo);
    void updateInquiry(@Param("inqNo") String inqNo, @Param("updateInqDto") InquiryDto updateInqDto);

}
