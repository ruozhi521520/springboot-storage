package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Order;
import com.github.pagehelper.PageInfo;

public interface OrderService {

    /**
     * 查询 账单
     *
     * @param param
     * @return
     */
    PageInfo<Order> page(Order param, PageDomain pageDomain);

    /**
     * 保存
     *
     * @param param
     * @return
     */
    boolean save(Order param);
}
