package com.test.mapper;

import com.test.dto.TestDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface TestMapper {
    ArrayList<TestDto> getItemList();
    void deleteItem(@Param("number") String number);
    void addItem(@Param("data") String data);
}
