package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Store;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StoreMapper {

    Page<Store> selectList(Store param);

    Store selectStoreFromStore(Store store);

    int save(Store param);

    int update(Store param);
}