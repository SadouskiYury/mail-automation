package main;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import steps.Step;

public class MailAutomationTest {
	private Step step;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		step = new Step();
		step.initDriver();
	}

	@Parameters({ "login", "Pass" })
	@Test(description = "Login to Mail", groups = { "Test" })
	public void checkLoginMail(String log, String pass) {
		step.loginMail(log, pass);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(step.isLoggedIn(log + "@mail.ru"));
	}

	@Parameters({ "email", "topic", "letter" })
	@Test(description = "Check sented Letter", groups = { "Test" })
	public void checkSentLetter(String email, String topic, String letter) {
		step.sendNewLetter(email, topic, letter);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(step.checkSentLetter(email, topic));
	}

	@AfterGroups(description = "Stop Browser", groups = "Test")
	public void stopBrowser() {
		step.closeDriver();
	}
}
