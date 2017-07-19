package com.susiha.jock.bean;

import java.io.Serializable;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public class BSJBaseBean extends BaseBean implements Serializable {
  private BSJBean showapi_res_body;

    public BSJBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(BSJBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
}
