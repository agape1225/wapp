package com.test.controller;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        String[] Categories = null;

        for (String category :
                Categories) {
            map.put(category, category);
        }

        System.out.println(map.toString());

        System.out.println(map.get("시그니처"));
    }
}
