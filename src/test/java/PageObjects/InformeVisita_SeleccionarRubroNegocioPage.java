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

public class InformeVisita_SeleccionarRubroNegocioPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRubroNegocio;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String VentanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_cargar;

    public InformeVisita_SeleccionarRubroNegocioPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void AbrirVentanaRubroNegocio(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            VentanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Rubro Negocio";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaRubroNegocio(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarCierreVentana(VentanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Rubro Negocio";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnCargar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_cargar));
            btn_cargar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Cargar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}