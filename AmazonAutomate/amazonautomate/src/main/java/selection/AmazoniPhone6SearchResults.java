package selection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazoniPhone6SearchResults {
	
	private WebDriver driver;

	// Use annotations to locate elements.
	@FindBy(css = "img.s-access-image.cfMarker")
	private WebElement searchItemSelect;

	@FindBy(xpath = "//li[@id='result_0']/div/div/div/div[2]/div/a/h2")
	private WebElement searchResults;

	@FindBy(xpath = "//li[@id='result_2']/div/div/div/div[2]/div/a/h2")
	private WebElement searchResultThirdItemSelect;

	/**
	 * Sole Constructor
	 *
	 * @param driver
	 *            the web driver
	 */
	public AmazoniPhone6SearchResults(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	public String getSearchResultText() {
		return searchResults.getText();
	}

	
	public AmazoniPhone6SearchResults selectSearchItem() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchResultThirdItemSelect.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new AmazoniPhone6SearchResults(driver);
	}


}
