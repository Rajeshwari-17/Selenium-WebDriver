package amazonautomate.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AmazonHomePage;
import Pages.EditBasketandProceedCheckout;
import Pages.RegisterUser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import selection.AmazoniPhone6SearchResults;

public class PageObjects extends TestCase{
	
	private final static Logger log = Logger.getLogger(PageObjects.class);

	private WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public PageObjects(String testName) {
		super(testName);
		log.debug("Generating Test Case: " + testName);
	}
	
	public static Test suite() {
		return new TestSuite(PageObjects.class);
	}
	
	@Override
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Override
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public void testA_Amazon_PageTitle_HomePage() {
		AmazonHomePage homePage = new AmazonHomePage(driver);
		driver.get(homePage.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		assertEquals(
				"Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more",
				driver.getTitle());
	}
	
	public void testB_AmazoniPhone6_Search_Results() {
		AmazonHomePage homePage = new AmazonHomePage(driver);
		driver.get(homePage.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		AmazoniPhone6SearchResults searchResults = homePage
				.searchFor("iPhone6");
		assertTrue(searchResults.getSearchResultText().contains("iPhone 6"));

		assertEquals("Amazon.co.uk: iPhone6", driver.getTitle());

		searchResults.selectSearchItem();
	}
	
	public void testC_AmazoniPhone6_editBasket() {
		EditBasketandProceedCheckout editbasketButton = new EditBasketandProceedCheckout(
				driver);
		driver.get(editbasketButton.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		editbasketButton.addtoBasket();
		assertEquals("Amazon.co.uk Shopping Basket", driver.getTitle());

		try {
			// assertEquals("1 item was added to your basket",
			// driver.findElement(By.id("confirm-text")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	editbasketButton.editBasket();
		
		// assertTitle
		assertEquals("Amazon.co.uk Shopping Basket", driver.getTitle());

		// CheckOut the items ordered
		editbasketButton.proceedCheckOut();
	}
	
	 
		public void testD_UserRegistration() {
			RegisterUser registeruser = new RegisterUser(driver);
			driver.get(registeruser.getPageURL());

			registeruser.signIn();

			
			assertEquals("Amazon.co.uk Registration", driver.getTitle());

			registeruser.Registration();

			

		}


}
