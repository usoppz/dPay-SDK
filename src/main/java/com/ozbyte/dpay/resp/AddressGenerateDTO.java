package com.ozbyte.dpay.resp;

import lombok.Data;

/**
 * order_address
 *
 * @author alex
 */
@Data
public class AddressGenerateDTO {

    /**
     * 钱包地址
     */
    private String address;

    /**
     * 钱包地址私钥
     */
    private String privateKey;

    private String signature;

}