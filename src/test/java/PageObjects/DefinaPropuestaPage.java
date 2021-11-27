package PageObjects;

import org.apache.xalan.transformer.XalanProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;

public class DefinaPropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private String detalleError = new String();

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_Cargar;


    public void AbrirVentanaDefinaPropuesta() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana defina propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaDefinaPropuesta() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");

        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana defina propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }


    public DefinaPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnCargar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cargar));
            btn_Cargar.click();
            objFuncionEsperar.EsperarTiempo(1);
        }catch (Exception Error){
            detalleError= "Error la seleccionar el boton cargar";

        }


    }




    }






