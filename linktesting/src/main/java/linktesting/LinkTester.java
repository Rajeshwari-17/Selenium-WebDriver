package linktesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTester {
    private static final Logger logger = Logger.getLogger(LinkTester.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://testpages.eviltester.com/styled/index.html");

            // Find all links on the webpage
            List<WebElement> links = driver.findElements(By.tagName("a"));

            // Test each link
            for (WebElement link : links) {
                String url = link.getAttribute("href");
                if (url != null && !url.isEmpty()) {
                    if (isValidLink(url)) {
                        logger.log(Level.INFO, "Valid link: " + url);
                    } else {
                        logger.log(Level.SEVERE, "Broken link: " + url);
                    }
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static boolean isValidLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error checking link validity: " + e.getMessage());
            return false;
        }
    }
}
