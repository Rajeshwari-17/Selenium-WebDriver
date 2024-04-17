package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    
    private WebDriver driver;
    @SuppressWarnings("unused")
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[@id='#cakesmenu']")
    public WebElement elementToHoverLocator;

    @FindBy(xpath = "//a[normalize-space()='Birthday Cakes']")
    public WebElement cakelinkLocator;

    @FindBy(xpath = "//ul[@class='product-details']")
    private WebElement productDetailsList;

    public void navigateToFnP() throws InterruptedException {
        driver.get("https://www.fnp.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHoverLocator).perform();
        cakelinkLocator.click();
        Thread.sleep(2000);
    }

    public boolean validateProductDetails(String flavour, String version, String type, String shape, String weight, String netQuantity, String diameter, String countryOfOrigin, String serves) {
        List<WebElement> productDetailItems = productDetailsList.findElements(By.tagName("li"));

        for (WebElement item : productDetailItems) {
            String detail = item.getText();
            String[] parts = detail.split(":");

            switch (parts[0].trim()) {
                case "Cake Flavour":
                    if (!parts[1].trim().equals(flavour))
                        return false;
                    break;
                case "Version":
                    if (!parts[1].trim().equals(version))
                        return false;
                    break;
                case "Type of Cake":
                    if (!parts[1].trim().equals(type))
                        return false;
                    break;
                case "Shape":
                    if (!parts[1].trim().equals(shape))
                        return false;
                    break;
                case "Weight":
                    if (!parts[1].trim().equals(weight))
                        return false;
                    break;
                case "Net Quantity":
                    if (!parts[1].trim().equals(netQuantity))
                        return false;
                    break;
                case "Diameter":
                    if (!parts[1].trim().equals(diameter))
                        return false;
                    break;
                case "Country Of Origin":
                    if (!parts[1].trim().equals(countryOfOrigin))
                        return false;
                    break;
                case "Serves":
                    if (!parts[1].trim().equals(serves))
                        return false;
                    break;
            }
        }

        return true;
    }
}
