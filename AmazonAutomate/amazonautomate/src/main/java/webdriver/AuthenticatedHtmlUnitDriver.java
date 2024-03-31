package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;

public class AuthenticatedHtmlUnitDriver {
	
	private static String USERNAME;
	private static String PASSWORD;

	private AuthenticatedHtmlUnitDriver() {
	}

	public static WebDriver create(String username, String password) {
		USERNAME = username;
		PASSWORD = password;
		return (WebDriver) new AuthenticatedHtmlUnitDriver();
	}

	protected WebClient newWebClient(BrowserVersion browserVersion) {
	    WebClient client = new WebClient(browserVersion);
	    DefaultCredentialsProvider provider = new DefaultCredentialsProvider();
	    provider.addCredentials(USERNAME, PASSWORD);
	    client.setCredentialsProvider(provider);
	    return client;
	}


}
