package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class ListadoHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //mapear locator
    @FindBy(xpath = "//td[@id='tab-bg:1']")
    private WebElement tab_codigo;
    @FindBy(xpath = "//div[@id='tab-body:1']//input[@type='text']")
    private WebElement txt_codigo;
    @FindBy(css = "#tab-body\\:1 > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)")
    private WebElement btn_buscar;
    @FindBy(xpath = "//img[@alt='Ver Hoja de Trabajo']")
    private WebElement icn_hojaTrabajo;
    @FindBy(xpath = "")
    private WebElement btn_regresar;


    public ListadoHojaTrabajoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void SeleccionarTabCodigo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(tab_codigo));
            tab_codigo.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar tab codigo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarCodigoCliente(String CodCliente) {
        try {
            txt_codigo.clear();
            txt_codigo.sendKeys(CodCliente);
        } catch (Exception Error) {
            detalleError = "Error al ingresar codigo cliente";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBuscarCliente() {
        try {
            btn_buscar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton buscar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarIconoHojaTrabajo() {
        try {
            icn_hojaTrabajo.click();
        } catch (Exception Error) {
            detalleError = "Error el icono hoja de trabajo";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
