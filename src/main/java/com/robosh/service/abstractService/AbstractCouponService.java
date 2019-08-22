package com.robosh.service.abstractService;

import com.robosh.model.entities.Coupon;

public interface AbstractCouponService {
    Coupon getCouponByCouponName(final String couponName);

    Integer getDiscount(final Coupon coupon);
}
