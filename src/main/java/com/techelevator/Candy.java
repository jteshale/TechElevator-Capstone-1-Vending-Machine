package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items {


    public Candy(String name, BigDecimal price, int quantityRemaining) {
        super(name, price, quantityRemaining);
    }

    public String getSound() {
        return "Munch Munch, Yum!";
    }
}
