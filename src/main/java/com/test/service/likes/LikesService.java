package com.test.service.likes;

public interface LikesService {
    boolean insertLecture(String userNo, String lecNo, String likeDate);

    boolean deleteLecture(String userNo, String lecNo);
}
