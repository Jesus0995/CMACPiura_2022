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

public class EnlazarEstadosFinancierosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarEstadosFinancieros;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    //mapeo elementos
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Enlazar;

    public void AbrirVentanaEnlazarEstadosFinancieros() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Enalazar Estados Financieros";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaEnlazarEstadosFinancieros() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Enalazar Estados Financieros";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public EnlazarEstadosFinancierosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickbtnEnlazar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Enlazar));
            btn_Enlazar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Enlazar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
