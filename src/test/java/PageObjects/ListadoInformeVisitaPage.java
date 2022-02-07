package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListadoInformeVisitaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //mapear locator
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)")
    private WebElement tab_codigo;
    @FindBy(css = "#tab-body\\:1 > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input")
    private WebElement txt_codigo;
    @FindBy(css = "#tab-body\\:1 > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)")
    private WebElement btn_buscar;


    public ListadoInformeVisitaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }


    public void SeleccionarTabCodigo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(tab_codigo));
            tab_codigo.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el tab codigo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarCodigoCliente(String CodCliente) {
        try {
            txt_codigo.clear();
            txt_codigo.sendKeys(CodCliente);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el codigo del cliente";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBuscarCliente() {
        try {
            btn_buscar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton buscar cliente";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarIconoInformeVisita() {
        try {
            WebElement icn_informeVisita = driver.findElement(By.xpath("//img[@alt='Ver Informes de Visitas']"));
            System.out.println(icn_informeVisita);
            icn_informeVisita.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el icono informe de visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarIconoInformeComercial() {
        try {
            WebElement icn_informeComercial = driver.findElement(By.xpath("//img[@alt='Ver Informes Comerciales']"));
            System.out.println(icn_informeComercial);
            icn_informeComercial.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el icono informe comercial";
            objLogErrores.logError(detalleError, Error);
        }
    }
}
