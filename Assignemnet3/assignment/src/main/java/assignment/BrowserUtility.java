package assignment;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserUtility {

    public static void openBrowser(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Browsing action not supported.");
            }
        } else {
            System.out.println("Desktop not supported.");
        }
    }

    public static void main(String[] args) {
        String url = "https://www.xyz.com";
        openBrowser(url);
    }
}
