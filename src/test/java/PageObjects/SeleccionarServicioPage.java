package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleccionarServicioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de objetos
    @FindBy(xpath = "//*[@id=\"servicio\"]") private WebElement cbx_servicio;
    @FindBy(xpath = "//*[@id=\"idServicioSofia\"]") private WebElement cbx_servicioCredito;
    @FindBy(xpath = "//*[@id=\"idTipoPropuesta\"]") private  WebElement cbx_tipoPropuesta;
    @FindBy(xpath = "//*[@id=\"idSubTipoPropuesta\"]") private WebElement cbx_subTipoPropuesta;
    @FindBy(xpath = "//*[@id=\"idPromocion\"]") private WebElement cbx_promocion;
    @FindBy(id = "idnegocio") private WebElement cbx_negocio;
    @FindBy(id = "idTipoOperacion") private  WebElement cbx_tipoOperacion;
    @FindBy(xpath = "//*[@id=\"bCargar\"]")private  WebElement btn_cargar;



    //crear meotodo para abrir ventana
    public void AbrirVentanaServicio(){
        Set<String> identificadoresServicio = driver.getWindowHandles();
        for (String identificadorservicio : identificadoresServicio){
            driver.switchTo().window(identificadorservicio);
        }
    }

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarServicio(){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_servicio));
        new Select(cbx_servicio).selectByVisibleText("CREDITO EMPRESARIAL");
        System.out.println(cbx_servicio);
    }

    public void SeleccionarServicioCredito(){
        new Select(cbx_servicioCredito).selectByVisibleText("CREDITOS PYMES");
    }

    public void SeleccionarTipoPropuesta (){
        new Select(cbx_tipoPropuesta).selectByVisibleText("NORMAL");
    }

    public void SeleccionarSubTipoPropuesta (){
        new Select(cbx_subTipoPropuesta).selectByVisibleText("NORMAL");
    }

    public void SeleccionarPromocion (){
        new Select(cbx_promocion).selectByVisibleText("SIN PROMOCION");
    }

    public void SeleccionarNegocio (){new Select (cbx_negocio).selectByVisibleText("VENTA AL POR MENOR DE PRENDAS DE VESTIR,");}

    public void SeleccionarTipoOperacion() {new Select (cbx_tipoOperacion).selectByVisibleText("SIMPLE");}

    public void ClickCargar(){
        btn_cargar.click();
    }

    //public void CerrarServicio() {driver.close();}



}
