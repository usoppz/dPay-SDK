# 简介

> [dPay](https://os.dpaycoin.com/) 是一个目前完全免费的数字货币交易订单支付平台，当前只支持基于TRC20的USDT支付，在后面我们将会根据用户的使用情况而支持更多的协议与币种。

## 为什么选择dPay ?

- 优势1：基于波场公链转账快与极强的稳定性，当前平台整体的收款回调成功率高达99.63%；
- 优势2：付款可选择直接进入商户钱包，不经平台中转，无需提现，也可选择需归集提现的方式；
- 优势3：便捷快速的API接入方式以及超强的用户体验，支持钱包扫码，一键付款；
- 优势4：全程匿名，一次对接，全球收款，天然匿名，拒绝追踪；
- 优势5：全网最低的收费，对的，你没看错，全网最低，因为我们目前全部免费。

## dPay业务特点 ?
> [dPay](https://os.dpaycoin.com/) 当前支持两种支付订单类型的创建，分别是：1.无需归集订单；2.需要归集订单。两种订单类型可优劣互补，商户可根据自身的业务场景选择使用。

​	**无需归集订单：**

- 优势：用户付款可直接进入商户指定的钱包地址，不经平台中转，也无需提现，无需归集gas费，亦无需提现gas费和提现操作。
- 劣势：用户付款需要精确到小数点后3位，且同一商户极短时间内创建多个相同订单金额的支付订单时，可能会出现小概率的订单匹配不上的情况（但订单付款还是到该商户钱包，不会丢失），需要商户到dPay平台手动处理未匹配上的订单。
- 场景：商户不想支付归集、提现gas费和提现操作，且不会在极短时间内产生大量相同金额的支付订单。

​	**需归集订单：**

- 优势：用户付款只需精确到小数点后2位，在级短时间内创建大量相同金额的支付订单也不会存在小概率的订单匹配不上的情况。
- 劣势：用户付款不能直接进入商户指定的钱包地址，需经平台一键归集和提现操作，需归集gas费和提现gas费。
- 场景：同一商户端会在极短时间内产生大量相同金额的支付订单，且在意订单小概率支付不匹配的情况以及不想在dPay平台进行手动处理该情况的订单。

# 快速使用

## 接入步骤

欢迎阅读 [`dPay API`](https://docs.dpaycoin.com/#/) 技术接入文档。在开始接入之前，你需要：

### 前期准备

1. 访问并登录 [商户后台](https://dpaycoin.com/login.html)。

2. 在商户后台分别查看技术接入必需的dPay平台公钥、商户私钥以及appId：

   `publicKey` & `privateKey` & `appId`。

3. 在商户后台配置你的 `收款地址` （也可以通过API接口方式配置）。

4. 阅读我们 [接口约定](https://usoppz.github.io/dPay/#/interface_desc) 及 [安全说明](https://usoppz.github.io/dPay/#/security_desc) 相关的内容。

### 代码接入（Java）

1. 新增配置文件<u>config.properties</u>，``并加入如下内容：

   ```properties
   host =https://dpaycoin.com
   ##商户私钥 merchant private key
   merchantPrivateKey =MIICdQIBADANBgk********** ## 前期准备 步骤2 获取到的商户私钥
   ##dPay平台公钥 platform public key
   dPayPublicKey =MIGfMA0GCSqGSIb************  ## 前期准备 步骤2 获取到的dPay平台公钥
   ##merchant appId
   appId =4c1fe739-54f9-44f3-bba8-c334a4541a7b  ## 前期准备 步骤2 获取到的appId
   ```

2. 通过下载SDK源码自行打包后引入jar包，或者直接通过maven配置直接引入

   SDK源码下载地址：[https://github.com/usoppz/dPay-SDK](https://github.com/usoppz/dPay-SDK)

   maven配置：

   ```xml
   <dependency>
     <groupId>com.dpaycoin</groupId>
     <artifactId>dPay-SDK</artifactId>
     <version>1.0</version>
   </dependency>
   ```

3. 编写代码，下面代码以创建订单为例：

   ```java
   public static void main(String[] args) {
       //一句代码就可以搞定支付订单的创建
       SignOrderDTO order = OrderClient.createOrder(getOrderReq());
       //打印返回数据
       System.out.println(JSON.toJSONString(order));
   }
   /**
    * 订单创建请求参数
   */
   private static PayOrderReq getOrderReq() {
       PayOrderReq req = new PayOrderReq();
       req.setOrderNo("PO123455678WD8GD0SD6668879BEF");
       req.setAmount(50.00);
       req.setCurrency("cny");
       req.setSymbol("usdt");
       req.setOrderType(2);
       req.setNetwork("trc20");
       req.setCustomerNo("test000301");
       req.setProductName("product0001");
       req.setReturnUrl("http://yourdomain/v1/order/returnUrl");
       req.setNotifyUrl("http://yourdomain/v1/order/notifyUrl");
       return req;
   }
   ```

   <font color='red'>注：appId 在配置文件配置后，可以不用在请求参数里面在设置appId。</font>



**说明**

你也可以直接参考 [Demo](https://github.com/usoppz/dPayDemo-java)，快速接入我们的API服务。

## 如何联系我们 ?

> 电报: [@dpayz](https://t.me/dpayz) <br>
> 邮箱: <a href="mailto:usoppz.yy@gmail.com" target="_blank">usoppz.yy@gmail.com</a>

## 商务合作

> 如需商务合作，请通过上述联系方式与我们商务人员进行洽谈！