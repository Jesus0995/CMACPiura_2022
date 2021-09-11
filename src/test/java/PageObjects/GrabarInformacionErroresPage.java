package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class GrabarInformacionErroresPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private Set<String> identificadoresGrabarInformacion;

    @FindBy(xpath = "//button[@type='button']") private WebElement btn_Cerrar;

    public void AbrirVentanaGrabarInformacion(){
        identificadoresGrabarInformacion = driver.getWindowHandles();
        System.out.println(identificadoresGrabarInformacion);
        String LastHandle="";

        for (String identificadorGrabarInformacion: identificadoresGrabarInformacion){
            LastHandle = identificadorGrabarInformacion;
        }

        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaGrabarInformacion(){
        Integer SetSize = identificadoresGrabarInformacion.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];

        for (String identificadorGrabarInformacion: identificadoresGrabarInformacion){
            Handles[Index] = identificadorGrabarInformacion;
            Index++;

        }
        driver.switchTo().window(Handles[0]);
        System.out.println(Handles[0]);


    }


    public GrabarInformacionErroresPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);

    }


    public void ClickbtnCerrar(){
        //wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
        //btn_Cerrar.click();
        String JScript = btn_Cerrar.getAttribute("onclick");
        ((JavascriptExecutor)driver).executeScript(JScript);

    }
}
