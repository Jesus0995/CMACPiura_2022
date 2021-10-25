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

public class MensajeActualizacionEEFFPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy(xpath = "//button[@type=\"button\"]")
    private WebElement btn_cerrar;

    public MensajeActualizacionEEFFPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnCerrar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_cerrar));
            btn_cerrar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton cerrar";
            objLogErrores.logError(detalleError, Error);
        }
    }


}
