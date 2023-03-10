package com.ozbyte.dpay.req;

import lombok.Data;

/**
 * 创建订单请求
 *
 * @author alex
 * @version V1.0
 * @date 2022/7/20 09:02
 */
@Data
public class PayOrderReq {

    /**
     * 公钥
     */
    private String appId;

    /**
     * 商户订单编号
     */
    private String orderNo;

    /**
     * 订单金额不能为空,精确到小数点后4位
     */
    private Double amount;

    /**
     * 主网协议，目前只支持TRC20。
     */
    private String network;

    /**
     * 订单币种单位。支持：CNY、USD。
     */
    private String currency;

    /**
     * 订单支付币种。目前固定为 USDT
     */
    private String symbol;

    /**
     * 订单类型：1.无需归集订单，2.需归集订单
     */
    private Integer orderType;

    /**
     * 商户端用户编号
     */
    private String customerNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 页面调转地址
     */
    private String returnUrl;

    /**
     * 通知回调地址
     */
    private String notifyUrl;

    /**
     * 签名串
     */
    private String signature;

}
