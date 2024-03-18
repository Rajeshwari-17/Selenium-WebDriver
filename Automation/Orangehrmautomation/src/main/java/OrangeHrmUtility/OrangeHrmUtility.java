package OrangeHrmUtility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmUtility {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		login(driver);
		
		 navigateToLanguagePage(driver);

			String expectedLanguageName = "Arabic";
		        boolean isDataMatching = getDataAndCompare(driver, expectedLanguageName);

		        if (isDataMatching) {
		            System.out.println("Actual data matches the expected value: " + expectedLanguageName);
		        } else {
		            System.out.println("Actual data does not match the expected value: " + expectedLanguageName);
		        }

		        try {
		            TimeUnit.SECONDS.sleep(15);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		            driver.quit();
		        }
		    }
		
		
		
	
	
	private static void login(WebDriver driver)
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
	
	 private static void navigateToLanguagePage(WebDriver driver) {
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewLanguages");
	        System.out.println("Navigated to the Languages page.");
	    }
	 
	 private static boolean getDataAndCompare(WebDriver driver, String expectedValue) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Locate the language table on the OrangaHRM webpage 
	        By languageTableLocator = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div");
	        WebElement languageTable = wait.until(ExpectedConditions.presenceOfElementLocated(languageTableLocator));

	        // Finding all Rows of language table
	        List<WebElement> languageRows = languageTable.findElements(
	                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]"));

	        // Check if language table rows are not empty
	        if (languageRows.isEmpty()) {
	            System.out.println("No language rows found on the page.");
	            return false;
	        }

	        // Create a list to store actual language names on OrangeHRM webpage
	        List<String> actualLanguageNames = new ArrayList<>();

	        // Iterate through language rows and capture the actual language names on webpage
	        for (WebElement row : languageRows) {
	            WebElement languageNameCell = row.findElement(
	                    By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]"));
	            String actualLanguageName = languageNameCell.getText().trim();
	            actualLanguageNames.add(actualLanguageName);
	            System.out.println("Actual Language Name: " + actualLanguageName);
	        }

	        System.out.println("Expected Language Name: " + expectedValue);

	        // Check if actual language names list is empty or not
	        if (actualLanguageNames.isEmpty()) {
	            System.out.println("No actual language names captured.");
	            return false;
	        }
		    
	        return actualLanguageNames.contains(expectedValue);
	    }

}
