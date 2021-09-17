package com.project.my.homeworks.hw6.q1.frontend.ui;

import java.util.Scanner;

import com.project.my.homeworks.hw6.q1.backend.services.*;
import com.project.my.homeworks.hw6.q1.backend.services.entities.item.*;
import com.project.my.homeworks.hw6.q1.backend.services.entities.user.*;

public class UIManager {
	private Scanner input;
	private static final int DASHED_BORDER_LENGTH = 40;
	OnlineMarket onlineMarket;
	private boolean isRunning;

	public UIManager() {
		input = new Scanner(System.in);
		onlineMarket = new OnlineMarket();
		isRunning = false;
	}

	public void run() {
		isRunning = true;
		while (isRunning)
			showLoginPage();

	}

	private String getOptionalStringInputValue(String msg) {
		System.out.print(msg + " ");
		return input.nextLine().trim();
	}

	private String getStringInputValue(String msg) {
		String result = null;
		while (true) {
			result = getOptionalStringInputValue(msg);
			if (result.isEmpty())
				printErrorMessage("Invalid input!");
			else
				return result;
		}
	}

	private int getIntInputValue(String msg) {
		while (true)
			try {
				return Integer.parseInt(getStringInputValue(msg));
			} catch (Exception e) {
				printErrorMessage("Invalid input!");
				if (msg.isEmpty())
					System.out.print(">> ");
			}
	}

	private void showLoginPage() {
		System.out.println("*** Welcome to Online Market ***");
		printTitle("Login Page");
		System.out.println("1- Login as Admin");
		System.out.println("2- Login as Customer");
		System.out.println("3- Sign up");
		System.out.println("4- Exit");
		printDashedBorder();
		System.out.print(">> ");

		switch (getIntInputValue("")) {
		case 1:
			loginAsAdmin();
			break;
		case 2:
			loginAsCustomer();
			break;
		case 3:
			signUp();
			break;
		case 4:
			stop();
			break;
		default:
			printErrorMessage("Invalid selection. Try again please!");
		}
	}

	private void loginAsAdmin() {
		printTitle("Login as Admin");
		String username = getStringInputValue("Enter username:");
		String password = getStringInputValue("Enter password:");
		if (onlineMarket.getUsersManager().loginAdmin(username, password))
			showAdminPage();
		else
			printErrorMessage("Invalid username/password!");
	}

	private void loginAsCustomer() {
		printTitle("Login as Customer");
		String username = getStringInputValue("Enter username:");
		String password = getStringInputValue("Enter username:");
		if (onlineMarket.getUsersManager().loginUser(username, password))
			showUserPage();
		else
			printErrorMessage("Invalid username/password!");
	}

	private void signUp() {
		printTitle("Sign Up");
		if (onlineMarket.getUsersManager().isCutomerArrayFull()) {
			printErrorMessage("Customers array is full.");
			return;
		}
		String username = getStringInputValue("Enter Username:");
		if (onlineMarket.getUsersManager().isDuplicateUsername(username)) {
			printErrorMessage("Username is duplicate. Try again please.");
			return;
		}
		String password = getStringInputValue("Enter Password:");
		String firstName = getStringInputValue("Enter First Name:");
		String lastName = getStringInputValue("Enter Last Name:");
		Customer customer = new Customer(username, password, firstName, lastName);
		onlineMarket.getUsersManager().addNewCustomer(customer);
		printInfoMessage("Signed up successfully.");

	}

	private void stop() {
		isRunning = false;
	}

	private void showAdminPage() {
		printTitle("Administrator Page");
		System.out.println("1- Add New Item");
		System.out.println("2- List of All Items");
		System.out.println("3- List of All Customers");
		System.out.println("4- Back");
		printDashedBorder();
		System.out.print(">> ");
		switch (getIntInputValue("")) {
		case 1:
			addNewItem();
			break;
		case 2:
			showAllItems(true);
			break;
		case 4:
			return;
		default:
			printErrorMessage("Invalid selection. Try again please!");
		}
		showAdminPage();
	}

