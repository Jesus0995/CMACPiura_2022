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

public class ConfirmarSegurosSeleccionadosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresConfirmacionSeguros;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_Cerrar;


    public void AbrirVentanaConfirmacionSeguros(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error en abrir ventana Confirmar Seguros";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }


    public void CerrarVentanaConfirmacionSeguros()  {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana Confirmar Seguros";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public ConfirmarSegurosSeleccionadosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickBtnCerrar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();
        } catch (Exception Error) {
            detalleError = "Error en botón cerrar";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
