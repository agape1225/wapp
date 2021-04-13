package com.test.controller;

import com.test.dto.LectureDto;
import com.test.service.lecture.LectureService;
import com.test.statics.Categories;
import com.test.statics.SortOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    LectureService lectureService;

    @GetMapping("/search")
    public String searchForUser(Model model,
                                @RequestParam(value = "query", defaultValue = "") String query,
                                @RequestParam(value = "sort", defaultValue = "accuracyOrder", required = false) String sortKey,
                                String... category
                                ) {
        System.out.println("검색페이지");
        Map<String, String> categories = new HashMap<String, String>();
        if (category != null)
            for (String c : category) {
                categories.put(c, c);
                System.out.println(c);
            }
        System.out.println(categories.toString());
        System.out.println(sortKey);

        String[] strQueries = query.split(" ");
        System.out.println(Arrays.toString(strQueries));

        ArrayList<LectureDto> lectureList = lectureService.readBasicDataListBySearch(strQueries,category,sortKey);

        model.addAttribute("lectureList", lectureList);
        model.addAttribute("query", query);
        model.addAttribute("categories", categories);
        model.addAttribute("sortKey", sortKey);
        model.addAttribute("categoryList", Categories.categories);
        model.addAttribute("sortListENG", SortOrders.sortOrdersENG);
        model.addAttribute("sortListKOR", SortOrders.sortOrdersKOR);

        return "lectureSearch";
    }
}
