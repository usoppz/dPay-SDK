package com.ozbyte.dpay.client;

import com.alibaba.fastjson.TypeReference;
import com.ozbyte.dpay.common.BizError;
import com.ozbyte.dpay.common.BizException;
import com.ozbyte.dpay.common.Constant;
import com.ozbyte.dpay.req.PayOrderReq;
import com.ozbyte.dpay.resp.SignOrderDTO;
import com.ozbyte.dpay.utils.*;

/**
 * 支付订单生成客户端
 *
 * @author alex
 * @version V1.0
 * @date 2023/3/9 11:38
 */
public class OrderClient {

    /**
     * 创建支付订单
     *
     * @param req 支付订单创建请求参数
     * @return 生成后的收款地址
     * @throws BizException 业务异常
     */
    public static SignOrderDTO createOrder(PayOrderReq req) throws BizException {
        verifyArgs(req);
        req.setAppId(ConfigUtil.getAppId());
        String signature = SignUtils.sign(SignDataUtils.getOrderSignData(req));
        req.setSignature(signature);

        Result<SignOrderDTO> resp = InterfaceUtil.invoke(req, ConfigUtil.getApiUrl(Constant.ORDER_CREATE), new TypeReference<SignOrderDTO>() {
        });
        SignOrderDTO order = resp.getData();
        if (null == order) {
            throw new BizException(resp.getMsg());
        }
        String respSignData = SignDataUtils.getOrderRespSignData(order);
        System.out.println("The current respOrderSignData : " + respSignData);
        if (SignUtils.verify(respSignData, order.getSignature())) {
            return order;
        }
        throw new BizException(BizError.RESP_DATA_VERIFY_ERROR);

    }

    public static void verifyArgs(Object req) {
        if (null == req) {
            throw new BizException(BizError.REQ_ARGS_ERROR);
        }
    }

}
