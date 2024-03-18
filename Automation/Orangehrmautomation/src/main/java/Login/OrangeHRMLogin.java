package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrangeHRMLogin {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		login(driver);

		driver.quit();
	}
	
	public static void login(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
		
		driver.manage().window().maximize();
		
		String username = "Admin";
		String password = "admin123";
		
		WebElement usernamefield = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@contents(@class,'oxd-input')][@name='username']")));
		
		WebElement passwordfield = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@contents(@class,'oxd-input')][@name='password']")));
		
		WebElement loginButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));
		
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginButton.click();
		
		System.out.println("Successfully logged in OrangeORM webpage !!");
		
		try {
			Thread.sleep(10000);
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}
	

}
