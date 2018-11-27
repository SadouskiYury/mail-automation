package steps;

import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import pages.GmailLoginPage;
import pages.LoginPage;
import pages.SendMailPage;
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
		loginPage.login(username, pass);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getTextLoggedInUserName();
		return actualUsername.equals(username);
	}

	public void sendNewLetter(String email, String topic, String message) {
		SendMailPage page=new LoginPage(driver).clickSendLetter();
        System.out.println("Sentletters opened");
        page.sendLetter(email, topic, message);
	}

	public boolean checkSentedLetter(String email, String topic) {
		SentLetterPage page = new SentLetterPage(driver);
		String sentWhom = page.SentWhom();
		String sentTopic = page.SentTopic();
		if (email.contains(sentWhom) && sentTopic.contains(topic))
			return true;
		else
			return false;
	}

	public void logInGmail(String login, String password){
		GmailLoginPage page=new GmailLoginPage(driver);

	}


}
