package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarGarantiaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo objetos
    //@FindBy(name="propiedad") private WebElement cbx_propiedad;

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_registrar;


    public SeleccionarGarantiaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickRegistrarGarantia(){btn_registrar.click();}


}