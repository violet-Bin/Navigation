package com.jsnjfz.manage.modular.system.controller;

import com.jsnjfz.manage.core.common.node.MenuNode;
import com.jsnjfz.manage.modular.system.model.Category;
import com.jsnjfz.manage.modular.system.model.Site;
import com.jsnjfz.manage.modular.system.service.CategoryService;
import com.jsnjfz.manage.modular.system.service.ISearchService;
import com.jsnjfz.manage.modular.system.service.impl.CategoryServiceImpl;
import com.jsnjfz.manage.modular.system.service.impl.SearchServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiangjiabin3
 * @Date: Created in 2019/12/21 13:59
 * @Description:
 */
@Controller
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    ISearchService searchService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/key")
    public String index(Model model,String key) throws Exception{
        List<MenuNode> menus = categoryService.getCatogryNode(new HashMap<>());
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        List<Category> categorySiteList = searchService.searchUrl(key);
        model.addAttribute("categorySiteList", categorySiteList);
        model.addAttribute("titles", titles);
        System.out.println(titles);
        return "/index.html";
    }

}
