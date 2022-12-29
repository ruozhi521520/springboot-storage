package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.entity.*;
import cn.lu.lrp.service.*;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author lull */
@RestController
@RequestMapping("/imp")
@ResponseBody
public class ImpExcelController extends ResultController {
  private static final Logger logger = LoggerFactory.getLogger(BuyerController.class);

  ItemService itemService;

  BuyerService buyerService;

  StoreService storeService;

  OutBoundService outBoundService;

  InBoundService inBoundService;

  InventoryService inventoryService;

  @Autowired
  public ImpExcelController(
      ItemService itemService,
      BuyerService buyerService,
      StoreService storeService,
      OutBoundService outBoundService,
      InBoundService inBoundService,
      InventoryService inventoryService) {
    this.itemService = itemService;
    this.buyerService = buyerService;
    this.storeService = storeService;
    this.outBoundService = outBoundService;
    this.inBoundService = inBoundService;
    this.inventoryService = inventoryService;
  }

  @PostMapping("items")
  public Result items(@RequestBody String param) {
    Result result = new Result();
    try {
      List<Item> items = JSONObject.parseArray(param, Item.class);
      for (Item item : items) {
        itemService.save(item);
      }
      result.setSuccess(true);
      result.setMsg("导入成功，请刷新数据。");
    } catch (Exception e) {
      e.printStackTrace();
      result.setSuccess(false);
      result.setMsg("转换错误" + e.getMessage());
    }
    return result;
  }

  @PostMapping("buyers")
  public Result buys(@RequestBody String param) {
    Result result = new Result();
    try {
      List<Buyer> buyers = JSONObject.parseArray(param, Buyer.class);
      for (Buyer buyer : buyers) {
        buyerService.save(buyer);
      }
      result.setSuccess(true);
      result.setMsg("导入成功，请刷新数据。");
    } catch (Exception e) {
      e.printStackTrace();
      result.setSuccess(false);
      result.setMsg("转换错误" + e.getMessage());
    }
    return result;
  }

