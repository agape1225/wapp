package com.test.dao;

import com.test.dto.TestDto;
import com.test.mapper.TestMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TestDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<TestDto> getItemList(){
        try{
            System.out.println("test.do Dao do");
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            ArrayList<TestDto> testInfoList = testMapper.getItemList();
            System.out.println("test.do Dao end");
            return testInfoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteItem(String number){
        try{
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            testMapper.deleteItem(number);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addItem(String data){
        try{
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            System.out.println("dao: " + data);
            testMapper.addItem(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
