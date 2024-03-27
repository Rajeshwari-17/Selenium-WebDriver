package qa.test;

import org.testng.annotations.Test;

import CommonUtils.Elementfetch;
import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

public class TestCase1 extends BaseTest{
	
	Elementfetch ele = new Elementfetch();
	HomePageEvents homepage = new HomePageEvents();
	LoginPageEvents loginpage = new LoginPageEvents();
  @Test
  public void sampleMethod() {
	  homepage.loginButton();
	  loginpage.verifyLoginPage();
	  loginpage.enterCredentials();
	  
	  
  }
}
