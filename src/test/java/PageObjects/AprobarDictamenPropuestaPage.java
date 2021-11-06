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

public class AprobarDictamenPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresAprobarDictamenPropuesta;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_Observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_Password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Procesar;

    public void AbrirVentanaAprobarDictamenPropuesta(){
        try {
            objFuncionEsperar.EsperarTiempo(2);
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Aprobar Dictamen de Propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaAprobarDictamenPropuesta(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Aprobar Dictamen de Propuesta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public AprobarDictamenPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void IngresarObservaciones(String Observaciones){
        try{
            txt_Observaciones.clear();
            objFuncionEsperar.EsperarTiempo(1);
            txt_Observaciones.sendKeys(Observaciones);
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error){
            detalleError = "Error al ingresar observaciones en el dictamen";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarContrasena(String Contrasena){
        try {
            txt_Password.clear();
            objFuncionEsperar.EsperarTiempo(1);
            txt_Password.sendKeys(Contrasena);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al ingresar contraseña del asesor";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnProcesar(){
        try {
            //wait.until(ExpectedConditions.elementToBeClickable(btn_procesar));
            System.out.println("Inicio click boton procesar dictamen");
            objFuncionEsperar.EsperarTiempo(2);
            WebElement Procesar = driver.findElement(By.xpath("//button[@type='submit']"));
            Procesar.click();
            System.out.println("Esperar el fin de procesar");

            for (int i = 0; i <= 60; i += 1) {
                if (driver.getWindowHandles().size() > 1) {
                    objFuncionEsperar.EsperarTiempo(1);
                    System.out.println("Esperando cierre de la ventana "+driver.getTitle()+" - "+i);
                    System.out.println(driver.getWindowHandles());
                } else {
                    i = 61;
                }
            }
            System.out.println("Fin click boton procesar dictamen");
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Procesar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