  @PostMapping("inBounds")
  public Result inBound(@RequestBody String param) {
    Result result = new Result();
    try {
      List<InBound> inBounds = JSONObject.parseArray(param, InBound.class);
      StringBuffer stringBuffer = new StringBuffer();
      int i = 1;
      for (InBound inBound : inBounds) {
        logger.info(inBound.toString());
        /** 循环数据，校验物资名称，仓库名称是否唯一并查找到ID */
        Item item = new Item();
        item.setItemName(inBound.getItemName());
        item.setStatus(true);
        item = itemService.selectItemFromItem(item);
        if (item != null) {
          inBound.setItemId(item.getId());
        } else {
          stringBuffer
              .append(String.format("第 %s 行 ，物资名称：%s ,未找到，或有多个名称相同的物资 ", i, inBound.getItemName()))
              .append("</br>");
        }

        Store store = new Store();
        store.setStoreName(inBound.getStoreName());
        store.setStatus(true);
        store = storeService.selectStoreFromStore(store);
        if (store != null) {
          inBound.setStoreId(store.getId());
        } else {
          stringBuffer
              .append(String.format("第 %s 行 ，仓库名称：%s ,未找到，或有多个名称相同的仓库 ", i, inBound.getStoreName()))
              .append("</br>");
        }
        i++;
      }

      if (stringBuffer.toString().length() == 0) {
        for (InBound inBound : inBounds) {
          inBoundService.save(inBound);
          Inventory inventory =
              inventoryService.selectInvFromItemIdAndStoreId(
                  inBound.getItemId(), inBound.getStoreId());
          if (inventory == null) {
            inventory = new Inventory();
            inventory.setItemId(inBound.getItemId());
            inventory.setStoreId(inBound.getStoreId());
            inventory.setOrderQty(inBound.getOrderQty());
            inventory.setIssueQty(inBound.getIssueQty());
            inventoryService.add(inventory);
          } else {
            int orderQty = inventory.getOrderQty() + inBound.getOrderQty();
            int issueQty = inventory.getIssueQty() + inBound.getIssueQty();
            int coeffiCient = inventory.getCoeffiCient();
            if (issueQty > coeffiCient) {
              orderQty = orderQty + issueQty / coeffiCient;
              issueQty = issueQty % coeffiCient;
            }
            inventory.setOrderQty(orderQty);
            inventory.setIssueQty(issueQty);
            inventoryService.update(inventory);
          }

          result.setSuccess(true);
          result.setMsg("导入成功，请刷新数据。");
        }

      } else {
        result.setSuccess(false);
        result.setMsg(stringBuffer.toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
      result.setSuccess(false);
      result.setMsg("转换错误" + e.getMessage());
    }
    return result;
  }

  @PostMapping("outBounds")
  public Result outBounds(@RequestBody String param) {
    Result result = new Result();
    try {
      List<OutBound> outBounds = JSONObject.parseArray(param, OutBound.class);
      StringBuffer stringBuffer = new StringBuffer();
      int i = 1;
      for (OutBound outBound : outBounds) {
        logger.info(outBound.toString());
        /** 循环数据，根据仓库名称 物资名称 查询对应库存 */
        Store store = new Store();
        store.setStoreName(outBound.getStoreName());
        store.setStatus(true);
        store = storeService.selectStoreFromStore(store);
        if (store != null) {
          outBound.setStoreId(store.getId());
        } else {
          stringBuffer
              .append(
                  String.format("第 %s 行 ，仓库名称：%s ,未找到，或有多个名称相同的仓库 ", i, outBound.getStoreName()))
              .append("</br>");
        }

        Item item = new Item();
        item.setItemName(outBound.getItemName());
        item.setStatus(true);
        item = itemService.selectItemFromItem(item);
        if (item != null) {
          outBound.setItemId(item.getId());
        } else {
          stringBuffer
              .append(String.format("第 %s 行 ，物资名称：%s ,未找到，或有多个名称相同的物资 ", i, outBound.getItemName()))
              .append("</br>");
        }

        Buyer buyer = new Buyer();
        buyer.setBuyerName(outBound.getBuyerName());
        buyer = buyerService.getBuyerByBuyer(buyer);
        if (buyer != null) {
          outBound.setBuyerId(buyer.getId());
        } else {
          stringBuffer
              .append(
                  String.format("第 %s 行 ，买家名称：%s ,未找到，或有多个名称相同的买家 ", i, outBound.getBuyerName()))
              .append("</br>");
        }

        if (outBound.getItemId() != 0 && outBound.getStoreId() != 0) {
          Inventory inventory =
              inventoryService.selectInvFromItemIdAndStoreId(
                  outBound.getItemId(), outBound.getStoreId());
          if (inventory == null) {
            stringBuffer
                .append(
                    String.format(
                        "第 %s 行 ，物资名称：%s ,仓库名称：%s ,未到找库存 ",
                        i, outBound.getItemName(), outBound.getStoreName()))
                .append("</br>");
          } else {
            int orderQty = inventory.getOrderQty();
            int issueQty = inventory.getIssueQty();
            int coeffiCient = inventory.getCoeffiCient();
            int total = orderQty * coeffiCient + issueQty;

            int orderQty1 = outBound.getOrderQty();
            int issueQty1 = outBound.getIssueQty();

            int total1 = orderQty1 * coeffiCient + issueQty1;

            if (total1 > total) {
              stringBuffer
                  .append(String.format("第 %s 行 ，出库数量大于库存数量 ", i, outBound.getBuyerName()))
                  .append("</br>");
            }
          }
        }

        if ("是".equals(outBound.getIsCheck())) {
          outBound.setIsCheck("1");
        } else {
          outBound.setIsCheck("0");
        }
        if ("是".equals(outBound.getIsPayment())) {
          outBound.setIsPayment("1");
        } else {
          outBound.setIsPayment("0");
        }

        i++;
      }

      if (stringBuffer.toString().length() == 0) {
        for (OutBound outBound : outBounds) {
          Inventory inventory =
              inventoryService.selectInvFromItemIdAndStoreId(
                  outBound.getItemId(), outBound.getStoreId());
          outBoundService.save(outBound);

          int orderQty = inventory.getOrderQty() - outBound.getOrderQty();
          int issueQty = outBound.getIssueQty();
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

          logger.debug(orderQty + " = " + issueQty);

          inventory.setOrderQty(orderQty);
          inventory.setIssueQty(issueQty);
          inventoryService.update(inventory);
        }

        result.setSuccess(true);
        result.setMsg("导入成功，请刷新数据。");

      } else {
        result.setSuccess(false);
        result.setMsg(stringBuffer.toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
      result.setSuccess(false);
      result.setMsg("转换错误" + e.getMessage());
    }
    return result;
  }
}
