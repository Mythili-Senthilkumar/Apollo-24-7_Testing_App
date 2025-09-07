package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	
	//for login button
	public static By login=By.xpath("//span[text()='Login']");
	
	// for mobile number entry field
	public static By mobilenumberfield=By.xpath("//input[@name='mobileNumber' and @title='Please enter mobile number']");
	
	//for continue button
	public static By continuebutton=By.xpath("//button[text()='Continue']");

	// for otp field
	public static By otpfield=By.xpath("//input[@title='Please enter the otp']");
	
	// for verify button
	public static By verifybutton=By.xpath("//button[text()='Verify']");
	
	
	
}
