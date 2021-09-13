package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class EnlazarEvaluacionEconomicaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarEvaluacionEconomica;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_realizar;

    public EnlazarEvaluacionEconomicaPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void AbrirVentanaEvaluacionEconomica(){
        identificadoresEnlazarEvaluacionEconomica = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarEvaluacionEconomica);
        String LastHandle = "";

        for (String identificadorEnlazarEvaluacionEconomica : identificadoresEnlazarEvaluacionEconomica){
            LastHandle = identificadorEnlazarEvaluacionEconomica;
        }
        driver.switchTo().window(LastHandle);

    }

    public void CerrarVentanaEvaluacionEconomica(){
        int Setsize = identificadoresEnlazarEvaluacionEconomica.size();
        int Index = 0;

        String[]Handles = new String[Setsize];
        for (String identificadorEnlazarEvaluacionEconomica : identificadoresEnlazarEvaluacionEconomica){
            Handles[Index] = identificadorEnlazarEvaluacionEconomica;
            Index ++;
        }
        driver.switchTo().window(Handles[0]);
    }

    public void ClickbtnRealizar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_realizar));
        btn_realizar.click();
    }

}
