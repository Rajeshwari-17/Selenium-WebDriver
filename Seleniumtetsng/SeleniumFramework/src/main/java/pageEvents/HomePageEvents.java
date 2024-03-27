package pageEvents;

import CommonUtils.Elementfetch;

import pageObject.HomePageElements;
public class HomePageEvents {
	
	Elementfetch ele = new Elementfetch();
	public void loginButton()
	{
		ele.getWebElement("XPATH", HomePageElements.loginbuttontext).click();
	}

}
