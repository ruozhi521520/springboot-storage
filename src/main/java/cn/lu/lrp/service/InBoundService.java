package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.InBound;
import com.github.pagehelper.PageInfo;

public interface InBoundService {

    PageInfo<InBound> page(InBound param, PageDomain pageDomain);

    boolean save(InBound param);

}
