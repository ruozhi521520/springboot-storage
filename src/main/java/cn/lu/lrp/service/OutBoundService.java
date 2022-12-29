package cn.lu.lrp.service;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.entity.Buyer;
import cn.lu.lrp.entity.OutBound;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lull
 */
public interface OutBoundService {

    /**
     * 查询出库
     *
     * @param param
     * @return
     */
    PageInfo<OutBound> page(OutBound param, PageDomain pageDomain);

    List<OutBound> page(OutBound param);

    /**
     * 保存出库
     *
     * @param param
     * @return
     */
    boolean save(OutBound param);

    boolean update(OutBound param);
}
