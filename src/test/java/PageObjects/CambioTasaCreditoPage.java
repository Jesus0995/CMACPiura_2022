package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CambioTasaCreditoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCambioTasaCredito;

    @FindBy(xpath = "//textarea[@name='txtTasaComentarioPropo']") private WebElement txt_Comentario;
    @FindBy(xpath = "//button[@name='btnCambio']") private WebElement btn_Grabar;


    public void AbrirVentanaCambioTasaCredito(){
        identificadoresCambioTasaCredito = driver.getWindowHandles();
        System.out.println(identificadoresCambioTasaCredito);
        String LastHandle ="";

        for (String identificadorCambioTasaCredito :identificadoresCambioTasaCredito ){
            LastHandle = identificadorCambioTasaCredito;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaCambioTasaCredito() {
        Integer SetSize = identificadoresCambioTasaCredito.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];
        for (String identificadorCambioTasaCredito : identificadoresCambioTasaCredito) {
            Handles[Index] = identificadorCambioTasaCredito;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public CambioTasaCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void IngresarComentarioCambio(String ComentarioCambioTasa){
        txt_Comentario.clear();
        txt_Comentario.sendKeys(ComentarioCambioTasa);

    }

    public void ClickGrabar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
    }

}

