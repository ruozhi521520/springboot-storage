package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Buyer;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lull
 */
public interface BuyerService {

    PageInfo<Buyer> page(Buyer param, PageDomain pageDomain);

    List<Buyer> page(Buyer param);

    Buyer getBuyerByID(int id);

    Buyer getBuyerByBuyer(Buyer param);

    boolean save(Buyer param);

    boolean update(Buyer param);

}
