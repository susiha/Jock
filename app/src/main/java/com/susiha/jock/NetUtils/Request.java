package com.susiha.jock.NetUtils;

import java.io.Serializable;
import java.util.HashMap;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 16:23
 * update: 2017/7/17
*/

public class Request<T> implements Serializable {


    private Class<T> m_class;
    private String url;

    private HashMap<String,String> mMap;

    public HashMap<String, String> getmMap() {
        return mMap;
    }

    public void setmMap(HashMap<String, String> mMap) {
        this.mMap = mMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class<T> getM_class() {
        return m_class;
    }

    public void setM_class(Class<T> m_class) {
        this.m_class = m_class;
    }




}
