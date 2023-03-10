package com.ozbyte.dpay.utils;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

/**
 * 鉴权工具类
 *
 * @author alex
 * @version V1.0
 * @date 2022/7/27 15:06
 */
public class SignUtils {

    public static String sign(String signData){
        return sign(signData,ConfigUtil.getPrivateKey());
    }

    public static String sign(String signData, String privateKey) {
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA, privateKey, null);
        return sign.signHex(signData.getBytes());
    }

    /**
     * sign 验证
     *
     * @param signData 需要验证的数据
     * @param signed   签名字符串
     * @return 验证结果
     */
    public static boolean verify(String signData, String signed) {
        return verify(signData, signed, ConfigUtil.getPublicKey());
    }

    public static boolean verify(String signData, String signed, String publicKey) {
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA, null, publicKey);
        return sign.verify(signData.getBytes(), HexUtil.decodeHex(signed));
    }

}
