package com.test.controller;

import com.test.dto.TestDto;
import com.test.service.popup.PopupService;
import com.test.service.test.TestService;
import com.test.util.firebase.FirebaseMessagingSnippets;
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
public class PopupController {
    @Autowired
    PopupService popupService;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/admin/login/manage-popup/popupUpload", method = RequestMethod.POST)
    public String insert(@RequestParam("popoupImg") MultipartFile file,
                         HttpServletRequest request) throws IOException {

        String banCount = "0";

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder = File.separator + "resources" + File.separator + "popupImg" + File.separator;
        System.out.println(webappRoot);
        System.out.println(relativeFolder);

        String filename = webappRoot + relativeFolder + file.getOriginalFilename();
        String banFileName = relativeFolder + file.getOriginalFilename();

        System.out.println(banFileName);

        FileCopyUtils.copy(file.getBytes(), new File(filename));

        popupService.addItem("false",banFileName, date);

        //bannerService.insertBanner(banFileName, banCount,date,banTitle,banContent);
        //lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);

        return "redirect:/admin/login/manage-popup";
    }
}
