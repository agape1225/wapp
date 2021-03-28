package com.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopupDto {
    String popType;
    String popImg;
    String popRegDate;

    public String getImg(){
        return popImg;
    }
}
