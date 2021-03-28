package com.test.mapper;

import com.test.dto.PopupDto;
import com.test.dto.TestDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PopupMapper {
    ArrayList<PopupDto> getPopupList();
    void addItem(@Param("popType") String popType,
                    @Param("popImg") String popImg,
                    @Param("popRegDate") String popRegDate);
    void deletePopup(@Param("data") String data);
}
