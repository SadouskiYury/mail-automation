package steps;

import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import pages.LoginPage;
import pages.SendLetterPage;
import pages.SentLetterPage;

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

	public void sendNewLetter(String eamil, String topic, String message) {
		SendLetterPage page = new SendLetterPage(driver);
		page.openPage();
		page.sendLetter(eamil, topic, message);
	}

	public boolean checkSentLetter(String email, String topic) {
		SentLetterPage page = new SentLetterPage(driver);
		page.openPage();
		String sentWhom = page.SentWhom();
		String sentTopic = page.SentTopic();

		if (email.contains(sentWhom) && sentTopic.contains(topic))
			return true;
		else
			return false;
	}

}
