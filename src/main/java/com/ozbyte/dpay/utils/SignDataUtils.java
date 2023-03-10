package com.ozbyte.dpay.utils;

import com.ozbyte.dpay.req.OrderNotifyReq;
import com.ozbyte.dpay.req.PayOrderReq;
import com.ozbyte.dpay.resp.SignOrderDTO;

/**
 * sign data 数据组装 工具类
 *
 * @author alex
 * @version V1.0
 * @date 2022/9/7 16:27
 */
public class SignDataUtils {

    /**
     * 订单创建时获取sign data 组装数据。
     *
     * @param req 订单创建请求数据
     * @return sign data
     */
    public static String getOrderSignData(PayOrderReq req) {
        return req.getAppId() + req.getOrderNo() + req.getAmount() + req.getNetwork() + req.getSymbol() + req.getCurrency()
                + req.getReturnUrl() + req.getNotifyUrl() + req.getCustomerNo() + req.getProductName();
    }

    /**
     * 订单返回时 获取响应数据的 sign data
     *
     * @param req 订单响应数据
     * @return sign data
     */
    public static String getOrderRespSignData(SignOrderDTO req) {
        return req.getOrderNo() + req.getAmount() + req.getTradeAmt() + req.getCurrency() + req.getSymbol()
                + req.getUsefulTime() + req.getAddress() + req.getQrcodeUrl() + req.getCashierUrl();
    }

    /**
     * 通知回调接收数据的有效性验证
     * @param req 通知回调参数
     * @return sign data
     */
    public static String getOrderNotifySignData(OrderNotifyReq req) {
        return req.getPlatformOrderNo() + req.getMerchantOrderNo() + req.getAmount() + req.getTradeAmt()
                + req.getNetwork() + req.getSymbol() + req.getCurrency() + req.getHash();
    }

}
