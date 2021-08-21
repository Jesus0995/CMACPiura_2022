package PageObjects;

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

    @FindBy (xpath = "//button[@type=\"submit\"]") private WebElement btn_Confirmar;

    public void AbrirVentanaSeleccionarSeguros(){
        identificadoresSeleccionarSeguros = driver.getWindowHandles();
        System.out.println(identificadoresSeleccionarSeguros);
        String LastHandle ="";

        for (String identificadorSeleccionarOP :identificadoresSeleccionarSeguros ){
            LastHandle = identificadorSeleccionarOP;
        }
        driver.switchTo().window(LastHandle);

    }

    public void CerrarVentanaSeleccionarSeguros(){
        Integer SetSize = identificadoresSeleccionarSeguros.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorSeleccionarSeguros : identificadoresSeleccionarSeguros) {
            Handles[Index] = identificadorSeleccionarSeguros;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public SeleccionarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    private void ClickConfirmar (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Confirmar));
        btn_Confirmar.click();}

}
