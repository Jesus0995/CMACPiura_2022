package PageObjects;

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

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_Observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_Password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Procesar;



    public void AbrirVentanaAprobarDictamenPropuesta(){
        Esperar(2);
        identificadoresAprobarDictamenPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresAprobarDictamenPropuesta);
        String LastHandle ="";

        for (String identificadorAprobarDictamenPropuesta :identificadoresAprobarDictamenPropuesta ){
            LastHandle = identificadorAprobarDictamenPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Ultimo Handle :" + driver.getWindowHandle() +driver.getTitle());
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
        System.out.println("Handle Inicial:"+Handles[0]+"-"+driver.getTitle());
    }

    public AprobarDictamenPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void IngresarObservaciones(String Observaciones){
        txt_Observaciones.clear();
        Esperar(1);
        txt_Observaciones.sendKeys(Observaciones);
        Esperar(2);
    }

    public void IngresarContrasena(String Contrasena){
        txt_Password.clear();
        Esperar(1);
        txt_Password.sendKeys(Contrasena);
        Esperar(2);
    }

    public void ClickbtnProcesar(){
        //wait.until(ExpectedConditions.elementToBeClickable(btn_procesar));
        System.out.println("Esperar el inicio de procesar");
        Esperar(2);
        WebElement Procesar = driver.findElement(By.xpath("//button[@type='submit']"));
        Procesar.click();
        System.out.println("Esperar el fin de procesar");
        for (int i = 0; i <= 60; i += 1) {
            if (driver.getWindowHandles().size() > 1) {
                Esperar(1);
                System.out.println("Esperando cierre de handle"+driver.getTitle()+" - "+i);
                System.out.println(driver.getWindowHandles());
            } else {
                i = 61;
            }
        }
        System.out.println("Despues de esperar muchos segundos");
    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos*1000;
        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
