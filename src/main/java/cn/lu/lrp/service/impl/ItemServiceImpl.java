package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.ItemMapper;
import cn.lu.lrp.entity.Item;
import cn.lu.lrp.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.ItemServiceImpl
 * @author: lull  
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
@Service
public class ItemServiceImpl implements ItemService {

    private ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public PageInfo<Item> page(Item param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<Item> lists = itemMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public List<Item> page(Item param) {
        return itemMapper.selectList(param);
    }

    @Override
    public Item selectItemFromItem(Item param) {
        return itemMapper.selectItemFromItem(param);
    }

    @Override
    public boolean save(Item param) {
        int result = itemMapper.save(param);
        return result > 0;
    }

    @Override
    public boolean update(Item param) {
        int result = itemMapper.update(param);
        return result > 0;
    }


}
