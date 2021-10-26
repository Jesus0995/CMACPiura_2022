package PageObjects;

import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrearHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;


    //mapear locator
    @FindBy(xpath = "//button[1]") private WebElement btn_crearHojaTrabajo;
    @FindBy(xpath = "//button[2]") private WebElement btn_regresarListado;

    public CrearHojaTrabajoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void CrearHojaTrabajo() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_crearHojaTrabajo));
            btn_crearHojaTrabajo.click();

        } catch (Exception Error) {
            detalleError = "Error en el botón para crear Hoja de Trabajo";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void RegresarListado(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_regresarListado));
            btn_regresarListado.click();

        } catch (Exception Error) {
            detalleError = "Error en el botón Regresar a Listado";
            objLogErrores.logError(detalleError,Error);
        }
    }

}