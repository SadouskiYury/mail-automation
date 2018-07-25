package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.get(BASE_URL);
	}

	@FindBy(xpath = ".//input[@id='mailbox:login']")
	private WebElement login;

	@FindBy(xpath = ".//input[@id='mailbox:password']")
	private WebElement pass;

	@FindBy(xpath = ".//input[@class='o-control']")
	private WebElement submit;

	public void login(String username, String password) {
		login.sendKeys(username);
		pass.sendKeys(password);
		submit.click();

	}

}