	private void showAllItems(boolean isAdmin) {
		printTitle("All Items List");
		if (onlineMarket.getItemsManager().isAnyAddedItem() == false) {
			printErrorMessage("There is no added item");
			return;
		}

		for (Item item : onlineMarket.getItemsManager().getAllItems())
			System.out.printf("%s%s%n", item, isAdmin ? " " + onlineMarket.getItemsManager().getItemCount(item) : "");
	}

	private void addNewItem() {
		printTitle("Add New Item");
		if (onlineMarket.getItemsManager().isItemArrayFull()) {
			printErrorMessage("Items array is full");
			return;
		}
		ItemCategory selectedItem = selectItemCategory();
		String code = getStringInputValue("Enter item code:");
		if (onlineMarket.getItemsManager().isDuplicateCode(code)) {
			printErrorMessage(code + " is duplicate code. Try again.");
			return;
		}

		int price = getIntInputValue("Enter item price:");
		Item item = new Item(code, price);

		switch (selectedItem) {
		case BOOK:
			item = getBook(item);
			break;
		case NEWSPAPER:
			item = getNewspaper(item);
			break;
		case MAGAZINE:
			item = getMagazine(item);
			break;
		case FORMAL_SHOE:
			item = getFormalShoe(item);
			break;
		case SPORT_SHOE:
			item = getSportShoe(item);
			break;
		case ANALOG_RADIO:
			item = getAnalogRadio(item);
			break;
		case DIGITAL_RADIO:
			item = getDigitalRadio(item);
			break;
		case LCD_TV:
			item = getLcdTV(item);
			break;
		case LED_TV:
			item = getLedTV(item);
			break;
		}
		int itemCount = getIntInputValue("Enter item count:");
		onlineMarket.getItemsManager().addNewItem(item, itemCount);
		printInfoMessage("Item added succesffuly");

	}

	private ItemCategory selectItemCategory() {
		System.out.println("Select an Item type: ");
		System.out.println(" + Readables: ");
		System.out.println("     1- Book");
		System.out.println("     2- Newspaper");
		System.out.println("     3- Magazine");
		System.out.println(" + Shoes: ");
		System.out.println("     4- Formal");
		System.out.println("     5- Sport");
		System.out.println(" + Electrical: ");
		System.out.println("     6- Analog Radio");
		System.out.println("     7- Digital Radio");
		System.out.println("     8- LCD TV");
		System.out.println("     9- LED TV");
		switch (getIntInputValue(">> ")) {
		case 1:
			return ItemCategory.BOOK;
		case 2:
			return ItemCategory.NEWSPAPER;
		case 3:
			return ItemCategory.MAGAZINE;
		case 4:
			return ItemCategory.FORMAL_SHOE;
		case 5:
			return ItemCategory.SPORT_SHOE;
		case 6:
			return ItemCategory.ANALOG_RADIO;
		case 7:
			return ItemCategory.DIGITAL_RADIO;
		case 8:
			return ItemCategory.LCD_TV;
		case 9:
			return ItemCategory.LED_TV;
		default:
			printErrorMessage("Invalid selection. Try again please!");
		}
		return selectItemCategory();
	}

	private Item getBook(Item item) {
		String title = getStringInputValue("Enter book title:");
		String authorName = getStringInputValue("Enter book author name:");
		Book book = new Book(title, authorName, item.getCode(), item.getPrice());
		return book;
	}

	private Item getNewspaper(Item item) {
		String title = getStringInputValue("Enter newspaper title:");
		String date = getStringInputValue("Enter newspaper date (Ex. 09-17-2021):");
		Newspaper newspaper = new Newspaper(title, date, item.getCode(), item.getPrice());
		return newspaper;
	}

	private Item getMagazine(Item item) {
		String title = getStringInputValue("Enter newspaper title:");
		String strMagazineType = getOptionalStringInputValue("Enter magazine type (General, Cooking, Fashion, Tech):")
				.toLowerCase();
		MagazineType magazineType = MagazineType.GENERAL;
		if (strMagazineType.startsWith("c"))
			magazineType = MagazineType.COOKING;
		else if (strMagazineType.startsWith("f"))
			magazineType = MagazineType.FASHION;
		else if (strMagazineType.startsWith("t"))
			magazineType = MagazineType.TECHNOLOGY;

		Magazine magazine = new Magazine(title, magazineType, item.getCode(), item.getPrice());
		return magazine;
	}

