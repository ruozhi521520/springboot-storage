package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.InBound;
import cn.lu.lrp.entity.Inventory;
import cn.lu.lrp.entity.Item;
import cn.lu.lrp.entity.Store;
import cn.lu.lrp.service.InBoundService;
import cn.lu.lrp.service.InventoryService;
import cn.lu.lrp.service.ItemService;
import cn.lu.lrp.service.StoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @program: cn.lu.lrp.controller.BuyerController
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/in")
@ResponseBody
public class InBoundController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(InBoundController.class);
    private static String MODULE_PATH = "in/";

    private InBoundService inBoundService;

    private StoreService storeService;

    private ItemService itemService;

    private InventoryService inventoryService;

    @Autowired
    public InBoundController(InBoundService inBoundService,
                             StoreService storeService,
                             ItemService itemService,
                             InventoryService inventoryService) {
        this.inBoundService = inBoundService;
        this.storeService = storeService;
        this.itemService = itemService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("ins")
    public ResultTable data(PageDomain pageDomain, InBound param) {
        PageInfo<InBound> pageInfo = inBoundService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("save")
    public Result save(@RequestBody InBound param) {
        Boolean result = inBoundService.save(param);
        Inventory inventory = inventoryService.selectInvFromItemIdAndStoreId(param.getItemId(), param.getStoreId());
        if (inventory == null) {
            inventory = new Inventory();
            inventory.setItemId(param.getItemId());
            inventory.setStoreId(param.getStoreId());
            inventory.setOrderQty(param.getOrderQty());
            inventory.setIssueQty(param.getIssueQty());
            inventoryService.add(inventory);
        } else {
            int orderQty = inventory.getOrderQty() + param.getOrderQty();
            int issueQty = inventory.getIssueQty() + param.getIssueQty();
            int coeffiCient = inventory.getCoeffiCient();
            if (issueQty > coeffiCient) {
                orderQty = orderQty + issueQty / coeffiCient;
                issueQty = issueQty % coeffiCient;
            }
            inventory.setOrderQty(orderQty);
            inventory.setIssueQty(issueQty);
            inventoryService.update(inventory);
        }
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


}
