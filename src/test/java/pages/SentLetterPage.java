package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentLetterPage extends AbstractPage {
	private final String URL = "https://e.mail.ru/messages/sent/";

	@FindBy(xpath = "//div[contains(text(),'sviatlana.zakharenka')]")
	private WebElement emailWhom;

	@FindBy(xpath = "//div[contains(text(),'HomeWork')]")
	private WebElement topic;

	public SentLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(URL);
		System.out.println("Sentletters opened");
	}

	public String SentTopic() {
		return topic.getText().trim();
	}

	public String SentWhom() {
		return emailWhom.getText().trim();
	}

}
