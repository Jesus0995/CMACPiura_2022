package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EnlazarInformeVisitaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarInformeVisita;

    //mapeop elementos
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_realizar;

    public void AbrirVentanaEnlazarInformeVisita(){
        identificadoresEnlazarInformeVisita = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarInformeVisita);
        String LastHandle="";

        for (String identificadorEnlazarInformeVisita : identificadoresEnlazarInformeVisita){
            LastHandle=identificadorEnlazarInformeVisita;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());
    }

    public void CerrarVentanaEnlazarInformeVisita(){
        Integer SetSize = identificadoresEnlazarInformeVisita.size();
        Integer Index= 0;

        String[]Handles = new String[SetSize];

        for (String identificadorEnlazarInformeVisita : identificadoresEnlazarInformeVisita){
            Handles[Index] = identificadorEnlazarInformeVisita;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public EnlazarInformeVisitaPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickbtnRealizar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_realizar));
        btn_realizar.click();
        Esperar (2);

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
