package PageObjects;

import Functions.funcionEsperar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class AprobarDictamenPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresAprobarDictamenPropuesta;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_Observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_Password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Procesar;



    public void AbrirVentanaAprobarDictamenPropuesta(){
        objFuncionEsperar.EsperarTiempo(2);
        identificadoresAprobarDictamenPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresAprobarDictamenPropuesta);
        String LastHandle ="";

        for (String identificadorAprobarDictamenPropuesta :identificadoresAprobarDictamenPropuesta ){
            LastHandle = identificadorAprobarDictamenPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Título última ventana: " + driver.getWindowHandle() +driver.getTitle());
    }

    public void CerrarVentanaAprobarDictamenPropuesta(){

        Integer SetSize = identificadoresAprobarDictamenPropuesta.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorAprobarDictamenPropuesta : identificadoresAprobarDictamenPropuesta) {
            Handles[Index] = identificadorAprobarDictamenPropuesta;
            Index++;
        }
        driver.switchTo().window(Handles[0]);
        System.out.println("Ventana principal:"+Handles[0]+"-"+driver.getTitle());
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

        } catch (Exception error){
            error.printStackTrace();
            System.out.println("Error al ingresar observaciones en el dictamen" +error.getMessage());
        }

    }

    public void IngresarContrasena(String Contrasena){
        txt_Password.clear();
        objFuncionEsperar.EsperarTiempo(1);
        txt_Password.sendKeys(Contrasena);
        objFuncionEsperar.EsperarTiempo(2);
    }

    public void ClickBtnProcesar(){
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
    }

}
