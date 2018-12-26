package com.tools.investing;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import com.tools.webutils.*;

public class Utils {
	
	public static String error = "*** Error ***";
	public static String userReportChoice = "Which report do you want to see?"; 
	public static String filePath = "C://Users//shuai_000//Desktop//stocks//";	
	public static String stockFilePath = "C://ListOfStocks//";
	
	public static SimpleDateFormat getSimpleDateFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");
		return dateFormat;
	}
	
}