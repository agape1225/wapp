package com.test.service.test;

import com.test.dao.TestDao;
import com.test.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TestServiceImp implements TestService {
    @Autowired
    TestDao testDao;

    @Override
    public ArrayList<TestDto> getItemList() {
        System.out.println("test.do Service do");
        ArrayList<TestDto> testInfoList = testDao.getItemList();
        System.out.println("test.do Service end");
        return testInfoList;
    }

    @Override
    public void deleteItem(String number) {
        testDao.deleteItem(number);
    }

    @Override
    public void addItem(String data) {
        System.out.println("service: " + data);
        testDao.addItem(data);
    }
}
