package com.robosh.model.entities;

import com.robosh.model.enums.OrderStatus;

public class Order {
    private int idOrder;
    private OrderStatus orderStatus;
    private Client client;
    private Driver driver;
    private Address addressArrive;
    private Address addressDeparture;
    private Coupon coupon;
    private int cost;
    private int costWithDiscount;
}
