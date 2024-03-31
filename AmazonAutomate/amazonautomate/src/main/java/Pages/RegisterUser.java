package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUser extends AbstractPages{
	
	private WebDriver driver;
	@SuppressWarnings("unused")
	private boolean acceptNextAlert = true;
	public static final String URL = "https://www.amazon.co.uk/ap/signin?_encoding=UTF8&openid.assoc_handle=amazon_checkout_gb&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.co.uk%2Fgp%2Fbuy%2Fsignin%2Fhandlers%2Fcontinue.html%3Fie%3DUTF8%26eGCApp%3D%26hasWorkingJavascript%3D0%26isEGCOrder%3D0%26oldCustomerId%3D%26oldPurchaseId%3D%26preInitiateCustomerId%3D%26purchaseInProgress%3D%26siteDesign%3D&pageId=amazon_checkout_gb&showRmrMe=0&siteState=isRegularCheckout.1|IMBMsgs.|isRedirect.0|isToBeGiftWrappedBefore.|zipcode.|shippingAddressID.new|zipcode.";

	// Use annotations to locate elements.

	// Use annotations to locate elements.
	// enter mail id
	@FindBy(id ="ap_email")
	private WebElement emailId;
	
	@FindBy(id= "ap_email_check")
	private WebElement emailCheck;

	@FindBy(id ="ap_signin_create_radio")
	private WebElement newCustomerradioButton;

	@FindBy(id ="signInSubmit-input")
	private WebElement signInSubmitInput;

	@FindBy(id ="ap_customer_name")
	private WebElement ap_customerName;

	@FindBy(id ="ap_phone_number")
	private WebElement apPhoneNumber;
	
	@FindBy(id ="ap_password")
	private WebElement ap_password;
	
	@FindBy(id ="ap_password_check")
	private WebElement ap_passwordCheck;

	@FindBy(id ="continue-input")
	private WebElement continueInput;
	
	@FindBy(id ="enterAddressFullName")
	private WebElement enterAddressFullName;

	@FindBy(id ="enterAddressAddressLine1")
	private WebElement enterAddressAddressLine1;

	@FindBy(id ="enterAddressAddressLine2")
	private WebElement enterAddressAddressLine2;

	@FindBy(id ="enterAddressCity")
	private WebElement enterAddressCity;

	@FindBy(id ="enterAddressStateOrRegion")
	private WebElement enterAddressStateOrRegion;

	@FindBy(id ="enterAddressPostalCode")
	private WebElement enterAddressPostalCode;

	@FindBy(id ="enterAddressPhoneNumber")
	private WebElement enterAddressPhoneNumber;

	@FindBy(id ="AddressType")
	private WebElement AddressType;

	@FindBy(id ="GateCode")
	private WebElement GateCode;

	@FindBy(id ="shipToThisAddress")
	private WebElement shipToThisAddress;
	
	@FindBy(id ="enterAddressCity")
	private WebElement enterAddressCity1;
	
	@FindBy(id ="enterAddressStateOrRegion")
	private WebElement enterAddressStateOrRegion1;
	
	@FindBy(id ="enterAddressPostalCode")
	private WebElement enterAddressPostalCode1;
	
	
	public void signIn() {

		emailId.clear();
		emailId.sendKeys("testregistration0001@gmail.com");
		newCustomerradioButton.click();
		
		signInSubmitInput.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	 public void Registration() {
		ap_customerName.clear();
		ap_customerName.sendKeys("as");

		emailCheck.clear();
		emailCheck.sendKeys("testregistration0001@gmail.com");
		
		apPhoneNumber.clear();
	    apPhoneNumber.sendKeys("122");
	   
	    ap_password.sendKeys("Test12345");
	    ap_passwordCheck.clear();
	    
	    ap_passwordCheck.sendKeys("Test12345");
	    continueInput.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 }
	 
	
	 public void addressInfo() {
		 
		 enterAddressFullName.clear();
		 enterAddressFullName.sendKeys("testuser");
		 
		 enterAddressAddressLine1.sendKeys("Test");
		 
		 enterAddressAddressLine2.clear();
		 enterAddressAddressLine2.sendKeys("Address2");

		 enterAddressCity.clear();
		 enterAddressCity.sendKeys("London");
		 
		 enterAddressStateOrRegion.clear();
		 enterAddressStateOrRegion.sendKeys("UK");
		 
		 enterAddressPostalCode.clear();
		 enterAddressPostalCode.sendKeys("23434");
		 
		 enterAddressPhoneNumber.clear();
		 enterAddressPhoneNumber.sendKeys("1234");
		 
		 AddressType.clear();
		 AddressType.sendKeys("AdressType");
		 
		 GateCode.clear();
		 GateCode.sendKeys("Gate code");
		 
		 shipToThisAddress.clear();
		 shipToThisAddress.sendKeys("shipToDress");
		 
		 enterAddressCity.clear();
		 enterAddressCity.sendKeys("adress city");
		 
		 enterAddressStateOrRegion.clear();
		 enterAddressStateOrRegion.sendKeys(" UK ");
		 
		 enterAddressPostalCode.clear();
		 enterAddressPostalCode.sendKeys("Postal code");
	 }
	 
	public RegisterUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Returns the page URL.
	 * @return String representation of the URL.
	 */
	@Override
	public String getPageURL() {
		return URL;
	}

	public void editBasket() {
	
	}


}
