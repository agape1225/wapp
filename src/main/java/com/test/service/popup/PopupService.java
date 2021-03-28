package com.test.service.popup;

import com.test.dto.PopupDto;
import com.test.dto.TestDto;

import java.util.ArrayList;

public interface PopupService {
    ArrayList<PopupDto> getPopupList();
    void deletePopup(String data);
    void addItem(String popType,
                 String popImg,
                 String popRegDate);
}
