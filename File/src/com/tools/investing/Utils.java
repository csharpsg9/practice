package com.tools.investing;

import java.text.SimpleDateFormat;

public class Utils {
	
	public static String error = "*** Error ***";
	
	public static void getWelcomeMessage(){
		System.out.println("\nWelcome to the Stock Price Report Generator");
	}
	
	public static void getUserSelectionFromMainMenu(){
		System.out.println("Please enter your choice\n");
	}
	
	public static void getThankYouMessage(){
		System.out.println("\nThank you for using Stock Price Report Generator.\n");
	}
	
	public static void getuserSelectedStockReport(){
		System.out.println("Which report do you want to see?\n");
	}
	
	public static SimpleDateFormat getSimpleDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");
		return dateFormat;
	}
	
}