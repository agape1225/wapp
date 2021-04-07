package com.test.service.likes;

public interface LikesService {
    void insertLecture(String userNo, String lecNo, String likeDate);

    void deleteLecture(String userNo, String lecNo);
}
