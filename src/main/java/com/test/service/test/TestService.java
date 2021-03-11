package com.test.service.test;

import com.test.dto.TestDto;

import java.util.ArrayList;

public interface TestService {
    ArrayList<TestDto> getItemList();
    void deleteItem(String number);
    void addItem(String data);
}
