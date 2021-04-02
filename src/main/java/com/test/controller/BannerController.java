package com.test.controller;

import com.test.dto.BannerDto;
import com.test.dto.LectureDto;
import com.test.service.banner.BannerService;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class BannerController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    BannerService bannerService;

    @GetMapping("admin/login/banner/data-table.do")
    public String banner_manage(Model model){
        try{
            System.out.println("Start manage_banner");
            ArrayList<BannerDto> bannerDto = bannerService.readBasicDataList();
            model.addAttribute("bannerData",bannerDto);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/data-table";
    }

    @PostMapping(value = "/admin/login/addBanner.do")
    public String insert_banner(BannerDto bannerDto,
                         MultipartFile banImage,
                         HttpServletRequest request) throws IOException {

        System.out.println(bannerDto.getBanTitle());
        System.out.println(bannerDto.getBanContent());

        //String banCount = "0";

        //set banner count
        bannerDto.setBanCount("0");

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateForImage = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date = sdf.format(d);
        String dateForImg = dateForImage.format(d);

        dateForImg = dateForImg.replace('.','_');
        dateForImg = dateForImg.replace(':','_');

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder =  "/files/bannerImage/";



        System.out.println(webappRoot);
        System.out.println(relativeFolder);

        String filename = webappRoot + relativeFolder + dateForImg + banImage.getOriginalFilename();
        String banFileName = relativeFolder + dateForImg +banImage.getOriginalFilename();

        //set ban file
        bannerDto.setBanImg(banFileName);

        //set reg date
        bannerDto.setBanRegDate(date);
        FileCopyUtils.copy(banImage.getBytes(), new File(filename));

        System.out.println(bannerDto.getBanImg());
        System.out.println(bannerDto.getBanContent());
        System.out.println(bannerDto.getBanRegDate());
        System.out.println(bannerDto.getBanTitle());
        System.out.println(bannerDto.getBanCount());

        bannerService.insertBanner(bannerDto);
        //lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);

        return "redirect:/admin/login/banner/data-table.do";
    }

    @RequestMapping(value = "/admin/login/banner/delete.do", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "banNo") String banNo) {

        try {
            System.out.println("banNo: " + banNo);
            bannerService.deleteBanner(banNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login/banner/data-table.do";
    }
  
    @GetMapping(value = "/admin/login/bannerList")
    public String readBasicDataList(Model model){
        ArrayList<BannerDto> bannerList =  bannerService.readBasicDataList();
        model.addAttribute("bannerList", bannerList);

        return "template/demo_1/manage-banner";
    }

    @GetMapping(value = "/admin/login/banner_data")
    public String readBasicDataByBanNo(@RequestParam(value = "banNo") String banNo, Model model){
        BannerDto banner =  bannerService.readBasicDataByBanNo(banNo);
        model.addAttribute("banner_detail", banner);

        return "template/demo_1/manage-banner";
    }

}
