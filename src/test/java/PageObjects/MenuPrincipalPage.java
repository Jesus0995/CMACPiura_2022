package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class MenuPrincipalPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();


    //mapear los locator
    @FindBy(partialLinkText = "PROPUESTA")
    private WebElement lnk_PropuestaFinanciamiento;
    @FindBy(linkText = "HOJA DE TRABAJO")
    private WebElement lnk_HojaTrabajo;
    @FindBy(linkText = "INFORME DE VISITA")
    private WebElement lnk_InformeVisita;
    @FindBy(linkText = "INFORME COMERCIAL NUEVO FORMATO")
    private WebElement lnk_InformeComercial;
    @FindBy(partialLinkText = "CERRAR")
    private WebElement lnk_CerrarSesion;
    @FindBy(xpath = "/html/body/table/tbody/tr[1]/td/table[1]/tbody/tr/td[2]/h2/strong/font")
    private WebElement lbl_Titulo;

    //constructor
    public MenuPrincipalPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickPropuestaFinanciamiento() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_PropuestaFinanciamiento));
            lnk_PropuestaFinanciamiento.click();
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar el link Propuesta Financiamiento:" + error.getMessage());
        }
    }

    public void ClickInformeVisita() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeVisita));
            lnk_InformeVisita.click();
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar el link informe visita" + error.getMessage());
        }
    }

    public void ClickHojaTrabajo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_HojaTrabajo));
            lnk_HojaTrabajo.click();
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar link Hoja de Trabajo" + error.getMessage());
        }
    }

    public void ClickInformeComercial() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeComercial));
            lnk_InformeComercial.click();
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar el link Informe Comercial" + error.getMessage());
        }
    }

    public void ClickCerrarSesion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_CerrarSesion));
            lnk_CerrarSesion.click();
            objFuncionEsperar.EsperarTiempo(30);
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar el link Cerrar Sesion:" + error.getMessage());
        }
    }
}