package com.tools.investing;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.io.*;
import com.tools.webutils.*;

public class Utils {
	
	public static String error = "*** Error ***";
	public static String userReportChoice = "Which report do you want to see?"; 
	public static String filePath = "C://Users//shuai_000//Desktop//stocks//";	
	public static String stockFilePath = "C://ListOfStocks//";
	
	public static TreeMap<Integer, String> createMainMenuList(){
		TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();
		mainMenu.put(1, "View Stock File List");
		mainMenu.put(2, "Enter Stock symbol");
		mainMenu.put(3, "Exit");
		return mainMenu;
	}
	
	public static void displayMainMenu() {
		TreeMap<Integer, String> mainMenu = createMainMenuList();

		System.out.println("\nWelcome to the Stock Price Report Generator");
		System.out.println("Please enter your choice\n");
		
		for (Map.Entry<Integer, String> entry : mainMenu.entrySet()) {	
			Integer key = entry.getKey();
			String menuItem = entry.getValue();
			
			System.out.println(key + "\t" + menuItem);
		}
	}

	public static SimpleDateFormat getSimpleDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");
		return dateFormat;
	}
	
	public static void startStockAnalysisProject(){
		StockFileOperations stockFileOperations = new StockFileOperations();
		boolean isDisplayed = true;

		do {
			Utils.displayMainMenu();
			Scanner userChoice = new Scanner(System.in);
			int choice = userChoice.nextInt();

				if (choice == 1) {
					stockFileOperations.viewStockFileList();
				} else if (choice == 2) {
					stockFileOperations.setStockList();
				} else if (choice == 3) {
					isDisplayed = false;
				}
		} while(isDisplayed);

		System.out.print("\nThank you for using Stock Price Report Generator.\n");
	}

}