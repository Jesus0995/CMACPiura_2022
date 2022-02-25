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

public class InformeVisita_InformePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy(xpath = "//td[@class='Invisible']//button[1]")
    private WebElement btn_crearVisita;
    @FindBy(xpath = "//td[@class='Invisible']//button[2]")
    private WebElement btn_regresar;
    @FindBy(xpath = "//td[@class='Invisible']//button[1]")
    private WebElement btn_regresarInformeComercial;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/div/table[2]/tbody/tr[8]/td/button")
    private WebElement btn_RegresarCE;

    public InformeVisita_InformePage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnCrear() {
        try {
            objFuncionEsperar.EsperarTiempo(2);
            btn_crearVisita.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton crear";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresar() {
        try {
            objFuncionEsperar.EsperarTiempo(1);//40
            wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
            btn_regresar.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton regresar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresarInformeComercial() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_regresarInformeComercial));
            btn_regresarInformeComercial.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton regresar informe comercial";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresarCE() {
        try {
            objFuncionEsperar.EsperarTiempo(60);
            wait.until(ExpectedConditions.elementToBeClickable(btn_RegresarCE));
            btn_RegresarCE.click();

        } catch (Exception Error) {
            detalleError = "";
            objLogErrores.logError(detalleError, Error);
        }
    }
}