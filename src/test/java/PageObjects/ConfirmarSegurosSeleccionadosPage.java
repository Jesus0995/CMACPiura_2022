package PageObjects;

import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ConfirmarSegurosSeleccionadosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresConfirmacionSeguros;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_Cerrar;


    public void AbrirVentanaConfirmacionSeguros(){
        try {
            identificadoresConfirmacionSeguros = driver.getWindowHandles();
            System.out.println(identificadoresConfirmacionSeguros);
            String LastHandle = "";

            for (String identificadorConfirmacionSeguros : identificadoresConfirmacionSeguros){
                LastHandle = identificadorConfirmacionSeguros;
            }
            driver.switchTo().window(LastHandle);
            System.out.println("Titulo:"+ driver.getTitle());

        } catch (Exception Error) {
            detalleError = "Error en abrir ventana Confirmar Seguros";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }


    public void CerrarVentanaConfirmacionSeguros()  {
        try {
            Integer SetSize = identificadoresConfirmacionSeguros.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];
            for (String identificadorConfirmacionSeguros : identificadoresConfirmacionSeguros) {
                Handles[Index] = identificadorConfirmacionSeguros;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana Confirmar Seguros";
            objFuncionExcepciones.logError(detalleError,Error);
        }

    }

    public ConfirmarSegurosSeleccionadosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickBtnCerrar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();

        } catch (Exception Error) {
            detalleError = "Error en botón cerrar";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
