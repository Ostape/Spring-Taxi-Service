package com.robosh.service;

import com.robosh.model.entities.Coupon;
import com.robosh.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon getCouponByCouponName(String couponName) {
        return couponRepository.findByCouponName(couponName);
    }

    public Integer getDiscount(Coupon coupon) {
        return coupon.getDiscount();
    }
}
