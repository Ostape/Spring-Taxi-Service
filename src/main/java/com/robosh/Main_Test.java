package com.robosh;

import com.robosh.model.entities.Address;

public class Main_Test {
    public static void main(String[] args) {
        Address address1 = new Address(2, "ff", "aa");
        Address address2 = new Address(1, "ff", "aa");
        System.out.println(address1.equals(address2));
    }
}
