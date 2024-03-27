package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String name) {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div[18]/div/div[2]/div/div/div/div/div/form/div/div[4]/div/div/input"));
        WebElement nameInput = driver.findElement(By.xpath("/html/body/div[18]/div/div[2]/div/div/div/div/div/form/div/div[5]/div/div/input"));
        WebElement subscribeButton = driver.findElement(By.xpath("/html/body/div[18]/div/div[2]/div/div/div/div/div/form/div/div[6]/div/button"));

        emailInput.sendKeys(email);
        nameInput.sendKeys(name);
        subscribeButton.click();
    }

    public void navigateToBestSellers() {
        driver.get("https://dibruno.com/gifts/best-sellers/");
        System.out.println("Navigated to the Best Sellers page.");
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[13]/div[1]/div[5]/main/form/ul/li[1]/article/div/div[2]/div[2]/a"));
        addToCartButton.click();
        System.out.println("Added item to the cart.");
    }

	

}
