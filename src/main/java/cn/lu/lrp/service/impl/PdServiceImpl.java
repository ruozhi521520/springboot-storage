package cn.lu.lrp.service.impl;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.dto.PdMapper;
import cn.lu.lrp.entity.Pd;
import cn.lu.lrp.entity.PdLine;
import cn.lu.lrp.service.PdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lull
 */
@Service
public class PdServiceImpl implements PdService {

    PdMapper pdMapper;

    @Autowired
    public PdServiceImpl(PdMapper pdMapper) {
        this.pdMapper = pdMapper;
    }

    @Override
    public PageInfo<Pd> page(Pd param, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<Pd> lists = pdMapper.selectList(param);
        return new PageInfo<>(lists);
    }

    @Override
    public List<Pd> selectPd(Pd param) {
        return pdMapper.selectPd(param);
    }

    @Override
    public int save(Pd param) {
        return pdMapper.save(param);
    }

    @Override
    public List<PdLine> pageLine(int id) {
        return pdMapper.selectLineList(id);
    }


    @Override
    public boolean saveLine(Pd param) {
        int result = pdMapper.saveLine(param);
        return result > 0;
    }
}
