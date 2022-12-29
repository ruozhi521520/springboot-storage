package cn.lu.lrp.entity;

public class Inventory {

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
     * 销售数量
     */
    private String issueUnit;
    /**
     * 转换系数
     */
    private int coeffiCient;
    /**
     * 销售单价
     */
    private double issueCost;
    private double unitFloor;
    private double lineFloor;
    /**
     * 仓库编码
     */
    private int storeId;
    /**
     * 仓库名称
     */
    private String storeName;

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

    public int getCoeffiCient() {
        return coeffiCient;
    }

    public void setCoeffiCient(int coeffiCient) {
        this.coeffiCient = coeffiCient;
    }

    public double getIssueCost() {
        return issueCost;
    }

    public void setIssueCost(double issueCost) {
        this.issueCost = issueCost;
    }

    public double getUnitFloor() {
        return unitFloor;
    }

    public void setUnitFloor(double unitFloor) {
        this.unitFloor = unitFloor;
    }

    public double getLineFloor() {
        return lineFloor;
    }

    public void setLineFloor(double lineFloor) {
        this.lineFloor = lineFloor;
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

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", orderQty=" + orderQty +
                ", orderUnit='" + orderUnit + '\'' +
                ", issueQty=" + issueQty +
                ", issueUnit='" + issueUnit + '\'' +
                ", coeffiCient=" + coeffiCient +
                ", issueCost=" + issueCost +
                ", unitFloor=" + unitFloor +
                ", lineFloor=" + lineFloor +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
