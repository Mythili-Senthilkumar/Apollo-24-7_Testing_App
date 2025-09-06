package com.stepup;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class BaseSteps {

	static final int TIME=2000;
	public static WebDriver driver;
		
	public void  launchBrowser()
	{
		Properties prop=PropertyReader.getProperty();
			
	    if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")){
	      ChromeOptions chrome=new ChromeOptions();
	   	  Map<String,Object> chromePrefs=new HashMap<>();
	   	  chromePrefs.put("credntials_enable_service",false);
	   	  chromePrefs.put("profile.password_manager_leak_detection",false);
	   	  chrome.setExperimentalOption("prefs",chromePrefs);
	   	  
	   	  driver=new ChromeDriver(chrome);
	   	  driver.manage().window().maximize();
	   	  
	     } else if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
	    	 driver=new FirefoxDriver();
	    	 driver.manage().window().maximize();  	 
	    }

	    driver.get(prop.getProperty("URL"));
		
	}

	public static void sleep()
	{
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

