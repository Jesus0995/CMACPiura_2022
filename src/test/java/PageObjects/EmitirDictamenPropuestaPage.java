package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EmitirDictamenPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEmitirDictamenPropuesta;

    @FindBy(xpath = "//textarea[@name='observaciones']") private WebElement txt_observaciones;
    @FindBy(xpath = "//input[@name='clave']") private WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_procesar;
    @FindBy(xpath = "//button[@type='button']") private WebElement btn_cancelar;

    public void AbrirVentanaEmitirDictamenPropuesta(){
        identificadoresEmitirDictamenPropuesta = driver.getWindowHandles();
        System.out.println(identificadoresEmitirDictamenPropuesta);
        String LastHandle ="";

        for (String identificadorEmitirDictamenPropuesta :identificadoresEmitirDictamenPropuesta ){
            LastHandle = identificadorEmitirDictamenPropuesta;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaEmitirDictamenPropuesta(){
        Integer SetSize = identificadoresEmitirDictamenPropuesta.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorEmitirDictamenPropuesta : identificadoresEmitirDictamenPropuesta) {
            Handles[Index] = identificadorEmitirDictamenPropuesta;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public EmitirDictamenPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);


    }


    public void IngresarObservaciones(String Observaciones){
        txt_observaciones.clear();
        txt_observaciones.sendKeys(Observaciones);

    }
}
