package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;

/**
 * 微信小店订单支付成功接口消息
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_7638cbc70355]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[o_CBes6AP0_HPzsRwzpe6kXF6FnM]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1463387703&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[merchant_order]]&gt;&lt;/Event&gt;
 * &lt;OrderId&gt;&lt;![CDATA[12924804247712204496]]&gt;&lt;/OrderId&gt;
 * &lt;OrderStatus&gt;2&lt;/OrderStatus&gt;
 * &lt;ProductId&gt;&lt;![CDATA[p_CBes1Evak4u6Gd5l-T0yYlk5dk]]&gt;&lt;/ProductId&gt;
 * &lt;SkuInfo&gt;&lt;![CDATA[]]&gt;&lt;/SkuInfo&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InMerChantOrderEvent extends InEventMessage {
    public static final String EVENT = "merchant_order";

    private String orderId;
    private Integer orderStatus;
    private String productId;
    private String skuInfo;

    public InMerChantOrderEvent(String toUserName, String fromUserName, Integer createTime) {
        super(toUserName, fromUserName, createTime, EVENT);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(String skuInfo) {
        this.skuInfo = skuInfo;
    }
}
