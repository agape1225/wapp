package com.test.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminLoginDto {
    String id;
    String password;

    public String getId(){
        return id;

    }

    public String getPassword(){
        return password;
    }
}
