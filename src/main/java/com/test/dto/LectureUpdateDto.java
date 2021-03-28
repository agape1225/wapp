package com.test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LectureUpdateDto {

    public LectureUpdateDto(String lecName, String lecCategory, String lecImg, String lecPrice) {
        this.lecName = lecName;
        this.lecCategory = lecCategory;
        this.lecImg = lecImg;
        this.lecPrice = lecPrice;
    }

    final private String lecName;
    final private String lecCategory;
    final private String lecImg;
    final private String lecPrice;


}
