package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Order;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: cn.lu.lrp.dto.ItemDto
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 查询 账单
     *
     * @param param
     * @return
     */
    Page<Order> selectList(Order param);

    /**
     * 保存
     *
     * @param param
     * @return
     */
    int save(Order param);

}
