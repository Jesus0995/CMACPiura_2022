package PageObjects;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EnlazarEEFFGrupoVinculadoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEEFFGrupoVinculado;


    @FindBy(xpath = "//textarea[@id='txt_analisis']") private WebElement txt_AnalisisEEFF;
    @FindBy(xpath = "//textarea[@id='txt_conducta']") private WebElement txt_ComportamientoPagoGrupo;
    @FindBy(xpath = "//a[@id='btn_graba']") private WebElement btn_Grabar;


    public void AbrirVentanaEnlazarEEFFGrupoVinculado(){
        identificadoresEEFFGrupoVinculado = driver.getWindowHandles();
        System.out.println(identificadoresEEFFGrupoVinculado);
        String LastHandle ="";

        for (String identificadorEEFFGrupoVinculado :identificadoresEEFFGrupoVinculado ){
            LastHandle = identificadorEEFFGrupoVinculado;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaEnlazarEEFFGrupoVinculado(){
        Integer SetSize = identificadoresEEFFGrupoVinculado.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorEEFFGrupoVinculado : identificadoresEEFFGrupoVinculado) {
            Handles[Index] = identificadorEEFFGrupoVinculado;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public EnlazarEEFFGrupoVinculadoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }


    public void IngresarAnalisisEEFF(String AnalisisEEFF){
        txt_AnalisisEEFF.clear();
        txt_AnalisisEEFF.sendKeys(AnalisisEEFF);

    }


    public void IngresarComentarioComportamientoPago(String ComportamientoPago){
        txt_ComportamientoPagoGrupo.clear();
        txt_ComportamientoPagoGrupo.sendKeys(ComportamientoPago);

    }


    public void ClickBtnGrabar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
        Esperar(5);


    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException error){
            error.printStackTrace();
        }

    }
}
