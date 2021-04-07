package com.test.controller;

import com.test.dto.InquiryDto;
import com.test.dto.LectureDto;
import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;
import com.test.service.inquiry.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class InquiryController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    InquiryService inquiryService;

    private final SimpleDateFormat dateForServer = new SimpleDateFormat("yyyyMMddHHmmss_");
    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/inquiryRegister")
    public String manage_lecture(Model model){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return "inquiryRegister";
    }

    @PostMapping("/inquiry/addInquiry")
    public String insert(InquiryDto inquiryDto) throws IOException {

        Date currentTime = new Date();
        String regDateForDB = dateForDB.format(currentTime);
        String regDateForServer = dateForServer.format(currentTime);


        inquiryDto.setInqRegDate(regDateForDB); // 현재시간 저장

        String root_path = servletContext.getRealPath("/");
        String filename_server = root_path;

        System.out.println(inquiryDto.getInqTitle());
        System.out.println(inquiryDto.getInqUserName());
        System.out.println(inquiryDto.getInqEmail());
        System.out.println(inquiryDto.getInqQuestion());
        System.out.println(regDateForDB);

        inquiryService.insertInquiry(inquiryDto); // DB에 저장

        return "redirect:/";
    }

//    @GetMapping("/inquiry")
//    public String inquiryRegister() {
//        return "inquiryRegister";
//    }

    @GetMapping("admin/inquiry/data-table")
    public String inquiry_manage(Model model){
        try{
            System.out.println("Start manage_inquiry");
            ArrayList<InquiryDto> inquiryList = inquiryService.readInquiryDataList();
            model.addAttribute("inquiryList", inquiryList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/inquiry/data-table";
    }

//    @RequestMapping(value = "/inquiry", method = RequestMethod.POST)
//    public String insert(InquiryDto inquiryDto) throws IOException {
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(d);
//
//        InquiryDto InqDto = new InquiryDto(
//                inquiryDto.getInqTitle(),
//                inquiryDto.getInqUserName(),
//                inquiryDto.getInqEmail(),
//                inquiryDto.getInqQuestion(),
//                date
//        );
//
//        System.out.println("control " + InqDto.toString());
//
//
//        System.out.println("insert inqDto success");
//        inquiryService.insertInquiry(InqDto); // DB에 저장
//
//        return "redirect:/";
//    }

    @GetMapping("/admin/inquiry/delete")
    public String delete_inq(@RequestParam(value = "inqNo") String inqNo) {
        System.out.println("Start delInq");

        try {
            System.out.println("inqNo: \n\n\n" + inqNo);
            inquiryService.deleteInquiry(inqNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/inquiry/data-table";
    }

}
