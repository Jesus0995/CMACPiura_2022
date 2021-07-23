package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarOperacionCreditoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapear elementos
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_aceptar;

    public SeleccionarOperacionCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void ClickAceptar(){
        btn_aceptar.click();
    }

}
