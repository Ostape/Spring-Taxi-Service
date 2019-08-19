package com.robosh.repository;

import com.robosh.model.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import java.awt.print.Pageable;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    Page<Order> (Pageable pageable);
}
