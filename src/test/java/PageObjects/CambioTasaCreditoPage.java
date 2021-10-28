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
import java.util.Set;

public class CambioTasaCreditoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCambioTasaCredito;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;

    @FindBy(xpath = "//textarea[@name='txtTasaComentarioPropo']") private WebElement txt_Comentario;
    @FindBy(xpath = "//button[@name='btnCambio']") private WebElement btn_Grabar;


    public void AbrirVentanaCambioTasaCredito(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error en abrir ventana Cambio de tasa";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaCambioTasaCredito() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana cambio de tasa";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public CambioTasaCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void IngresarComentarioCambio(String ComentarioCambioTasa){
        try {
            txt_Comentario.clear();
            txt_Comentario.sendKeys(ComentarioCambioTasa);

        } catch (Exception Error) {
            detalleError = "Error en ingresar comentario";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public void ClickGrabar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();

        } catch (Exception Error) {
            detalleError = "Error en grabar cambio de tasa";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
