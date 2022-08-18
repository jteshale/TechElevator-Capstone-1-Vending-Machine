package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TheLogger {
    private String fileName = "Log.txt";
    private File logFile = new File(fileName);
    private static final String CURRENT_DATE = "MM/dd/yyyy HH:mm:ss a";

    public static String getCurrentDate(String format) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(currentDate);
    }

//    METHOD TO LOG WHEN MONEY IS FED
    public void logMoneyFed(BigDecimal moneyFed, BigDecimal balance) {
        try (PrintWriter logOutput = new PrintWriter(new FileOutputStream(logFile, true))) {
            logOutput.println(String.format(getCurrentDate(CURRENT_DATE) + " FEED MONEY: $%.2f $%.2f", moneyFed, balance));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file destination.");
        }
    }
//METHOD TO LOG A PURCHASE
    public void logPurchases(String productName, String slotNumber, BigDecimal price, BigDecimal balance) {

        try (PrintWriter logOutput = new PrintWriter(new FileOutputStream(logFile, true))) {
            logOutput.println(String.format(getCurrentDate(CURRENT_DATE) + " %s %s $%.2f $%.2f", productName, slotNumber, price, balance));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file destination.");
        }
    }

    public void logChange(BigDecimal changeDispensed, BigDecimal balance) {

        try(PrintWriter logOutput = new PrintWriter(new FileOutputStream(logFile, true))) {
            logOutput.println(String.format(getCurrentDate(CURRENT_DATE) + " GIVE CHANGE: $%.2f $%.2f", changeDispensed, balance));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file destination.");
        }
    }




}
