package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class InformeVisita_SeleccionarRubroNegocioPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRubroNegocio;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_cargar;

    public InformeVisita_SeleccionarRubroNegocioPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void AbrirVentanaRubroNegocio(){
        identificadoresRubroNegocio = driver.getWindowHandles();
        System.out.println(identificadoresRubroNegocio);
        String LastHandle = "";

        for (String identificadorRubroNegocio : identificadoresRubroNegocio){
            LastHandle = identificadorRubroNegocio;
        }
        driver.switchTo().window(LastHandle);
    }

    public void CerrarVentanaRubroNegocio(){
        Integer SetSize = identificadoresRubroNegocio.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];

        for (String identificadorRubroNegocio : identificadoresRubroNegocio){
            Handles[Index] = identificadorRubroNegocio;
            Index++;
        }
        driver.switchTo().window(Handles[0]);
    }

    public void ClickCargar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_cargar));
        btn_cargar.click();
    }
}