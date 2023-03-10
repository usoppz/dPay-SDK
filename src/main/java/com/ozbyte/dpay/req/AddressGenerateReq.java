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
public class AddressGenerateReq {

    /**
     * 主网协议
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
