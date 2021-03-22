package com.test.controller;

import com.test.dto.BannerDto;
import com.test.service.banner.BannerService;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping(value = "/admin/login/banUpload", method = RequestMethod.POST)
    public String insert(@RequestParam(value = "banTitle") String banTitle,
                         @RequestParam(value = "banContent") String banContent,
                         @RequestParam("banImg") MultipartFile file,
                         HttpServletRequest request) throws IOException {

        String banCount = "0";

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder = File.separator + "resources" + File.separator + "bannerImg" + File.separator;
        System.out.println(webappRoot);
        System.out.println(relativeFolder);

        String filename = webappRoot + relativeFolder + file.getOriginalFilename();
        String banFileName = relativeFolder + file.getOriginalFilename();

        System.out.println(banTitle);
        System.out.println(banContent);
        System.out.println(banCount);
        System.out.println(date);
        System.out.println(banFileName);

        FileCopyUtils.copy(file.getBytes(), new File(filename));

        bannerService.insertBanner(banFileName, banCount,date,banTitle,banContent);

        //lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);

        return "template/demo_1/manage-banner";
    }

    @RequestMapping(value = "/admin/login/banDelete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "banNo") String banNo) {

        try {
            System.out.println("banNo: " + banNo);
            bannerService.deleteBanner(banNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
  
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
