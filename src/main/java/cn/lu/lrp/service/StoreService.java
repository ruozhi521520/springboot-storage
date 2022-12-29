package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Store;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StoreService {

    PageInfo<Store> page(Store param, PageDomain pageDomain);

    List<Store> page(Store param);

    Store selectStoreFromStore(Store store);

    boolean save(Store param);

    boolean update(Store param);

}
