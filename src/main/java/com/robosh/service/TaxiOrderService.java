package com.robosh.service;

import com.robosh.dto.OrderTaxiDto;
import com.robosh.model.entities.Driver;
import com.robosh.model.entities.Order;
import com.robosh.model.enums.DriverStatus;
import com.robosh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaxiOrderService {

    private final OrderRepository orderRepository;
    private final DriverService driverService;

    @Autowired
    public TaxiOrderService(OrderRepository orderRepository, DriverService driverService) {
        this.orderRepository = orderRepository;
        this.driverService = driverService;
    }

    @Transactional
    public Order makeOrder(OrderTaxiDto orderDto){

        return null;
    }
}
