package com.robosh.service;

import com.robosh.model.entities.Coupon;
import com.robosh.repository.CouponRepository;
import com.robosh.service.abstractService.AbstractCouponService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService implements AbstractCouponService {
    private final Logger logger = LogManager.getLogger(CouponService.class);
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(final CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon getCouponByCouponName(final String couponName) {
        logger.info("get coupon by it`s name: " + couponName);
        return couponRepository.findByCouponName(couponName);
    }

    @Override
    public Integer getDiscount(final Coupon coupon) {
        logger.info("get discount by coupon: " + coupon);
        return coupon.getDiscount();
    }
}
