package com.test.service.likes;

import com.test.dao.LikesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImp implements LikesService{

    @Autowired
    LikesDao likesDao;

    @Override
    public void insertLecture(String userNo, String lecNo, String likeDate) {
        likesDao.insertLikes(userNo, lecNo, likeDate);
    }

    @Override
    public void deleteLecture(String userNo, String lecNo) {
        likesDao.deleteLikes(userNo, lecNo);
    }
}
