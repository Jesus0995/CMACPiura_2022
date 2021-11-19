package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionVentana;
import Functions.funcionExcepciones;
import Functions.funcionEsperar;

public class CondicionesRefinanciarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionExcepciones objLogErrores;
    private funcionVentana objFuncionVentana;
    private funcionEsperar objFuncionEsperar;
    private String detalleError;
    private String ventanaUltima;


    @FindBy(name = "montoAmortizar") private WebElement txt_MontoAmortizar;
    @FindBy(name="interesRefinanciar")private WebElement txt_InteresRefinanciar;
    @FindBy(id="grabar")private WebElement btn_Grabar;

    public void AbrirVentanaCondicionRefinanciar() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();

        }catch (Exception Error){
            detalleError = "Error al abrir ventana condicion refinanciar";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void CerrarVentanaCondicionRefinanciar() {
        try{
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin Cerrar Ventana");
        }catch (Exception Error){
            detalleError = "Error al cerrar ventana condicion refinanciar";
            objLogErrores.logError(detalleError,Error);
        }

    }


    public CondicionesRefinanciarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);


    }


    public void IngresarMontoAmortizar(String MontoAmortizar){
        try {
            txt_MontoAmortizar.clear();
            txt_MontoAmortizar.sendKeys(MontoAmortizar);

        }catch (Exception Error){
            detalleError = "Error al ingresar monto amortizar";
            objLogErrores.logError(detalleError,Error);

        }

    }

    public void IngresarInteresRefinanciar(String InteresRefinanciar){
        try {
            txt_InteresRefinanciar.clear();
            txt_InteresRefinanciar.sendKeys(InteresRefinanciar);
        }catch (Exception Error){
            detalleError = "Error al ingresar interes a refinanciar";
            objLogErrores.logError(detalleError,Error);

        }

    }

    public void ClickBtnGrabar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();

        }catch (Exception Error){
            detalleError = "Error al seleccionar el boton grabar";
            objLogErrores.logError(detalleError,Error);

        }
    }


}
