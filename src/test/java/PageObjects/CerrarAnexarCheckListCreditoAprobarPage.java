package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class CerrarAnexarCheckListCreditoAprobarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identfCerrarAnexarCheckListAprobar;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type='button']") private WebElement btn_Cerrar; //cambió xpath

    public void AbrirVentanaCerrarAnexarCheckListAprobar(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Cerrar/Anexar Checklist";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaCerrarAnexarCheckListAprobar(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Cerrar/Anexar Checklist";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public CerrarAnexarCheckListCreditoAprobarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickBtnCerrar(){
        try {
            System.out.println("Click en el boton cerrar");
            System.out.println("Handles iniciales"+driver.getWindowHandles());
            Integer numeroHandles = driver.getWindowHandles().size();
            objFuncionEsperar.EsperarTiempo(5);
            btn_Cerrar.click();
            for (int i=0; i<=240;i+=1 ){
                if (driver.getWindowHandles().size()==numeroHandles){
                    objFuncionEsperar.EsperarTiempo(1);
                    System.out.println("Esperando cierre de handle:" +i);

                } else
                {
                    i=241;
                }
            }
            System.out.println("Handles final" + driver.getWindowHandles());
            System.out.println("fin del boton cerrar");

        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Cerrar";
            objLogErrores.logError(detalleError,Error);

        }
    }

}
