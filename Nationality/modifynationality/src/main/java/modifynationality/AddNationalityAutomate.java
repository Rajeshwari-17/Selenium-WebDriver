package modifynationality;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddNationalityAutomate {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
		
		login(driver);
		navigateToNationalitiesPage(driver);
		addNationality(driver, "Sri Lankan");
		editNationality(driver,"Sri Lankan","Indian");
		deleteNationality(driver,"Indian");
	
	
	try {
		TimeUnit.SECONDS.sleep(15);
	} catch (InterruptedException e) {
		e.printStackTrace();
	} finally {
		driver.quit();
	}
}

private static void login(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Navigate to the OrangeHRM login page
	//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");

	driver.manage().window().maximize();

	// Input-login credentials
	String username = "Admin";
	String password = "admin123";

	// Locate web-elements through xpath
	WebElement usernameField = wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
	WebElement passwordField = wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
	WebElement loginButton = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
	loginButton.click();
	log.info("Successfully logged in OrangeORM webpage !!");
}

private static void navigateToNationalitiesPage(WebDriver driver) {
	// Navigate to the Nationalities page
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/nationality");

	log.info("Navigated to the Nationalities page.");
}

private static void addNationality(WebDriver driver, String nationalityName) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Locate elements using XPath
	WebElement addButton = wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button")));
	wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

	log.info("Navigated to the Add Nationality page.");

	WebElement nationalityNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
	nationalityNameField.sendKeys(nationalityName);

	WebElement saveButton = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")));
	saveButton.click();

	log.info("Nationality added successfully.");
}
private static void editNationality(WebDriver driver, String currentNationalityName, String newNationalityName) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Navigate to the Nationalities page
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/nationality");

    // Find the row containing the current nationality name
    WebElement nationalityRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr/td/a[contains(text(),'" + currentNationalityName + "')]/ancestor::tr")));

    // Find the edit button in the row and click it
    WebElement editButton = nationalityRow.findElement(By.xpath(".//a[@href='#']"));
    editButton.click();

    log.info("Navigated to the Edit Nationality page.");

    // Find the nationality name field and clear existing text
    WebElement nationalityNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nationality_name")));
    nationalityNameField.clear();

    // Enter the new nationality name
    nationalityNameField.sendKeys(newNationalityName);

    // Find and click the save button
    WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
    saveButton.click();

    log.info("Nationality edited successfully.");
}
private static void deleteNationality(WebDriver driver, String nationalityName) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Navigate to the Nationalities page
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/nationality");

    // Find the row containing the nationality name to be deleted
    WebElement nationalityRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr/td/a[contains(text(),'" + nationalityName + "')]/ancestor::tr")));

    // Find the checkbox in the row and select it
    WebElement checkbox = nationalityRow.findElement(By.xpath(".//input[@type='checkbox']"));
    checkbox.click();

    // Find and click the delete button
    WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnDelete")));
    deleteButton.click();

    // Confirm the deletion in the alert dialog
    driver.switchTo().alert().accept();

    log.info("Nationality deleted successfully.");
}


}
