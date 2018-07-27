package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SentLetterPage extends AbstractPage {

	public SentLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		
	}

	

	@Override
	public void openPage() {

	}

}
