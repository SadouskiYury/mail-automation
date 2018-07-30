package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMailPage extends AbstractPage {
	private final String BASE_URL = "https://e.mail.ru/compose";

	public SendMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = ".//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frameNewLetter;

	@FindBy(xpath = ".//body[@class='mceContentBody compose2']")
	private WebElement NewLetter;

	@FindBy(xpath = "//child::textarea[attribute::data-original-name='To']")
	private WebElement emailField;

	@FindBy(xpath = ".//input[@class='b-input']")
	private WebElement topic;

	@FindBy(xpath = ".//body/iframe[@name='easyXDM_default3_provider']")
	private WebElement frameWhom;

	@FindBy(xpath = ".//div[@data-name='send']/span")
	private WebElement button;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		System.out.println("WriteLetter page opened");
	}

	public void sendLetter(String em, String top, String message) {
		WebElement email = driver.switchTo().activeElement();
		email.clear();
		email.sendKeys(em);
		email.sendKeys(Keys.TAB);
		topic.sendKeys(top);

		driver.switchTo().frame(frameNewLetter);
		NewLetter.clear();
		NewLetter.sendKeys(message);
		driver.switchTo().defaultContent();
		button.click();
	}

}
