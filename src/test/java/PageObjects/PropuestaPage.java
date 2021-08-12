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
    @FindBy(name = "btnEnviar2") private WebElement btn_AgregarSeguro;
    @FindBy(xpath = "//button[@onclick=\"window.open('anexaCheckList.jsp', 'Anexo Check List 93F33861F69D989C9B85816814AEAA8A', 'toolbar=no,scrollbars=yes,location=no,status=no,menubar=no,resizable=yes,width=690,height=500,dependent=yes');\"]") private WebElement btn_Checklist;
    @FindBy(name = "btnGaranExist") private WebElement btn_AgregarGarantias;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/button") private  WebElement btn_EnlazarEstadosFinancieros;
    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[1]/td[3]/button") private WebElement btn_EnlazarInformeVisita;
    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[3]/td[3]/button") private WebElement btn_EnlazarInformeComercial;

    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[1]/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a")private WebElement btn_Grabar;
    //@FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[2]/tbody/tr[1]/td/a") private WebElement btn_Aprobar;

    //metodo para abrir ventana
    /*
    public void AbrirVentanaPropuesta(){
        Set<String> IdentificadorPropuesta = driver.getWindowHandles();
       for (String identificador3 : IdentificadorPropuesta ){
           driver.switchTo().window(identificador3);
       }
    }
    */


    public PropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,140);
        PageFactory.initElements(driver,this);

    }

    public void IngresarClasificacionCrediticia (){
        wait.until(ExpectedConditions.elementToBeClickable(txt_ClasificacionCrediticia));
        txt_ClasificacionCrediticia.clear();
        txt_ClasificacionCrediticia.sendKeys("prueba");}

    public void IngresarObjetivoCredto () {
        txt_ObjetivoCredito.clear();
        txt_ObjetivoCredito.sendKeys("prueba");}

    public void IngresarJustificacionCredito () {
        txt_JustificacionCredito.clear();
        txt_JustificacionCredito.sendKeys("prueba");}

    public void ClickBotonOperacion () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_NuevaOperacion));
        btn_NuevaOperacion.click();}

    public void ClickBtnSeguro () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_AgregarSeguro));
        btn_AgregarSeguro.click();}

    public void CickAnexarCheckList () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Checklist));
        btn_Checklist.click();}



    public void ClickAnexarGarantias () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_AgregarGarantias));
        btn_AgregarGarantias.click();}

    public void ClickEnlazarEstadosFinancieros () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarEstadosFinancieros));
        btn_EnlazarEstadosFinancieros.click();}

    public void ClickEnlazarInformeVisita() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeVisita));
        btn_EnlazarInformeVisita.click();}

    public void ClickInformeComercial () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeComercial));
        btn_EnlazarInformeComercial.click();}

    public void ClickGrabar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();}



}
