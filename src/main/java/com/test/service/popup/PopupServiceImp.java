package com.test.service.popup;

import com.test.dao.PopupDao;
import com.test.dao.TestDao;
import com.test.dto.PopupDto;
import com.test.dto.TestDto;
import com.test.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PopupServiceImp implements PopupService {
    @Autowired
    PopupDao popupDao;


    @Override
    public ArrayList<PopupDto> getPopupList() {
        ArrayList<PopupDto> popupList = popupDao.getPopupList();
        return popupList;
    }

    @Override
    public void deletePopup(String data) {
        popupDao.deletePopup(data);

    }

    @Override
    public void addItem(String popType, String popImg, String popRegDate) {
        popupDao.addItem(popType, popImg, popRegDate);

    }
}
