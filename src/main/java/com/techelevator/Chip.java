package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Items {

    public Chip(String name, BigDecimal price, int quantityRemaining) {
        super(name, price, quantityRemaining);
    }

    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
