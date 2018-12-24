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

public class StockFileList
{
	public TreeMap<Integer, String> stockFileList = new TreeMap<Integer, String>();
	
	
	public StockFileList(){}
	
	public StockFileList(TreeMap<Integer, String> stockFile){
		stockFileList = stockFile;
	}
	
	public void setStockList() {
		
			FileOperations fileOperations = new FileOperations();
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
				fileOperations.writeToFile(fileOperations.createFile(stockSymbol), Scraper.getStockPrice(stockSymbol));
			}
			
			listOfStocks.setStockFileList(listOfStocks);
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
	//Utils.selectStockFile(stocks);
	selectStockFile(stocks);
}
	
	public void selectStockFile(TreeMap<Integer, String> stocks) {
		StockFileReport stockFileReport = new StockFileReport(); 
		System.out.println(Utils.userReportChoice + "\n");

		Scanner reportChoice = new Scanner(System.in);
		Integer decision = reportChoice.nextInt();

		for (Map.Entry<Integer, String> entry : stocks.entrySet()) {
			Integer key = entry.getKey();

			if (decision == key) {
				stockFileReport.viewStockReport(stocks.get(decision));
			}
		}
	}
		
	public void setStockFileList(StockFileList stockList)
	{
		for (Map.Entry<Integer, String> entry : stockList.stockFileList.entrySet()) {	
			Integer key = entry.getKey();
			String stockFile = entry.getValue();
		}
		
		try {
	         FileOutputStream fileOut = new FileOutputStream(Utils.stockFilePath + "//list.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(stockList.stockFileList);
	         out.close();
	         fileOut.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	
}
