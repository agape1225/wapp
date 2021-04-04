package com.test.service.popup;

import com.test.dao.PopupDao;
import com.test.dto.PopupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PopupServiceImp implements PopupService {
    @Autowired
    PopupDao popupDao;

    @Override
    public ArrayList<PopupDto> getPopupList() {
        return popupDao.getPopupList();
    }

    @Override
    public void deleteItem(String popNo) {
        popupDao.deleteItem(popNo);
    }

    @Override
    public void addItem(PopupDto popupDto) {
        popupDao.addItem(popupDto);
    }

    @Override
    public void editItem(PopupDto popupDto){
        popupDao.editItem(popupDto);
    }

    @Override
    public PopupDto selectItem(String popNo) {
        return popupDao.selectItem(popNo);
    }

}