	private Item getFormalShoe(Item item) {
		int size = getIntInputValue("Enter fromal shoe size:");
		String color = getStringInputValue("Enter formal shoe color:");
		String strFormalShoeType = getOptionalStringInputValue("Enter formal shoe type (Kids, Women, Men):")
				.toLowerCase();
		FormalShoeType formalShoeType = FormalShoeType.MEN;
		if (strFormalShoeType.startsWith("w"))
			formalShoeType = FormalShoeType.WOMEN;
		else if (strFormalShoeType.startsWith("k"))
			formalShoeType = FormalShoeType.KIDS;
		FormalShoe formalShoe = new FormalShoe(color, formalShoeType, size, item.getCode(), item.getPrice());
		return formalShoe;
	}

	private Item getSportShoe(Item item) {
		int size = getIntInputValue("Enter sport shoe size:");
		String color = getStringInputValue("Enter sport shoe color:");
		SportShoe sportShoe = new SportShoe(color, size, item.getCode(), item.getPrice());
		return sportShoe;
	}

	private Item getAnalogRadio(Item item) {
		String mark = getStringInputValue("Enter analog radio mark:");
		AnalogRadio analogRadio = new AnalogRadio(mark, item.getCode(), item.getPrice());
		return analogRadio;
	}

	private Item getDigitalRadio(Item item) {
		String mark = getStringInputValue("Enter digital radio mark:");
		boolean isChargeble = getOptionalStringInputValue("Is chargeable digital radio (yes/no):").toLowerCase()
				.startsWith("y");
		DigitalRadio digitalRadio = new DigitalRadio(mark, isChargeble, item.getCode(), item.getPrice());
		return digitalRadio;
	}

	private Item getLcdTV(Item item) {
		String mark = getStringInputValue("Enter LCD TV mark:");
		int size = getIntInputValue("Enter LCD TV size inch:");
		LcdTV lcdTV = new LcdTV(mark, size, item.getCode(), item.getPrice());
		return lcdTV;
	}

	private Item getLedTV(Item item) {
		String mark = getStringInputValue("Enter LED TV mark:");
		int size = getIntInputValue("Enter LED TV size inch:");
		boolean isSmart = getOptionalStringInputValue("is Smart LED TV (yes/no):").toLowerCase().startsWith("y");
		LedTV ledTV = new LedTV(mark, isSmart, size, item.getCode(), item.getPrice());
		return ledTV;
	}

	private void showUserPage() {
		printTitle("Customer Page");
		System.out.println("1- Buy New Item");
		System.out.println("2- Show Shopping Basket");
		System.out.println("6- Submit Orders");
		System.out.println("3- Cancel an Order");
		System.out.println("4- Increase Balance");
		System.out.println("5- Show Orders History");
		System.out.println("6- Edit Profile Information");
		System.out.println("7- Back");
		printDashedBorder();
		System.out.print(">> ");
	}

	private void printTitle(String title) {
		printDashedBorder();
		for (int i = 0; i < DASHED_BORDER_LENGTH / 2 - title.length() / 2; i++)
			System.out.print(" ");
		System.out.println(title);
		printDashedBorder();
	}

	private void printDashedBorder() {
		for (int i = 0; i < DASHED_BORDER_LENGTH; i++)
			System.out.print("-");
		System.out.println();
	}

	private void printErrorMessage(String msg) {
		System.out.println("| Error: " + msg + " |");
		printWaitingMessage();
	}

	private void printInfoMessage(String msg) {
		System.out.println(">>> " + msg + " <<<");
		printWaitingMessage();
	}

	private void printWaitingMessage() {
		System.out.println("_____________ press Enter to continue...");
		input.nextLine();
	}
}
