package com.tools.investing;

import java.util.*;
import java.text.*;
import java.io.*;
import com.tools.webutils.*;
import com.test.email.*;

public class FileOperations implements IMenu, IProcessUserChoice {
	
	public void setStockList() {
		//Scanner howManyTickerSymbols = null;
		
			Scanner howManyTickerSymbols = new Scanner(System.in);
			String stockSymbol = "";
			StockFileList listOfStocks = new StockFileList();
			int numberOfSymbols = 0;

			System.out.println("How many ticker symbols do you want to enter? ");
			numberOfSymbols = howManyTickerSymbols.nextInt();
			
			ArrayList<Scanner> userInputs = new ArrayList<Scanner>(numberOfSymbols);
			
			for (Integer i = 0; i < numberOfSymbols; i++) {
				userInputs.add(new Scanner(System.in));
				System.out.println("Enter a Stock Symbol: ");
				stockSymbol = userInputs.get(i).nextLine();
				listOfStocks.stockFileList.put(i, stockSymbol +".txt");	
				Utils.writeToFile(Utils.createFile(stockSymbol), Scraper.getStockPrice(stockSymbol));
			}
			
			//Utils.serializeFileList(listOfStocks);
			Utils.setStockFileList(listOfStocks);
			
			/*
			for (Integer i = 0; i < numberOfSymbols; i++) {
			
				userInputs.add(new Scanner(System.in));
				System.out.println("Enter a Stock Symbol: ");
				stockSymbol = userInputs.get(i).nextLine();
				listOfStocks.stockFileList.put(i, stockSymbol +".txt");	
				Utils.writeToFile(Utils.createFile(stockSymbol), Scraper.getStockPrice(stockSymbol));
			}*/
			
			//Utils.serializeFileList(listOfStocks);
	}
	
	public void displayMainMenu() {
		TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();

		System.out.println("\nWelcome to the Stock Price Report Generator");
		System.out.println("Please enter your choice\n");
		
		mainMenu.put(1, "View Stock File List");
		mainMenu.put(2, "Enter Stock symbol");
		mainMenu.put(3, "Email current stocks data");
		mainMenu.put(4, "Email foreign stocks data");
		mainMenu.put(5, "Email watchlist data");
		mainMenu.put(6, "Email HCHC 401K data");
		mainMenu.put(7, "Exit");
		
		for (Map.Entry<Integer, String> entry : mainMenu.entrySet()) {	
			Integer key = entry.getKey();
			String menuItem = entry.getValue();
			
			System.out.println(key + "\t" + menuItem);
		}
	}

	public void viewStockFileList() {
		File stockFilePath = new File(Utils.filePath);
		File[] listOfFiles = stockFilePath.listFiles();
		TreeMap<Integer, String> stocks = new TreeMap<Integer, String>();
		int lengthOfFileName;

		for (int i = 0; i < listOfFiles.length; i++) {
			stocks.put(i + 1, listOfFiles[i].getName());
			lengthOfFileName = listOfFiles[i].getName().length();
			System.out.print((i + 1)+ " - " + listOfFiles[i].getName().substring(0, lengthOfFileName - 4).toUpperCase() + "\n");
		}
		System.out.println("\n");
		Utils.selectStockFile(stocks);
	}

	public static void main(String[] args) {
			FileOperations stockFileOperations = new FileOperations();
			boolean isDisplayed = true;

			do {
				stockFileOperations.displayMainMenu();
				Scanner userChoice = new Scanner(System.in);
				int choice = userChoice.nextInt();

					if (choice == 1) {
						stockFileOperations.viewStockFileList();
					} else if (choice == 2) {
						stockFileOperations.setStockList();
					} else if (choice == 3) {
						EmailInformation.emailStockReport();
					}
					else if (choice == 7) {
						isDisplayed = false;
					}
					//userChoice.close();	
			} while(isDisplayed);
	
		System.out.print("\nThank you for using Stock Price Report Generator.\n");
	}

}
