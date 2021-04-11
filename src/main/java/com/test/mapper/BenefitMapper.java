package com.test.mapper;

import com.test.dto.BenefitDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface BenefitMapper {
    ArrayList<BenefitDto> getBenefitList();
    void addItem(@Param("benefitDto") BenefitDto benefitDto);
    void deleteItem(@Param("benNo") String benNo);
    void editItem(@Param("benefitDto") BenefitDto benefitDto);
    BenefitDto selectItem(@Param("benNo") String benNo);

}
