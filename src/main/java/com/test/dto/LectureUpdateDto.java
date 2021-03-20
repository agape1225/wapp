package com.test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LectureUpdateDto {

    private String lecName;
    private String lecCategory;
    private String lecImg;
    private String lecPrice;
}
