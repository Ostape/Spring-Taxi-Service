package com.robosh.model.entities;

import com.robosh.model.enums.Role;

public abstract class Person {
    protected int personId;
    protected String name;
    protected String surname;
    protected String password;
    protected String phoneNumber;
    protected Role role;
}
