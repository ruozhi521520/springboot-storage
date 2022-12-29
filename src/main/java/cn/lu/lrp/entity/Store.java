package cn.lu.lrp.entity;

import java.util.Date;

/**
 * @program: cn.lu.lrp.entity.Item
 * @author: lull lull@shuto.cn
 * @create: 2021-04-05
 * @version: <p> 2021-04-05 14:26 1、   lull
 **/
public class Store {

    /**
     * 编号
     */
    private int id;
    /**
     * 仓库名称
     */
    private String storeName;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private boolean status;
    /**
     * 创建时间
     */
    private Date addDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", addDate=" + addDate +
                '}';
    }
}
