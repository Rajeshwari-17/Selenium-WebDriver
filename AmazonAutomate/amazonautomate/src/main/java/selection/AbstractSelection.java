package selection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractSelection {
	
	public AbstractSelection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
