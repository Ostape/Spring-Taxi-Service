package com.robosh.controllers;

import com.robosh.dto.OrderTaxiDto;
import com.robosh.service.AddressService;
import com.robosh.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class TaxiOrderController {


    private final AddressService addressService;
    private final DriverService driverService;

    @Autowired
    public TaxiOrderController(AddressService addressService, DriverService driverService) {
        this.addressService = addressService;
        this.driverService = driverService;
    }


    @GetMapping("/making-order")
    public String makingTaxiOrder(Model model){
        model.addAttribute("addresses", addressService.getAllAddresses());
        model.addAttribute("order", new OrderTaxiDto());
        return "taxi_order";
    }

    @PostMapping("/makeOrder")
    public String madeOrder(@NotNull @Valid OrderTaxiDto dto) {

        @NotNull @NotEmpty String carType = dto.getCarType();

        System.out.println(dto);

        if (driverService.checkIfDriverIsFree(carType)) {

            return "order_status";
        }
        return "redirect:/taxi-kyiv/client-account/making-order";
    }
}
