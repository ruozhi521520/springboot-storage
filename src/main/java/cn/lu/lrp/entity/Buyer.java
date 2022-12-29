package cn.lu.lrp.entity;

import java.util.Date;

public class Buyer {
    /**
     * 编号
     */
    private int id;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 欠款
     */
    private double total;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 备注
     */
    private String remark;
    /**
     * 添加时间
     */
    private Date addDate;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", buyerName='" + buyerName + '\'' +
                ", total=" + total +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", addDate=" + addDate +
                '}';
    }
}
