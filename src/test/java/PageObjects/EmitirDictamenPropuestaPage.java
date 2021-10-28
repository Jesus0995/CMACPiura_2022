package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class EmitirDictamenPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEmitirDictamenPropuesta;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_procesar;
    @FindBy(xpath = "//button[@type='button']") private WebElement btn_cancelar;

    public void AbrirVentanaEmitirDictamenPropuesta(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Emitir Dictamen Propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaEmitirDictamenPropuesta(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Emitir Dictamen Propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public EmitirDictamenPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }


    public void IngresarObservaciones(String Observaciones){
        try {
            txt_observaciones.clear();
            txt_observaciones.sendKeys(Observaciones);
        } catch (Exception Error) {
            detalleError = "Error al ingresar Observaciones";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
