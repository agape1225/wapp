package com.test.service.benefit;

import com.test.dao.BenefitDao;
import com.test.dto.BenefitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BenefitServiceImp implements BenefitService {
    @Autowired
    BenefitDao benefitDao;

    @Override
    public ArrayList<BenefitDto> getBenefitList() {
        return benefitDao.getBenefitList();
    }

    @Override
    public void deleteItem(String benNo) {
        benefitDao.deleteItem(benNo);
    }

    @Override
    public void addItem(BenefitDto benefitDto) {
        benefitDao.addItem(benefitDto);
    }

    @Override
    public void editItem(BenefitDto benefitDto){
        benefitDao.editItem(benefitDto);
    }

    @Override
    public BenefitDto selectItem(String benNo) {
        return benefitDao.selectItem(benNo);
    }

}
