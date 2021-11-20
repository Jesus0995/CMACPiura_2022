package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionExcepciones;
import Functions.funcionVentana;

public class SeleccionarClientesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String detalleError;
    private String ventanaUltima;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_Consultar;


    public void AbrirVentanaSeleccionarClientes() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir la ventana Seleccionar clientes";
            objLogErrores.logError(detalleError, Error);

        }
    }
    public void CerrarVentanaSeleccionarClientes(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin Cerrar Ventana");

        }catch (Exception Error){
            detalleError = "Error al cerrar ventana seleccionar clientes";
            objLogErrores.logError(detalleError,Error);

        }

    }

    public SeleccionarClientesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickBtnConsultar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Consultar));
            btn_Consultar.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton consultar";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
