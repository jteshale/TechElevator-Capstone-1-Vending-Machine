package com.techelevator;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addMoney(BigDecimal amountDeposit) {
        BigDecimal sum = balance.add(amountDeposit);
        balance = sum;
    }

    public void moneyLeftover(BigDecimal amountSpent) {
        BigDecimal moneyLeftover = balance.subtract(amountSpent);
        balance = moneyLeftover;
    }

    public void getChange(BigDecimal amountChange) {
        BigDecimal diff = balance.subtract(amountChange);
        balance = diff;
    }


}
