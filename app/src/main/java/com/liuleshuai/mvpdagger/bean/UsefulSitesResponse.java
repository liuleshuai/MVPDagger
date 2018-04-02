package com.liuleshuai.mvpdagger.bean;

import java.util.List;


public class UsefulSitesResponse extends BaseResponse {

    private List<UsefulSiteData> data;

    public List<UsefulSiteData> getData() {
        return data;
    }

    public void setData(List<UsefulSiteData> data) {
        this.data = data;
    }
}
