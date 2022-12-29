package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Item;
import cn.lu.lrp.service.ItemService;
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
@RequestMapping("/item")
@ResponseBody
public class ItemController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

    private static String MODULE_PATH = "item/";

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add(Model model) {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("items")
    public ResultTable data(PageDomain pageDomain, Item param) {
        PageInfo<Item> pageInfo = itemService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("save")
    public Result save(@RequestBody Item param) {
        Boolean result = itemService.save(param);
        return decide(result);
    }

    @PostMapping("update")
    public Result update(@RequestBody Item param) {
        boolean result = itemService.update(param);
        return decide(result);
    }

}
