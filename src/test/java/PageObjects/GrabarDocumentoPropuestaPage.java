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



    public void AbrirVentanaGrabarPropuesta(){

        /*validar handles activos
        String handleActual = driver.getWindowHandle();
        for (String recorrerHandles : driver.getWindowHandles() ){
            driver.switchTo().window(recorrerHandles);
            System.out.println(driver.getWindowHandle()+"-"+driver.getTitle());
        }
        driver.switchTo().window(handleActual);*/

        //System.out.println(driver.getWindowHandles());
        identificadoresGrabarPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresGrabarPropuesta);
        String LastHandle ="";

        for (String identificadorGrabarPropuesta :identificadoresGrabarPropuesta ){
            LastHandle = identificadorGrabarPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo: "+ driver.getTitle());

    }

    public void CerrarVentanaGrabarPropuesta(){
        Integer SetSize = identificadoresGrabarPropuesta.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorGrabarPropuesta : identificadoresGrabarPropuesta) {
            Handles[Index] = identificadorGrabarPropuesta;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

        //Esperar(1);
    }


    public GrabarDocumentoPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickbtnCerrar(){

     WebElement btn_Cerrar= driver.findElement(By.xpath("//button[@type='button']"));

        String JScript = btn_Cerrar.getAttribute("onclick");
        ((JavascriptExecutor)driver).executeScript(JScript);

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
