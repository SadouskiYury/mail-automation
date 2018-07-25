package driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
	private static WebDriver driver;
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "C:\\Program Files\\ChromeDriver\\chromedriver.exe";

	private DriverSingleton() {
	}

}
