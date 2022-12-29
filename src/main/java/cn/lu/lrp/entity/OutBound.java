package cn.lu.lrp.entity;

/**
 * @author lull
 */
public class OutBound {

    /**
     * 序号
     */
    private int id;
    /**
     * 买家编码
     */
    private int buyerId;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 物资编码
     */
    private int itemId;
    /**
     * 物资名称
     */
    private String itemName;
    /**
     * 数量
     */
    private int orderQty;
    /**
     * 订购单位
     */
    private String orderUnit;
    /**
     * 数量
     */
    private int issueQty;
    /**
     * 销售单位
     */
    private String issueUnit;
    /**
     * 单价
     */
    private String issueCost;
    /**
     * 总价
     */
    private String lineCost;
    /**
     * 是否收款
     */
    private String isCheck;
    /**
     * 是否代收
     */
    private String isPayment;
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
    private String check1;
    private String check2;
    private String payment1;
    private String payment2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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

    public String getIssueCost() {
        return issueCost;
    }

    public void setIssueCost(String issueCost) {
        this.issueCost = issueCost;
    }

    public String getLineCost() {
        return lineCost;
    }

    public void setLineCost(String lineCost) {
        this.lineCost = lineCost;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(String isPayment) {
        this.isPayment = isPayment;
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

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getCheck2() {
        return check2;
    }

    public void setCheck2(String check2) {
        this.check2 = check2;
    }

    public String getPayment1() {
        return payment1;
    }

    public void setPayment1(String payment1) {
        this.payment1 = payment1;
    }

    public String getPayment2() {
        return payment2;
    }

    public void setPayment2(String payment2) {
        this.payment2 = payment2;
    }

    @Override
    public String toString() {
        return "OutBound{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", buyerName='" + buyerName + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", orderQty=" + orderQty +
                ", orderUnit='" + orderUnit + '\'' +
                ", issueQty=" + issueQty +
                ", issueUnit='" + issueUnit + '\'' +
                ", issueCost='" + issueCost + '\'' +
                ", lineCost='" + lineCost + '\'' +
                ", isCheck='" + isCheck + '\'' +
                ", isPayment='" + isPayment + '\'' +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", remark='" + remark + '\'' +
                ", addDate='" + addDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
