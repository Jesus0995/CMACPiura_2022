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


public class EnlazarEvaluacionEconomicaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarEvaluacionEconomica;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Realizar;

    public void AbrirVentanaEvaluacionEconomica(){
        try {
            objFuncionEsperar.EsperarTiempo(5);
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error abrir ventana Evaluación Económica";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaEvaluacionEconomica(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error cerrar ventana Evaluación Económica";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public EnlazarEvaluacionEconomicaPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void ClickBtnRealizar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Realizar));
            objFuncionEsperar.EsperarTiempo(2);
            btn_Realizar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Realizar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
