package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarServicioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de objetos
    @FindBy(xpath = "//*[@id=\"servicio\"]") private WebElement cbx_servicio;
    @FindBy(id = "idServicioSofia") private WebElement cbx_servicioCredito;
    @FindBy(id = "idTipoPropuesta") private  WebElement cbx_tipoPropuesta;
    @FindBy(id = "idSubTipoPropuesta") private WebElement cbx_subTipoPropuesta;
    @FindBy(id = "idPromocion") private WebElement cbx_promocion;
    @FindBy(id = "idnegocio") private WebElement cbx_negocio;
    @FindBy(id = "idTipoOperacion") private  WebElement cbx_tipoOperacion;
    @FindBy(id = "bCargar")private  WebElement btn_cargar;
    @FindBy(xpath = "//button[@onclick=\"javascript:window.close();\"]") private  WebElement btn_cancelar;


    //crear meotodo para abrir ventana
    public void AbrirVentana(){
        Set<String> identificadores =driver.getWindowHandles();
        for (String identificador : identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarServicio(){
        new Select(cbx_servicio).selectByValue("CREDITO EMPRESARIAL");
    }

    public void SeleccionarServicioCredito(){
        new Select(cbx_servicioCredito).selectByValue("CREDITOS PYMES");
    }

    public void SeleccionarTipoPropuesta (){
        new Select(cbx_tipoPropuesta).selectByValue("NORMAL");
    }

    public void SeleccionarSubTipoPropuesta (){
        new Select(cbx_subTipoPropuesta).selectByValue("NORMAL");
    }

    public void SeleccionarPromocion (){
        new Select(cbx_promocion).selectByValue("SIN PROMOCION");
    }

    public void ClickCargar(){
        btn_cargar.click();
    }

}
