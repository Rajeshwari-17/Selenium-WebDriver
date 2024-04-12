package com.pageobjectpattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "//div[@id='CAKE86093']")
	public WebElement selectCakeLocator;
	
	

	public void navigateTofnp() throws InterruptedException {
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHoverLocator).perform();
		cakelinkLocator.click();
		Thread.sleep(2000);
		excelDrivenDataMethod();

	}
	
	public void navigateTofnp2() throws InterruptedException {
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHoverLocator).perform();
		cakelinkLocator.click();
		Thread.sleep(2000);
		selectCakeLocator.click();
		Thread.sleep(4000);
		try {
			performExcelDataValidation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	    public void excelDrivenDataMethod() throws InterruptedException {
	        try {
	            Object[][] testData = ExcelDataManager.provideTestData();
	            boolean methodExecuted = false;

	            for (Object[] data : testData) {
	                if (data[0] != null) {
	                    String address = data[0].toString(); // Convert to String
	                    String radiobutton = data[1].toString(); // Convert to String
	                    String message = data[2].toString(); // Convert to String
	                    String addon = data[3].toString(); // Convert to String
	                    String dateString = data[4].toString(); // Convert to String
	                    String deliveryMethod = data[5].toString(); // Convert to String
	                    String timeSlot = data[6].toString(); // Convert to String

	                    if (!methodExecuted) {
	                        AddCakeToCartPage addCakeToCartPage = new AddCakeToCartPage(driver);
	                        addCakeToCartPage.addCakeToCartMethod(address, radiobutton, message, addon, dateString, deliveryMethod, timeSlot);
	                        methodExecuted = true;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void performExcelDataValidation() throws IOException {
	        FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\Book5.xlsx");
	        Workbook workbook = WorkbookFactory.create(file);
	        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
	        int rowCount = sheet.getLastRowNum();
	        for (int i = 1; i <= rowCount; i++) { // Starting from 1 to skip header row
	            Row row = sheet.getRow(i);
	            if (row != null) { // Check if row is null
	                String flavour = getStringValue(row.getCell(0));
	                String version = getStringValue(row.getCell(1));
	                String type = getStringValue(row.getCell(2));
	                String shape = getStringValue(row.getCell(3));
	                String weight = getStringValue(row.getCell(4));
	                String netQuantity = getStringValue(row.getCell(5));
	                String diameter = getStringValue(row.getCell(6));
	                String countryOfOrigin = getStringValue(row.getCell(7));
	                String serves = getStringValue(row.getCell(8));

	                boolean validationPassed = DataValidations.validateDataOnWebsite(driver, flavour, version, type, shape, weight, netQuantity, diameter, countryOfOrigin, serves);

	                if (validationPassed) {
	                    System.out.println("Data validation passed for: " + flavour);
	                } else {
	                    System.out.println("Data validation failed for: " + flavour);
	                    // You can add appropriate actions here for failed validation
	                }
	            }
	        }
	        workbook.close();
	        file.close();
	    }

	    // Method to safely convert cell value to string, handling null values
	    private static String getStringValue(Cell cell) {
	        if (cell != null) {
	            return cell.toString();
	        }
	        return ""; // Return empty string if cell is null
	    }
	}


