package com.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDemo1 {

	public static void main(String[] args) {
		WebDriver driver;
		//System.setProperty("webdriver.gecko.driver", "C:\\software\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);
	}

}
