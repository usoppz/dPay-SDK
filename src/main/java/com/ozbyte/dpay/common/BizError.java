package com.ozbyte.dpay.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务处理错误枚举类
 *
 * @author zohar
 * @date 2019年1月7日
 */
@Getter
@AllArgsConstructor
public enum BizError {

    /**
     * 参数异常
     */
    REQ_ARGS_ERROR(4001, "请求参数为空"),
    RESP_DATA_NULL_ERROR(4002, "数据返回为空"),
    RESP_DATA_VERIFY_ERROR(4003, "数据返回有效验证失败");


    private final Integer code;

    private final String msg;

}
