package com.robosh.controllers;

import com.robosh.service.AddressService;
import com.robosh.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class TaxiOrderController {

    @Autowired
    private final AddressService addressService;

    public TaxiOrderController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/making-order")
    public String makingTaxiOrder(Model model){
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "taxi_order";
    }

    @PostMapping("/madeOrder")
    public String madeOrder(){
        return "order_status";
    }
}
