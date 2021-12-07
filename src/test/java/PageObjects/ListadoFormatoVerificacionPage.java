package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;
import Functions.funcionExcepciones;

public class ListadoFormatoVerificacionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();
    @FindBy(xpath = "/html/body/table[3]/tbody/tr/td/div[1]/form/table/tbody/tr[2]/td/button[1]") private WebElement btn_Buscar;
    @FindBy(xpath = "/html/body/form/p/b/button[1]") private WebElement btn_IngresarNuevoFormato;
    @FindBy(xpath = "/html/body/form/table/tbody/tr[22]/td/button") private WebElement btn_Regresar;

    public ListadoFormatoVerificacionPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickBtnBuscar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Buscar));
            btn_Buscar.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton buscar";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void ClickBtnIngresarNuevoFormato() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_IngresarNuevoFormato));
            btn_IngresarNuevoFormato.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton ingresar nuevo formato";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void ClickBtnRegresar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
            btn_Regresar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton regresar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
