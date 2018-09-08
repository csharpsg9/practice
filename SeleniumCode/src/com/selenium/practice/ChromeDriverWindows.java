package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {

	public static void main(String[] args) {
		String baseURL = "http://www.google.com";
		
		//System.setProperty("webdriver.chrome.driver","C:\\software\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(baseURL);
		
	}

}
