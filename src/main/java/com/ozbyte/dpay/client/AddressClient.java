package com.ozbyte.dpay.client;

import com.alibaba.fastjson.TypeReference;
import com.ozbyte.dpay.common.BizError;
import com.ozbyte.dpay.common.BizException;
import com.ozbyte.dpay.common.Constant;
import com.ozbyte.dpay.req.AddressAddApiReq;
import com.ozbyte.dpay.req.AddressDisabledApiReq;
import com.ozbyte.dpay.req.AddressGenerateReq;
import com.ozbyte.dpay.req.AddressListApiReq;
import com.ozbyte.dpay.resp.AddressCofigDTO;
import com.ozbyte.dpay.resp.AddressDTO;
import com.ozbyte.dpay.resp.AddressGenerateDTO;
import com.ozbyte.dpay.utils.ConfigUtil;
import com.ozbyte.dpay.utils.InterfaceUtil;
import com.ozbyte.dpay.utils.Result;
import com.ozbyte.dpay.utils.SignUtils;

import java.util.List;

/**
 * 订单地址请求客户端
 *
 * @author alex
 * @version V1.0
 * @date 2023/3/9 11:00
 */
public class AddressClient {

    /**
     * 生成订单收款地址
     *
     * @param req 订单收款地址生成请求参数
     * @return 生成后的收款地址
     * @throws BizException 业务异常
     */
    public static AddressGenerateDTO generateAddress(AddressGenerateReq req) throws BizException {
        return generateAddress(req, ConfigUtil.getApiUrl(Constant.ADDRESS_CREATE));
    }

    private static AddressGenerateDTO generateAddress(AddressGenerateReq req, String url) {
        OrderClient.verifyArgs(req);
        req.setAppId(ConfigUtil.getAppId());
        String signature = getSignature(req);
        req.setSignature(signature);
        Result<AddressGenerateDTO> resp = InterfaceUtil.invoke(req, url, new TypeReference<AddressGenerateDTO>() {
        });
        AddressGenerateDTO address = resp.getData();
        if (null == address) {
            throw new BizException(resp.getMsg());
        }
        String respSignData = req.getAppId() + address.getAddress() + address.getPrivateKey();
        if (SignUtils.verify(respSignData, address.getSignature())) {
            return address;
        }
        throw new BizException(BizError.RESP_DATA_VERIFY_ERROR);
    }

    private static String getSignature(AddressGenerateReq req) {
        String signData = req.getAppId() + req.getNetwork();
        return SignUtils.sign(signData);
    }

    /**
     * 生成订单收款地址并且配置该地址
     *
     * @param req 订单收款地址生成请求参数
     * @return 生成后的收款地址
     * @throws BizException 业务异常
     */
    public static AddressGenerateDTO addressGenerateAndConfig(AddressGenerateReq req) {
        return generateAddress(req, ConfigUtil.getApiUrl(Constant.ADDRESS_GENERATE_CONFIG));
    }

    /**
     * 启用或禁用当前地址
     *
     * @param req 禁用或启用参数
     * @return 成功与否
     */
    public static String disableAddress(AddressDisabledApiReq req) {
        OrderClient.verifyArgs(req);
        req.setAppId(ConfigUtil.getAppId());
        String signData = req.getAppId() + req.getAddress() + req.getStatus();
        req.setSignature(SignUtils.sign(signData));
        Result<Object> resp = InterfaceUtil.invoke(req, ConfigUtil.getApiUrl(Constant.ADDRESS_DISABLED), null);
        return resp.getMsg();
    }


    /**
     * 订单收款地址配置
     *
     * @param req 订单收款地址生成请求参数
     * @return 生成后的收款地址
     * @throws BizException 业务异常
     */
    public static AddressCofigDTO addAddress(AddressAddApiReq req) throws BizException {
        OrderClient.verifyArgs(req);
        req.setAppId(ConfigUtil.getAppId());
        String signData = req.getAppId() + req.getAddress() + req.getNetwork();
        String signature = SignUtils.sign(signData);
        req.setSignature(signature);
        Result<AddressCofigDTO> resp = InterfaceUtil.invoke(req, ConfigUtil.getApiUrl(Constant.ADDRESS_CONFIG), new TypeReference<AddressCofigDTO>() {
        });
        AddressCofigDTO config = resp.getData();
        if (null == config) {
            throw new BizException(resp.getMsg());
        }
        String respSignData = req.getAppId() + config.getAddress();
        if (SignUtils.verify(respSignData, config.getSignature())) {
            return config;
        }
        throw new BizException(BizError.RESP_DATA_VERIFY_ERROR);
    }

    /**
     * 配置地址列表查询
     *
     * @return 所配置的地址列表
     */
    public static List<AddressDTO> listAddress() {
        AddressListApiReq req = new AddressListApiReq();
        req.setAppId(ConfigUtil.getAppId());
        req.setSignature(SignUtils.sign(req.getAppId()));
        Result<List<AddressDTO>> resp = InterfaceUtil.invoke(req, ConfigUtil.getApiUrl(Constant.ADDRESS_LIST), new TypeReference<List<AddressDTO>>() {
        });
        return resp.getData();
    }


}
