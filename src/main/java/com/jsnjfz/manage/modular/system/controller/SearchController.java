package com.jsnjfz.manage.modular.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jiangjiabin3
 * @Date: Created in 2019/12/21 13:59
 * @Description:
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/key")
    public String search(String key) {
        Map map = new HashMap();
        map.put("key",key);
        return "search.html";
    }

}
