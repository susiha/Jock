package com.susiha.jock.bean;

import java.io.Serializable;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public class BSJBean implements Serializable {
    private BSJList pagebean;

    public BSJList getPagebean() {
        return pagebean;
    }

    public void setPagebean(BSJList pagebean) {
        this.pagebean = pagebean;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    private String  ret_code;//0 成功其他失败

}
