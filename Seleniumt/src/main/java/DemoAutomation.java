import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DemoAutomation {
    public static void main(String[] args) {
        
    	WebDriver driver = new ChromeDriver();
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
    	
    	driver.get("https://www.udemy.com/");
    	
    	//WebDriverWait wait = new WebDriverWait(driver,10);
    	
    	WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
    	
    	searchInput.sendKeys("Selenium WebDriver");

        // Find the search button and click it
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
    }

	
}

