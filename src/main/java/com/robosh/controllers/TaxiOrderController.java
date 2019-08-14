package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class TaxiOrderController {
    @GetMapping("/making-order")
    public String makingTaxiOrder(){
        return "taxi_order";
    }

    @PostMapping("/madeOrder")
    public String madeOrder(){
        return "order_status";
    }
}
