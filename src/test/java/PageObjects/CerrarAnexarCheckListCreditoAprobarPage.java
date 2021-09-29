package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CerrarAnexarCheckListCreditoAprobarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identfCerrarAnexarCheckListAprobar;

    @FindBy(xpath = "//*[@onclick='window.close();']") private WebElement btn_Cerrar;


    public void AbrirVentanaCerrarAnexarCheckListAprobar(){
        identfCerrarAnexarCheckListAprobar = driver.getWindowHandles();
        System.out.println(identfCerrarAnexarCheckListAprobar);
        String LastHandle ="";

        for (String idCerrarAnexarCheckListAprobar :identfCerrarAnexarCheckListAprobar ){
            LastHandle = idCerrarAnexarCheckListAprobar;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:"+ driver.getTitle());

    }

    public void CerrarVentanaCerrarAnexarCheckListAprobar(){
        Integer SetSize = identfCerrarAnexarCheckListAprobar.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String idCerrarAnexarCheckListAprobar : identfCerrarAnexarCheckListAprobar) {
            Handles[Index] = idCerrarAnexarCheckListAprobar;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public CerrarAnexarCheckListCreditoAprobarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);


    }

    public void ClickBtnCerrar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
        btn_Cerrar.click();

    }
}
