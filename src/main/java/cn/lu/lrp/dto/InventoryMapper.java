package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Inventory;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InventoryMapper {

    Page<Inventory> selectList(Inventory param);

    Inventory selectInvFromItemIdAndStoreId(@Param("itemId") int itemId, @Param("storeId") int storeId);

    int add(Inventory param);

    int update(Inventory param);

}
