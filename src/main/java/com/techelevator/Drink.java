package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Items {

    public Drink(String name, BigDecimal price, int quantityRemaining) {
        super(name, price, quantityRemaining);
    }

    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
