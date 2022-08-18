package com.techelevator;

import java.math.BigDecimal;

public abstract class Items {
    private String name;
    private BigDecimal price;
    private int quantityRemaining;

    public Items(String name, BigDecimal price, int quantityRemaining) {
        this.name = name;
        this.price = price;
        this.quantityRemaining = quantityRemaining;
    }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setQuantityRemaining(int quantityDispensed) {
        this.quantityRemaining = quantityRemaining - quantityDispensed;
    }

    public int getQuantityRemaining() {
        return quantityRemaining;
    }



}
