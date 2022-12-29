package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Buyer;
import cn.lu.lrp.service.BuyerService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: cn.lu.lrp.controller.BuyerController
 * @author: lull lull@shuto.cn
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 16:53 1、   lull
 **/
@RestController
@RequestMapping("/buyer")
@ResponseBody
public class BuyerController extends ResultController {
    private final static Logger logger = LoggerFactory.getLogger(BuyerController.class);
    private static String MODULE_PATH = "buyer/";

    private BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("list")
    public ModelAndView list(Model model, int id) {
        model.addAttribute("buyer", buyerService.getBuyerByID(id));
        return jumpPage(MODULE_PATH + "operate/list");
    }

    @GetMapping("buyers")
    public ResultTable data(PageDomain pageDomain, Buyer param) {
        PageInfo<Buyer> pageInfo = buyerService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @PostMapping("save")
    public Result save(@RequestBody Buyer param) {
        Boolean result = buyerService.save(param);
        return decide(result);
    }

    @GetMapping("edit")
    public ModelAndView edit(Model model, int id) {
        model.addAttribute("buyer", buyerService.getBuyerByID(id));
        return jumpPage(MODULE_PATH + "operate/edit");
    }

    @PostMapping("update")
    public Result update(@RequestBody Buyer param) {
        boolean result = buyerService.update(param);
        return decide(result);
    }


}
