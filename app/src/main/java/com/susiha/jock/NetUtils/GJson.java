package com.susiha.jock.NetUtils;

import com.google.gson.Gson;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 15:30
 * update: 2017/7/17
*/

public class GJson {


    public static <T> T parseJsonToObj(String jsonStr, Class<T> clazz) {
        try {
            Gson sGson = new Gson();
            return sGson.fromJson(jsonStr, clazz);
        } catch (Exception e) {

        }
        return null;
    }

}
