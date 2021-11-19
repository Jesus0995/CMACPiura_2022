package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefinalaPropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DefinalaPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);



    }
}
