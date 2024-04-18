package dibrunobrosdatavalidation.TestAutomation;

import org.testng.annotations.Test;

import dibrunobrosdatavalidation.commonutils.BrowserController;
import pageobjectpattern.HomePage;

public class TestRunner extends BrowserController{
	
	@Test
	private static void addToCarttest() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		
		Thread.sleep(1500);

	}


}
