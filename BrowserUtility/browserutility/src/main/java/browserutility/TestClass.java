package browserutility;

import org.openqa.selenium.WebDriver;

public class TestClass {

    public static void main(String[] args) {
    	 BrowserUtility.openBrowser(BrowserUtility.BrowserType.CHROME);

         // Open Firefox browser
        // BrowserUtility.openBrowser(BrowserUtility.BrowserType.FIREFOX);

         // Open Edge browser
         BrowserUtility.openBrowser(BrowserUtility.BrowserType.EDGE);
    }
}

