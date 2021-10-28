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

public class EnlazarInformeVisitaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarInformeVisita;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    //mapeop elementos
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Realizar;

    public void AbrirVentanaEnlazarInformeVisita(){
        try {
            objFuncionEsperar.EsperarTiempo(2);
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Enlazar Informe de Visita";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaEnlazarInformeVisita(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Enlazar Informe de Visita";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public EnlazarInformeVisitaPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickBtnRealizar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Realizar));
            btn_Realizar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Realizar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
