package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarGarantiaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String>identificadoresGarantia;

    //mapeo objetos

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_RegistrarGarantia;

    public SeleccionarGarantiaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void AbrirVentanaGarantia() {
        identificadoresGarantia = driver.getWindowHandles();
        System.out.println(identificadoresGarantia);
        String LastHandle = "";

        for (String identificadorGarantia : identificadoresGarantia) {
            LastHandle = identificadorGarantia;

        }
        driver.switchTo().window(LastHandle);

        System.out.println("Titulo : " +driver.getTitle());
    }


    public void CerrarVentanaGarantia(){
            Integer SetSize = identificadoresGarantia.size();
            Integer Index = 0;
            String[]Handles = new String[SetSize];

            for (String identificadorGarantia:identificadoresGarantia ){
                Handles[Index]= identificadorGarantia;
                Index++;

            }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }



    public void ClickRegistrarGarantia() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_RegistrarGarantia));
        btn_RegistrarGarantia.click();
    }


}
