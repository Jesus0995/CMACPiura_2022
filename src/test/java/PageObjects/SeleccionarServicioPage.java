package PageObjects;

import io.cucumber.messages.internal.com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import java.util.Set;

public class SeleccionarServicioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de objetos
    @FindBy(xpath = "//select[@name='servicio']") private WebElement cbx_servicio;
    @FindBy(xpath = "//select[@name='idServicioSofia']") private WebElement cbx_servicioCredito;
    @FindBy(xpath = "//select[@name='idTipoPropuesta']") private  WebElement cbx_tipoPropuesta;
    @FindBy(xpath = "//select[@name='idSubTipoPropuesta']") private WebElement cbx_subTipoPropuesta;
    @FindBy(xpath = "//select[@name='idPromocion']") private WebElement cbx_promocion;
    @FindBy(xpath = "//select[@name='idnegocio']") private WebElement cbx_negocio;
    @FindBy(xpath = "//select[@name='idTipoOperacion']") private  WebElement cbx_tipoOperacion;
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
        wait = new WebDriverWait(driver,120);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarServicio(){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_servicio));
        new Select(cbx_servicio).selectByVisibleText("CREDITO EMPRESARIAL");

        System.out.println(cbx_servicio);
    }

    public void SeleccionarServicioCredito(){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_servicioCredito));
        new Select(cbx_servicioCredito).selectByVisibleText("CREDITOS PYMES");
        System.out.println(cbx_servicioCredito);
    }


    public void SeleccionarTipoPropuesta (){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_tipoPropuesta));
        new Select(cbx_tipoPropuesta).selectByVisibleText("NORMAL");
        System.out.println(cbx_tipoPropuesta);
    }

    public void SeleccionarSubTipoPropuesta (){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_subTipoPropuesta));
        new Select(cbx_subTipoPropuesta).selectByVisibleText("NORMAL");
        System.out.println(cbx_subTipoPropuesta);
    }

    public void SeleccionarPromocion (){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_promocion));
        new Select(cbx_promocion).selectByVisibleText("SIN PROMOCION");
        System.out.println(cbx_promocion);
    }

    public void SeleccionarNegocio (){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_negocio));
        new Select (cbx_negocio).selectByVisibleText("VENTA AL POR MENOR DE PRENDAS DE VESTIR,");
        System.out.println(cbx_negocio);
    }

    public void SeleccionarTipoOperacion() {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_tipoOperacion));
        new Select (cbx_tipoOperacion).selectByVisibleText("SIMPLE");
        System.out.println(cbx_tipoOperacion);
    }

    public void ClickCargar(){
        btn_cargar.click();
    }

    //public void CerrarServicio() {driver.close();}



}
