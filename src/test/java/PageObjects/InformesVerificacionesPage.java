package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.funcionExcepciones;
import Functions.funcionEsperar;

public class InformesVerificacionesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private String detalleError = new String();

    @FindBy(xpath = "//*[text()=\"Crear Informe Verificación\"]") private WebElement btn_CrearInformeVerificacion;

    public InformesVerificacionesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickBtnCrearInformeVerificacion(){
        try {
        objFuncionEsperar.EsperarTiempo(1);
        wait.until(ExpectedConditions.elementToBeClickable(btn_CrearInformeVerificacion));
        btn_CrearInformeVerificacion.click();
        objFuncionEsperar.EsperarTiempo(2);
        }catch (Exception Error){
            detalleError= "Error al seleccionar el boton crear informe verificacion";
            objLogErrores.logError(detalleError,Error);
        }

    }

}
