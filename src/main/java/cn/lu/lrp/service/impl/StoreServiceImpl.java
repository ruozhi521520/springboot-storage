package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.StoreMapper;
import cn.lu.lrp.entity.Store;
import cn.lu.lrp.service.StoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.ItemServiceImpl
 * @author: lull lull@shuto.cn
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
@Service
public class StoreServiceImpl implements StoreService {

    private StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }


    @Override
    public PageInfo<Store> page(Store param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<Store> lists = storeMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public List<Store> page(Store param) {
        return storeMapper.selectList(param);
    }

    @Override
    public Store selectStoreFromStore(Store store) {
        return storeMapper.selectStoreFromStore(store);
    }

    @Override
    public boolean save(Store param) {
        int result = storeMapper.save(param);
        return result > 0;
    }

    @Override
    public boolean update(Store param) {
        int result = storeMapper.update(param);
        return result > 0;
    }
}
