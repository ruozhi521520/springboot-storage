package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Pd;
import cn.lu.lrp.entity.PdLine;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lull
 */
public interface PdService {

    PageInfo<Pd> page(Pd param, PageDomain pageDomain);

    List<Pd> selectPd(Pd param);

    int save(Pd param);

    List<PdLine> pageLine(int id);

    boolean saveLine(Pd param);
}
