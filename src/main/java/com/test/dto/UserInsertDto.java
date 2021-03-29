package com.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInsertDto {
    public UserInsertDto(String userName, String userEmail, String userPw, String userRegDate) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userRegDate = userRegDate;
    }

    String userName;
    String userEmail;
    String userPw;
    String userRegDate;
}