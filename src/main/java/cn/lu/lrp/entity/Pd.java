package cn.lu.lrp.entity;

/**
 * 盘点主表
 *
 * @author lull
 */
public class Pd {

    private int id;
    private int year;
    private int month;
    private int storeId;
    private String storeName;
    private String pdName;
    private String remark;
    private String addDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
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

    @Override
    public String toString() {
        return "Pd{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", pdName='" + pdName + '\'' +
                ", remark='" + remark + '\'' +
                ", addDate='" + addDate + '\'' +
                '}';
    }
}
