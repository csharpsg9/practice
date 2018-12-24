package com.tools.investing;

import java.util.*;
import java.text.*;
import java.io.*;
import com.tools.webutils.*;
import com.test.email.*;

public class FileOperations{
	
	public void writeToFile(File file, Stock myStock) {
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String content = Utils.getSimpleDateFormat().format(new Date()) + ", " + myStock.stockSymbol + ", " + decimalFormat.format(myStock.price);

		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(content + "\n");
			bufferWriter.close();
		} catch (IOException e) {
			System.out.println(Utils.error);
			e.printStackTrace();
		}
	}
	
	public File createFile(String nameOfFile) {
		
		File file = new File(Utils.filePath + nameOfFile + ".txt");
		FileOutputStream fileOutputStream = null;
		String fileTitle = "Stock Price History Report\n";

		try {
			if (file.createNewFile()) {
				fileOutputStream = new FileOutputStream(file);
				byte[] contentInBytes = fileTitle.getBytes();
				fileOutputStream.write(contentInBytes);
				fileOutputStream.flush();
				fileOutputStream.close();
				System.out.println("File created.");
			} else {
				System.out.println("File updated.");
			}
		} catch (IOException e) {
			System.out.println(Utils.error);
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				System.out.print(Utils.error);
				e.printStackTrace();
			}
		}
		return file;
	}
}
