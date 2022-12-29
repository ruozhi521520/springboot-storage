package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.*;
import cn.lu.lrp.service.*;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @program: cn.lu.lrp.controller.BuyerController
 * @author: lull lull@shuto.cn
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/out")
@ResponseBody
public class OutBoundController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(OutBoundController.class);
    private static String MODULE_PATH = "out/";

    private OutBoundService outBoundService;

    private StoreService storeService;

    private ItemService itemService;

    private BuyerService buyerService;

    private InventoryService inventoryService;

    @Autowired
    public OutBoundController(OutBoundService outBoundService,
                              StoreService storeService,
                              ItemService itemService, BuyerService buyerService,
                              InventoryService inventoryService) {
        this.outBoundService = outBoundService;
        this.storeService = storeService;
        this.itemService = itemService;
        this.buyerService = buyerService;
        this.inventoryService = inventoryService;
    }

    @Autowired


    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("outs")
    public ResultTable data(PageDomain pageDomain, OutBound param) {
        PageInfo<OutBound> pageInfo = outBoundService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @GetMapping("outs1")
    public List<OutBound> outs(OutBound param) {
        return outBoundService.page(param);
    }

    @PostMapping("save")
    public Result save(@RequestBody OutBound param) {
        logger.info(param.toString());
        Inventory inventory = inventoryService.selectInvFromItemIdAndStoreId(param.getItemId(), param.getStoreId());
        if (inventory == null) {
            return Result.failure("数据异常");
        }
        Boolean result = outBoundService.save(param);

        int orderQty = inventory.getOrderQty() - param.getOrderQty();
        int issueQty = param.getIssueQty();
        int coeffiCient = inventory.getCoeffiCient();

        if (issueQty > coeffiCient) {
            orderQty = orderQty - issueQty / coeffiCient;
            issueQty = issueQty % coeffiCient;
        }

        if (issueQty > inventory.getIssueQty()) {
            orderQty = orderQty - 1;
            issueQty = inventory.getIssueQty() + coeffiCient - issueQty;
        } else {
            issueQty = inventory.getIssueQty() - issueQty;
        }

        logger.info(orderQty + " = " + issueQty);

        inventory.setOrderQty(orderQty);
        inventory.setIssueQty(issueQty);
        inventoryService.update(inventory);

        return decide(result);
    }

    @GetMapping("stores")
    public List<Store> data(Store param) {
        return storeService.page(param);
    }

    @GetMapping("items")
    public List<Item> data(Item param) {
        return itemService.page(param);
    }

    @GetMapping("buyers")
    public List<Buyer> data(Buyer param) {
        return buyerService.page(param);
    }

    @GetMapping("invs")
    public List<Inventory> data(Inventory param) {
        return inventoryService.page(param);
    }

    @PostMapping("update")
    public Result update(@RequestBody OutBound param) {
        boolean result = outBoundService.update(param);
        return decide(result);
    }
}
