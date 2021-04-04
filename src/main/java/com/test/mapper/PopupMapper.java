package com.test.mapper;

import com.test.dto.PopupDto;
import com.test.dto.TestDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PopupMapper {
    ArrayList<PopupDto> getPopupList();
    void addItem(@Param("popupDto") PopupDto popupDto);
    void deleteItem(@Param("popNo") String popNo);
    void editItem(@Param("popupDto") PopupDto popupDto);
    PopupDto selectItem(@Param("popNo") String popNo);

}
