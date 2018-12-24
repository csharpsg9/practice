package com.tools.investing;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.io.*;
import com.tools.webutils.*;

public class Utils {
	
	public static final String error = "*** Error ***";
	public static final String userReportChoice = "Which report do you want to see?"; 
	public static String filePath = "C://Users//shuai_000//Desktop//stocks//";		                                    
	
	public static void displayMainMenu() {
		TreeMap<Integer, String> mainMenu = new TreeMap<Integer, String>();

		System.out.println("\nWelcome to the Stock Price Report Generator");
		System.out.println("Please enter your choice\n");
		
		mainMenu.put(1, "View Stock File List");
		mainMenu.put(2, "Enter Stock symbol");
		mainMenu.put(3, "Exit");
		
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

}