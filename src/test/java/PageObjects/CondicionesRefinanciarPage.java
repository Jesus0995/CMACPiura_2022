package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionVentana;
import Functions.funcionExcepciones;
import Functions.funcionEsperar;

import java.util.Set;

public class CondicionesRefinanciarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCondicionRefinanciar;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private String ventanaUltima;
    private String detalleError;


    @FindBy(xpath = "//*[@id=\"monto_amortizar\"]")
    private WebElement txt_MontoAmortizar;
    @FindBy(xpath = "//*[@id=\"interes_refinanciar\"]")
    private WebElement txt_InteresRefinanciar;
    @FindBy(id = "grabar")
    private WebElement btn_Grabar;

    public void AbrirVentanaCondicionRefinanciar() {
        try {
            identificadoresCondicionRefinanciar = driver.getWindowHandles();
            System.out.println(identificadoresCondicionRefinanciar);
            String LastHandle = "";

            for (String identificadorCondicionRefinanciar : identificadoresCondicionRefinanciar) {
                LastHandle = identificadorCondicionRefinanciar;

            }
            driver.switchTo().window(LastHandle);
            System.out.println("Titulo : " + driver.getTitle());
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana garantia";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void CerrarVentanaCondicionRefinanciar() {
        try {
            Integer SetSize = identificadoresCondicionRefinanciar.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];

            for (String identificadorCondicionRefinanciar : identificadoresCondicionRefinanciar) {
                Handles[Index] = identificadorCondicionRefinanciar;
                Index++;

            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public CondicionesRefinanciarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void IngresarMontoAmortizar(String MontoAmortizar) {
        try {
            txt_MontoAmortizar.sendKeys(Keys.CONTROL,"A");
            txt_MontoAmortizar.sendKeys(MontoAmortizar);

        } catch (Exception Error) {
            detalleError = "Error al ingresar monto amortizar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarInteresRefinanciar(String InteresRefinanciar) {
        try {

            txt_MontoAmortizar.sendKeys(Keys.CONTROL,"A");
            txt_InteresRefinanciar.sendKeys(InteresRefinanciar);
            } catch (Exception Error) {
            detalleError = "Error al ingresar interes a refinanciar";
            objLogErrores.logError(detalleError, Error);

        }

    }

    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton grabar";
            objLogErrores.logError(detalleError, Error);

        }
    }


}
