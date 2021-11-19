package PageObjects;

import Definitions.Hooks;
import Functions.funcionExcepciones;
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
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;


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

    @FindBy(linkText = "") private WebElement lnk_InformeVisitaVerificacion;

    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td/div[2]/form/table/tbody/tr[2]/td/button[1]")private  WebElement btn_Buscar;
    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td/div[2]/form/table/tbody/tr[2]/td/button[2]")private  WebElement btn_Cancelar;
    @FindBy(xpath = "/html/body/form/p/b/button[1]") private WebElement btn_IngresarNuevoFormato;

    /*
    btn_Buscar;
    lbl_Titulo;
    opt_Nuevo;
    rdn_Nuevo;
    chk_Nuevo;
    txt_Usuario;
*/


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
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el link Propuesta Financiamiento";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickInformeVisita() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeVisita));
            lnk_InformeVisita.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el link informe visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickHojaTrabajo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_HojaTrabajo));
            lnk_HojaTrabajo.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar link Hoja de Trabajo";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void ClickInformeComercial() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_InformeComercial));
            lnk_InformeComercial.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el link Informe Comercial";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void ClickBtnCerrarSesion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lnk_CerrarSesion));
            lnk_CerrarSesion.click();
            objFuncionEsperar.EsperarTiempo(30);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el link Cerrar Sesion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaEmergente(){
      driver.getWindowHandles();
      for w in driver.getWindowHandles(1);
      driver.switchTo(w);
      driver.close();
      driver.switchTo().window(w).getWindowHandles(0);

    }



}