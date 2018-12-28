package com.tools.investing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StockAnalysis {

	Scanner sascanner;
	StockOperations stockOperations;
	FileOperations fileOperations;
	String thefilePath;
	TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();
	
	StockAnalysis(Scanner scanner){
		thefilePath = System.getProperty("user.dir") + "\\stocks\\";
		this.sascanner = scanner;
		mainMenu = createMainMenuList();
		fileOperations = new FileOperations(thefilePath);
		stockOperations = new StockOperations(sascanner,fileOperations,thefilePath);
	}
	
	public static void main(String[] args) {
		StockAnalysis stockAnalysis = new StockAnalysis(new Scanner(System.in));
	
		System.out.println("\nWelcome to the Stock Price Report Generator");
		System.out.println("Please enter your choice\n");
		stockAnalysis.getUserInput();
			
		System.out.print("\nThank you for using Stock Price Report Generator.\n");
		
	}
	
	public void getUserInput(){
		
		boolean isDisplayed = true;
		do {
			displayMainMenu();
			int choice = sascanner.nextInt();

				if (choice == 1) {
					stockOperations.getStockFileList();
				} else if (choice == 2) {
					stockOperations.enterStockSymbol();
				} else if (choice == 3) {
					isDisplayed = false;
				}
		} while(isDisplayed);
		sascanner.close();
	}
	
	public TreeMap<Integer, String> createMainMenuList(){
		TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();
		mainMenu.put(1, "View Stock File List");
		mainMenu.put(2, "Enter Stock symbol");
		mainMenu.put(3, "Exit");
		return mainMenu;
	}
	
	public void displayMainMenu() {

		for (Map.Entry<Integer, String> entry : mainMenu.entrySet()) {	
			Integer key = entry.getKey();
			String menuItem = entry.getValue();
			
			System.out.println(key + "\t" + menuItem);
		}
	}
}
