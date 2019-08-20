package com.robosh.service;

import com.robosh.dto.OrderDto;
import com.robosh.model.entities.Client;
import com.robosh.model.entities.Driver;
import com.robosh.model.entities.Order;
import com.robosh.model.enums.DriverStatus;
import com.robosh.model.enums.OrderStatus;
import com.robosh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiOrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final DriverService driverService;

    public TaxiOrderService(OrderRepository orderRepository, DriverService driverService) {
        this.orderRepository = orderRepository;
        this.driverService = driverService;
    }

    public Order makeOrder(OrderDto orderDto){
        Driver driver = driverService.getDriverByDriverStatusAndCarType(orderDto.getCarType(), DriverStatus.free);

//
//        Order order = Order.builder()
//                .orderStatus(OrderStatus.EXECUTING)
//                .client()
                return null;
    }
}
