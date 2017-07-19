package com.susiha.jock.NetUtils;
import android.util.Log;

import com.show.api.ShowApiRequest;
import com.susiha.jock.Utils.Config;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 15:26 
 * update: 2017/7/17
*/

public class NetUtils {

    private volatile static NetUtils instance=null;


    public static final NetUtils getInstance()
    {
        if(instance==null)
        {
            synchronized (NetUtils.class)
            {
                if(instance==null)
                {
                    instance=new NetUtils();
                }
            }
        }
        return instance;
    }

    private NetUtils(){}
    public <T>T request(Request<T> request)
    {
        ShowApiRequest showApiRequest=new ShowApiRequest(request.getUrl(), Config.appid,Config.secret);
        for(String key:request.getmMap().keySet())
        {
            showApiRequest.addTextPara(key,request.getmMap().get(key));
        }
        final String result=showApiRequest.post();
        Log.i("NetUtils",result);

        return GJson.parseJsonToObj(result,request.getM_class());
    }
}
