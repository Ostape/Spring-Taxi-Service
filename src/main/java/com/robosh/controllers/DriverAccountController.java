package com.robosh.controllers;


import com.robosh.model.entities.Client;
import com.robosh.model.entities.Driver;
import com.robosh.model.entities.Order;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/taxi-kyiv/driver-account")
public class DriverAccountController {

    @Autowired
    private final DriverService driverService;

    @Autowired
    private final OrderService orderService;

    public DriverAccountController(DriverService driverService, OrderService orderService) {
        this.driverService = driverService;
        this.orderService = orderService;
    }


    @GetMapping
    public String showDriverPage(Model model, Principal principal, HttpServletRequest request){
        Driver driver = driverService.getDriverByPhoneNumber(principal.getName());
        model.addAttribute("name", driver.getName());
        model.addAttribute("surname", driver.getSurname());
        model.addAttribute("phone_number", driver.getPhoneNumber());
        model.addAttribute("auto_type", driver.getCar().getCarType());
        model.addAttribute("status", driver.getDriverStatus());
        return "driver_account";
    }

    @GetMapping("/show-orders")
    public String showDriverOrders(Model model,
                                   @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Order> orderPage = orderService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("orderPage", orderPage);

        int totalPages = orderPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "show_driver_orders";
    }
}
