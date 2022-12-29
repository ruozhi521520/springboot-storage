package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.InventoryMapper;
import cn.lu.lrp.entity.Inventory;
import cn.lu.lrp.service.InventoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.BuyerServiceImpl
 * @author: lull lull@shuto.cn
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
@Service
public class InventoryrServiceImpl implements InventoryService {

    private InventoryMapper inventoryMapper;

    @Autowired
    public InventoryrServiceImpl(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public PageInfo<Inventory> page(Inventory param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<Inventory> lists = inventoryMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public List<Inventory> page(Inventory param) {
        return inventoryMapper.selectList(param);
    }

    @Override
    public Inventory selectInvFromItemIdAndStoreId(int itemId, int storeId) {
        return inventoryMapper.selectInvFromItemIdAndStoreId(itemId, storeId);
    }

    @Override
    public boolean add(Inventory param) {
        int result = inventoryMapper.add(param);
        return result > 0;
    }

    @Override
    public boolean update(Inventory param) {
        int result = inventoryMapper.update(param);
        return result > 0;
    }


}
