package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeComercialNuevoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//input[@id='patrimoniopersonal']") private WebElement txt_patrimonio;
    @FindBy(xpath = "//input[@name='patrimoniopersonal']") private WebElement txt_PatrimonioComercial;
    @FindBy(xpath = "//img[@alt='Grabar']") private WebElement btn_grabar;
    @FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_regresar;

    ///html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a

    public InformeComercialNuevoPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void IngresarPatrimonio(String Patrimonio){
        try {
            txt_patrimonio.clear();
            txt_patrimonio.sendKeys(Patrimonio);
        } catch (Exception Error) {
            detalleError = "Error al ingresar monto del Patrimonio";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public  void IngresarPatrimonioComercial(String PatrimonioComercial){
        try {
            objFuncionEsperar.EsperarTiempo (6);
            txt_PatrimonioComercial.clear();
            txt_PatrimonioComercial.sendKeys(PatrimonioComercial);
        } catch (Exception Error) {
            detalleError = "Error al ingresar monto del Patrimonio";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnGrabar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
            btn_grabar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Grabar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnRegresar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
            btn_regresar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Regresar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
