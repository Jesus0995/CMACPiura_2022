package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarGarantiasExistentesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresGarantiasExistentes;

    //mapeo objetos

    @FindBy(xpath = "//input[@name='garantia']") private WebElement chk_GarantiaExistentes;
    @FindBy(xpath = "//button[@type=\"submit\"]") private  WebElement btn_Aceptar;
    //@FindBy(xpath = "//input[@value='611-1-4725262']") private WebElement chk_GarantiaMaquinaria;
    //@FindBy(xpath = "//input[@value='611-1-4725261']") private WebElement chk_GarantiaMaquinaria;


    ///html/body/form/table/tbody/tr[4]/td[5]


    public void AbrirVentanaGarantiasExistentes(){
        identificadoresGarantiasExistentes = driver.getWindowHandles();
        System.out.println(identificadoresGarantiasExistentes);
        String LastHandle ="";

        for (String identificadorOperacionCredito :identificadoresGarantiasExistentes ){
            LastHandle = identificadorOperacionCredito;
        }
        driver.switchTo().window(LastHandle);

        System.out.println("Titulo : " +driver.getTitle() );

    }

    public void CerrarVentanaGarantiasExistentes(){
        Integer SetSize = identificadoresGarantiasExistentes.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorGarantiasExistentes : identificadoresGarantiasExistentes) {
            Handles[Index] = identificadorGarantiasExistentes;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public SeleccionarGarantiasExistentesPage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void SeleccionarCheckGarantiasExistentes() {
        wait.until(ExpectedConditions.elementToBeClickable(chk_GarantiaExistentes));
        chk_GarantiaExistentes.click();
    }

    /*
    public void SeleccionarCheckGarantiaMaquinaria(){
        wait.until(ExpectedConditions.elementToBeClickable(chk_GarantiaMaquinaria));
        chk_GarantiaMaquinaria.click();
    }*/

    public void ClickbtnAceptar (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Aceptar));
        btn_Aceptar.click();
        //Esperar(1);
    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;

        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
