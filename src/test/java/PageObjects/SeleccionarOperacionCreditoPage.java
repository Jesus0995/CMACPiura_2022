package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class SeleccionarOperacionCreditoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresSeleccionarOP;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    //mapear elementos
    //@FindBy(xpath = "//button[@type='submit']") private WebElement btn_aceptar;

    public void AbrirVentanaSeleccionarOP(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error abrir ventana Seleccionar Operación Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaSeleccionarOP(){
        try {
            System.out.println(driver.getWindowHandles());
            //objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
            /*Integer SetSize = identificadoresSeleccionarOP.size();
            Integer Index=0;
            String[] Handles = new String[SetSize] ;
            for (String identificadorSeleccionarOP : identificadoresSeleccionarOP) {
                Handles[Index] = identificadorSeleccionarOP;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);*/
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Seleccionar Operacion Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    //constructor
    public SeleccionarOperacionCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,50);
        PageFactory.initElements(driver,this);

    }
    public void ValidarVentanaOP(){
        try {
            System.out.println("Handles :" + driver.getWindowHandle());
            System.out.println("Title :" + driver.getTitle());
            WebElement btn_Aceptar = driver.findElement(By.xpath("//button[@type='submit']"));
            btn_Aceptar.click();
            objFuncionEsperar.EsperarTiempo(11);
        } catch (Exception Error) {
            detalleError = "Error al validar ventana Seleccionar Operación Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

}

            /*identificadoresSeleccionarOP = driver.getWindowHandles();
            System.out.println(identificadoresSeleccionarOP);
            String LastHandle ="";

            for (String identificadorSeleccionarOP :identificadoresSeleccionarOP ){
                LastHandle = identificadorSeleccionarOP;
            }
            driver.switchTo().window(LastHandle);
            objFuncionEsperar.EsperarTiempo(3);*/