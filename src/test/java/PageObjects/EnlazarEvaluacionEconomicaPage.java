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

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Realizar;

    public void AbrirVentanaEvaluacionEconomica(){
        Esperar(5);
        identificadoresEnlazarEvaluacionEconomica = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarEvaluacionEconomica);
        String LastHandle = "";

        for (String identificadorEnlazarEvaluacionEconomica : identificadoresEnlazarEvaluacionEconomica){
            LastHandle = identificadorEnlazarEvaluacionEconomica;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());
        Esperar(1);
    }

    public void CerrarVentanaEvaluacionEconomica(){
        Integer Setsize = identificadoresEnlazarEvaluacionEconomica.size();
        Integer Index = 0;

        //Validar handles
        for(int i=0; i<=30;i+=1)
        {
            if (driver.getWindowHandles().size() > 1){
                Esperar(1);
                System.out.println("Esperando cierre de handle");
            }
            else {
                i=31;
            }
        }

        String[]Handles = new String[Setsize];
        for (String identificadorEnlazarEvaluacionEconomica : identificadoresEnlazarEvaluacionEconomica){
            Handles[Index] = identificadorEnlazarEvaluacionEconomica;
            Index ++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
        Esperar(2);
    }

    public EnlazarEvaluacionEconomicaPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void ClickBtnRealizar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Realizar));
        btn_Realizar.click();
        Esperar(2);
    }

    private void Esperar (Integer Segundos){
        Integer Milisegundos = Segundos*1000;

        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
