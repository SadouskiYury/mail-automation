package main;

import org.testng.Assert;
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
	public void checkLoginMail() throws InterruptedException {
		step.loginMail(USERNAME, PASSWORD);
		Thread.sleep(3000);
		Assert.assertTrue(step.isLoggedIn(USERNAME+"@mail.ru"));
	}
	
	@Test(description = "Check sented Letter")
	public void checkSentedLetter() throws InterruptedException {
		step.createNewLetter("Hello my dear friend!!!");
		
	}

//	 @AfterMethod(description = "Stop Browser")
//	 public void stopBrowser() {
//	 step.closeDriver();
//	 }
}
