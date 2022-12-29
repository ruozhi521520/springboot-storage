package cn.lu.lrp.entity;

/**
 * 盘点子表
 *
 * @author lull
 */
public class PdLine {
    private int id;
    private int pdId;
    private int itemId;
    private String itemName;
    private String unitFloor;
    private String lineFloor;
    private int orderQty;
    private String orderUnit;
    private int issueQty;
    private String issueUnit;
    private int storeId;
    private String storeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPdId() {
        return pdId;
    }

    public void setPdId(int pdId) {
        this.pdId = pdId;
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

    public String getUnitFloor() {
        return unitFloor;
    }

    public void setUnitFloor(String unitFloor) {
        this.unitFloor = unitFloor;
    }

    public String getLineFloor() {
        return lineFloor;
    }

    public void setLineFloor(String lineFloor) {
        this.lineFloor = lineFloor;
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

    @Override
    public String toString() {
        return "PdLine{" +
                "id=" + id +
                ", pdId=" + pdId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", unitFloor='" + unitFloor + '\'' +
                ", lineFloor='" + lineFloor + '\'' +
                ", orderQty=" + orderQty +
                ", orderUnit='" + orderUnit + '\'' +
                ", issueQty=" + issueQty +
                ", issueUnit='" + issueUnit + '\'' +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
