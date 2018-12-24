package com.tools.investing;

import java.io.*;

public class StockFileReport {
	
	public StockFileReport(){}
	
	public void viewStockReport(String fileName) {
		BufferedReader bufferedReader = null;

		try {
			String currentLine;
			bufferedReader = new BufferedReader(new FileReader(Utils.filePath + fileName));

			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}
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
