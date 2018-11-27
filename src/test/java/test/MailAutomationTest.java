package test;

import org.testng.Assert;
import org.testng.annotations.*;
import steps.Step;
import util.ListenerTest;

@Listeners({ListenerTest.class})
public class MailAutomationTest {
	private Step step;
	private static final String mail = "@mail.ru";

	@BeforeGroups(description = "Init browser", groups = {"Test"})
	public void setUp() {
		step = new Step();
		step.initDriver();
	}

	@Parameters({ "login", "Pass" })
	@Test(description = "Login to Mail", groups = {"Test"})
	public void checkLoginMail(@Optional String log, @Optional String pass) {
		step.loginMail(log, pass);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(step.isLoggedIn(log + mail));
	}

	@Parameters({ "email", "topic", "letter" })
	@Test(description = "Check sented Letter", groups = {"Test"})
	public void checkSentedLetter(@Optional String email, @Optional String topic, @Optional String letter) {
		step.sendNewLetter(email, topic, letter);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(step.checkSentedLetter(email, topic));
	}

	@AfterGroups(description = "Stop Browser", groups = {"Test"})
	public void stopBrowser() {
		step.closeDriver();
	}
}
