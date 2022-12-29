package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Order;
import cn.lu.lrp.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @program: cn.lu.lrp.controller.BuyerController
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/order")
@ResponseBody
public class OrderController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static String MODULE_PATH = "order/";

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("orders")
    public ResultTable data(PageDomain pageDomain, Order param) {
        PageInfo<Order> pageInfo = orderService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("save")
    public Result save(@RequestBody Order param) {
        Boolean result = orderService.save(param);
        return decide(result);
    }

}
