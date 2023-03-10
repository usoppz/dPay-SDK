package com.ozbyte.dpay.req;

import lombok.Data;

/**
 * 订单支付成功通知参数
 *
 * @author alex
 * @version V1.0
 * @date 2022/9/19 13:43
 */
@Data
public class OrderNotifyReq {

    /**
     * 官方平台订单号
     */
    private String platformOrderNo;

    /**
     * 商户订单号（创建订单时商家传给平台的订单编号）
     */
    private String merchantOrderNo;

    /**
     * 订单金额不能为空,精确到小数点后4位
     */
    private Double amount;

    /**
     * 实际交易金额
     */
    private Double tradeAmt;

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
     * 交易Hash
     */
    private String hash;

    /**
     * 签名串
     */
    private String signature;

}
