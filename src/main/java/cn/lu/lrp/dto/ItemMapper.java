package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Item;
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
public interface ItemMapper {

    Page<Item> selectList(Item param);

    Item selectItemFromItem(Item item);

    /**
     * 添加物资编码
     *
     * @param param
     * @return
     */
    int save(Item param);

    /**
     * 根据物资编码ID 变更状态
     *
     * @param param
     * @return
     */
    int update(Item param);
}
