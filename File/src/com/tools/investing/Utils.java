package com.tools.investing;

import java.text.SimpleDateFormat;

public class Utils {
	
	public static String error = "*** Error ***";
	
	public static void getWelcomeMessage(){
		System.out.println("\nWelcome to the Stock Price Report Generator");
	}
	
	public static void getUserSelectionFromMainMenu(){
		System.out.println("\nPlease enter your choice\n");
	}
	
	public static void getThankYouMessage(){
		System.out.println("\nThank you for using Stock Price Report Generator.\n");
	}
	
	public static void getuserSelectedStockReport(){
		System.out.println("\nWhich report do you want to see?\n");
	}
	
	public static void getNumberOfStockSymbolsMessage(){
		System.out.println("\nHow many ticker symbols do you want to enter?\n");
	}
	
	public static void getStockSymbolFromUser(){
		System.out.println("\nEnter a Stock Symbol: ");
	}
	
	public static SimpleDateFormat getSimpleDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");
		return dateFormat;
	}
	
}