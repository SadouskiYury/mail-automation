package steps;

import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import pages.LoginPage;

public class Step {
	private WebDriver driver;

	public void initDriver() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginMail(String username, String pass) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, pass);
	}
}
