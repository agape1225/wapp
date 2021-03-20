package com.test.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LectureUpdateDto {

    final private String lecName;
    final private String lecCategory;
    final private String lecImg;
    final private String lecPrice;
}
