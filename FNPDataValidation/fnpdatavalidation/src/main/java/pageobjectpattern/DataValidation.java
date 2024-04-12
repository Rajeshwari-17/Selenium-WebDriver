package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DataValidation {
    private WebDriver driver;

    public DataValidation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateDataOnWebsite(String flavour, String version, String type, String shape, String weight, String netQuantity, String diameter, String countryOfOrigin, String serves) {
        WebElement productList = driver.findElement(By.xpath("//ul[@class='product-details']"));
        List<WebElement> productDetails = productList.findElements(By.tagName("li"));

        String actualFlavour = productDetails.get(0).getText();
        String actualVersion = productDetails.get(1).getText();
        String actualType = productDetails.get(2).getText();
        String actualShape = productDetails.get(3).getText();
        String actualWeight = productDetails.get(4).getText();
        String actualNetQuantity = productDetails.get(5).getText();
        String actualDiameter = productDetails.get(6).getText();
        String actualCountryOfOrigin = productDetails.get(7).getText();
        String actualServes = productDetails.get(8).getText();

        // Compare the actual data with the provided parameters
        boolean flavourMatches = actualFlavour.equals(flavour);
        boolean versionMatches = actualVersion.equals(version);
        boolean typeMatches = actualType.equals(type);
        boolean shapeMatches = actualShape.equals(shape);
        boolean weightMatches = actualWeight.equals(weight);
        boolean netQuantityMatches = actualNetQuantity.equals(netQuantity);
        boolean diameterMatches = actualDiameter.equals(diameter);
        boolean countryOfOriginMatches = actualCountryOfOrigin.equals(countryOfOrigin);
        boolean servesMatches = actualServes.equals(serves);

        // Return true if all data matches, otherwise return false
        return flavourMatches && versionMatches && typeMatches && shapeMatches && weightMatches && netQuantityMatches && diameterMatches && countryOfOriginMatches && servesMatches;
    }
}
