package com.test.dao;

import com.test.dto.PopupDto;
import com.test.dto.TestDto;
import com.test.mapper.PopupMapper;
import com.test.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PopupDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<PopupDto> getPopupList(){
        try{
            System.out.println("Popup dto start");
            PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
            ArrayList<PopupDto> popupList = popupMapper.getPopupList();
            System.out.println("Popup dto end");
            return popupList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deletePopup(String data){
        try{
            //TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
            popupMapper.deletePopup(data);
            //PopupMapper.deleteItem(number);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addItem(String popType, String popImg, String popRegDate){
        try{
            //TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            //System.out.println("dao: " + data);
            //testMapper.addItem(data);
            PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
            System.out.println("popType : " + popType);
            System.out.println("popImg : " + popImg);
            System.out.println("popRegDate : " + popRegDate);
            popupMapper.addItem(popType, popImg, popRegDate);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
