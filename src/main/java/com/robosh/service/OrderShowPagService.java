package com.robosh.service;

import com.robosh.model.entities.Order;
import com.robosh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderShowPagService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderShowPagService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<Order> getCurrentOrder(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }


    public Page<Order> findPaginated(Pageable pageable) {
        List<Order> orders = orderRepository.findAll();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Order> list;

        if (orders.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, orders.size());
            list = orders.subList(startItem, toIndex);
        }

        Page<Order> orderPage
                = new PageImpl<Order>(list, PageRequest.of(currentPage, pageSize), orders.size());

        return orderPage;
    }


}
