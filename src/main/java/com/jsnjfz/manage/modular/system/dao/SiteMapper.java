package com.jsnjfz.manage.modular.system.dao;

import com.jsnjfz.manage.modular.system.model.Site;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteMapper extends BaseDao<Site> {

    public List<Site> searchSiteByKey(@Param(value="searchkey") String searchkey) throws Exception;

}