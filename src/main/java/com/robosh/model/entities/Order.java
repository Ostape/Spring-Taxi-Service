package com.robosh.model.entities;

import com.robosh.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder;
    private OrderStatus orderStatus;
    private Client client;
    private Driver driver;
    private Address addressArrive;
    private Address addressDeparture;
    private Coupon coupon;
    private int cost;
    private int costWithDiscount;
}
