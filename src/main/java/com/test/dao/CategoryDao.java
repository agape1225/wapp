package com.test.dao;

import com.test.dto.CategoryDto;
import com.test.mapper.categoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Locale;

@Repository
public class CategoryDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<CategoryDto> getCategoryList(){
        try{
            categoryMapper categorymapper = sqlSession.getMapper(categoryMapper.class);
            ArrayList<CategoryDto> categoryList = categorymapper.getCategoryList();
            return categoryList;

        }catch (Exception e){
            return null;
        }
    }
}
