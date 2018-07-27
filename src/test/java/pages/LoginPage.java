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

	@FindBy(xpath = ".//span[contains(text(),'Написать письмо')]")
	private WebElement goToSentPage;

	@FindBy(xpath = ".//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frameNewLetter;

	@FindBy(xpath = ".//body[@class='mceContentBody compose2']")
	private WebElement NewLetter;
	
	@FindBy(xpath = ".//body[@class='mceContentBody compose2']")
	private WebElement email;
	
	@FindBy(xpath = ".//body[@class='mceContentBody compose2']")
	private WebElement topic;

	public void login(String username, String password) {
		login.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
		System.out.println("Login entered");
	}

	public String getTextLoggedInUserName() {
		return LoggedInUser.getText().trim();
	}

	public void goToPageSentTeller(String newLetter) {
		goToSentPage.click();
		driver.switchTo().frame(frameNewLetter);
		NewLetter.clear();
		NewLetter.sendKeys(newLetter);
	}
	
	public void sentLetter(String eamil,String topic) {
		driver.switchTo().defaultContent();
		
	}

}
