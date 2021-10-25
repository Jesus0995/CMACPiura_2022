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

import java.util.Set;

public class InformeVisita_SeleccionarRubroNegocioPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRubroNegocio;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_cargar;

    public InformeVisita_SeleccionarRubroNegocioPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void AbrirVentanaRubroNegocio() {
        try {
            identificadoresRubroNegocio = driver.getWindowHandles();
            System.out.println(identificadoresRubroNegocio);
            String LastHandle = "";

            for (String identificadorRubroNegocio : identificadoresRubroNegocio) {
                LastHandle = identificadorRubroNegocio;
            }
            driver.switchTo().window(LastHandle);
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana rubro negocio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaRubroNegocio() {
        try {
            Integer SetSize = identificadoresRubroNegocio.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];

            for (String identificadorRubroNegocio : identificadoresRubroNegocio) {
                Handles[Index] = identificadorRubroNegocio;
                Index++;
            }
            driver.switchTo().window(Handles[0]);
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventan principal";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnCargar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_cargar));
            btn_cargar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton cargar";
            objLogErrores.logError(detalleError, Error);
        }
    }
}