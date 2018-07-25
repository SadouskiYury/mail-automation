package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage() {
		this.driver = driver;
	}
}
