package PageObjects;

import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;

import java.util.Set;

public class AprobarCheckListCreditoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identfAnexarCheckListAprobar;
    private funcionEsperar objFuncionEsperar =  new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//*[@value=\"2\"]")
    private WebElement opt_Aprobar;
    @FindBy(xpath = "//*[@name=\"comRevisionCheck\"]")
    private WebElement txt_Comentarios;
    @FindBy(xpath = "//*[@name=\"idSave\"]")
    private WebElement btn_Guardar;
    @FindBy(xpath = "/html/body/fieldset/form/table/tbody/tr[2]/td/button")
    private WebElement btn_Cerrar;

    public void AbrirVentanaAprobarCheckListCredito() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Aprobar CheckList Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaAprobarCheckListCredito() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Aprobar CheckList Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public AprobarCheckListCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);


    }

    public void SeleccionarOptAprobar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_Aprobar));
            opt_Aprobar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar la Opcion Aprobar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarComentarios() {
        try {
            txt_Comentarios.clear();
            txt_Comentarios.sendKeys("Se aprueba el checklist");
        } catch (Exception Error) {
            detalleError = "Error al ingresar Comentarios";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnGuardar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Guardar));
            btn_Guardar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Guardar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnCerrar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Cerrar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
