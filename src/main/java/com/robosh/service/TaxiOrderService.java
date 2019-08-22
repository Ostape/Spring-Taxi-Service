package com.robosh.service;

import com.robosh.customExceptions.NoSuchDriverOrderException;
import com.robosh.dto.OrderTaxiDto;
import com.robosh.model.entities.*;
import com.robosh.model.enums.DriverStatus;
import com.robosh.model.enums.OrderStatus;
import com.robosh.repository.OrderRepository;
import com.robosh.service.abstractService.AbstractAddressService;
import com.robosh.service.abstractService.AbstractCouponService;
import com.robosh.service.abstractService.AbstractDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaxiOrderService {

    private final OrderRepository orderRepository;
    private final AbstractDriverService driverService;
    private final AbstractAddressService addressService;
    private final AbstractCouponService couponService;

    @Autowired
    public TaxiOrderService(OrderRepository orderRepository, AbstractDriverService driverService,
                            AbstractAddressService addressService, AbstractCouponService couponService) {
        this.orderRepository = orderRepository;
        this.driverService = driverService;
        this.addressService = addressService;
        this.couponService = couponService;
    }

    @Transactional
    public Order makeOrder(final OrderTaxiDto orderDto, final Client client) {
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
        return (int) (Math.random() * 1500);
    }

    private int getPriceWithCoupon(int price, Coupon coupon) {
        int discountPercent = 0;
        if (coupon != null) {
            discountPercent = couponService.getDiscount(coupon);
        }
        return (int) (price - price * (double) discountPercent / 100);
    }

    @Transactional
    public void performOrder(Long idDriver, Long idOrder) {
        Order order = orderRepository.findByIdOrderAndOrderStatus(idOrder, OrderStatus.EXECUTING);
        if (order == null) {
            throw new NoSuchDriverOrderException();
        }
        //if null

        Driver driverFromOrder = order.getDriver();
        if (!driverFromOrder.getPersonId().equals(idDriver)) {
            throw new NoSuchDriverOrderException();
        }
        order.setOrderStatus(OrderStatus.COMPLETE);
        driverFromOrder.setDriverStatus(DriverStatus.free);
    }
}
