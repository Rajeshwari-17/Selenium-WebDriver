package tests;

import org.testng.annotations.Test;

import CommonUtils.BasePage;
import PageObject.HomePage;

public class TestCase extends BasePage {
	
	 @Test
	    public void testAddToCart() {
	        HomePage homePage = new HomePage(driver);
	        homePage.login("test@example.com", "Test User");
	        homePage.navigateToBestSellers();
	        homePage.addToCart();
	    }

}
