package cn.lu.lrp.entity;

/**
 * 账单
 *
 * @author lull
 */
public class Order {
    /**
     * 编号
     */
    private int id;
    /**
     * 事由
     */
    private String subject_matter;
    /**
     * 支出
     */
    private double expenditure;
    /**
     * 收入
     */
    private double income;
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

    public String getSubject_matter() {
        return subject_matter;
    }

    public void setSubject_matter(String subject_matter) {
        this.subject_matter = subject_matter;
    }

    public double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
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
        return "Order{" +
                "id=" + id +
                ", subject_matter='" + subject_matter + '\'' +
                ", expenditure=" + expenditure +
                ", income=" + income +
                ", remark='" + remark + '\'' +
                ", addDate='" + addDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
