package com.company.common.utils;

import java.math.BigDecimal;

/**
 * @author : farid
 * @date : 2023/11/5
 */
public class CouponContext {

    private CouponStrategy couponStrategy;

    public CouponContext(CouponStrategy couponStrategy) {
        this.couponStrategy = couponStrategy;
    }

    public BigDecimal qoutePrice(BigDecimal money,BigDecimal sales){
        return couponStrategy.calculatePrice(money,sales);
    }
}
