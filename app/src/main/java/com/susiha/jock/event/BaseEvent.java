package com.susiha.jock.event;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public class BaseEvent {
    public static final String SUCESS="SUCESS";
    public static final String FAILED="FAILED";
    public static final String EXCEPTION="EXCEPTION";
    private String status="";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
