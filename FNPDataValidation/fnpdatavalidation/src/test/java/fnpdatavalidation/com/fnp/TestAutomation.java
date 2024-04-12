package fnpdatavalidation.com.fnp;

import org.testng.annotations.Test;

import fnpdatavalidation.commonutils.BrowserController;
import pageobjectpattern.HomePage;

public class TestAutomation extends BrowserController {

	@Test
	private static void addToCarttest() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.navigateToFnP();
		Thread.sleep(1500);

	}

}
