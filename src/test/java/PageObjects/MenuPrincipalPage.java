package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class MenuPrincipalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapear los locator
    @FindBy(partialLinkText = "PROPUESTA") private WebElement lnk_PropuestaFinanciamiento;
    @FindBy(linkText = "HOJA DE TRABAJO") private WebElement lnk_HojaTrabajo;
    @FindBy(linkText = "INFORME DE VISITA") private WebElement lnk_InformeVisita;
    @FindBy(linkText = "INFORME COMERCIAL NUEVO FORMATO") private WebElement lnk_InformeComercial;
    @FindBy(partialLinkText = "CERRAR") private WebElement lnk_CerrarSesion;
    @FindBy(xpath = "/html/body/table/tbody/tr[1]/td/table[1]/tbody/tr/td[2]/h2/strong/font") private WebElement lbl_Titulo;

    //constructor
    public MenuPrincipalPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickPropuestaFinanciamiento (){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_PropuestaFinanciamiento));
        lnk_PropuestaFinanciamiento.click();
    }

    public void ClickInformeVisita(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeVisita));
        lnk_InformeVisita.click();
    }

    public void ClickHojaTrabajo(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_HojaTrabajo));
        lnk_HojaTrabajo.click();
    }

    public void ClickInformeComercial(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeComercial));
        lnk_InformeComercial.click();
    }

    public void ClickCerrarSesion(){
        Esperar(5);
        wait.until(ExpectedConditions.elementToBeClickable(lnk_CerrarSesion));
        lnk_CerrarSesion.click();
        Esperar(35);

    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException error){
            error.printStackTrace();
        }

    }

}