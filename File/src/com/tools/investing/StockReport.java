package com.tools.investing;

import java.io.*;

public class StockReport {
	
	String filePath;
	public StockReport(String filePath){
		this.filePath = filePath;
	}
	
	public void viewStockReport(String fileName) {
		BufferedReader bufferedReader = null;

		try {
			String currentLine;
			bufferedReader = new BufferedReader(new FileReader(filePath + fileName));

			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}
			System.out.println("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ex) {
				System.out.println(Utils.error);
				ex.printStackTrace();
			}
		}

	}

}
