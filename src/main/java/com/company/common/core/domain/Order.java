package com.company.common.core.domain;

import lombok.Data;

import java.util.Date;

/**
 * Author : flk
 * Date : 2023/6/6 13:57
 */
@Data
public class Order {

    private int id;

    //订单id
    private String orderId;

    //发货单号
    private String courierNumber;

    // 订单总金额
    private Double money;

    //订单状态 1待支付 2待发货 3待收货 4已收货 5售后中
    private String status;

    //订单备注
    private String remark;

    /** 订单属性 1购物车订单 2商品订单 */
    private String belong;

    private String attribute;

    /** 0快递订单 1自提订单 */
    private String delivery;

    private String errorFlag;

    //运费
    private int freight;

    private Date payTime;

    private Date createTime;

    private Date updateTime;
}
