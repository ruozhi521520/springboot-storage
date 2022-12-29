package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.OrderMapper;
import cn.lu.lrp.entity.Order;
import cn.lu.lrp.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.BuyerServiceImpl
 * @author: lull lull@shuto.cn
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 查询 账单
     *
     * @param param
     * @param pageDomain
     * @return
     */
    @Override
    public PageInfo<Order> page(Order param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<Order> lists = orderMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    /**
     * 保存
     *
     * @param param
     * @return
     */
    @Override
    public boolean save(Order param) {
        int result = orderMapper.save(param);
        return result > 0;
    }

}
