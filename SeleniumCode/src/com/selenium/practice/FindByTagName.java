package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByTagName {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String baseURL = "http://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		//Thread.sleep(15000);
		
		//driver.findElement(By.tagName("span")).click();
		//driver.findElement(By.xpath("//span[@class='country-indicator']")).click();
		driver.findElement(By.linkText("Coming soon")).click();
		driver.findElement(By.linkText("New!")).click();
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Terms & Conditions")).click();
		Thread.sleep(2000);
	}

}
