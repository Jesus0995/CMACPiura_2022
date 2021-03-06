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

public class SeleccionarGarantiaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresGarantia;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();


    //mapeo objetos

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_RegistrarGarantia;

    public SeleccionarGarantiaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void AbrirVentanaGarantia() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana garantia";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void CerrarVentanaGarantia() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickRegistrarGarantia() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_RegistrarGarantia));
            btn_RegistrarGarantia.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton registrar garantia";
            objLogErrores.logError(detalleError, Error);
        }
    }


}
