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

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_Cerrar;

    public void AbrirVentanaGrabarPropuesta(){

        identificadoresGrabarPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresGrabarPropuesta);
        String LastHandle ="";

        for (String identificadorGrabarPropuesta :identificadoresGrabarPropuesta ){
            LastHandle = identificadorGrabarPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

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
    }


    public GrabarDocumentoPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickbtnCerrar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
        btn_Cerrar.click();
        /*
        WebElement btn_Cerrar = driver.findElement(By.xpath("//button[@type='button']"));
        String JScript = btn_Cerrar.getAttribute("click");
        ((JavascriptExecutor)driver).executeScript(JScript);
        */


    }


















}
