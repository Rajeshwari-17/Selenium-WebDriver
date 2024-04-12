package com.pageobjectpattern;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataValidations {
    @SuppressWarnings("unused")
	private WebDriver driver;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[1]")
	public static WebElement productdesc1;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[2]")
	public static WebElement productdesc2;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[3]")
	public static WebElement productdesc3;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[4]")
	public static WebElement productdesc4;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[5]")
	public static WebElement productdesc5;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[6]")
	public static WebElement productdesc6;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[7]")
	public static WebElement productdesc7;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[8]")
	public static WebElement productdesc8;
    
    @FindBy(xpath = "//div[@class='product-desc-desktop_productDescription__1hRLx']//ul[1]/li[9]")
	public static WebElement productdesc9;

    public DataValidations(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean validateDataOnWebsite(WebDriver driver, String flavour, String version, String type, String shape, String weight, String netQuantity, String diameter, String countryOfOrigin, String serves) {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("excecuted 1 !!");
   
       String actualFlavour = productdesc1.getText();
       
    	
        String actualVersion = productdesc2.getText();
        String actualType = productdesc3.getText();
        String actualShape = productdesc4.getText();
        String actualWeight = productdesc5.getText();
        String actualNetQuantity = productdesc6.getText();
        String actualDiameter = productdesc7.getText();
        String actualCountryOfOrigin = productdesc8.getText();
        String actualServes = productdesc9.getText();

        // Compare the actual data with the provided parameters
        boolean flavourMatches = actualFlavour.equals(flavour);
        boolean versionMatches = actualVersion.equals(version);
        boolean typeMatches = actualType.equals(type);
        boolean shapeMatches = actualShape.equals(shape);
        boolean weightMatches = actualWeight.equals(weight);
        boolean netQuantityMatches = actualNetQuantity.equals(netQuantity);
        boolean diameterMatches = actualDiameter.equals(diameter);
        boolean countryOfOriginMatches = actualCountryOfOrigin.equals(countryOfOrigin);
        boolean servesMatches = actualServes.equals(serves);

        // Print validation result
        if (flavourMatches && versionMatches && typeMatches && shapeMatches && weightMatches && netQuantityMatches && diameterMatches && countryOfOriginMatches && servesMatches) {
            System.out.println("Data validation passed for: " + flavour);
            return true;
        } else {
            System.out.println("Data validation failed for: " + flavour);
            return false;
        }
    }

}
