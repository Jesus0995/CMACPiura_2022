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

public class EnlazarInformeComercialNuevoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarInformeComercialNuevo;
    private  funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Realizar;


    public void AbrirVentanaEnlazarInformeComercialNuevo() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error abrir ventana Enlazar Informe Comercial";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaEnlazarInformeComercialNuevo() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error cerrar ventana Enlazar Informe Comercial";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public EnlazarInformeComercialNuevoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickBtnRealizar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Realizar));
            btn_Realizar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Realizar enlace del informe comercial nuevo";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
