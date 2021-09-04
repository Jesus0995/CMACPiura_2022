package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CancelandoPagaresPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCancelandoPagares;

    public void AbrirVentanaCancelandoPagares(){
        identificadoresCancelandoPagares = driver.getWindowHandles();
        System.out.println(identificadoresCancelandoPagares);
        String LastHandle ="";

        for (String identificadorCancelandoPagares :identificadoresCancelandoPagares ){
            LastHandle = identificadorCancelandoPagares;
        }
        driver.switchTo().window(LastHandle);

        System.out.println("Titulo : " +driver.getTitle() );

    }

    public void CerrarVentanaCancelandoPagares(){
        Integer SetSize = identificadoresCancelandoPagares.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorCancelandoPagares : identificadoresCancelandoPagares) {
            Handles[Index] = identificadorCancelandoPagares;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public CancelandoPagaresPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
}
