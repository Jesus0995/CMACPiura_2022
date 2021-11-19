package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefinaPropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DefinaPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);



    }
}
