package com.company.common.utils;

import java.math.BigDecimal;

/**
 * @author : farid
 * @date : 2023/11/5
 */
public class FullReduceStrategy implements CouponStrategy{
    @Override
    public BigDecimal calculatePrice(BigDecimal money, BigDecimal sales) {
        return money.subtract(sales);
    }
}
