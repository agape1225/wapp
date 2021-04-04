package com.test.controller;

import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;
import com.test.dto.UserRegisterDto;
import com.test.service.kakao.KakaoApiService;
import com.test.service.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class UserRegisterController {

    @Autowired
    UserService userService;

    @Autowired
    KakaoApiService kakaoApiService;

    @GetMapping("/user/register")
    public String registerUserView() {
        return "userRegister";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUser(UserRegisterDto userRegisterDto) {

        UserDto originUserDto = userService.readUserInfoListByUserEmail(userRegisterDto.getUserEmail());
        if (originUserDto != null)
            return "userRegister";

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        UserInsertDto userDto = new UserInsertDto(
                userRegisterDto.getUserName(),
                userRegisterDto.getUserEmail(),
                userRegisterDto.getUserPw(),
                date
        );

        System.out.println("control " + userDto.toString());

        userService.insertUser(userDto);

        System.out.println("insert userDto success");
        return "redirect:/user/login";
    }

    @RequestMapping("/user/kakao_login")
    public String kakaoLogIn(@Param(value = "code") String code,
                             HttpServletRequest request,
                             Model model) {
        System.out.println("code : " + code);
        String access_Token = kakaoApiService.getAccessToken(code);
        System.out.println("access_token : " + access_Token);
        HttpSession session = request.getSession();
        HashMap<String, Object> userInfo = kakaoApiService.getUserInfo(access_Token);

        if (userInfo.get("email") != null) {
            String userEmail = userInfo.get("email").toString();
            String userName = userInfo.get("nickname").toString();
            System.out.println("Email : " + userEmail + ", Name : " + userName);
            UserDto existUserList = userService.readUserInfoListByUserEmail(userEmail);
            if (existUserList == null) {
                System.out.println("Registering Kakao User");
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(d);

                UserInsertDto userDto = new UserInsertDto(
                        userName,
                        userEmail,
                        null,
                        date
                );

                System.out.println("control " + userDto.toString());

                userService.insertUser(userDto);
            }else{
                System.out.println("Registered Kakao User");
            }
            if(session.getAttribute("userLogin") != null)
                session.removeAttribute("userLogin");

            UserDto userDto = userService.readUserInfoListByUserEmail(userEmail);
            if(userDto != null && userDto.getUserEmail().equals(userEmail) && userDto.getUserName().equals(userName)){
                session.setAttribute("userLogin", userDto);
            }else {
                //해당 로직을 돌면서 문제 생길 확률이 낮지만 혹시 모를 오류를 위해 등록
                model.addAttribute("msg", "카카오 로그인 오류 및 알 수 없는 오류가 발생했습니다.");
            }

            return "redirect:/";

        } else {
            // 계정에 등록된 이메일이 없음 -> 로그인 안됨 로직 처리
            // 카카오 계정에 이메일이 없다는 알림을 띄운 뒤 일반 회원가입으로 안내하며 메인 로그인 화면으로 돌아오는 게 나아보임
            // 어디서 알람을 띄워야할지 모르겠음.
            return "userLogin";
        }
    }
}