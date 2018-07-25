package main;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Step;

public class MailAutomation {
	private Step step;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new Step();
		step.initDriver();
	}

	@Test(description = "Login to Mail")
	public void oneCanLoginMail() {
		step.loginMail(USERNAME, PASSWORD);
		// Assert.assertTrue(step.isLoggedIn(USERNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		step.closeDriver();
	}
}
