package com.susiha.jock.NetUtils;

import com.susiha.jock.bean.BaseBean;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public interface NetResultLinstener {
    void sucess(BaseBean bean);
    void failed(String code,String msg);
    void exception(String msg);

}
