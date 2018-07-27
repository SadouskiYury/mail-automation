package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru/";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		System.out.println("Login page opened");
	}

	@FindBy(xpath = ".//input[@id='mailbox:login']")
	private WebElement login;

	@FindBy(xpath = ".//input[@id='mailbox:password']")
	private WebElement pass;

	@FindBy(xpath = ".//input[@class='o-control']")
	private WebElement submit;

	@FindBy(xpath = "//span[@id='PH_authMenu_button']/i[@id='PH_user-email']")
	private WebElement LoggedInUser;

	public void login(String username, String password) {
		login.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
		System.out.println("Login entered");
	}

	public String getTextLoggedInUserName() {
		return LoggedInUser.getText().trim();
	}

}
