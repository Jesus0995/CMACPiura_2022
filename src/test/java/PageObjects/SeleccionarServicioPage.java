package PageObjects;

import Functions.funcionExcepciones;
import Functions.funcionEsperar;
import Functions.funcionVentana;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class SeleccionarServicioPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresServicio;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private String detalleError;

    //mapeo de objetos
    @FindBy(xpath ="//select[@name='servicio']") private WebElement cbx_Servicio;
    @FindBy(xpath ="//select[@name='idServicioSofia']") private WebElement cbx_ServicioCredito;
    @FindBy(xpath ="//select[@name='idTipoPropuesta']") private WebElement cbx_TipoPropuesta;
    @FindBy(xpath ="//select[@name='idSubTipoPropuesta']") private WebElement cbx_SubTipoPropuesta;
    @FindBy(xpath ="//select[@name='idPromocion']") private WebElement cbx_Promocion;
    //@FindBy(xpath = "//select[@name='idnegocio']") private WebElement cbx_Negocio;
    @FindBy(xpath = "//select[@name='idTipoOperacion']") private  WebElement cbx_TipoOperacion;
    @FindBy(xpath ="//*[@id=\"bCargar\"]") private WebElement btn_Cargar;
    @FindBy(xpath = "/html/body/form/table/tbody/tr[9]/td[2]/button[1]") private WebElement btn_Seleccionar;
    @FindBy(id = "idPagare") private WebElement cbx_Pagare;


    public void AbrirVentanaServicio() {

        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Al abrir ventana servicio se presenta los siguientes errores";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaServicio() {
        //Actions Acciones = new Actions(driver);
        try {
            System.out.println(driver.getWindowHandles());
           // objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Al cerrar ventana servicio se presenta los siguientes errores";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void SeleccionarServicio(String TipoServicio) {
        try {
            objFuncionEsperar.EsperarTiempo(1);
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Servicio));
            new Select(cbx_Servicio).selectByVisibleText(TipoServicio);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el tipo servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarServicioCredito(String ServicioCredito) {
        try {
            objFuncionEsperar.EsperarTiempo(1);
            wait.until(ExpectedConditions.elementToBeClickable(cbx_ServicioCredito));
            new Select(cbx_ServicioCredito).selectByVisibleText(ServicioCredito);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar servicio de credito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarTipoPropuesta(String TipoPropuesta) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_TipoPropuesta));
            objFuncionEsperar.EsperarTiempo(1);
            new Select(cbx_TipoPropuesta).selectByVisibleText(TipoPropuesta);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar tipo propuesta del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarSubTipoPropuesta(String SubTipoPropuesta) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_SubTipoPropuesta));
            objFuncionEsperar.EsperarTiempo(1);
            new Select(cbx_SubTipoPropuesta).selectByVisibleText(SubTipoPropuesta);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar subtipopropuesta del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarPromocion(String Promocion) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Promocion));
            objFuncionEsperar.EsperarTiempo(2);
            new Select(cbx_Promocion).selectByVisibleText(Promocion);
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar promocion del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarTipoOperacion(String TipoOperacion){
        try {
            objFuncionEsperar.EsperarTiempo(1);
            wait.until(ExpectedConditions.elementToBeClickable(cbx_TipoOperacion));
            new Select(cbx_TipoOperacion).selectByVisibleText(TipoOperacion);
        }catch (Exception Error){
            detalleError = "Error al seleccionar el tipo de operacion";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void AbrirOpcionesPagare(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Pagare));
            cbx_Pagare.click();
        }catch (Exception Error){
            detalleError = "Error al desglosar las opciones del combo Pagar??";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarPagare(String Pagare){
        try {
            objFuncionEsperar.EsperarTiempo(3);
            WebElement opcionPagare = driver.findElement(By.xpath("//select[@id='idPagare']//option[text()='"+Pagare+"']"));
            opcionPagare.click();
            objFuncionEsperar.EsperarTiempo(3);

        }catch (Exception Error){
            detalleError = "Error al seleccionar el pagare";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnSeleccionarPagare(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Seleccionar));
            objFuncionEsperar.EsperarTiempo(1);
            btn_Seleccionar.click();
            objFuncionEsperar.EsperarTiempo(1);
        }catch (Exception Error){
            detalleError = "Error al hacer click en el bot??n seleccionar pagare";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnCargar()  {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cargar));
            btn_Cargar.click();
            objFuncionEsperar.EsperarTiempo(10); //Cambiar el tiempo de espera
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el boton cargar";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
