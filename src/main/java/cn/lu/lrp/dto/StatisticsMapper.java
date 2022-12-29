package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatisticsMapper {

    List<Statistics> selectThisWeek();

}
