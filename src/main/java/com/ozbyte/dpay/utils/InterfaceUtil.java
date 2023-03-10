package com.ozbyte.dpay.utils;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * dPay http 接口请求工具类
 *
 * @author alex
 * @version V1.0
 * @date 2022/10/20 14:17
 */
public class InterfaceUtil {

    public static <T> Result<T> invoke(Object req, String url, TypeReference<T> reference) {
        String json = JSONUtil.parseObj(req).toStringPretty();
        System.out.println("请求参数：" + json);
        String result = HttpUtil.post(url, json);
        return getResult(reference, result);
    }

    private static <T> Result<T> getResult(TypeReference<T> reference, String result) {
        System.out.println("响应参数：" + JSONUtil.parseObj(result).toStringPretty());
        JSONObject resp = JSON.parseObject(result);
        assert resp != null;
        int code = Integer.parseInt(resp.getString("code"));
        String msg = resp.getString("msg");
        String data = resp.getString("data");
        return null == data ? new Result<>(code,msg) : new Result<>(code, msg, JSON.parseObject(data, reference));
    }

    public static <T> Result<T> get(String req, String url, TypeReference<T> reference) {
        System.out.println("请求参数：" + req);
        String result = HttpRequest.get(url+req)
                .header(Header.ACCEPT, "application/json")
                .header(Header.ACCEPT_CHARSET,"utf-8")
                .execute().body();

        return getResult(reference, result);
    }

}
