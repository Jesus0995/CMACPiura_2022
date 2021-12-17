package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class ListadoPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //Mapear los locator
    @FindBy(name = "criterio")
    private WebElement cbx_Propuesta;
    @FindBy(name = "tipoBusqueda")
    private WebElement cbx_TipoPropuesta;
    @FindBy(name = "valorBuscado")
    private WebElement txt_ValorBuscado;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Buscar;
    @FindBy(xpath = "//button[@type='button' and contains(text(),'Crear nueva Propuesta')]")
    private WebElement btn_CrearPropuesta;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/div/button[2]")
    private WebElement btn_Regresar;
    @FindBy(xpath = "//select[@name='tipoBusqueda']")
    private WebElement cbx_BusquedaAprobacion;
    @FindBy(xpath = "//input[@name='valorBuscado']")
    private WebElement txt_NumeroPropuestaAprobacion;
    @FindBy(xpath = "//img[@alt='Editar']")
    private WebElement icn_Editar;

    public ListadoPropuestaPage(WebDriver d) {
        //Iniciar las variables
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    //crear metodo para dar click a crear propuesta
    public void ClickBtnCrearPropuesta() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_CrearPropuesta));
            btn_CrearPropuesta.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton crear propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresar() {
        try {
            System.out.println("Inicio click regresar");
            System.out.println("Ventanas activas: " + driver.getWindowHandles());
            System.out.println("Ventana actual " + driver.getWindowHandle() + " - " + driver.getTitle());

            wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
            btn_Regresar.click();
            objFuncionEsperar.EsperarTiempo(2);
            System.out.println("Fin regresar");
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton regresar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickTipoBusquedaAprobacion() {
        try {
            Select TipoBusquedaAprobacion = new Select(cbx_BusquedaAprobacion);
            TipoBusquedaAprobacion.selectByVisibleText("NUMERO PROPUESTA");
        } catch (Exception Error) {
            detalleError = "Error al seleccionar la opcion numero de propuesta";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void IngresarNumeroPropuesta(String NumeroPropuesta) {
        try {
            txt_NumeroPropuestaAprobacion.clear();
            txt_NumeroPropuestaAprobacion.sendKeys(NumeroPropuesta);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el numero de propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickBtnBuscar() {
        try {
            btn_Buscar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton buscar ";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEditarPropuesta() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(icn_Editar));
            icn_Editar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el icono crear propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
