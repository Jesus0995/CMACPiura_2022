package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class CrearHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //mapear locator
    @FindBy(xpath = "//button[1]") private WebElement btn_crearHojaTrabajo;
    @FindBy(xpath = "//button[2]") private WebElement btn_regresarListado;

    public CrearHojaTrabajoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void CrearHojaTrabajo() {

        btn_crearHojaTrabajo.click();
    }

    public void RegresarListado(){

        btn_regresarListado.click();
    }

}