package com.ozbyte.dpay.req;

import lombok.Data;

/**
 * 支付订单查询请求参数
 *
 * @author alex
 * @version V1.0
 * @date 2022/7/19 19:25
 */
@Data
public class AddressListApiReq {

    private String appId;

    private String signature;

}
