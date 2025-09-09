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
	public static By aloeVeraProduct = By.xpath("//img[@alt='Apollo Life Aloe Vera Skin Care Gel, 200 gm (2x100 gm)']");

	// for add to cart button
	public static By addtocartbutton=By.xpath("//span[text()='Add to Cart']");
	
	// for view cart click
	public static By viewcartclick=By.xpath("//span[text()='View Cart']");
	
	//for handwash click
	public static By handwashclick=By.xpath("//h2[text()='Apollo Pharmacy Premium Aqua Blue Handwash, 500 ml (2x250 ml)']");
	
	//for add click disabled
	public static By addclickdisable=By.xpath("//p[contains(text(),'currently unavailable')]");
	
/*****************************************************************************/
	
	// for babycare click
	public static By babycareclick=By.xpath("(//a[text()='Baby Care'])[1]");
	
	//for baby food click
	public static By babyfoodclick=By.xpath("//a[text()='Baby Food']");

	//for baby cereals
	public static By babycearealclick=By.xpath("//a[text()='Baby Cereals']");
	
	//for sort click
	public static By sortclick=By.xpath("//span[text()='Relevance']");
	
	//for low to high sort click
	public static By lowtohighclick=By.xpath("//input[@name='product-sort' and @value='low-to-high']");
	
	//for baby cereal product add click
	public static By babyproductclick=By.xpath("//span[text()='Add'][1]");
	
/*********************************************************************************************************/
	
	// for baby skin
	public static By babyskincareclick=By.xpath("//a[text()='Baby Skin Care']");
	
	//for sort click
		//public static By sortclick=By.xpath("//span[text()='Relevance']");
	
	//for better discount click
	public static By betterdiscountclick=By.xpath("//label[text()='Better Discount']");
	
	//for himalaya product click
	public static By himalayaproductclick=By.xpath("//h2[text()='Himalaya Baby pH 5.5 Cream with Pure Cow Ghee, 200 ml']");

	//for changing pack
	public static By packchangeclick=By.cssSelector("header.hR");
	
	//for add to cart
	public static By productaddclick=By.xpath("//span[text()='Add to Cart']");
	
	//for view cart click
	public static By viewclick=By.xpath("//span[text()='View Cart']");

}
