package com.bjut.fit.sse.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    // 当前页码
    private Integer pageNo;

    // 总页码
    private Integer pageTotal;

    // 每页数量
    private Integer pageSize = PAGE_SIZE;

    // 总记录数
    private Integer pageCount;

    // 当前页数据
    private List<T> items;

    // 分页条中的请求地址
    private String url;

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        // 数据有效范围，边界检查
        // 如果小于1，就是第一页
        // 如果大于最后一页，就显示最后一页
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
