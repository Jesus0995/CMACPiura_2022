package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ConfirmarSegurosSeleccionadosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresConfirmacionSeguros;

    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cerrar;


    public void AbrirVentanaConfirmacionSeguros(){

        identificadoresConfirmacionSeguros = driver.getWindowHandles();
        System.out.println(identificadoresConfirmacionSeguros);
        String LastHandle = "";

        for (String identificadorConfirmacionSeguros : identificadoresConfirmacionSeguros){
            LastHandle = identificadorConfirmacionSeguros;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo: " + driver.getTitle());
    }


    public void CerrarVentanaConfirmacionSeguros()  {

            Integer SetSize = identificadoresConfirmacionSeguros.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];
            for (String identificadorConfirmacionSeguros : identificadoresConfirmacionSeguros) {
                Handles[Index] = identificadorConfirmacionSeguros;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        }



    public ConfirmarSegurosSeleccionadosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCerrar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_cerrar));
        btn_cerrar.click();}
}
