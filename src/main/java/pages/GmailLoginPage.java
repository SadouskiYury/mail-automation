package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends AbstractPage {
    private static final String BASE_URL = "https://gmail.com/";

    public GmailLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
        driver.navigate().to(BASE_URL);

    }


    private By HEADER= By.xpath("");
}
