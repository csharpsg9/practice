package com.tools.investing;

//import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
//import java.util.*;
//import java.text.*;
//import java.io.*;


public class Utils {
	
	public static String error = "*** Error ***";
	public static String userSelectedStockReport = "Which report do you want to see?"; 
	public static String welcomeMessage = "\nWelcome to the Stock Price Report Generator";
	public static String thankyouMessage = "\nThank you for using Stock Price Report Generator.\n";
	public static String enterYourChoice = "Please enter your choice\n";
	
	public static SimpleDateFormat getSimpleDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");
		return dateFormat;
	}
	
}