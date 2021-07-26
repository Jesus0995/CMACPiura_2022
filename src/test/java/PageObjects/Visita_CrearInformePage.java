package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Visita_CrearInformePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "numeroIntegrantes") private  WebElement txt_nroIntegrantes;
    @FindBy(name="valuacionPerito") private WebElement opt_conforme;
    @FindBy(name="lavact1") private WebElement opt_lavadoActivo;
    @FindBy(name = "lavact2") private WebElement opt_senalesAlerta;
    @FindBy(name = "lavact3") private WebElement opt_legal;
    @FindBy(name="observaciones") private WebElement txt_obs;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/a/img") private WebElement btn_grabar;

    public Visita_CrearInformePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    public void IngresarNroInteg(){txt_nroIntegrantes.sendKeys("3");}
    public void SeleccionarConforme(){opt_conforme.click();}
    public void SeleccionarNoLavado(){opt_lavadoActivo.click();}
    public void SeleccionarAlerta(){opt_senalesAlerta.click();}
    public void SeleccionarLegal(){opt_legal.click();}
    public void IngresarObservacion(){txt_obs.sendKeys("prueba");}
    public void ClickGrabar(){btn_grabar.click();}

}
