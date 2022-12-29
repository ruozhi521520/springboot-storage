package cn.lu.lrp.controller.domain;

/**
 * Describe: 前 端 表 格 数 据 封 装
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 */
public class ResultTable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 消息总量
     */
    private Long count;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 构 建
     */
    public static ResultTable pageTable(long count, Object data) {
        ResultTable resultTable = new ResultTable();
        resultTable.setData(data);
        resultTable.setCode(0);
        resultTable.setCount(count);
        return resultTable;
    }

    public static ResultTable dataTable(Object data) {
        ResultTable resultTable = new ResultTable();
        resultTable.setData(data);
        resultTable.setCode(0);
        return resultTable;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
