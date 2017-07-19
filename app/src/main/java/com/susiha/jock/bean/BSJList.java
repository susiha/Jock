package com.susiha.jock.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public class BSJList implements Serializable {
    private ArrayList<BSJItem> contentlist;
    private String maxResult;
    private String allNum;
    private String allPages;
    private String currentPage;

    public ArrayList<BSJItem> getContentlist() {
        return contentlist;
    }

    public void setContentlist(ArrayList<BSJItem> contentlist) {
        this.contentlist = contentlist;
    }

    public String getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(String maxResult) {
        this.maxResult = maxResult;
    }

    public String getAllNum() {
        return allNum;
    }

    public void setAllNum(String allNum) {
        this.allNum = allNum;
    }

    public String getAllPages() {
        return allPages;
    }

    public void setAllPages(String allPages) {
        this.allPages = allPages;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
}
