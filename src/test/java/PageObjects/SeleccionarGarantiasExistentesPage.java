package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarGarantiasExistentesPage {

    private WebDriver driver;
    private WebDriverWait wait;


    //mapeo objetos

    @FindBy(name = "garantia") private WebElement chk_garantia;
    @FindBy(xpath = "//button[@type=\"submit\"]") private  WebElement btn_aceptar;

    public SeleccionarGarantiasExistentesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public void SeleccionarCheck() {chk_garantia.click();}
    public void ClickSubmit (){btn_aceptar.click();}



}
