package com.ozbyte.dpay.resp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * order_address
 *
 * @author alex
 */
@Data
public class AddressDTO {

    /**
     * 钱包地址
     */
    private String address;

    /**
     * 钱包地址余额
     */
    private BigDecimal balance;


    /**
     * 地址使用状态
     */
    private Byte status;

    /**
     * 主网
     */
    private String network;

    /**
     * 创建时间
     */
    private Date createDate;

}