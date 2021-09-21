package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class GrabarDocumentoPropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresGrabarPropuesta;

    @FindBy(xpath = "//button[@type='button']") private WebElement btn_Cerrar;

    public void AbrirVentanaGrabarPropuesta(){

        Esperar(5);
        System.out.println(driver.getWindowHandles());
        identificadoresGrabarPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresGrabarPropuesta);
        String LastHandle ="";

        for (String identificadorGrabarPropuesta :identificadoresGrabarPropuesta ){
            LastHandle = identificadorGrabarPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo LastHandle: "+ driver.getWindowHandle() +" - "+driver.getTitle());


    }

    public void CerrarVentanaGrabarPropuesta(){
        System.out.println("Inicio cerrar ventana");
        for (int i = 0; i <=240; i+=1)
        {
            if(driver.getWindowHandles().size()>1){
                Esperar (1);
                System.out.println("Esperar el cierre de handle" +i);
            }
            else{
                i = 241;
            }

        }


        Integer SetSize = driver.getWindowHandles().size();
        Integer Index=0;

        /*[0-2]
        0 propuesta
        1 seguro
        2 grabarinformacion*/

        String[] Handles = new String[SetSize] ;
        for (String identificadorGrabarPropuesta : driver.getWindowHandles()) {
            Handles[Index] = identificadorGrabarPropuesta;
            Index++;
        }

        System.out.println("Ventana Inicial:"+Handles[0]);
        driver.switchTo().window(Handles[0]);
        System.out.println(driver.getWindowHandle()+" - "+driver.getTitle());

        Esperar(5);

        System.out.println("Fin cerrar ventana");
    }


    public GrabarDocumentoPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickbtnCerrar(){

        String JScript = btn_Cerrar.getAttribute("onclick");
        ((JavascriptExecutor)driver).executeScript(JScript);
        Esperar(5);

    }

    public void ClickbtnCerrarInformacion(){

        System.out.println("Click en boton cerrar");
        System.out.println("Handles iniciales: " +driver.getWindowHandles());

        Integer numeroHandles = driver.getWindowHandles().size();

        Esperar(5);
        btn_Cerrar.click();

        for(int i=0; i<=240;i+=1)
        {
            if (driver.getWindowHandles().size() == numeroHandles){
                Esperar(1);
                System.out.println("Esperando cierre de handle "+i);
            }
            else {
                i=241;
            }
        }
        System.out.println("Handles final: " +driver.getWindowHandles());
        System.out.println("Fin click en boton cerrar");
    }



    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
