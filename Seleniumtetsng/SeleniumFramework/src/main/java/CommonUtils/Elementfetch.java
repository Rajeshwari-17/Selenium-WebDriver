package CommonUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class Elementfetch {

	public WebElement getWebElement(String identifierType, String identifierValue)
	{
		switch(identifierType)
		{
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));

		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
			
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));
		
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifierValue));
			

		default:
			return null;
		}
	}
	
	public List<WebElement> getWebElements(String identifierType, String identifierValue)
	{
		switch(identifierType)
		{
		case "XPATH":
			return (List<WebElement>) BaseTest.driver.findElement(By.xpath(identifierValue));

		case "CSS":
			return (List<WebElement>) BaseTest.driver.findElement(By.cssSelector(identifierValue));
			
		case "ID":
			return (List<WebElement>) BaseTest.driver.findElement(By.id(identifierValue));
		
		case "NAME":
			return (List<WebElement>) BaseTest.driver.findElement(By.name(identifierValue));
		
		case "TAGNAME":
			return (List<WebElement>) BaseTest.driver.findElement(By.tagName(identifierValue));
			

		default:
			return null;
		}
	}

	
}
