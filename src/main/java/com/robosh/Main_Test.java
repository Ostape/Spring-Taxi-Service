package com.robosh;

import com.robosh.model.entities.Address;
import com.robosh.model.entities.Client;

public class Main_Test {
    public static void main(String[] args) {

        System.out.println(method());
    }

    private static int method(){
        try {

            System.out.println("aaaa");
            if (2 == 2)
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e) {
            System.out.println("before catch");
            return 12;
        }
        finally {
            System.out.println("finale");

        }
        return 222;
    }

}

abstract class A{
    private String a;

    public A(){}
}
