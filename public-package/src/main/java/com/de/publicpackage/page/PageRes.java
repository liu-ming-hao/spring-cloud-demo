package com.de.publicpackage.page;

import java.io.Serializable;
import java.util.List;

/**
 * PageRes
 *
 * @author 刘明浩
 * @Description  封装公共分页返回
 * @since 2020/12/23 11:12
 */
public class PageRes<T> implements Serializable {
    private static final long serialVersionUID = -2903063547272237247L;

    private long total;
    private long page;
    private long size;
    private List<T> pageData;

    public PageRes(){}

    public PageRes(long total,long page,long size,List<T> pageData){
        this.total = total;
        this.page = page;
        this.size = size;
        this.pageData = pageData;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageRes{" +
                "total=" + total +
                ", page=" + page +
                ", size=" + size +
                ", pageData=" + pageData +
                '}';
    }
}
