package com.test.service.adminLogin;

import com.test.dao.AdminLoginDao;
import com.test.dao.CategoryDao;
import com.test.dto.AdminLoginDto;
import com.test.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AdminLoginServiceImp {
    @Autowired
    AdminLoginDao adminLoginDao;

    @Override
    public ArrayList<AdminLoginDto> getLoginImfo(){
        ArrayList<AdminLoginDto> loginImfo = adminLoginDao.getLoginImfo();
        return loginImfo;

    }
}
