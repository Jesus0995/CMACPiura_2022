package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarRubroNegocioPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRubroNegocio;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Cargar;

    public void AbrirVentanaRubroNegocio(){
        identificadoresRubroNegocio = driver.getWindowHandles();

        String LastHandle="";
        for(String identificadorRubroNegocio: identificadoresRubroNegocio){
            LastHandle = identificadorRubroNegocio;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" +driver.getTitle());


    }

    public void CerrarVentanaRubroNegocio(){
        Integer SetSize= identificadoresRubroNegocio.size();
        Integer Index=0;
        String[] Handles = new String[SetSize];

        for (String identificadorRubroNegocio:identificadoresRubroNegocio){
            Handles[Index] = identificadorRubroNegocio;
            Index++;
        }

        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public SeleccionarRubroNegocioPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickBtnCargar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cargar));
        btn_Cargar.click();
    }


}
