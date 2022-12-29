package cn.lu.lrp.entity;

import java.util.Date;

/**
 * @program: cn.lu.lrp.entity.Item
 * @author: lull  
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:26 1、   lull
 **/
public class Item {

    /**
     * 序号
     */
    private int id;
    /**
     * 物资名称
     */
    private String itemName;
    /**
     * 销售单价
     */
    private float issueCost;
    /**
     * 单价底价
     */
    private float unitFloor;
    /**
     * 订购单位
     */
    private String orderUnit;
    /**
     * 销售单位
     */
    private String issueUnit;
    /**
     * 转换系数
     */
    private float coeffiCient;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否启用
     */
    private boolean status;
    /**
     * 添加时间
     */
    private Date addDate;
    /**
     * 修改时间
     */
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getIssueCost() {
        return issueCost;
    }

    public void setIssueCost(float issueCost) {
        this.issueCost = issueCost;
    }

    public float getUnitFloor() {
        return unitFloor;
    }

    public void setUnitFloor(float unitFloor) {
        this.unitFloor = unitFloor;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public float getCoeffiCient() {
        return coeffiCient;
    }

    public void setCoeffiCient(float coeffiCient) {
        this.coeffiCient = coeffiCient;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", issueCost=" + issueCost +
                ", unitFloor=" + unitFloor +
                ", orderUnit='" + orderUnit + '\'' +
                ", issueUnit='" + issueUnit + '\'' +
                ", coeffiCient=" + coeffiCient +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", addDate=" + addDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
