package fnpdatavalidation.commonutils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScreenShotUtility extends BrowserController {
	
	public static void getScreenshot() throws IOException {
		Date currentDate = new Date();
		String screenshotFilename = currentDate.toString().replace(" ", "_").replace(":", "-");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("C:\\Users\\Admin\\Downloads\\Testfailsnaps" + screenshotFilename + ".png"));
		log.info("Screenshot captured and saved at: C:\\Users\\Admin\\Downloads\\Testfailsnaps" + screenshotFilename
				+ ".png");
	}

}
