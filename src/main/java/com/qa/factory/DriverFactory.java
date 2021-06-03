package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver dr;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();  // new java8 feature for parller testing.
	
	/**
	 * following method is used to initialize the thradlocal driver on the bases of given browser
	 * this will return tldriver
	 * */
	
	public WebDriver init_driver(String browser){         // this browser name get from Application hooks..
		
		System.out.println("browser value is:-" + browser);  
		
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();       // it use for automate the browser setup in selenium code. it download the latest code for browser.
	        tldriver.set(new ChromeDriver());            // set the driverand lunch the browser with thread local.
		}
		
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();       // it use for automate the browser setup in selenium code. it download the latest code for browser.
	        tldriver.set( new FirefoxDriver());
		}
		else {
			System.out.println("Please pass correct browser name:-" + browser);
		}
		
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		return getdriver();
	}
	/**
	 * this is used to get the driver with threadlocal
	 * @return
	 */
		public static synchronized WebDriver getdriver(){    //Get the driver from init_driver method.
			
			return tldriver.get();
		}	

}
