package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.InBoundMapper;
import cn.lu.lrp.entity.InBound;
import cn.lu.lrp.service.InBoundService;
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
public class InBoundServiceImpl implements InBoundService {

    private InBoundMapper inBoundMapper;

    @Autowired
    public InBoundServiceImpl(InBoundMapper inBoundMapper) {
        this.inBoundMapper = inBoundMapper;
    }

    @Override
    public PageInfo<InBound> page(InBound param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<InBound> lists = inBoundMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public boolean save(InBound param) {
        int result = inBoundMapper.save(param);
        return result > 0;
    }

}
