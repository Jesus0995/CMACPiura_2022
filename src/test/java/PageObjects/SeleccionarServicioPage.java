package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarServicioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de objetos
    @FindBy(id = "servicio") private WebElement cbx_servicio;
    @FindBy(id = "idServicioSofia") private WebElement cbx_servicioCredito;
    @FindBy(id = "idTipoPropuesta") private  WebElement cbx_tipoPropuesta;
    @FindBy(id = "idSubTipoPropuesta") private WebElement cbx_subTipoPropuesta;
    @FindBy(id = "idPromocion") private WebElement cbx_promocion;
    @FindBy(id = "idnegocio") private WebElement cbx_negocio;
    @FindBy(id = "idTipoOperacion") private  WebElement cbx_tipoOperacion;
    @FindBy(id = "bCargar")private  WebElement btn_cargar;
    @FindBy(xpath = "//button[@onclick=\"javascript:window.close();\"]") private  WebElement btn_cancelar;

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarServicio(String Servicio){
        new Select(cbx_servicio).selectByValue(Servicio);
    }

    public void SeleccionarServicioCredito(String ServicioCredito){
        new Select(cbx_servicioCredito).selectByValue(ServicioCredito);
    }

    public void SeleccionarTipoPropuesta (String TipoPropuesta){
        new Select(cbx_tipoPropuesta).selectByValue(TipoPropuesta);
    }

    public void SeleccionarSubTipoPropuesta (String SubTipoPropuesta){
        new Select(cbx_subTipoPropuesta).selectByValue(SubTipoPropuesta);
    }

    public void SeleccionarPromocion (String Promocion){
        new Select(cbx_promocion).selectByValue(Promocion);
    }

    public void ClickCargar(){
        btn_cargar.click();
    }

}
