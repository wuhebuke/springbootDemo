package com.company.common.utils;

import java.math.BigDecimal;

/**
 * @author : farid
 * @date : 2023/11/5
 */
public interface CouponStrategy {


    /**
     * 订单价格计算的抽象方法
     *
     * @param money 订单实际金额
     * @param sales 折扣额度
     * @return 订单实付金额
     */
    public  BigDecimal calculatePrice(BigDecimal money, BigDecimal sales);
}
