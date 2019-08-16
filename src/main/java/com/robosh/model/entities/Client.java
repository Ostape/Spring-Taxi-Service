package com.robosh.model.entities;


import com.robosh.model.enums.Role;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true, includeFieldNames=true)

@Entity
@Table(name = "client")
public class Client extends Person {
    private String email;

    {
        roles=Role.CLIENT;
    }
}
