package com.robosh.model.entities;

import com.robosh.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long personId;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String surname;
    @Column(nullable = false)
    protected String password;
    @Column(unique = true, nullable = false)
    protected String phoneNumber;
    @Column(nullable = false)
    protected Boolean active;

    @Enumerated(value = EnumType.STRING)
    protected Role role;
}
