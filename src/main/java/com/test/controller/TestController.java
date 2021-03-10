package com.test.controller;

import com.test.dto.CategoryDto;
import com.test.dto.TestDto;
import com.test.service.category.CatrgoryService;
import com.test.service.test.TestService;
import com.test.util.firebase.FirebaseMessagingSnippets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    CatrgoryService catrgoryService;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;

    @GetMapping("/")
    public String main(Model model){
        try{
            System.out.println("양동균 개새1끼");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/test.do")
    public String test(Model model){
        try{
            System.out.println("test.do Controller");
            ArrayList<TestDto> itemList = testService.getItemList();
            ArrayList<CategoryDto> categoryList = catrgoryService.getCategoryList();
            model.addAttribute("itemList", itemList);
            model.addAttribute("categoryList",categoryList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "test";
    }

    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    public String get(@RequestParam(value = "data") String data){
        try{
            System.out.println("controller: " + data);
            testService.addItem(data);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/test.do";
    }

    @RequestMapping(value = "/post.do", method = RequestMethod.POST)
    public String post(@RequestParam(value = "data") String data){
        try{
            System.out.println("post방식 data: " + data);
            testService.addItem(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/test.do";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "number") String number){
        try{
            System.out.println("number: " + number);
            testService.deleteItem(number);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/test.do";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    public String updateView(Model model, @RequestParam(value = "number") String number ){
        try{
            System.out.println("number: " + number);
            model.addAttribute("number", number);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/update";
    }

    @RequestMapping(value = "/update.do/update", method = RequestMethod.POST)
    public String update(@RequestParam(value = "number") String number, @RequestParam(value = "data") String data){
        try{
            System.out.println("number: " + number);
            System.out.println("data: " + data);
            testService.updateItem(number,data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/test.do";
    }

    @GetMapping("/fcm.do")
    public String fcm(@RequestParam(value = "fcm") String fcm, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content, HttpServletRequest req){
        try{
            System.out.println("fcm: " + fcm);
            System.out.println("title: " + title);
            System.out.println("content: " + content);
            firebaseMessagingSnippets.test_send_FCM(fcm, title, content, req);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
