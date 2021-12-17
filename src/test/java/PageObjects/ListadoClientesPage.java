package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import io.cucumber.java.tr.Ve;
import org.openqa.selenium.*;
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
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)") private WebElement tab_Codigo;
    @FindBy(xpath = "//*[@id=\"valorCodigo\"]") private WebElement txt_Codigo;
    @FindBy(css = "#form2 > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)")
    private WebElement btn_Buscar;
    @FindBy(xpath = "//table[3]/tbody/tr/td/div/button[1]") private WebElement btn_Regresar;
    @FindBy(xpath = "//img[@alt='Ver Informes de Visitas']") private WebElement icn_VerInformeVisita;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td/div[2]/form/table/tbody/tr[1]/td[2]/input") private WebElement txt_CodigoClienteInformeVisita;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td/div[2]/form/table/tbody/tr[2]/td/button[1]")
    private WebElement btn_BuscarCodigoClienteInforme;


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
            objFuncionEsperar.EsperarTiempo(1);
            icn_nuevaPropuesta.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar icono propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
            btn_Regresar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Regresar";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void IngresarCodigoClienteInformeVisita(String CodigoClienteInformeVisita){
        try {
            txt_CodigoClienteInformeVisita.clear();
            txt_CodigoClienteInformeVisita.sendKeys(CodigoClienteInformeVisita);
        }catch (Exception Error){
            detalleError= "Error al ingresar el codigo de cliente para crear informe de visita";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnBuscarCodigoClienteInformeVisita(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_BuscarCodigoClienteInforme));
            btn_BuscarCodigoClienteInforme.click();
        }catch (Exception Error){
            detalleError = "Error al seleccionar el boton buscar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarVerInformeVisita(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(icn_VerInformeVisita));
            icn_VerInformeVisita.click();
        }catch (Exception Error){
            detalleError= "Error al seleccionar icono ver informe propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public static void cambiarventana(WebDriver driver) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
                    }
    }
    public void CerrarVentanaEmergente(WebDriver driver) {
        cambiarventana(driver);
        driver.get("10.0.13.245:58081/SCORING-war/login/login_1.xhtml?user=ALPAMA&pass=xvPoDst4tzBM44p6ZCYa4w==4Bg7kOdwu0bwmVRDOz1/EA==f1db3cf7e21e3105cdeef852");
        driver.close();
        }

    }



