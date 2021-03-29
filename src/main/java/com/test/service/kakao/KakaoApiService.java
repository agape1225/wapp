package com.test.service.kakao;

import java.util.HashMap;

public interface KakaoApiService {
   String getAccessToken(String authorize_code);
   HashMap<String, Object> getUserInfo (String access_Token);
}
