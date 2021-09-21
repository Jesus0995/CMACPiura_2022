package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.Set;

public class EnlazarInformeComercialNuevoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private Set<String> identificadoresEnlazarInformeComercialNuevo;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_realizar;


    public void AbrirVentanaEnlazarInformeComercialNuevo() {
        identificadoresEnlazarInformeComercialNuevo = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarInformeComercialNuevo);
        String LastHandle = "";

        for (String identificadorEnlazarInformeComercialNuevo : identificadoresEnlazarInformeComercialNuevo) {
            LastHandle = identificadorEnlazarInformeComercialNuevo;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());
    }

    public void CerrarVentanaEnlazarInformeComercialNuevo() {
        Integer SetSize = identificadoresEnlazarInformeComercialNuevo.size();
        Integer Index = 0;

        String[] Handles = new String[SetSize];

        for (String identificadorEnlazarInformeComercialNuevo : identificadoresEnlazarInformeComercialNuevo) {
            Handles[Index] = identificadorEnlazarInformeComercialNuevo;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public EnlazarInformeComercialNuevoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }


    public void ClickBtnRealizar() {

        wait.until(ExpectedConditions.elementToBeClickable(btn_realizar));
        btn_realizar.click();
        Esperar(2);
    }

    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;

        try {
            Thread.sleep(Milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
