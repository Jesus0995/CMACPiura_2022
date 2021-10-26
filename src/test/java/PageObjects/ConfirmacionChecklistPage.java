package PageObjects;

import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ConfirmacionChecklistPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> idenficadoresCheckList;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cerrar;

    public void AbrirVentanaConfirmacionCheckList(){
        try {
            idenficadoresCheckList = driver.getWindowHandles();
            System.out.println(idenficadoresCheckList);
            String LastHandle = "";

            for (String identificadorCheckList :idenficadoresCheckList ){
                LastHandle =  identificadorCheckList;
            }

            driver.switchTo().window(LastHandle);
            System.out.println("Titulo: " + driver.getTitle());

        } catch (Exception Error) {
            detalleError = "Error en abrir ventana Checklist";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaConfirmacionCheckList(){
        try {
            Integer SetSize = idenficadoresCheckList.size();
            Integer Index=0;

            String[]Handles = new String[SetSize];

            for (String identificadorCheckList : idenficadoresCheckList){
                Handles[Index] = identificadorCheckList;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        } catch (Exception Error) {
            detalleError = "Error en cerrar ventana Checklist";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }


    public ConfirmacionChecklistPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }


    public void ClickBtnCerrar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_cerrar));
            btn_cerrar.click();

        } catch (Exception Error) {
            detalleError = "Error en boton cerrar";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
