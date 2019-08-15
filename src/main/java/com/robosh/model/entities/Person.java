package com.robosh.model.entities;

import com.robosh.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer personId;
    protected String name;
    protected String surname;
    protected String password;
    protected String phoneNumber;
//
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "person_id"))
//    @Enumerated(EnumType.STRING)
//    protected Set<Role> roles;
}
