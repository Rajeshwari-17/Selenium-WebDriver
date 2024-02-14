
package brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksChecker {

    private static final Logger logger = Logger.getLogger(BrokenLinksChecker.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://testpages.eviltester.com/styled/index.html");

            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            logger.info("Total links on the web page: " + allLinks.size());

            int brokenLinksCount = 0;

            Iterator<WebElement> iterator = allLinks.iterator();
            while (iterator.hasNext()) {
                WebElement link = iterator.next();
                String url = link.getAttribute("href");

                if (url != null && !url.isEmpty()) {
                    if (isLinkBroken(new URL(url))) {
                        logger.warning("Broken Link: " + url);
                        brokenLinksCount++;
                    }
                }
            }

            logger.info("Number of broken links: " + brokenLinksCount);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while checking for broken links.", e);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static boolean isLinkBroken(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (responseCode != 200);
        } catch (Exception e) {
            return true;
        }
    }
}
