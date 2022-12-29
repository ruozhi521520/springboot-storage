package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.BuyerMapper;
import cn.lu.lrp.entity.Buyer;
import cn.lu.lrp.service.BuyerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.BuyerServiceImpl
 * @author: lull lull@shuto.cn
 * @create: 2021-04-05
 * @version:
 *     <p>2021-04-05 14:29 1、 lull
 */
@Service
public class BuyerServiceImpl implements BuyerService {

  private BuyerMapper buyerMapper;

  @Autowired
  public BuyerServiceImpl(BuyerMapper buyerMapper) {
    this.buyerMapper = buyerMapper;
  }

  @Override
  public PageInfo<Buyer> page(Buyer param, PageDomain pageDomain) {
    PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
    List<Buyer> lists = buyerMapper.selectList(param);
    return new PageInfo<>(lists);
  }

  @Override
  public List<Buyer> page(Buyer param) {
    return buyerMapper.selectList(param);
  }

  @Override
  public Buyer getBuyerByID(int id) {
    return buyerMapper.getBuyerByID(id);
  }

  @Override
  public Buyer getBuyerByBuyer(Buyer param) {
    return buyerMapper.getBuyerByBuyer(param);
  }

  @Override
  public boolean save(Buyer param) {
    int result = buyerMapper.save(param);
    return result > 0;
  }

  @Override
  public boolean update(Buyer param) {
    int result = buyerMapper.update(param);
    return result > 0;
  }
}
