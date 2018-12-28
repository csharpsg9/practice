package com.tools.investing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import com.tools.investing.Utils;
import com.tools.webutils.Scraper;

public class StockOperations
{
	Scanner stockoperationsScanner;
	FileOperations fileOperations;
	String sofilePath, soSerializedFilePath;
	
	public StockOperations(Scanner scanner, FileOperations fileOperations, String filePath, String pathToSerializedFile){
		this.stockoperationsScanner = scanner;
		this.fileOperations = fileOperations;
		this.sofilePath = filePath;
		this.soSerializedFilePath = pathToSerializedFile;
		this.fileOperations = new FileOperations(sofilePath);
		
	}
	public TreeMap<Integer, String> stockFileList = new TreeMap<Integer, String>();
	public StockOperations(TreeMap<Integer, String> stockFile){
		stockFileList = stockFile;
	}
	
	public int getNumberOfStockSymbols(){
		
		System.out.println("How many ticker symbols do you want to enter? ");
		int numberOfSymbols = stockoperationsScanner.nextInt();
		return numberOfSymbols;
	}
	
	public void enterStockSymbol() {
		
		int numberOfStocks = getNumberOfStockSymbols();
		String stockSymbol = "";
		StockOperations listOfStocks = new StockOperations(stockoperationsScanner, fileOperations, sofilePath, soSerializedFilePath);
		ArrayList<Scanner> userInputs = new ArrayList<Scanner>(numberOfStocks);
			
		for (Integer i = 0; i < numberOfStocks; i++) {
			userInputs.add(new Scanner(System.in));
			System.out.println("Enter a Stock Symbol: ");
			stockSymbol = userInputs.get(i).nextLine();
			listOfStocks.stockFileList.put(i, stockSymbol +".txt");	
			fileOperations.writeToFile(fileOperations.createFile(stockSymbol,"txt"), Scraper.getStockPrice(stockSymbol));
		}	
		listOfStocks.setStockFileList(listOfStocks);
	}
	
	public void getStockFileList() {
		
		File stockFilePath = new File(sofilePath);
		File[] listOfFiles = stockFilePath.listFiles();
		TreeMap<Integer, String> stocks = new TreeMap<Integer, String>();
		int lengthOfFileName;

		for (int i = 0; i < listOfFiles.length; i++) {
			stocks.put(i + 1, listOfFiles[i].getName());
			lengthOfFileName = listOfFiles[i].getName().length();
			System.out.print((i + 1)+ " - " + listOfFiles[i].getName().substring(0, lengthOfFileName - 4).toUpperCase() + "\n");
		}
		System.out.println("\n");
		selectStockFile(stocks);
}
	
	public void selectStockFile(TreeMap<Integer, String> stocks) {
		StockReport stockFileReport = new StockReport(sofilePath); 
		System.out.println(Utils.userSelectedStockReport + "\n");

		Integer decision = stockoperationsScanner.nextInt();

		for (Map.Entry<Integer, String> entry : stocks.entrySet()) {
			Integer key = entry.getKey();

			if (decision == key) {
				stockFileReport.viewStockReport(stocks.get(decision));
			}
		}
	}
		
	public void setStockFileList(StockOperations stockList)
	{
		try {
	         FileOutputStream fileOut = new FileOutputStream(soSerializedFilePath + "//list.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(stockList.stockFileList);
	         out.close();
	         fileOut.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
}
