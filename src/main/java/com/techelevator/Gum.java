package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Items {

    public Gum(String name, BigDecimal price, int quantityRemaining) {
        super(name, price, quantityRemaining);
    }

    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
