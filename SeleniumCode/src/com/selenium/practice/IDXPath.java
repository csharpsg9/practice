package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IDXPath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		
		//driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("los angeles");		
		//driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")).sendKeys("microsoft");
		Thread.sleep(5000);
		driver.findElement(By.name("btnK")).click();
	}

}
