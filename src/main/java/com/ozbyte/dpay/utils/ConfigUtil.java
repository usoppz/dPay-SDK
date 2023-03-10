package com.ozbyte.dpay.utils;

import cn.hutool.setting.Setting;

/**
 * 配置工具类
 *
 * @author alex
 * @version V1.0
 * @date 2023/2/26 19:41
 */
public class ConfigUtil {

    private final static Setting CONFIG = new Setting("config.properties");

    public static String get(String key) {
        return CONFIG.get(key);
    }

    public static Boolean getBoolean(String key) {
        return CONFIG.getBool(key);
    }

    public static Integer getInt(String key) {
        return CONFIG.getInt(key);
    }

    public static String getApiUrl(String path){
        return get("host") + path;
    }

    public static String getAppId(){
        return get("appId");
    }

    /**
     * 获取官方平台公钥
     * @return 平台公钥
     */
    public static String getPublicKey() {
        return get("dPayPublicKey");
    }

    /**
     * 获取商户私钥
     * @return 商户私钥
     */
    public static String getPrivateKey() {
        return get("merchantPrivateKey");
    }

}
