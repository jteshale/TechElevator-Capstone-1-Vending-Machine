package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	Scanner keyboardInput = new Scanner(System.in);

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTION = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,
			PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;
	private VendingMachine vendingMachine;

	public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
		this.menu = menu; this.vendingMachine = vendingMachine;
	}

	boolean done = false;
	boolean secondMenuDone = false;

	public void run() {
		while (!done) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendingMachine.displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (!secondMenuDone) {

					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION);


					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						System.out.print("Enter amount of money: ");
						String feedMoneyChoice = keyboardInput.nextLine();
						Double moneyProvided = Double.parseDouble(feedMoneyChoice);

						vendingMachine.feedMoney(BigDecimal.valueOf(moneyProvided));

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						for (Map.Entry<String, Items> entry : vendingMachine.getVendingMachineItems().entrySet()) {
							System.out.println("|" + entry.getKey() + "| " + (entry.getValue()).getName() + " $" + (entry.getValue()).getPrice());

						}

						System.out.println(String.format("Current Balance: $%.2f", vendingMachine.getVendingMachineBalance()));
						System.out.print("Enter slot number: ");
						String itemChoice = keyboardInput.nextLine();

						vendingMachine.dispenseProduct(itemChoice);


					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						System.out.println(vendingMachine.dispenseChange(vendingMachine.getVendingMachineBalance()));
						secondMenuDone = true;
					}

				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				done = true;
			}
		}
	}

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine);
		cli.run();
	}
}
