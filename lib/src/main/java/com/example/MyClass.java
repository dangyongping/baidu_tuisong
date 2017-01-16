package com.example;

import com.alibaba.fastjson.JSON;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyClass {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("canOpen", true);
        //推送类型
        int a =0;
        String          dStr = "2017.01.16-14.06.00";
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
        Date             d    = null;
        try {
            d = sdf.parse(dStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
        Long LL = d.getTime();
        switch (a){
            case 0:
                map.put("endTime",LL);
                map.put("durationTime", "2");
                map.put("title", "appointInfo");
                map.put("appointId", "45325423a");
                map.put("openId", "oN3A3wqbVrITX53zeLLdOumeqbm0");
                break;
            case 1:
                map.put("endTime",LL);
                map.put("durationTime", "1");
                map.put("title", "renewInfo");
                map.put("reNewId", "9999999");
                map.put("openId", "oN3A3wqbVrITX53zeLLdOumeqbm0");
                break;
            default:
                map.put("title", "dyp");
                break;
        }
        String json = JSON.toJSONString(map);
        //初次String channelId = "3790788674348992420";
        String channelId = "4210186328531208892";
        try {
            BaiduPushUtil.pushMsg(json,channelId);
        } catch (PushClientException e) {
            e.printStackTrace();
        } catch (PushServerException e) {
            e.printStackTrace();
        }
    }
}
