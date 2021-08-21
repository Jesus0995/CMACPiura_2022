package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@onclick=\"window.location='./index.jsp'\"]") private WebElement btn_IniciarNuevaSesion;


    public LogoutPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickIniciarNuevaSesion(){
        btn_IniciarNuevaSesion.click();

    }

}
