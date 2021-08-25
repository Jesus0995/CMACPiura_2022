package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class GrabarDocumentoHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresGrabarDocumento;

    //mapear locator
    @FindBy(xpath = "//body/div/button") private WebElement btn_cerrarHojaTrabajo;

    //constructor
    public GrabarDocumentoHojaTrabajoPage (WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //crear metodo para abrir ventana
    public void AbrirVentanaServicio(){

        identificadoresGrabarDocumento = driver.getWindowHandles();
        System.out.println(identificadoresGrabarDocumento);
        String LastHandle = "";

        for (String identificadorGrabarDocumento : identificadoresGrabarDocumento){
            LastHandle = identificadorGrabarDocumento;
        }

        driver.switchTo().window(LastHandle);
    }

    //crear metodo para cerrar ventana
    public void CerrarVentanaServicio(){
        //Actions Acciones = new Actions(driver);

        Integer SetSize = identificadoresGrabarDocumento.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];

        for (String identificadorGrabarDocumento : identificadoresGrabarDocumento){
            Handles[Index] = identificadorGrabarDocumento;
            Index++;
        }

        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
    }

    public void GrabarDocumentoHojaTrabajo() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(btn_cerrarHojaTrabajo));
        btn_cerrarHojaTrabajo.click();
        Thread.sleep(10000);
    }

}