package com.robosh.model.entities;

import com.robosh.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long personId;
    protected String name;
    protected String surname;
    protected String password;
    protected String phoneNumber;

    @Transient
    protected Role roles;
}
