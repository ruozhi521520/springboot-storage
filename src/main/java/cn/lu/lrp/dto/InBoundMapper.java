package cn.lu.lrp.dto;

import cn.lu.lrp.entity.InBound;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: cn.lu.lrp.dto.ItemDto
 * @author: lull lull@shuto.cn
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@Mapper
@Repository
public interface InBoundMapper {

    Page<InBound> selectList(InBound param);

    int save(InBound param);

}
