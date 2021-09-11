package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class DesenlazarInformeVisitaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresDesenlazarInformeVisita;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_realizar;


    public void AbrirVentanaDesenlazarInformeVisita(){
        identificadoresDesenlazarInformeVisita = driver.getWindowHandles();
        String LastHandle = "";

        for (String identificadorDesenlazarInformeVisita:identificadoresDesenlazarInformeVisita ){
            LastHandle = identificadorDesenlazarInformeVisita;

        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }


    public void CerrarVentanaDesenlazarInformeVisita (){
        Integer SetSize = identificadoresDesenlazarInformeVisita.size();
        Integer Index = 0;

        String[]Handles = new String[SetSize];

        for (String identificadorDesenlazarInformeVisita: identificadoresDesenlazarInformeVisita){
            Handles[Index] = identificadorDesenlazarInformeVisita;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
    }


    public DesenlazarInformeVisitaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }


    public void clickbtnRealizar(){

        wait.until(ExpectedConditions.elementToBeClickable(btn_realizar));
        btn_realizar.click();
        Esperar(2);


    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos*1000;

        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}





