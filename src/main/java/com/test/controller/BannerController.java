package com.test.controller;

import com.test.dto.BannerDto;
import com.test.dto.LectureDto;
import com.test.service.banner.BannerService;
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

    /////////////////////////////////////////////// 배너
    @GetMapping("admin/banner/form")
    public String add_banner(Model model){
        try{
            System.out.println("Start manage_banner");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/banner/form";
    }

    @GetMapping("admin/banner/data-table")
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

    @PostMapping(value = "/admin/addBanner")
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

        return "redirect:/admin/banner/data-table";
    }

    @RequestMapping(value = "/admin/banner/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "banNo") String banNo) {

        try {
            System.out.println("banNo: " + banNo);
            bannerService.deleteBanner(banNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/banner/data-table";
    }

    @GetMapping("/admin/banner/edit")
    public String update_banner_form(@RequestParam(value = "banNo") String banNo,  Model model) {
        System.out.println("Start update lecture form");

        try {
            BannerDto bannerDto = bannerService.readBasicDataByBanNo(banNo);
            model.addAttribute("banner",bannerDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/banner/edit";
    }

    @RequestMapping(value = "/admin/editBanner", method = {RequestMethod.POST, RequestMethod.GET})
    public String update_banner(@RequestParam(value = "banNo") String banNo,
                                 BannerDto bannerDto, MultipartFile banImage,
                                 Model model) {
        System.out.println("Start update lecture");

        try {
            //BannerDto lectureInDb = lectureService.readBasicDataByLecNo(lecNo);
            //System.out.println(lectureInDb.getLecName());
            //String filename = lecImage.getOriginalFilename();
            BannerDto bannerInDb = bannerService.readBasicDataByBanNo(banNo);
            String fileName = banImage.getOriginalFilename();
            if (fileName.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItemWithoutImg");
                bannerDto.setBanImg(bannerInDb.getBanImg()); // db에 있던 배너이미지를 그대로 넣어주기
                //lectureDto.setLecImg(lectureInDb.getLecImg());

            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItemWithImg");

                File targetFile = new File(servletContext.getRealPath("/") + bannerInDb.getBanImg()); // 서버에있는 삭제할 배너파일 지정
                String delName = targetFile.getName(); // 삭제될 배너파일이름
                if (targetFile.delete()) {
                    System.out.println("Deleted file : " + delName);
                } else {
                    System.out.println("Failed to delete the file.");
                }

                // 서버에 사진 저장
                String rootPath = servletContext.getRealPath("/");
                String relativeFolder =  "/files/bannerImage/";
                System.out.println(rootPath + relativeFolder);

                String serverFile = rootPath + relativeFolder + fileName;

                FileCopyUtils.copy(banImage.getBytes(), new File(serverFile)); // 서버에 이미지 저장

                bannerDto.setBanImg("/files/lectureImage/" + fileName); // 새로운 이미지이름으로 dto객체의 이미지이름 저장
            }

            bannerService.updateBanner(banNo, bannerDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/banner/data-table";
    }
}
