package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeVisita_CrearPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "numeroIntegrantes") private  WebElement txt_nroIntegrantes;
    @FindBy(name="valuacionPerito") private WebElement opt_conforme;
    @FindBy(name="lavact1") private WebElement opt_lavadoActivo;
    @FindBy(name = "lavact2") private WebElement opt_senalesAlerta;
    @FindBy(name = "lavact3") private WebElement opt_legal;
    @FindBy(name="observaciones") private WebElement txt_observacion;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/a/img") private WebElement btn_grabar;

    public InformeVisita_CrearPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void IngresarNroInteg(){
        txt_nroIntegrantes.clear();
        txt_nroIntegrantes.sendKeys("3");
    }

    public void SeleccionarConforme(){
        wait.until(ExpectedConditions.elementToBeClickable(opt_conforme));
        opt_conforme.click();
    }

    public void SeleccionarNoLavado(){
        wait.until(ExpectedConditions.elementToBeClickable(opt_lavadoActivo));
        opt_lavadoActivo.click();
    }

    public void SeleccionarAlerta(){
        wait.until(ExpectedConditions.elementToBeClickable(opt_senalesAlerta));
        opt_senalesAlerta.click();
    }

    public void SeleccionarLegal(){
        wait.until(ExpectedConditions.elementToBeClickable(opt_legal));
        opt_legal.click();
    }

    public void IngresarObservacion(){
        txt_observacion.clear();
        txt_observacion.sendKeys("prueba");
    }

    public void ClickGrabar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
        btn_grabar.click();
    }

}
