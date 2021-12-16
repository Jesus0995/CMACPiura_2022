package PageObjects;


import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GrabarInformacionDocumentoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    protected String mensajeDerivacion;



    @FindBy(xpath = "//button[@type='button']") private WebElement btn_Cerrar;
    @FindBy(xpath = "/html/body/p[1]") private WebElement lbl_MensajeDerivacion;



    public void AbrirVentanaGrabarPropuesta() {
        try {
            objFuncionEsperar.EsperarTiempo(5);
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Grabar Documento";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaGrabarPropuesta() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            objFuncionEsperar.EsperarTiempo(5);
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Grabar Documento";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public GrabarInformacionDocumentoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnCerrar() {
        try {
            String JScript = btn_Cerrar.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(5);
        } catch (Exception Error) {
            detalleError = "Error en el botón cerrar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnCerrarInformacion() {
        try {
            System.out.println("Click en boton cerrar");
            System.out.println("Ventanas actuales: " + driver.getWindowHandles()+driver.getTitle());

            Integer numeroHandles = driver.getWindowHandles().size();

            objFuncionEsperar.EsperarTiempo(2);
            btn_Cerrar.click();

            for (int i = 0; i <= 240; i += 1) {
                if (driver.getWindowHandles().size() == numeroHandles) {
                    objFuncionEsperar.EsperarTiempo(1);
                    System.out.println("Esperando la ejecución del boton cerrar " + i);
                } else {
                    i = 241;
                }
            }
            System.out.println("Ventana vigente: " + driver.getWindowHandles());
            System.out.println("Fin click en boton cerrar");

        } catch (Exception Error) {
            detalleError = "Error en el botón Cerrar Información";
            objLogErrores.logError(detalleError, Error);
        }
    }
    public void ClickBtnCerrarInformes() {

        try {
            System.out.println("Click en boton cerrar");
            System.out.println("Ventanas actuales: " + driver.getWindowHandles()+driver.getTitle());

            Integer numeroHandles = driver.getWindowHandles().size();

            objFuncionEsperar.EsperarTiempo(2);
            btn_Cerrar.click();

            for (int i = 0; i <= 120; i += 1) {
                if (driver.getWindowHandles().size() == numeroHandles) {
                    objFuncionEsperar.EsperarTiempo(1);
                    System.out.println("Esperando la ejecución del boton cerrar " + i);
                } else {
                    i = 121;
                }
            }
            System.out.println("Ventana vigente: " + driver.getWindowHandles());
            System.out.println("Fin click en boton cerrar");

        } catch (Exception Error) {
            detalleError = "Error en el botón Cerrar Información de informes";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public String CapturarMensajeDerivacion() {
        try {
            wait.until(ExpectedConditions.visibilityOf(lbl_MensajeDerivacion));
            mensajeDerivacion=lbl_MensajeDerivacion.getText();
            System.out.println("El mensaje es :" + mensajeDerivacion);

        } catch (Exception Error) {
            detalleError = "Error al capturar el mensaje de derivacion de documento";
            objLogErrores.logError(detalleError, Error);
        }

        return mensajeDerivacion;
    }


}
