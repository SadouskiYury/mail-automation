package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private static final String BASE_URL = "https://mail.ru/";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
        if(driver.getCurrentUrl()==null) {
            driver.navigate().to(BASE_URL);
//            logger.info("LoginPage opened");
        }
	}

	@FindBy(xpath = ".//input[@id='mailbox:login']")
	private WebElement login;

	@FindBy(xpath = ".//input[@id='mailbox:password']")
	private WebElement pass;

	@FindBy(xpath = ".//input[@class='o-control']")
	private WebElement submit;

	@FindBy(xpath = "//span[@id='PH_authMenu_button']/i[@id='PH_user-email']")
	private WebElement LoggedInUser;

	@FindBy(xpath = "//div[@class='b-toolbar__item']/a[@data-title[normalize-space()='Написать письмо (N)']]")
	private WebElement buttonSentLetter;

	public void login(String username, String password) {
        login.sendKeys(username);
        pass.sendKeys(password);
        submit.click();
		System.out.println("Login entered");
	}

	public String getTextLoggedInUserName() {
		return LoggedInUser.getText().trim();
	}

	public SendMailPage clickSendLetter (){
		 buttonSentLetter.click();
	 return new SendMailPage(driver);
	}

}
