package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Inventory;
import cn.lu.lrp.service.InventoryService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: cn.lu.lrp.controller.BuyerController
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/inv")
@ResponseBody
public class InventoryController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(InventoryController.class);
    private static String MODULE_PATH = "inv/";

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("invs")
    public ResultTable data(PageDomain pageDomain, Inventory param) {
        PageInfo<Inventory> pageInfo = inventoryService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }


}
