package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SegurosSeleccionadosPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cerrar;

    public SegurosSeleccionadosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCerrar(){btn_cerrar.click();}
}
