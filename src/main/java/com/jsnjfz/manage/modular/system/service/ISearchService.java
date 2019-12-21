package com.jsnjfz.manage.modular.system.service;

import com.jsnjfz.manage.modular.system.model.Category;
import com.jsnjfz.manage.modular.system.model.Site;

import java.util.List;

/**
 * @description:
 * @Date: 2019/12/21
 */
public interface ISearchService {
    public List<Category> searchUrl(String key) throws Exception;

}
