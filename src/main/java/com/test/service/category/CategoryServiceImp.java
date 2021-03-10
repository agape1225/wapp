package com.test.service.category;

import com.test.dao.CategoryDao;
import com.test.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImp implements CatrgoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public ArrayList<CategoryDto> getCategoryList(){
        ArrayList<CategoryDto> catrgory = categoryDao.getCategoryList();
        return catrgory;

    }
}
