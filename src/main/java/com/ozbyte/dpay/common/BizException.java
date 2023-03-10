package com.ozbyte.dpay.common;

import lombok.Getter;

/**
 * 自定义业务异常
 *
 * @author zohar
 * @date 2019年1月7日
 */
@Getter
public class BizException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    public BizException(BizError bizError) {
        super(bizError.getMsg());
        this.code = bizError.getCode();
        this.msg = bizError.getMsg();
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(String msg) {
        super(msg);
    }

}
