package cn.lu.lrp.entity;

/**
 * @author lull
 */
public class InBound {

    /**
     * 序号
     */
    private int id;
    /**
     * 物资编码
     */
    private int itemId;
    /**
     * 物资名称
     */
    private String itemName;
    /**
     * 入库数量
     */
    private int orderQty;
    /**
     * 订购单位
     */
    private String orderUnit;
    /**
     * 入库数量
     */
    private int issueQty;
    /**
     * 销售单位
     */
    private String issueUnit;
    /**
     * 仓库编码
     */
    private int storeId;
    /**
     * 仓库名称
     */
    private String storeName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 添加时间
     */
    private String addDate;
    /**
     * 查询开始时间
     */
    private String startDate;
    /**
     * 查询结束时间
     */
    private String endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    public int getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(int issueQty) {
        this.issueQty = issueQty;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "InBound{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", orderQty=" + orderQty +
                ", orderUnit='" + orderUnit + '\'' +
                ", issueQty=" + issueQty +
                ", issueUnit='" + issueUnit + '\'' +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", remark='" + remark + '\'' +
                ", addDate='" + addDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
