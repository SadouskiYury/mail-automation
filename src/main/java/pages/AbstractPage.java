package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected WebDriver driver;
//	public static Logger logger=;
//WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(chousenDateDeparture));


    public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
