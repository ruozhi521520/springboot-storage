package cn.lu.lrp.service.impl;

import cn.lu.lrp.dto.StatisticsMapper;
import cn.lu.lrp.entity.Statistics;
import cn.lu.lrp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {


    StatisticsMapper statisticsMapper;

    @Autowired
    public StatisticsServiceImpl(StatisticsMapper statisticsMapper) {
        this.statisticsMapper = statisticsMapper;
    }

    @Override
    public List<Statistics> selectThisWeek() {
        return statisticsMapper.selectThisWeek();
    }
}
