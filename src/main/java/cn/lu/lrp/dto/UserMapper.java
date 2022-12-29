package cn.lu.lrp.dto;

import cn.lu.lrp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: cn.lu.lrp.dto.ItemDto
 * @author: lull lull@shuto.cn
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@Mapper
@Repository
public interface UserMapper {

    User selectByUsername(@Param("userName") String userName);
}
