package cn.lu.lrp.dto;

import cn.lu.lrp.entity.OutBound;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: cn.lu.lrp.dto.OutBoundMapper
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@Mapper
@Repository
public interface OutBoundMapper {

    /**
     * 查询出库
     *
     * @param param
     * @return
     */
    Page<OutBound> selectList(OutBound param);

    /**
     * 保存出库
     *
     * @param param
     * @return
     */
    int save(OutBound param);

    int update(OutBound param);
}
