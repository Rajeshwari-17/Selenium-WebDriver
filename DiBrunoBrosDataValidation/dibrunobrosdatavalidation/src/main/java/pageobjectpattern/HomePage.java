package pageobjectpattern;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


	private WebDriver driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Manually define the email address
			String emailAddress = "example@example.com";

			// Navigate to the Website
			driver.get("https://dibruno.com/");
			driver.manage().window().maximize();

			// Fill Email Address
			WebElement emailInput = driver.findElement(By.id("email_103614096")); 
			emailInput.sendKeys(emailAddress);

			// Click Subscribe Button
			WebElement subscribeButton = driver.findElement(By.xpath("/html/body/div[18]/div/div[2]/div/div/div/div/div/form/div/div[6]/div/button"));
			subscribeButton.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement noThanksButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[18]/div/div[2]/div/div/div/div/div/form/div/div[4]/div/button")));


			noThanksButton.click();
			Thread.sleep(2000);

			Actions actions = new Actions(driver);

			actions.moveToElement(driver.findElement(By.xpath("/html/body/header/div[5]/nav/ul[1]/li[1]/a"))).perform();

			WebElement cakelinkLocator = driver.findElement(By.xpath("/html/body/header/div[5]/nav/ul[1]/li[1]/div/ul[2]/li[7]/a")); 
			cakelinkLocator.click();

			Thread.sleep(2000);
			Thread.sleep(2000);


			//driver.get("https://dibruno.com/cannoli-crisps-cream-kit/");

			scrollDownToElement("/html/body/div[13]/div[1]/div[5]/main/form/ul/li[2]/article/div/div[2]/div[2]/a");

			// Click on the element
			WebElement elementToClick = driver.findElement(By.xpath("/html/body/div[13]/div[1]/div[5]/main/form/ul/li[2]/article/div/div[2]/div[2]/a"));
			elementToClick.click();


			// Wait for the form field to be clickable
			WebElement formField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[2]/div[1]")));

			// Scroll to the form field
			scrollToElement(formField);



			WebElement thankingyouCheckbox = formField.findElement(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[2]/div[1]/ul/li[6]/div/label"));
			thankingyouCheckbox.click();

			WebElement formField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[2]/div[2]")));

			WebElement GourmentTopping = formField.findElement(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[2]/div[2]/ul/li[2]/div/label"));
			GourmentTopping.click();

			Thread.sleep(2000);
			Thread.sleep(2000);


			/* WebElement Addtocart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[5]/input")));
            Addtocart.click();

            WebElement viewcart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[21]/div[1]/div[2]/div/div/div[2]/div/a[2]")));
            viewcart.click();*/


			WebElement para1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[1]")));
			scrollToElement(para1);

			FileInputStream excelFile = new FileInputStream("C:\\Users\\Admin\\Downloads\\Book5.xlsx");
			//FileInputStream excelFile = new FileInputStream("C:\\Users\\Admin\\Downloads\\File2.xlsx");
			Workbook workbook = WorkbookFactory.create(excelFile);


			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

			// Get descriptions from Excel sheet
			List<String> descriptionsFromExcel = new ArrayList<>();
			for (org.apache.poi.ss.usermodel.Row row : sheet) {
				org.apache.poi.ss.usermodel.Cell cell = row.getCell(0); // Assuming descriptions are in the first column
				if (cell != null) {
					descriptionsFromExcel.add(cell.getStringCellValue());
				}
			}


			// Get descriptions from Excel sheet


			// XPaths for descriptions
			String[] xpaths = {
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[1]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[2]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[3]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[4]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/p[5]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[1]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[2]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[3]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[4]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[5]",
					"/html/body/div[12]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[6]"
			};

			// Get descriptions from the webpage
			List<String> descriptionsFromWeb = new ArrayList<>();
			for (String xpath : xpaths) {
				WebElement element = driver.findElement(By.xpath(xpath));
				descriptionsFromWeb.add(element.getText());
			}

			// Compare descriptions
			for (int i = 0; i < descriptionsFromExcel.size(); i++) {
				String descriptionFromExcel = descriptionsFromExcel.get(i);
				String descriptionFromWeb = descriptionsFromWeb.get(i);
				if (descriptionFromExcel.equals(descriptionFromWeb)) {
					System.out.println("Description " + (i + 1) + " matches.");
				} else {
					System.out.println("Description " + (i + 1) + " does not match.");
				}
			}

			// Close the workbook and release resources
			workbook.close();
			excelFile.close();

			Thread.sleep(2000);

			WebElement Addtocart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[5]/input")));

			scrollUp("/html/body/div[12]/div[1]/div/div[1]/section[1]/div[3]/form/div[5]/input");

			Addtocart.click();

			WebElement viewcart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[21]/div[1]/div[2]/div/div/div[2]/div/a[2]")));
			viewcart.click();


			Thread.sleep(2000);


			// Method to scroll to an element using JavaScriptExecutor



		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	// Method to scroll to an element using JavaScriptExecutor
	private void scrollToElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Scroll to the element and align it to the top of the viewport
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
	}



	private void scrollDownToElement(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	private void scrollUp(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll up by negative y-coordinate value
		js.executeScript("window.scrollBy(0, -300);");
	}


}

