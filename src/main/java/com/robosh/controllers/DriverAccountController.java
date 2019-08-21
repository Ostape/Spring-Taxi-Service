package com.robosh.controllers;


import com.robosh.dto.ExecuteOrderDto;
import com.robosh.model.entities.Driver;
import com.robosh.model.entities.Order;
import com.robosh.model.enums.DriverStatus;
import com.robosh.service.DriverService;
import com.robosh.service.OrderShowPagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private final OrderShowPagService orderShowPagService;

    public DriverAccountController(DriverService driverService, OrderShowPagService orderShowPagService) {
        this.driverService = driverService;
        this.orderShowPagService = orderShowPagService;
    }


    @GetMapping
    public String showDriverPage(Model model, Principal principal){
        addDriverInfoAttribute(model, principal, new ExecuteOrderDto());
        return "driver_account";
    }

    private void addDriverInfoAttribute(Model model, Principal principal, ExecuteOrderDto dto) {
        Driver driver = getDriver(principal);
        addDriverAttributeToAccount(model, driver);
        model.addAttribute("execute_order", dto);
    }

    private Driver getDriver(Principal principal) {
        return driverService.getDriverByPhoneNumber(principal.getName());
    }

    private void addDriverAttributeToAccount(Model model, Driver driver) {
        model.addAttribute("name", driver.getName());
        model.addAttribute("surname", driver.getSurname());
        model.addAttribute("phone_number", driver.getPhoneNumber());
        model.addAttribute("auto_type", driver.getCar().getCarType());
        model.addAttribute("status", driver.getDriverStatus());
    }

    @PostMapping("/enterNumOrder")
    public String executeOrder(@ModelAttribute("execute_order") @Valid ExecuteOrderDto executeOrderDto,
                               BindingResult result, Principal principal, Model model){
        if (result.hasErrors()){
            addDriverInfoAttribute(model, principal, executeOrderDto);
            return "driver_account";
        }
        Driver driver = getDriver(principal);

        if (executeOrderDto != null && driver.getDriverStatus().equals(DriverStatus.booked)){
            System.out.println(executeOrderDto);
        }

        addDriverInfoAttribute(model, principal, executeOrderDto);
        return "driver_account";
    }

    @GetMapping("/show-orders")
    public String showDriverOrders(Model model,
                                   @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Order> orderPage = orderShowPagService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

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
