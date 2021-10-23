package PageObjects;

import Functions.funcionExcepciones;
import Functions.funcionEsperar;
import Functions.funcionVentana;
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
    private String detalleError = new String();

    //mapeo de objetos
    @FindBy(xpath ="//select[@name='servicio']")
    private WebElement cbx_Servicio;
    @FindBy(xpath ="//select[@name='idServicioSofia']")
    private WebElement cbx_ServicioCredito;
    @FindBy(xpath ="//select[@name='idTipoPropuesta']")
    private WebElement cbx_TipoPropuesta;
    @FindBy(xpath ="//select[@name='idSubTipoPropuesta']")
    private WebElement cbx_SubTipoPropuesta;
    @FindBy(xpath ="//select[@name='idPromocion']")
    private WebElement cbx_Promocion;
    //@FindBy(xpath = "//select[@name='idnegocio']") private WebElement cbx_Negocio;
    //@FindBy(xpath = "//select[@name='idTipoOperacion']") private  WebElement cbx_TipoOperacion;
    @FindBy(xpath ="//*[@id=\"bCargar\"]")
    private WebElement btn_Cargar;

    public void AbrirVentanaServicio() {

        try {
            identificadoresServicio = driver.getWindowHandles();
            System.out.println(identificadoresServicio);
            String LastHandle = "";

            for (String identificadorservicio : identificadoresServicio) {
                LastHandle = identificadorservicio;
            }
            driver.switchTo().window(LastHandle);
        } catch (Exception Error) {
            detalleError = "La ventana servicio tiene los siguientes errores";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaServicio() {
        //Actions Acciones = new Actions(driver);
        try {
            Integer SetSize = identificadoresServicio.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];

            for (String identificadorservicio : identificadoresServicio) {
                Handles[Index] = identificadorservicio;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);
        } catch (Exception Error) {
            Error.printStackTrace();
            System.out.println("Al cerrar la ventana tiene el siguiente error" + Error.getMessage());
        }
    }

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 120);
        PageFactory.initElements(driver, this);

    }

    public void SeleccionarServicio(String TipoServicio) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Servicio));
            new Select(cbx_Servicio).selectByVisibleText(TipoServicio);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el tipo servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarServicioCredito(String ServicioCredito) {
        try {
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
            new Select(cbx_TipoPropuesta).selectByVisibleText(TipoPropuesta);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar tipo propuesta del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarSubTipoPropuesta(String SubTipoPropuesta) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_SubTipoPropuesta));
            new Select(cbx_SubTipoPropuesta).selectByVisibleText(SubTipoPropuesta);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar subtipopropuesta del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarPromocion(String Promocion) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Promocion));
            new Select(cbx_Promocion).selectByVisibleText(Promocion);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar promocion del servicio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnCargar() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cargar));
            btn_Cargar.click();
            Thread.sleep(10000);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el boton cargar";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
