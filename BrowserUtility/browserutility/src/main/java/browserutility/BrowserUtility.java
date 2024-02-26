package browserutility;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class BrowserUtility {

    public static void openBrowser(BrowserType browserType) {
        String url = "https://www.example.com"; // You can change the URL as needed

        switch (browserType) {
            case CHROME:
                openChrome(url);
                break;
            case FIREFOX:
                openFirefox(url);
                break;
            case EDGE:
                openEdge(url);
                break;
            default:
                System.out.println("Invalid browser type");
        }
    }

    private static void openChrome(String url) {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "chrome", url});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFirefox(String url) {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "firefox", url});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openEdge(String url) {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "msedge", url});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }
}
