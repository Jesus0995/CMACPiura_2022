package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EnlazarEstadosFinancierosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarEstadosFinancieros;

    //mapeop elementos
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_enlazarEEFF;

    public void AbrirVentanaEnlazarEstadosFinancieros(){
        identificadoresEnlazarEstadosFinancieros = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarEstadosFinancieros);
        String LastHandle="";

        for (String identificadorEnlazarEstadosFinancieros : identificadoresEnlazarEstadosFinancieros){
            LastHandle=identificadorEnlazarEstadosFinancieros;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo : " + driver.getTitle());
    }

    public void CerrarVentanaEnlazarEstadosFinancieros(){
        Integer SetSize = identificadoresEnlazarEstadosFinancieros.size();
        Integer Index= 0;

        String[]Handles = new String[SetSize];

        for (String identificadorEnlazarEstadosFinancieros : identificadoresEnlazarEstadosFinancieros){
                Handles[Index] = identificadorEnlazarEstadosFinancieros;
                Index++;
            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        }

    public EnlazarEstadosFinancierosPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickEnlazar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_enlazarEEFF));
        btn_enlazarEEFF.click();
        Esperar(1);

    }




    private void Esperar (Integer Segundos){
        Integer Milisegundos = Segundos * 10000;

        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }

}
