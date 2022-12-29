package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Item;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.ItemService
 * @author: lull  
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
public interface ItemService {

    PageInfo<Item> page(Item param, PageDomain pageDomain);

    List<Item> page(Item param);

    Item selectItemFromItem(Item param);

    boolean save(Item param);

    boolean update(Item param);


}
