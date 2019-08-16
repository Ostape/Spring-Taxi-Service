package com.robosh.model.entities;

import com.robosh.model.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true, includeFieldNames=true)

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_driver")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "id_address_arrive")
    private Address addressArrive;

    @ManyToOne
    @JoinColumn(name = "id_address_departure")
    private Address addressDeparture;

    @ManyToOne
    @JoinColumn(name = "id_coupon")
    private Coupon coupon;

    private int cost;
    private int costWithDiscount;
}
