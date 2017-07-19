package com.susiha.jock.NetUtils;

import com.susiha.jock.Utils.Config;
import com.susiha.jock.bean.BSJBaseBean;
import com.susiha.jock.bean.BSJBean;

import java.util.HashMap;

/**
 * Created by 苏斯哈 on 2017/7/17.
 */

public class NetAcessImpl {

    private volatile static NetAcessImpl instance=null;


    public static final NetAcessImpl getInstance()
    {
        if(instance==null)
        {
            synchronized (NetAcessImpl.class)
            {
                if(instance==null)
                {
                    instance=new NetAcessImpl();
                }
            }
        }
        return instance;
    }

    private NetAcessImpl(){}

    /**
     *
     * @param type
     *
     * type=10 图片
       type=29 段子
       type=31 声音
       type=41 视频
     *
     * @param title
     * @param page
     * @param listener
     */
    public void  accessBSJ(String type,String title,String page,NetResultLinstener listener)
    {
        Request<BSJBaseBean> request=new Request<>();
        HashMap<String,String> map=new HashMap<>();
        map.put("type",type);
        map.put("title",title);
        map.put("page",page);
        request.setmMap(map);
        request.setUrl(Config.BSJ_PATH);
        request.setM_class(BSJBaseBean.class);
        BSJBaseBean bean=NetUtils.getInstance().request(request);

        if(bean==null)
        {
            listener.exception("数据解析失败！");
        }else
        {
            if(bean.getShowapi_res_code().equals("0"))
            {
                listener.sucess(bean);
            }else
            {
                listener.failed(bean.getShowapi_res_code(),bean.getShowapi_res_error());
            }
        }













    }


}
