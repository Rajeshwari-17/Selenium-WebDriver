package pageEvents;

import org.testng.Assert;

import CommonUtils.Elementfetch;
import pageObject.HomePageElements;
import pageObject.LoginPageElements;

public class LoginPageEvents {

	Elementfetch ele = new Elementfetch();
	public void verifyLoginPage()
	{
		Assert.assertTrue(ele.getWebElements("XPATH",LoginPageElements.signinText).size()>0,"Element not found");

	}

	public void enterCredentials()
	{
		ele.getWebElement("XPATH",LoginPageElements.email).sendKeys("thyes@gmail.com");
		ele.getWebElement("XPATH",LoginPageElements.password).sendKeys("harry8potter");

	}


}
