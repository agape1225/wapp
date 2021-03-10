package com.test.dto;

import lombok.Getter;
import lombok.Setter;

public class AdminLoginDto {
    @Getter
    @Setter
    public class CategoryDto {
        String id;
        String password;
    }

}
