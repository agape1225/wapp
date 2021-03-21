package com.test.service.adminLogin;

import com.test.dao.AdminLoginDao;
import com.test.dto.AdminLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AdminLoginServiceImp implements AdminLoginService{
    @Autowired
    AdminLoginDao adminLoginDao;

    @Override
    public ArrayList<AdminLoginDto> getLoginInfo(){
        ArrayList<AdminLoginDto> loginInfo = adminLoginDao.getLoginInfo();
        return loginInfo;

    }
}
