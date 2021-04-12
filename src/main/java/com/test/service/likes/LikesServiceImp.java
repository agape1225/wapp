package com.test.service.likes;

import com.test.dao.LikesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImp implements LikesService{

    @Autowired
    LikesDao likesDao;

    @Override
    public boolean insertLecture(String userNo, String lecNo, String likeDate) {
        return likesDao.insertLikes(userNo, lecNo, likeDate);
    }

    @Override
    public boolean deleteLecture(String userNo, String lecNo) {
        return likesDao.deleteLikes(userNo, lecNo);
    }
}
