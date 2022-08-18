package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;

public class VendingMachine {
    private Balance vendingMachineBalance;
    private Map<String, Items> vendingMachineItems;
    private TheLogger vendingMachineLogger = new TheLogger();

    //constructor
    public VendingMachine() {
        this.vendingMachineBalance = new Balance(BigDecimal.valueOf(0.00));
        ReadFile vendingMachineFileReader = new ReadFile();
        vendingMachineItems = vendingMachineFileReader.loadData();
    }

    //getters & setters
    public Map<String, Items> getVendingMachineItems() {
        return vendingMachineItems;
    }

    public BigDecimal getVendingMachineBalance() {
        return this.vendingMachineBalance.getBalance();
    }

    //methods
    public void displayItems(){
        for (Map.Entry<String, Items> entry : getVendingMachineItems().entrySet()) {
            System.out.println((entry.getValue()).getName() + " | quantity remaining: " + (entry.getValue()).getQuantityRemaining());

        }
    }

    public void feedMoney(BigDecimal startingBalance) {
        vendingMachineBalance.addMoney(startingBalance);
        System.out.println(String.format("Current Money Provided: $%.2f", getVendingMachineBalance()));
        //log money fed
        vendingMachineLogger.logMoneyFed(startingBalance, getVendingMachineBalance());

    }

    public void moneyRemaining(BigDecimal amountSpent) {
        vendingMachineBalance.moneyLeftover(amountSpent);
    }

    public void dispenseProduct(String itemChoice) {
        if (!getVendingMachineItems().containsKey(itemChoice)) {

            System.out.println("Product does not exist");

        } else if (getVendingMachineItems().containsKey(itemChoice)) {

            for (Map.Entry<String, Items> entry : getVendingMachineItems().entrySet()) {

                if (entry.getKey().equals(itemChoice)) {

                    if (((entry.getValue()).getQuantityRemaining()) > 0) {

                        if (((entry.getValue()).getPrice()).compareTo(getVendingMachineBalance()) <= 0) {

                            System.out.println((entry.getValue()).getName() + ", price: $" + (entry.getValue()).getPrice());
                            moneyRemaining((entry.getValue()).getPrice());
                            System.out.println("Money Remaining: $" + getVendingMachineBalance());
                            int amountDispensed = 1;
                            System.out.println((entry.getValue()).getSound());
                            (entry.getValue()).setQuantityRemaining(amountDispensed);
                            //log purchase
                            vendingMachineLogger.logPurchases((entry.getValue()).getName(), entry.getKey(), (entry.getValue()).getPrice(), vendingMachineBalance.getBalance());

                        } else if (((entry.getValue()).getPrice()).compareTo(getVendingMachineBalance()) > 0) {
                            System.out.println("Not enough money in balance to complete transaction.");
                        }
                    } else if (((entry.getValue()).getQuantityRemaining()) == 0) {
                        System.out.println("Product is sold out!");
                    }
                }
            }
        }

    }

    public String dispenseChange(BigDecimal changeOwed) {
        vendingMachineBalance.getChange(changeOwed);
        vendingMachineLogger.logChange(changeOwed, vendingMachineBalance.getBalance());
        return String.format("Transaction Finished. Here is your change: $%.2f", changeOwed);
    }


}
