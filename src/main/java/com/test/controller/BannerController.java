package com.test.controller;

import com.test.service.banner.BannerService;
import com.test.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

        return "admin";
    }

}
