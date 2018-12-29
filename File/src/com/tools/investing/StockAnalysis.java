package com.tools.investing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StockAnalysis {

	String directoryPath = System.getProperty("user.dir"); 
	Scanner sascanner;
	StockOperations stockOperations;
	FileOperations fileOperations;
	String thefilePath, pathToSerializedFile;
	TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();
	
	StockAnalysis(Scanner scanner){
		thefilePath = directoryPath + "\\stocks\\";
		pathToSerializedFile = directoryPath + "\\ListOfStocks\\";
		this.sascanner = scanner;
		mainMenu = createMainMenuList();
		fileOperations = new FileOperations(thefilePath);
		stockOperations = new StockOperations(sascanner,fileOperations,thefilePath,pathToSerializedFile);
	}
	
	public static void main(String[] args) {
		StockAnalysis stockAnalysis = new StockAnalysis(new Scanner(System.in));
	
		Utils.getWelcomeMessage();
		Utils.getUserSelectionFromMainMenu();
		stockAnalysis.getUserInput();
		Utils.getThankYouMessage();
		
	}
	
	public void getUserInput(){
		
		boolean isDisplayed = true;
		do {
			displayMainMenu();
			int choice = sascanner.nextInt();

				if (choice == 1) {
					stockOperations.getStockFileList();
				} else if (choice == 2) {
					stockOperations.enterStockSymbol("list.ser");
				} else if (choice == 3) {
					stockOperations.getStockPriceFromPreviousUserStockSymbolInputs("list.ser");
				} else if (choice == 4) {
					stockOperations.getStockPriceFromPreviousUserStockSymbolInputs("financial.ser");
				} else if (choice == 5) {
					stockOperations.getStockPriceFromPreviousUserStockSymbolInputs("watchlist.ser");
				} else if (choice == 6) {
					isDisplayed = false;
				}
		} while(isDisplayed);
		sascanner.close();
	}
	
	public TreeMap<Integer, String> createMainMenuList(){
		TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();
		mainMenu.put(1, "View Stock File List");
		mainMenu.put(2, "Enter Stock symbol");
		mainMenu.put(3, "Get Quotes From Previous Inputs");
		mainMenu.put(4, "Get Finance Quotes");
		mainMenu.put(5, "Get Watchlist Quotes");
		mainMenu.put(6, "Exit");
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
