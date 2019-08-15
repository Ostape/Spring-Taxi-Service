package com.robosh.model.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "client")
public class Client extends Person {
    private String email;
}
