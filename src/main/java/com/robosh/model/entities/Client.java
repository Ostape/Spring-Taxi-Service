package com.robosh.model.entities;


import com.robosh.model.enums.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
@Entity
public class Client extends Person {
    @Column(unique = true)
    private String email;

    public Client(String email) {
        this.email = email;
    }

    @Builder(builderMethodName = "clientBuilder")
    public Client(Long personId, String name, String surname,
                  String password, String phoneNumber, Boolean active, Role role, String email) {
        super(personId, name, surname, password, phoneNumber, active, role);
        this.email = email;
    }
}
