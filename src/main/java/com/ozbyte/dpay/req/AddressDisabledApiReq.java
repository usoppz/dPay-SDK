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
public class AddressDisabledApiReq {

    /**
     * 订单收款地址
     */
    private String address;

    /**
     * 状态值只能是 1：启用 和 2：禁用
     */
    private Byte status;

    /**
     * appId不能为空
     */
    private String appId;

    /**
     * 签名不能为空
     */
    private String signature;
}
