package com.test.service.popup;

import com.test.dto.PopupDto;

import java.util.ArrayList;

public interface PopupService {
    ArrayList<PopupDto> getPopupList();
    void addItem(PopupDto popupDto);
    void deleteItem(String popNo);
    void editItem(PopupDto popupDto);
    PopupDto selectItem(String popNo);
}
