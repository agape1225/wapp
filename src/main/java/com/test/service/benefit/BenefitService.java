package com.test.service.benefit;

import com.test.dto.BenefitDto;

import java.util.ArrayList;

public interface BenefitService {
    ArrayList<BenefitDto> getBenefitList();
    void addItem(BenefitDto benefitDto);
    void deleteItem(String benNo);
    void editItem(BenefitDto benefitDto);
    BenefitDto selectItem(String benNo);
}
