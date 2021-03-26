package com.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    String userName;
    String userEmail;
    String userPw;
}