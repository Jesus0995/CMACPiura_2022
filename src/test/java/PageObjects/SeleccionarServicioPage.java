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
    private Set<String> identificadoresServicio;

    //mapeo de objetos
    @FindBy(xpath = "//select[@name='servicio']") private WebElement cbx_Servicio;
    @FindBy(xpath = "//select[@name='idServicioSofia']") private WebElement cbx_ServicioCredito;
    @FindBy(xpath = "//select[@name='idTipoPropuesta']") private  WebElement cbx_TipoPropuesta;
    @FindBy(xpath = "//select[@name='idSubTipoPropuesta']") private WebElement cbx_SubTipoPropuesta;
    @FindBy(xpath = "//select[@name='idPromocion']") private WebElement cbx_Promocion;
    //@FindBy(xpath = "//select[@name='idnegocio']") private WebElement cbx_Negocio;
    //@FindBy(xpath = "//select[@name='idTipoOperacion']") private  WebElement cbx_TipoOperacion;
    @FindBy(xpath = "//*[@id=\"bCargar\"]")private  WebElement btn_Cargar;

    //crear metodo para abrir ventana
    public void AbrirVentanaServicio(){

        identificadoresServicio = driver.getWindowHandles();
        System.out.println(identificadoresServicio);
        String LastHandle = "";

        for (String identificadorservicio : identificadoresServicio){
            LastHandle = identificadorservicio;
        }
        driver.switchTo().window(LastHandle);
    }

    //crear metodo para salir de ventana
    public void CerrarVentanaServicio(){
        //Actions Acciones = new Actions(driver);

        Integer SetSize = identificadoresServicio.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];

        for (String identificadorservicio : identificadoresServicio){
            Handles[Index] = identificadorservicio;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
    }

    public SeleccionarServicioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,120);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarServicio(String TipoServicio){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Servicio));
        new Select(cbx_Servicio).selectByVisibleText(TipoServicio);
        //System.out.println(cbx_servicio);
        //"CREDITO EMPRESARIAL"
    }

    public void SeleccionarServicioCredito(String ServicioCredito){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_ServicioCredito));
        new Select(cbx_ServicioCredito).selectByVisibleText(ServicioCredito);
        //System.out.println(cbx_servicioCredito);
        //"CREDITOS PYMES"

    }

    public void SeleccionarTipoPropuesta (String TipoPropuesta){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_TipoPropuesta));
        new Select(cbx_TipoPropuesta).selectByVisibleText(TipoPropuesta);
        //System.out.println(cbx_tipoPropuesta);
        //"NORMAL"
    }

    public void SeleccionarSubTipoPropuesta (String SubTipoPropuesta){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_SubTipoPropuesta));
        new Select(cbx_SubTipoPropuesta).selectByVisibleText(SubTipoPropuesta);
        //System.out.println(cbx_subTipoPropuesta);
        //"NORMAL"
    }

    public void SeleccionarPromocion (String Promocion){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Promocion));
        new Select(cbx_Promocion).selectByVisibleText(Promocion);
        //System.out.println(cbx_promocion);
        //"SIN PROMOCION"
    }

    /*
    public void SeleccionarNegocio (String Negocio){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_negocio));
        new Select (cbx_negocio).selectByVisibleText(Negocio);
        System.out.println(cbx_negocio);
        //"VENTA AL POR MENOR DE PRENDAS DE VESTIR,"
    }

    public void SeleccionarTipoOperacion(String TipoOperacion) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_tipoOperacion));
        new Select (cbx_tipoOperacion).selectByVisibleText(TipoOperacion);
        System.out.println(cbx_tipoOperacion);
        //"SIMPLE"
    }
    */

    public void ClickCargar() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cargar));
        btn_Cargar.click();
        Thread.sleep(10000);
    }

}
