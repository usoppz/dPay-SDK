package com.ozbyte.dpay.req;

import lombok.Data;

/**
 * 地址添加请求参数
 *
 * @author alex
 * @version V1.0
 * @date 2022/9/4 13:36
 */
@Data
public class AddressAddApiReq {

    /**
     * 订单收款地址
     */
    private String address;

    /**
     * 主网
     */
    private String network;

    /**
     * appId
     */
    private String appId;

    /**
     * 签名串
     */
    private String signature;

}
