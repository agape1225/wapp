package com.test.controller;

import com.test.dto.LectureDto;
import com.test.dto.LectureUpdateDto;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class LectureController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    LectureService lectureService;

    /*@GetMapping("/admin/login/manage-lecture")
    public String test(Model model) {
        try {
            ArrayList<LectureDto> lectureList = lectureService.readBasicDataList();
            model.addAttribute("lectureList", lectureList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "template/demo_1/manage-lecture";
    }*/

    @GetMapping("/admin/login/lecture/delete.do")
    public String delete_lec(@RequestParam(value = "lecNo") String lecNo) {
        System.out.println("Start delLecture");

        try {
            System.out.println("lecNo: \n\n\n" + lecNo);
            lectureService.deleteLecture(lecNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login/lecture/data-table.do";
    }

///

    @RequestMapping(value = "/admin/login/addLecture.do", method = RequestMethod.POST)
    public String insert(@RequestParam(value = "lecCategory") String lecCategory,
                         @RequestParam(value = "lecName") String lecName,
                         @RequestParam(value = "lecPrice") String lecPrice,
                         @RequestParam("lecImg") MultipartFile file,
                         RedirectAttributes   redirect,
                         HttpServletRequest request) throws IOException {

        // String path = new
        // ClassPathResource("/src/main/resources/uploads").getPath();

        // FileCopyUtils.copy(file.getBytes(), new File(path));

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        System.out.println(lecCategory);
        System.out.println(lecName);
        System.out.println(lecPrice);
        System.out.println(date);

        String webappRoot = servletContext.getRealPath("/");
        String relativeFolder =  "/files/img/";
        System.out.println(webappRoot);
        System.out.println(relativeFolder);

        String filename = webappRoot + relativeFolder + file.getOriginalFilename();
        String lecFileName = relativeFolder + file.getOriginalFilename();

        System.out.println(lecCategory);
        System.out.println(lecName);
        System.out.println(lecPrice);
        System.out.println(date);
        System.out.println(lecFileName);

        FileCopyUtils.copy(file.getBytes(), new File(filename));

        lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("id", "root");
        map.put("password", "1234");
        redirect.addFlashAttribute("vo", map);

        return "redirect:/admin/login/lecture/data-table.do";
    }
    ///admin/popup/edit.do
    @GetMapping("/admin/login/lecture/edit.do")
    public String update_lecture_form(@RequestParam(value = "lecNo") String lecNo,  Model model) {
        System.out.println("Start update lecture form");

        try {
            LectureDto lecDto = lectureService.readBasicDataByLecNo(lecNo);
            model.addAttribute("lecture",lecDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/lecture/edit";
    }

    @RequestMapping(value = "/admin/login/editLecture.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String update_lecture(@RequestParam(value = "lecNo") String lecNo, LectureDto lectureDto, MultipartFile lecImage, Model model) {
        System.out.println("Start update lecture");

        try {
            LectureDto lectureInDb = lectureService.readBasicDataByLecNo(lecNo);

            String filename = lecImage.getOriginalFilename();
            if (filename.isEmpty()) { // 이미지이름이 빈칸 == 이미지새로 업로드 안함
                System.out.println("editItemWithoutImg");

                lectureDto.setLecImg(lectureInDb.getLecImg()); // db에 있던 배너이미지를 그대로 넣어주기
            } else { // 이미지 이름이 있으면 기존이미지 삭제 후 새이미지를 저장
                System.out.println("editItemWithImg");

                File targetFile = new File(servletContext.getRealPath("/") + lectureInDb.getLecImg()); // 서버에있는 삭제할 배너파일 지정
                String delName = targetFile.getName(); // 삭제될 배너파일이름
                if (targetFile.delete()) {
                    System.out.println("Deleted file : " + delName);
                } else {
                    System.out.println("Failed to delete the file.");
                }

                // 서버에 사진 저장
                String rootPath = servletContext.getRealPath("/");
                String relativeFolder =  "/files/img/";
                System.out.println(rootPath + relativeFolder);

                String serverFile = rootPath + relativeFolder + filename;

                FileCopyUtils.copy(lecImage.getBytes(), new File(serverFile)); // 서버에 이미지 저장

                lectureDto.setLecImg("/files/img/" + filename); // 새로운 이미지이름으로 dto객체의 이미지이름 저장
            }
            System.out.println(lectureDto.getLecCategory());
            System.out.println(lectureDto.getLecName());
            System.out.println(lectureDto.getLecPrice());
            System.out.println(lectureDto.getLecImg());
            lectureService.updateLecture(lecNo, lectureDto); // db에 저장


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/login/lecture/data-table.do";
    }




//    @RequestMapping(value = "/admin/login/manage-lecture/lecUpload", method = RequestMethod.POST)
//    public String insert(@RequestParam(value = "lecCategory") String lecCategory,
//                         @RequestParam(value = "lecName") String lecName,
//                         @RequestParam(value = "lecPrice") String lecPrice,
//                         @RequestParam("lecImg") MultipartFile file,
//                         RedirectAttributes   redirect,
//                         HttpServletRequest request) throws IOException {
//
//        // String path = new
//        // ClassPathResource("/src/main/resources/uploads").getPath();
//
//        // FileCopyUtils.copy(file.getBytes(), new File(path));
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(d);
//
//        System.out.println(lecCategory);
//        System.out.println(lecName);
//        System.out.println(lecPrice);
//        System.out.println(date);
//
//        String webappRoot = servletContext.getRealPath("/");
//        //webappRoot = webappRoot.replace("/","");
//        String relativeFolder =  "files" + File.separator + "img" + File.separator;
//        System.out.println(webappRoot);
//        System.out.println(relativeFolder);
//
//        String filename = webappRoot + relativeFolder + file.getOriginalFilename();
//        String lecFileName = relativeFolder + file.getOriginalFilename();
//
//        System.out.println(lecCategory);
//        System.out.println(lecName);
//        System.out.println(lecPrice);
//        System.out.println(date);
//        System.out.println(lecFileName);
//
//        FileCopyUtils.copy(file.getBytes(), new File(filename));
//
//        lectureService.insertLecture(lecCategory, lecName, lecPrice, date, lecFileName);
//
//        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("id", "root");
//        map.put("password", "1234");
//        redirect.addFlashAttribute("vo", map);
//
//        return "redirect:/admin/login/manage-lecture";
//    }

    @GetMapping("/admin/login/update/{lecNo}")
    public String lectureUpdate(@PathVariable(value = "lecNo") String lecNo, Model model) {
        System.out.println(lecNo);
        LectureDto lectureDto = lectureService.readBasicDataByLecNo(lecNo);
        model.addAttribute("lecture", lectureDto);

        return "template/demo_1/lecture-update";
    }

    @GetMapping("/admin/login/detail")
    public String detail(@RequestParam(value = "lecNo") String lecNo,
                         Model model)
    {
        try {
            LectureDto lectureDetail = lectureService.readBasicDataByLecNo(lecNo);
            model.addAttribute("Lecture_Detail", lectureDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "template/demo_1/manage-lecture";
    }

    @GetMapping("/admin/login/specific_search")
    public String specificSearch(@RequestParam(value = "LecName", required = false) String lecName,
                                 @RequestParam(value = "minPrice", required = false) String minPrice,
                                 @RequestParam(value = "maxPrice", required = false) String maxPrice,
                                 @RequestParam(value = "LecCategory", required = false) String lecCategory,
                                 Model model)
    {
        try {
            if(lecName != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecName(lecName);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else if(lecCategory != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecCategory(lecCategory);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else if(minPrice != null && maxPrice != null){
                ArrayList<LectureDto> searchedLecture = lectureService.readBasicDataByLecPrice(minPrice, maxPrice);
                model.addAttribute("searched_Lecture", searchedLecture);
            }else{
                //검색어가 없을 때의 경우 : 웹에서 검색을 할 때 아무것도 입력하지 않으면 or 가격 범위를 제대로 설정하지 않으면 이 함수 자체에 들어오지 않도록 구현해야합니다.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "\"template/demo_1/manage-lecture\"";
    }

}
