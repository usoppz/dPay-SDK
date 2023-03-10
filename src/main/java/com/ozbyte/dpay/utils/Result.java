package com.ozbyte.dpay.utils;

import lombok.Data;

/**
 * 结果响应数据
 *
 * @author alex
 * @version V1.0
 * @date 2022/10/21 09:44
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this(code,msg);
        this.data = data;
    }
}
