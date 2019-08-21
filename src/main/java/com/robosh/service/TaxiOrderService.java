package com.robosh.service;

import com.robosh.dto.OrderTaxiDto;
import com.robosh.model.entities.*;
import com.robosh.model.enums.DriverStatus;
import com.robosh.model.enums.OrderStatus;
import com.robosh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class TaxiOrderService {

    private final OrderRepository orderRepository;
    private final DriverService driverService;
    private final AddressService addressService;
    private final CouponService couponService;

    @Autowired
    public TaxiOrderService(OrderRepository orderRepository, DriverService driverService, AddressService addressService, CouponService couponService) {
        this.orderRepository = orderRepository;
        this.driverService = driverService;
        this.addressService = addressService;
        this.couponService = couponService;
    }

    @Transactional
    public Order makeOrder(OrderTaxiDto orderDto, Client client){
        Driver driver = driverService.getDriverIfFree(orderDto.getCarType());
        driver.setDriverStatus(DriverStatus.booked);

        Address departureAddress = addressService.getAddressById(orderDto.getId_address_departure());
        Address arriveAddress = addressService.getAddressById(orderDto.getId_address_arrive());
        Coupon coupon = couponService.getCouponByCouponName(orderDto.getCoupon());
        int price = getPriceWithoutDiscount();
        int priceWithCoupon = getPriceWithCoupon(price, coupon);

        Order order = Order.builder()
                .orderStatus(OrderStatus.EXECUTING)
                .client(client)
                .driver(driver)
                .addressDeparture(departureAddress)
                .addressArrive(arriveAddress)
                .coupon(coupon)
                .cost(price)
                .costWithDiscount(priceWithCoupon)
                .build();
        orderRepository.save(order);
        return order;
    }

    private int getPriceWithoutDiscount() {
        return (int) (Math.random() * 150);
    }

    private int getPriceWithCoupon(int price, Coupon coupon) {
        Integer discountPercent = couponService.getDiscount(coupon);
        return (int) (price - price * ((double)discountPercent / 100.0));
    }

}
