package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// from selenium.webdriver.common.keys import Keys  # Antes de usar el método de la tecla del teclado, primero debe importar el paquete de la clase de teclas.

import java.util.Set;

public class PropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de locator
    //span[@class='ui-icon ui-icon-closethick

    //@FindBy(xpath = "/html/body/div[1]/div[1]/a/span") private WebElement xxx;
    //@FindBy(xpath = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']") private WebElement AlertaComunicado;
    //@FindBy(xpath= "i")private WebElement PopUpComunicado;
    @FindBy(xpath = "//textarea[@name='comentCalifCred']") private WebElement txt_ClasificacionCrediticia;
    @FindBy(id = "txtobjetivo") private WebElement txt_ObjetivoCredito;
    @FindBy(id = "justificacion") private WebElement txt_JustificacionCredito;
    @FindBy(name = "btnEnviar") private WebElement btn_NuevaOperacion;
    @FindBy(xpath = "//img[@src='./images/mail-send-receive.png']") private WebElement icn_CambioTasa;
    @FindBy(name = "btnEnviar2") private WebElement btn_AgregarSeguro;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[8]/tbody/tr[1]/td[2]/button") private WebElement btn_AnexarChecklist;

    @FindBy(xpath = "//textarea[@id='txtcaracter']") private WebElement txt_caracteristicaNegocio;
    @FindBy(xpath = "//textarea[@id='txtclasificac']") private WebElement txt_clasificacionRiesgoCliente;
    @FindBy(xpath = "//textarea[@id='txtclasificaAval']")private  WebElement txt_clasificacionRiesgoAval;
    @FindBy(xpath = "//textarea[@id='txtanalisisUEF']") private WebElement txt_analisisUnidadFinanciera;

    @FindBy(xpath = "//button[@name=\"btnGaranExist\"]") private WebElement btn_AnexarGarantias;

    @FindBy(css = "#frmPropuesta > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > div:nth-child(7) > button:nth-child(65)") private  WebElement btn_EnlazarEEFF;

    @FindBy(xpath = "//textarea[@id='txtPrincipalRatio']")private  WebElement txt_comentariosRatios;

    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[1]/td[3]/button") private WebElement btn_DesenlazarInformeVisita;

    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[1]/td[3]/button") private WebElement btn_EnlazarInformeVisita;

    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[3]/td[3]/button") private WebElement btn_EnlazarInformeComercial;

    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[1]/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a")private WebElement btn_Grabar;
    //@FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[2]/tbody/tr[1]/td/a") private WebElement btn_Aprobar;

    @FindBy(xpath = "//img[@alt='Aprobar']") private WebElement btn_Aprobar;

    public PropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,140);
        PageFactory.initElements(driver,this);

    }

    public void IngresarClasificacionCrediticia (String clasificacion){
        wait.until(ExpectedConditions.elementToBeClickable(txt_ClasificacionCrediticia));
        txt_ClasificacionCrediticia.clear();
        txt_ClasificacionCrediticia.sendKeys(clasificacion);
    }

    public void IngresarObjetivoCredito (String Objetivo) {
        txt_ObjetivoCredito.clear();
        txt_ObjetivoCredito.sendKeys(Objetivo);
    }

    public void IngresarJustificacionCredito (String Justificacion) {
        txt_JustificacionCredito.clear();
        txt_JustificacionCredito.sendKeys(Justificacion);
    }

    public void ClickBotonOperacion () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_NuevaOperacion));
        btn_NuevaOperacion.click();
    }

    public void ClickIcnCambioTasa(){
        wait.until(ExpectedConditions.elementToBeClickable(icn_CambioTasa));
        icn_CambioTasa.click();
    }

    public void ClickBotonRegistrarSeguro () {

        wait.until(ExpectedConditions.elementToBeClickable(btn_AgregarSeguro));
        btn_AgregarSeguro.click();
    }

    public void ClickAnexarCheckListCreditos () {

        wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarChecklist));
        btn_AnexarChecklist.click();
    }

    public void IngresarCaracteristicaNegocio(String CaracteristicaNegocio){
        txt_caracteristicaNegocio.clear();
        txt_caracteristicaNegocio.sendKeys(CaracteristicaNegocio);
    }

    public void IngresarClasificacionRiesgoCliente(String ClasificacionRiesgoNegocio){
        txt_clasificacionRiesgoCliente.clear();
        txt_clasificacionRiesgoCliente.sendKeys(ClasificacionRiesgoNegocio);

    }

    public void IngresarClasificacionRiesgoAval(String ClasificacionRiesgoAval){
        txt_clasificacionRiesgoAval.clear();
        txt_clasificacionRiesgoAval.sendKeys(ClasificacionRiesgoAval);
    }

    public void IngresarAnalisisUnidadF(String AnalisisUnidadFinanciera){
        txt_analisisUnidadFinanciera.clear();
        txt_analisisUnidadFinanciera.sendKeys(AnalisisUnidadFinanciera);
    }


    public void ClickAnexarGarantias () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarGarantias));
        btn_AnexarGarantias.click();
    }

    public void ClickEnlazarEEFF () {
        //wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarEEFF));
        //btn_EnlazarEEFF.click();
        WebElement btn_EEFF = driver.findElement(By.xpath("//*[text() = 'Enlazar']"));
        String JScript = btn_EEFF.getAttribute("click");
        ((JavascriptExecutor)driver).executeScript(JScript);

    }


    public void IngresarComentariosRatios(String ComentariosRatios){
        txt_comentariosRatios.clear();
        txt_comentariosRatios.sendKeys(ComentariosRatios);
    }



    public void ClickDesenlazarInformeVisita() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_DesenlazarInformeVisita));
        btn_DesenlazarInformeVisita.click();
    }

    public void ClickEnlazarInformeVisita(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeVisita));
        btn_EnlazarInformeVisita.click();

    }

    public void ClickInformeComercial () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeComercial));
        btn_EnlazarInformeComercial.click();
    }

    public void ClickGrabar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
    }


    public void ClickbtnAprobar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Aprobar));
        btn_Aprobar.click();

    }



}
