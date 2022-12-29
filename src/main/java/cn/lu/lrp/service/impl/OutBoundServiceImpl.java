package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.OutBoundMapper;
import cn.lu.lrp.entity.OutBound;
import cn.lu.lrp.service.OutBoundService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cn.lu.lrp.service.impl.BuyerServiceImpl
 * @author: lull  
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:29 1、   lull
 **/
@Service
public class OutBoundServiceImpl implements OutBoundService {

    private OutBoundMapper outBoundMapper;

    @Autowired
    public OutBoundServiceImpl(OutBoundMapper outBoundMapper) {
        this.outBoundMapper = outBoundMapper;
    }

    /**
     * 查询出库
     * @param param
     * @param pageDomain
     * @return
     */
    @Override
    public PageInfo<OutBound> page(OutBound param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<OutBound> lists = outBoundMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public List<OutBound> page(OutBound param) {
        return outBoundMapper.selectList(param);
    }

    /**
     * 保存出库
     * @param param
     * @return
     */
    @Override
    public boolean save(OutBound param) {
        int result = outBoundMapper.save(param);
        return result > 0;
    }

    @Override
    public boolean update(OutBound param) {
        int result = outBoundMapper.update(param);
        return result > 0;
    }
}
