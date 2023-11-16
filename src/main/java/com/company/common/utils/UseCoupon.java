package com.company.common.utils;

import java.math.BigDecimal;

/**
 * @author : farid
 * @date : 2023/11/5
 */
public class UseCoupon {

    public static void main(String[] args) {
        //向上转型
        CouponStrategy fullReduceStrategy = new FullReduceStrategy();
        CouponStrategy discountStrategy = new DiscountStrategy();


        CouponContext fullReduceContext = new CouponContext(fullReduceStrategy);
        CouponContext discountContext = new CouponContext(discountStrategy);

        System.out.println(fullReduceContext.qoutePrice(new BigDecimal("80"),new BigDecimal("12")));
        System.out.println(discountContext.qoutePrice(new BigDecimal("100"),new BigDecimal("0.8")));

    }
}
