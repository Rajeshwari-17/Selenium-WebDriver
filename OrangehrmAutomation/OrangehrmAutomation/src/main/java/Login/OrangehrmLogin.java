package Login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class OrangehrmLogin {
	static {
		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
//		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 login(driver);
		 addJobTitles(driver);
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
	
	
	private static void addJobTitles(WebDriver driver) throws InterruptedException
	{
		try {
	           
	            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Admin\\Downloads\\Details.xlsx"));
	            
	            Workbook workbook = WorkbookFactory.create(fileInputStream);
	            
	            Sheet sheet = workbook.getSheetAt(0); 

	            
	            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            for (int i = 1; i < sheet.getLastRowNum(); i++) {
	                String jobTitle = sheet.getRow(i).getCell(2).getStringCellValue();

	                WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'bi-plus')]")));
	                addButton.click();
                    
	               // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle");
	                WebElement jobTitleField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')]")));
	                jobTitleField.sendKeys(jobTitle);

	                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'orangehrm-left-space')]")));
	                saveButton.click();

	            }


	            fileInputStream.close();
	        } catch (IOException | EncryptedDocumentException ex) {
	            ex.printStackTrace();
	        }
		
		
	    }

	}

	
	

	



		