package PageObjects;

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

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_procesar;



    public void AbrirVentanaAprobarDictamenPropuesta(){

        identificadoresAprobarDictamenPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresAprobarDictamenPropuesta);
        String LastHandle ="";

        for (String identificadorAprobarDictamenPropuesta :identificadoresAprobarDictamenPropuesta ){
            LastHandle = identificadorAprobarDictamenPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo :"+driver.getTitle());

    }

    public void CerrarVentanaAprobarDictamenPropuesta(){
        Integer SetSize = identificadoresAprobarDictamenPropuesta.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorAprobarDictamenPropuesta : identificadoresAprobarDictamenPropuesta) {
            Handles[Index] = identificadorAprobarDictamenPropuesta;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public AprobarDictamenPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);


    }


    public void IngresarObservaciones(String Observaciones){
        txt_observaciones.clear();
        txt_observaciones.sendKeys(Observaciones);
    }


    public void IngresarContrasena(String Contrasena){
        txt_password.clear();
        txt_password.sendKeys(Contrasena);
    }


    public void ClickbtnProcesar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_procesar));
        btn_procesar.click();
        Esperar(3);


    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos*1000;
        try {
            Thread.sleep(Segundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
