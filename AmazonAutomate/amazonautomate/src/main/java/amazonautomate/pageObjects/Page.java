package amazonautomate.pageObjects;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}


}
