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

public class ConfirmacionChecklistPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> idenficadoresCheckList;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cerrar;

    public void AbrirVentanaConfirmacionCheckList(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarTiempo(5);
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error en abrir ventana confirmación Checklist";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaConfirmacionCheckList(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana Checklist";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }


    public ConfirmacionChecklistPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }


    public void ClickBtnCerrar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_cerrar));
            btn_cerrar.click();
            objFuncionEsperar.EsperarTiempo(3);

        } catch (Exception Error) {
            detalleError = "Error en boton cerrar";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
