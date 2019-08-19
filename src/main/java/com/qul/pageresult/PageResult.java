package com.qul.pageresult;

import com.qul.pojo.Brand;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

    private long total;//总记录数
    private List rows;//当前页结果
    private int pageNum;

    public PageResult(long total, List rows, int pageNum) {
        this.total = total;
        this.rows = rows;
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                ", pageNum=" + pageNum +
                '}';
    }
}
