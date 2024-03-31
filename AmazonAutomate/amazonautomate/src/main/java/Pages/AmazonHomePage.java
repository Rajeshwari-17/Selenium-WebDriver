package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selection.AmazoniPhone6SearchResults;

public class AmazonHomePage extends AbstractPages{
	
	private WebDriver driver;

	public static final String URL = "https://www.amazon.com//";

	// Use annotations to locate elements.
	@FindBy(id = "twotabsearchtextbox")
	private WebElement twotabsearchtextbox;

	@FindBy(css = "input.nav-submit-input")
	private WebElement searchButton;

	
	public AmazonHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	@Override
	public String getPageURL() {
		return URL;
	}

	
	public AmazoniPhone6SearchResults searchFor(String text) {
		twotabsearchtextbox.sendKeys(text);
		twotabsearchtextbox.submit();
		searchButton.click();
		return new AmazoniPhone6SearchResults(driver);
	}
	
	

}
