package cn.dp.common;

import java.util.List;

public class Page {
    private int currentPageNum;//当前页码
    private int totalRecords;//总记录条数
    private int totalPages;//总页数
    private int prePageNum;//上一页
    private int nextPageNum;//下一页
    private int pageSize = 10;//每页显示的记录条数,默认10条
    private int startIndex;//第一条记录的索引
    private List records;//存放分页记录

    public Page(int totalRecords, int currentPageNum) {
        this.totalRecords = totalRecords;
        this.currentPageNum = currentPageNum;
        totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords /pageSize + 1;
        prePageNum = currentPageNum - 1 >0 ? currentPageNum - 1 : 1;
        nextPageNum = currentPageNum + 1 < totalPages ? currentPageNum + 1 : totalPages;
        startIndex = (currentPageNum - 1) * pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
