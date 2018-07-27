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

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getTextLoggedInUserName();
		return actualUsername.equals(username);
	}

	public void sentNewLetter(String eamil, String topic) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sentLetter(eamil, topic);

	}

	public void createNewLetter(String newLetter) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goToPageSentTeller(newLetter);
	}

}
