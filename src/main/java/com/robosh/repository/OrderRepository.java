package com.robosh.repository;

import com.robosh.model.entities.Order;
import com.robosh.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdOrderAndOrderStatus(Long idOrder, OrderStatus orderStatus);
}
