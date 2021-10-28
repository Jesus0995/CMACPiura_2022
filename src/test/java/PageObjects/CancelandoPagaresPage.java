package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CancelandoPagaresPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCancelandoPagares;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;

    public void AbrirVentanaCancelandoPagares(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error en abrir ventana de pagares";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaCancelandoPagares(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana de pagares";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public CancelandoPagaresPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
}
