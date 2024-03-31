package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditBasketandProceedCheckout extends AbstractPages {
	


	private WebDriver driver;
	@SuppressWarnings("unused")
	private boolean acceptNextAlert = true;
	public static final String URL = "http://www.amazon.co.uk/Apple-iPhone-UNLOCKED-Silver-Space/dp/B00NK332EK/ref=sr_1_3?ie=UTF8&qid=1416170857&sr=8-3&keywords=iPhone6";

	
	@FindBy(id = "bb_atc_button")
	private WebElement addBasketbutton;

	
	@FindBy(id = "nav-cart")
	private WebElement viewCart;

	
	@FindBy(id = "a-autoid-2-announce")
	private WebElement editBasket;

	// Increase quantity value to 3
	@FindBy(id = "dropdown1_2")
	private WebElement quantity;

	@FindBy(name = "proceedToCheckout")
	private WebElement proceedToCheckout;

	/**
	 * Sole Constructor
	 * @param driver
	 * the web driver
	 **/

	public void addtoBasket() {

		addBasketbutton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public EditBasketandProceedCheckout(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	@Override
	public String getPageURL() {
		return URL;
	}

	public void editBasket() {
		viewCart.click();
		editBasket.click();
		quantity.click();
		// quantity.click();
	}

	
	public void editQuantityValue() {
		quantity.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	
	public void proceedCheckOut() {
		proceedToCheckout.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	

}
