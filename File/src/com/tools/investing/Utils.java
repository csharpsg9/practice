package com.tools.investing;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.text.*;
import java.io.*;
import com.tools.webutils.*;

public class Utils {
	
	public static final String error = "*** Error ***";
	public static final String filePath = "C://Users//shuai_000//Desktop//stocks//";
	public static final String stockFilePath = "C://ListOfStocks//";
	public static final String userReportChoice = "Which report do you want to see?"; 
		                                    
	public static void setStockFileList(StockFileList stockList)
	{
		for (Map.Entry<Integer, String> entry : stockList.stockFileList.entrySet()) {	
			Integer key = entry.getKey();
			String stockFile = entry.getValue();
		}
		
		try {
	         FileOutputStream fileOut = new FileOutputStream(stockFilePath + "//list.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(stockList.stockFileList);
	         out.close();
	         fileOut.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static TreeMap<Integer, String> getStockFileList()
	{
		TreeMap<Integer, String> stocks = new TreeMap<Integer, String>();
		
		try {
	         FileInputStream fileIn = new FileInputStream("C://ListOfStocks//list.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         stocks = (TreeMap<Integer, String>)in.readObject();
	         System.out.println("deserialized data");
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c) {
	         c.printStackTrace();
	      }
		return stocks;
	}
	
	public static void selectStockFile(TreeMap<Integer, String> stocks) {
		System.out.println(userReportChoice + "\n");

		Scanner reportChoice = new Scanner(System.in);
		Integer decision = reportChoice.nextInt();

		for (Map.Entry<Integer, String> entry : stocks.entrySet()) {
			Integer key = entry.getKey();

			if (decision == key) {
				Utils.viewStockReport(stocks.get(decision));
			}
		}
	}
	
	public static void viewStockReport(String fileName) {
		BufferedReader bufferedReader = null;

		try {
			String currentLine;
			bufferedReader = new BufferedReader(new FileReader(filePath + fileName));

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
				System.out.println(error);
				ex.printStackTrace();
			}
		}

	}
	
	public static void writeToFile(File file, Stock myStock) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy - hh:mm:ss a zzz");

		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String content = dateFormat.format(date) + ", " + myStock.stockSymbol + ", " + decimalFormat.format(myStock.price);

		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(content + "\n");
			bufferWriter.close();
		} catch (IOException e) {
			System.out.println(error);
			e.printStackTrace();
		}
	}
	
	public static File createFile(String nameOfFile) {
		
		File file = new File(filePath + nameOfFile + ".txt");
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
			System.out.println(error);
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				System.out.print(error);
				e.printStackTrace();
			}
		}
		return file;
	}

}
