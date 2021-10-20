package PageObjects;

import Functions.funcionEsperar;
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
    private funcionEsperar objFuncionEsperar = new funcionEsperar();

    @FindBy(xpath = "/html/body/fieldset/form/table/tbody/tr[2]/td/button") private WebElement btn_Cerrar;


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
        System.out.println("Click en el boton cerrar");
        System.out.println("Handles iniciales"+driver.getWindowHandles());
        Integer numeroHandles = driver.getWindowHandles().size();
        objFuncionEsperar.EsperarTiempo(3);
        btn_Cerrar.click();
        for (int i=0; i<=240;i+=1 ){
            if (driver.getWindowHandles().size()==numeroHandles){
                objFuncionEsperar.EsperarTiempo(1);
                System.out.println("Esperando cierre de handle:" +i);

            } else
            {
                i=241;
            }

        }
        System.out.println("Handles final" + driver.getWindowHandles());
        System.out.println("fin del boton cerrar");

    }

}
