package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;


public class ReadFile {


	public Map<String, Items> loadData() {

		Scanner keyboardInput = new Scanner(System.in);
		File inputFile = new File("vendingmachine.csv");

		Map<String, Items> vendingMachineItems = new TreeMap<>();



		//reading the file of inventory & catching file not found exception.
		try (Scanner inventoryFile = new Scanner(inputFile)) {
			while (inventoryFile.hasNextLine()) {
				//putting each line of the file into a String & splitting the String into variables
				String lineOfInput = inventoryFile.nextLine();
				String[] separateVariables = lineOfInput.split("\\|");
				String slotNumber = separateVariables[0];
				String productName = separateVariables[1];
				BigDecimal itemPrice = new BigDecimal(separateVariables[2]);
				String className = separateVariables[3];
				int initialQuantity = 5;

				//create item instances from these variables & put those items into a map.
				if(className.equals("Chip")) {
					Chip chip  = new Chip(productName, itemPrice, initialQuantity);
					vendingMachineItems.put(slotNumber, chip);

				} else if(className.equals("Candy")) {
					 Candy candy = new Candy(productName,itemPrice,initialQuantity);
					 vendingMachineItems.put(slotNumber, candy);

				} else if(className.equals("Drink")) {
					Drink drink = new Drink(productName, itemPrice, initialQuantity);
					vendingMachineItems.put(slotNumber, drink);

				} else if(className.equals("Gum")) {
					Gum gum = new Gum(productName,itemPrice,initialQuantity);
					vendingMachineItems.put(slotNumber, gum);

				}

			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}

			return vendingMachineItems;


	}


	}


