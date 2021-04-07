package com.test.service.recommended;

import com.test.dao.RecommendedDao;
import com.test.dto.RecommendedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendedServiceImp implements RecommendedService{
    @Autowired
    RecommendedDao recommendedDao;

    @Override
    public void insertRecommended(String lecNo) {
        recommendedDao.insertRecommended(lecNo);
    }

    @Override
    public void deleteRecommended(String lecNo) {
        recommendedDao.deleteRecommended(lecNo);
    }
}
