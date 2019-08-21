package com.robosh.controllers;

import com.robosh.dto.OrderTaxiDto;
import com.robosh.model.customExceptions.NoDriverAvailableException;
import com.robosh.model.entities.Client;
import com.robosh.service.AddressService;
import com.robosh.service.ClientService;
import com.robosh.service.TaxiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class TaxiOrderController {

    private final AddressService addressService;
    private final TaxiOrderService orderService;
    private final ClientService clientService;

    @Autowired
    public TaxiOrderController(AddressService addressService, TaxiOrderService orderService, ClientService clientService) {
        this.addressService = addressService;
        this.orderService = orderService;
        this.clientService = clientService;
    }


    @GetMapping("/making-order")
    public String makingTaxiOrder(Model model){
        setAttributes(model,new OrderTaxiDto());
        return "taxi_order";
    }

    @GetMapping("/order-status")
    public String showOrderInfo(){
        return "order_status";
    }

    @PostMapping("/makeOrder")
    public String madeOrder(@ModelAttribute("order") @NotNull @Valid OrderTaxiDto dto,
                            BindingResult result, Model model, Principal principal) {
        Client client = clientService.getClientByPhoneNumber(principal.getName());

        if (hasValidationErrors(result, dto)){
            setAttributes(model,dto);
            return "taxi_order";
        }

        if (!makeOrderIfDriverAvailable(dto, client)) {
            result.rejectValue("carType", "taxi.order.no.car");
            setAttributes(model, dto);
            return "taxi_order";
        }

        return "redirect:/taxi-kyiv/client-account/order-status";
    }

    private void setAttributes(Model model, OrderTaxiDto dto){
        model.addAttribute("order", dto);
        model.addAttribute("addresses", new ArrayList<>(addressService.getAllAddresses()));
    }

    private boolean hasValidationErrors(BindingResult result, OrderTaxiDto orderTaxiDto) {
        if (isNotEqualAddresses(orderTaxiDto, result)){
            return true;
        }
        return result.hasErrors();
    }

    private boolean isNotEqualAddresses(OrderTaxiDto orderTaxiDto, BindingResult result) {
        Long idAddressDeparture = orderTaxiDto.getId_address_departure();
        Long idAddressArrive = orderTaxiDto.getId_address_arrive();
        if (idAddressArrive.equals(idAddressDeparture)){
            result.rejectValue("id_address_departure", "taxi.order.choose.error");
            return true;
        }
        return false;
    }

    private boolean makeOrderIfDriverAvailable(OrderTaxiDto dto, Client client){
        try {
            orderService.makeOrder(dto, client);
        }catch (NoDriverAvailableException e){
            return false;
        }
        return true;
    }

}
