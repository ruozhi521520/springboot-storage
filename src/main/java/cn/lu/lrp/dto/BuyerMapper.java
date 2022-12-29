package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Buyer;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: cn.lu.lrp.dto.ItemDto
 * @author: lull  
 * @create: 2021-04-03
 * @version:
 *     <p>2021-04-03 16:53 1、 lull
 */
@Mapper
@Repository
public interface BuyerMapper {

  Page<Buyer> selectList(Buyer param);

  Buyer getBuyerByID(@Param("id") int id);

  Buyer getBuyerByBuyer(Buyer param);

  int save(Buyer param);

  int update(Buyer param);
}
