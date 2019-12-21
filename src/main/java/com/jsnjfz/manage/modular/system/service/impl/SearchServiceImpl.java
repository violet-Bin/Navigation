package com.jsnjfz.manage.modular.system.service.impl;

import com.jsnjfz.manage.modular.system.dao.CategoryMapper;
import com.jsnjfz.manage.modular.system.dao.SiteMapper;
import com.jsnjfz.manage.modular.system.model.Category;
import com.jsnjfz.manage.modular.system.model.Site;
import com.jsnjfz.manage.modular.system.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Date: 2019/12/21
 */
@Service
@Slf4j
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private SiteMapper siteMapper;

    @Autowired
    CategoryMapper categoryMapper;

  /*  @Override
    public List<Site> searchUrl(String key) throws Exception{
        List<Site> siteList = null;
        siteList = siteMapper.searchSiteByKey(key);
        return siteList;
    }*/

    @Override
    public List<Category> searchUrl(String key) throws Exception{
        List<Category> categoryList = categoryMapper.getList(null);
        List<Site> siteList = siteMapper.searchSiteByKey(key);
        for (Category category:categoryList) {
            List<Site> sites = new ArrayList<>();
            for (Site site:siteList){
                if (site.getCategoryId() == category.getId()){
                    sites.add(site);
                }
            }
            category.setSites(sites);
        }
        return categoryList;
    }
}
