package com.robosh.controllers;

import com.robosh.dto.OrderTaxiDto;
import com.robosh.model.enums.DriverStatus;
import com.robosh.service.AddressService;
import com.robosh.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

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
        model.addAttribute("order", new OrderTaxiDto());
        model.addAttribute("addresses", new ArrayList<>(addressService.getAllAddresses()));
        return "taxi_order";
    }

    @PostMapping("/makeOrder")
    public String madeOrder(@ModelAttribute("client") @NotNull @Valid OrderTaxiDto dto, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("order", dto);
            model.addAttribute("addresses", new ArrayList<>(addressService.getAllAddresses()));
            return "taxi_order";
        }
        String carType = dto.getCarType();

        driverService.updateDriver(DriverStatus.booked, 1L);

        if (driverService.getDriverIfFree(carType) != null) {
            //todo redirect
            return "order_status";
        }

        //todo addAtribute
        return "taxi_order";
    }
}
