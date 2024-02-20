import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.io.File;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OrangeHrmTest {
	static {
			System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
		}
		
		public static void main(String[] args) throws InterruptedException 
		{
//			System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com");
			driver.manage().window().maximize();
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			 login(driver);
			 OpenCity(driver);
			 driver.wait();
	}
		
		private static void login(WebDriver driver) {
			// TODO Auto-generated method stub
			 String excelFilePath = "C:\\Users\\Admin\\Downloads\\Details.xlsx";
		        FileInputStream fileInputStream;
		        try {
		            fileInputStream = new FileInputStream(new File(excelFilePath));
		            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming login details are in the first sheet

		            // Assuming username is in cell A1 and password is in cell B1
		            String username = sheet.getRow(1).getCell(0).getStringCellValue();
		            String password = sheet.getRow(1).getCell(1).getStringCellValue();
	                
		            
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		            WebElement usernameField = wait.until(ExpectedConditions
		    				.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
		    		WebElement passwordField = wait.until(ExpectedConditions
		    				.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
		    		WebElement loginButton = wait.until(ExpectedConditions
		    				.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

		    		usernameField.sendKeys(username);
		    		passwordField.sendKeys(password);
		    		loginButton.click();

		            

		            fileInputStream.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
		}
		
		private static void OpenCity(WebDriver driver) {
		    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewLocations");
		    String excelFilePath = "C:\\Users\\Admin\\Downloads\\Details.xlsx";
		    
		    FileInputStream fileInputStream;
		    try {
		        fileInputStream = new FileInputStream(new File(excelFilePath));
		        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming login details are in the first sheet

		        // Assuming username is in cell A1 and password is in cell B1
		        String name = sheet.getRow(1).getCell(0).getStringCellValue();
		        String city = sheet.getRow(1).getCell(1).getStringCellValue();
		        
		        driver.findElement(By.cssSelector("input[data-v-1f99f73c='']")).sendKeys(name);
		        driver.findElement(By.cssSelector("input[data-v-1f99f73c='']")).sendKeys(city);
		        driver.findElement(By.cssSelector("i[data-v-bddebfba][data-v-67d2aedf]")).click(); // Click on the dropdown arrow
		        // Define eachRow or pass the necessary object containing country information
	            String countryName = ""; // Placeholder for countryName
	            driver.findElement(By.xpath("//div[text()='" + countryName + "']")).click(); // Click on the desired country option
	            driver.findElement(By.id("btnSearch")).click();

		            
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

}
 