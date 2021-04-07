package com.test.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InquiryDto {
    public InquiryDto(String inqTitle, String inqUserName, String inqEmail, String inqQuestion, String inqRegDate) {
        this.inqTitle = inqTitle;
        this.inqUserName = inqUserName;
        this.inqEmail = inqEmail;
        this.inqQuestion = inqQuestion;
        this.inqRegDate = inqRegDate;
    }
    String inqNo;
    String inqUserName;
    String inqQuestion;
    String inqTitle;
    String inqEmail;
    String inqRegDate;
}
