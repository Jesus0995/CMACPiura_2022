package PageObjects;

import Functions.funcionVentana;
import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarSegurosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresSeleccionarSeguros;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy (xpath = "//button[@type=\"submit\"]") private WebElement btn_Confirmar;

    public void AbrirVentanaSeleccionarSeguros(){
        identificadoresSeleccionarSeguros = driver.getWindowHandles();
        System.out.println(identificadoresSeleccionarSeguros);
        String LastHandle ="";

        for (String identificadorSeleccionarOP :identificadoresSeleccionarSeguros ){
            LastHandle = identificadorSeleccionarOP;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getWindowHandle()+"-"+ driver.getTitle());

    }

    public void CerrarVentanaSeleccionarSeguros(){
        Integer SetSize = identificadoresSeleccionarSeguros.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorSeleccionarSeguros : identificadoresSeleccionarSeguros) {
            Handles[Index] = identificadorSeleccionarSeguros;
            Index++;
        }
        System.out.println("Ventana Principal:" +Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public SeleccionarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void ClickbtnConfirmar(){
        try{
        wait.until(ExpectedConditions.elementToBeClickable(btn_Confirmar));
        btn_Confirmar.click();}
        catch (Exception error) {
        error.printStackTrace();
            System.out.println("Error al hacer click en boton confirmar:"+error.getMessage());
        }
    }

}
