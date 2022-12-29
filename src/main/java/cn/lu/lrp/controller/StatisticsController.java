package cn.lu.lrp.controller;


import cn.lu.lrp.entity.Statistics;
import cn.lu.lrp.service.StatisticsService;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.series.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sta")
@ResponseBody
public class StatisticsController {

    StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("thisWeek")
    public Option selectThisWeek() {
        Option option = new Option();
        List<Statistics> statistics = statisticsService.selectThisWeek();
        if (statistics.isEmpty()) {
            return null;
        }
        for (Statistics statistic : statistics) {
            option.legend(statistic.getStoreName());
            Line line = new Line(statistic.getStoreName());
            line.smooth(true).itemStyle().normal().areaStyle().typeDefault();
            line.data(statistic.getJanuary(),
                    statistic.getFebruary(),
                    statistic.getMarch(),
                    statistic.getApril(),
                    statistic.getMay(),
                    statistic.getJune(),
                    statistic.getJuly(),
                    statistic.getAugust(),
                    statistic.getSeptember(),
                    statistic.getOctober(),
                    statistic.getNovember(),
                    statistic.getDecember());
            option.series(line);
        }

        return option;
    }


}
