package cn.lu.lrp.controller;

import cn.hutool.core.date.DateUtil;
import cn.lu.lrp.controller.domain.PageDomain;
import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.controller.domain.ResultTable;
import cn.lu.lrp.entity.Pd;
import cn.lu.lrp.entity.PdLine;
import cn.lu.lrp.entity.Store;
import cn.lu.lrp.service.PdService;
import cn.lu.lrp.service.StoreService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pd")
@ResponseBody
public class PdController extends ResultController {

    private final static Logger logger = LoggerFactory.getLogger(BuyerController.class);
    private static String MODULE_PATH = "pd/";

    private PdService pdService;

    private StoreService storeService;

    @Autowired
    public PdController(PdService pdService, StoreService storeService) {
        this.pdService = pdService;
        this.storeService = storeService;
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage(MODULE_PATH + "main");
    }

    @GetMapping("add")
    public ModelAndView add() {
        return jumpPage(MODULE_PATH + "operate/add");
    }

    @GetMapping("pds")
    public ResultTable data(PageDomain pageDomain, Pd param) {
        PageInfo<Pd> pageInfo = pdService.page(param, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    @GetMapping("pdlines")
    public ModelAndView list(Model model, int id) {
        model.addAttribute("id", id);
        return jumpPage(MODULE_PATH + "operate/list");
    }

    @GetMapping("datas")
    public ResultTable data(int id) {
        List<PdLine> pdLines = pdService.pageLine(id);
        return pageTable(pdLines, pdLines.size());
    }

    @PostMapping("save")
    public Result save(@RequestBody Pd param) {
        int year = DateUtil.year(new Date());
        int month = DateUtil.month(new Date()) + 1;
        param.setYear(year);
        param.setMonth(month);
        param.setRemark(param.getRemark());
        List<Pd> pds = pdService.selectPd(param);

        Store store = new Store();
        store.setId(param.getStoreId());
        Store store1 = storeService.selectStoreFromStore(store);

        if (pds.isEmpty()) {
            param.setPdName(year + "年" + month + "月-" + store1.getStoreName() + "-第1次-盘点");
        } else {
            int size = pds.size() + 1;
            param.setPdName(year + "年" + month + "月-" + store1.getStoreName() + "-第" + size + "次-盘点");
        }
        pdService.save(param);
        pdService.saveLine(param);
        return Result.success("操作成功");
    }


}
