package com.akkuandidiot.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.akkuandidiot.utility.WebEventListener;

public class CrmProBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eFiringDriver;
	public static WebEventListener eventListener;
	
	//Loading config.properties file
	public CrmProBase() {
		try {
			prop=new Properties();	
			FileInputStream file=new FileInputStream("F:\\Java-Selenium\\SeleniumCrmProPom\\src\\main\\java\\com\\akkuandidiot\\config\\config.properties");
			prop.load(file);
			}catch(IOException e) {
				e.printStackTrace();
		}
		
	}
	
	//Initialing drivers and setting browser and 
	public static void initialization() {
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_driver_path"));
			driver=new ChromeDriver();
		}else if(prop.getProperty("browser").contains("fiefox")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("firefox_driver_path"));
			driver=new FirefoxDriver();
		}
		eFiringDriver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		eFiringDriver.register(eventListener);
		driver=eFiringDriver;
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageload_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicit_wait")), TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		
	}

}

