package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Inventory;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InventoryService {

    PageInfo<Inventory> page(Inventory param, PageDomain pageDomain);

    List<Inventory> page(Inventory param);

    Inventory selectInvFromItemIdAndStoreId(int itemId, int storeId);

    boolean add(Inventory param);

    boolean update(Inventory param);

}
