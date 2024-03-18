package Usermanagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adduser {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		login(driver);
		navigateToAddUserPage(driver);
		addUser(driver, "Admin", "s", "Disabled", "john.doe", "Password123", "Password123");
		
		try {
			TimeUnit.SECONDS.sleep(20);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}finally {
			driver.quit();
		}
	}
	
	public static void login(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		String username = "Admin";
		String password = "admin123";
		
		WebElement usernameField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@contents(@class,'oxd-input')][@name = 'username']")));
		
		WebElement passwordField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@contents(@class,'oxd-input')][@name = 'password']")));
		
		WebElement loginButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@contents(@class,'orangehrm-login-button")));
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		
		System.out.println("Login Succesful");
		
    }
	
	public static void navigateToAddUserPage(WebDriver driver)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

		System.out.println("Navigated to the Add User page.");
	}
	
	private static void addUser(WebDriver driver, String userRole, String partialEmployeeName, String status,
			String username, String password, String confirmPassword) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Locate elements using XPath
		WebElement addButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")));
		userRoleDropdown.click();
		WebElement userRoleOption = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + userRole + "')]")));
		userRoleOption.click();

		WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")));
		employeeNameField.sendKeys(partialEmployeeName);
		employeeNameField.sendKeys(Keys.ARROW_DOWN);
		employeeNameField.sendKeys(Keys.ENTER);

		WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
		statusDropdown.click();
		WebElement statusOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + status + "')]")));
		statusOption.click();

		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")));
		usernameField.sendKeys(username);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
		passwordField.sendKeys(password);

		WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
		confirmPasswordField.sendKeys(confirmPassword);

		WebElement saveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")));
		saveButton.click();

		System.out.println("User added successfully.");
	}

}
