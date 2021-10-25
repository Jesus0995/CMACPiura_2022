package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class ListadoClientesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //mapear locator
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)")
    private WebElement tab_Codigo;
    @FindBy(xpath = "//*[@id=\"valorCodigo\"]")
    private WebElement txt_Codigo;
    @FindBy(css = "#form2 > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)")
    private WebElement btn_Buscar;


    public ListadoClientesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public void SeleccionarTabCodigo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(tab_Codigo));
            tab_Codigo.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar tab codigo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarCodigoCliente(String CodCliente) {
        try {
            txt_Codigo.clear();
            txt_Codigo.sendKeys(CodCliente);
        } catch (Exception Error) {
            detalleError = "Error al ingresar codigo cliente";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBuscarCliente() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Buscar));
            btn_Buscar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton buscar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarIconoPropuesta() {
        try {
            WebElement icn_nuevaPropuesta = driver.findElement(By.xpath("//img[@alt='Nueva Propuesta']"));
            icn_nuevaPropuesta.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar icono propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }
}
