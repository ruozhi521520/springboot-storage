package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Store;
import cn.lu.lrp.service.StoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: cn.lu.lrp.controller.ItemController
 * @author: lull  
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/store")
@ResponseBody
public class StoreController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(StoreController.class);

    private static String MODULE_PATH = "store/";

    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add(Model model) {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("stores")
    public ResultTable data(PageDomain pageDomain, Store param) {
        PageInfo<Store> pageInfo = storeService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("save")
    public Result save(@RequestBody Store store) {
        Boolean result = storeService.save(store);
        return decide(result);
    }

    @PostMapping("update")
    public Result update(@RequestBody Store store) {
        boolean result = storeService.update(store);
        return decide(result);
    }

}
