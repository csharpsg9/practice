package com.selenium.practice;

import javax.security.auth.login.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriver {

	public static void main(String[] args) {
		WebDriver driver;
		//System.setProperty("webdriver.ie.driver", "C:\\software\\selenium\\drivers\\IEDriverServer.exe");
		
		//DesiredCapabilities capability = DesiredCapabilities.internetExplorer(); 
		//capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, ""); 
		
		driver = new InternetExplorerDriver();
		
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);

	}

}
