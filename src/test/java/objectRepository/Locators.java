package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	
	//for login click
	public static By login=By.xpath("//span[text()='Login']");
	
	// for mobile number entry field
	public static By mobilenumberfield=By.xpath("//input[@name='mobileNumber']");
	
	//for continue button
	public static By continuebutton=By.xpath("//button[text()='Continue']");

	// for otp field
	public static By otpfield=By.xpath("//input[@title='Please enter the otp']");
	
	//for resend otp
	public static By resendOtpButton = By.xpath("//span[text()='Resend OTP']");
	
	// for verify button
	public static By verifybutton=By.xpath("//button[text()='Verify']");
	
	//for logout click
	public static By logoutbutton=By.xpath("//span[@class='ProfileNew_leftBx__mRY1M']");
	
	// for cross click
	public static By crossclick=By.cssSelector("span[aria-label='close button']");
	
	//for buy medicine
	public static By buymedicineclick=By.xpath("//a[text()='Buy Medicines']");
	
	// for apollo products
	public static By apolloproductsclick=By.xpath("//a[text()='Apollo Products']");
	
	//for personal care
	public static By personalcareclick=By.xpath("//span[text()='Personal Care']");
	
	//for skin care
	public static By skincareclick=By.xpath("//a[text()='Skin Care']");
	
	//for aloevera gel product
	public static By aloeVeraProduct = By.xpath("//img[contains(@alt,'Aloe Vera Skin Care Gel')]");

	// for add to cart button
	public static By addtocartbutton=By.xpath("//span[text()='Add to Cart']");
	
	// for view cart click
	public static By viewcartclick=By.xpath("//span[text()='View Cart']");
	
	// for brand click
	public static By brandclick=By.xpath("//*[text()='Brands']");
	
	//for checkbox click
	public static By apollopharmacyclick=By.xpath("//div[@class='gB hB CategoryFilterWeb_paddingTb8__6EuUW CategoryFilterWeb_labelCustom__XasvL  '][2]");
	
	//for add click
	public static By addclick=By.xpath("//span[text()='Add']");

	

	
	
}
