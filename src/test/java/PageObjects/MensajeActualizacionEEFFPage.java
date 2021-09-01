package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MensajeActualizacionEEFFPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cerrar;

    public MensajeActualizacionEEFFPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCerrar () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_cerrar));
        btn_cerrar.click();
    }

}
