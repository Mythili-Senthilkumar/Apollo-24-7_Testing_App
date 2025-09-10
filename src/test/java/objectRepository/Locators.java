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
	
	/***********************************************************************************************/
	
	//for buy medicine
	public static By buymedicineclick=By.xpath("//a[text()='Buy Medicines']");
	
	// for apollo products
	public static By apolloproductsclick=By.linkText("Apollo Products");
	
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
	//touch cart-icon
	public static By carticon=By.xpath("//a[contains(@href,'/medicines-cart')]");
	
	// for cart page
	public static By cartpage=By.xpath("//h2[text()='OFFERS & DISCOUNTS']");
	
	//for dropdown
	public static By dropdown=By.xpath("//p[text()='Qty ']");
	
	//for new quantity
	public static By newquanity=By.xpath("//p[text()='3']");
	
	//for validate 
	public static By updatedquantity=By.xpath("//p[contains(text(),'Qty')]");
	
	//for remove
	public static By deleteicon=By.xpath("//div[contains(@class, 'MedicineProductCard_deleteIcon__kZ81e')]");
}
