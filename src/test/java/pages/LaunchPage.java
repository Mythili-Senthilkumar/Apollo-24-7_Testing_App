package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import setup.PropertyReader;

public class LaunchPage {

	static WebDriver driver;
	static Properties prop = PropertyReader.getProperty();
	
	
    public static String getURL() {
		return prop.getProperty("URL");
	}
}