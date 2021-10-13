package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// from selenium.webdriver.common.keys import Keys  # Antes de usar el método de la tecla del teclado, primero debe importar el paquete de la clase de teclas.

import java.util.List;
import java.util.Set;

public class PropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de locator

    @FindBy(xpath = "//textarea[@name='comentCalifCred']")
    private WebElement txt_ClasificacionCrediticia;
    @FindBy(id = "txtobjetivo")
    private WebElement txt_ObjetivoCredito;
    @FindBy(id = "justificacion")
    private WebElement txt_JustificacionCredito;
    @FindBy(name = "btnEnviar")
    private WebElement btn_NuevaOperacion;
    @FindBy(xpath = "//img[@src='./images/mail-send-receive.png']")
    private WebElement icn_CambioTasa;
    @FindBy(name = "btnEnviar2")
    private WebElement btn_AgregarSeguro;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[8]/tbody/tr[1]/td[2]/button")
    private WebElement btn_AnexarChecklist;
    @FindBy(xpath = "//textarea[@id='txtcaracter']")
    private WebElement txt_CaracteristicaNegocio; //se cambio el name del nuevo ambiente //textarea[@name='caractNegocio']
    @FindBy(xpath = "//textarea[@id='txtclasificac']")
    private WebElement txt_ClasificacionRiesgoCliente;
    @FindBy(xpath = "//textarea[@id='txtclasificaAval']")
    private WebElement txt_ClasificacionRiesgoAval;
    @FindBy(xpath = "//textarea[@id='txtanalisisUEF']")
    private WebElement txt_AnalisisUnidadFinanciera;
    //nuevos cambios 29/09
    @FindBy(xpath = "//textarea[@id='txtProducServic']")
    private WebElement txt_Productos;
    @FindBy(xpath = "//textarea[@id='txtPrincClienProv']")
    private WebElement txt_PrincipalesClientes;
    @FindBy(xpath = "//textarea[@id='txtPersonalLabora']")
    private WebElement txt_PersonalLaboral;
    @FindBy(xpath = "//textarea[@id='txtSectorEconomic']")
    private WebElement txt_AnalisisSector;
    @FindBy(xpath = "//textarea[@id='txtProyeccCreci']")
    private WebElement txt_ProyeccionesCrecimiento;


    @FindBy(xpath = "//button[@name=\"btnGaranExist\"]")
    private WebElement btn_AnexarGarantias;
    @FindBy(xpath = "//textarea[@id='txtPrincipalRatio']")
    private WebElement txt_ComentariosRatios;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[1]/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a")
    private WebElement btn_Grabar;
    @FindBy(xpath = "//td[@id='NewDdTD']")
    private WebElement btn_Dictamen;
    @FindBy(xpath = "//img[@alt='Aprobar']")
    private WebElement btn_AprobarPropuesta;

    @FindBy(xpath = "//button[@name='btnEnviar2']")
    private WebElement btn_VerificarCheckListCredito;


    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[6]/td[3]/button")
    private WebElement btn_EnlazarEEFFGrupoVinculado;


    public PropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 140);
        PageFactory.initElements(driver, this);

    }

    public void IngresarClasificacionCrediticia(String clasificacion) {
        wait.until(ExpectedConditions.elementToBeClickable(txt_ClasificacionCrediticia));
        txt_ClasificacionCrediticia.clear();
        txt_ClasificacionCrediticia.sendKeys(clasificacion);
    }

    public void IngresarObjetivoCredito(String Objetivo) {
        txt_ObjetivoCredito.clear();
        txt_ObjetivoCredito.sendKeys(Objetivo);
    }

    public void IngresarJustificacionCredito(String Justificacion) {
        txt_JustificacionCredito.clear();
        txt_JustificacionCredito.sendKeys(Justificacion);
    }

    public void ClickBotonOperacion() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_NuevaOperacion));
        btn_NuevaOperacion.click();
    }

    public void ClickIcnCambioTasa() {
        wait.until(ExpectedConditions.elementToBeClickable(icn_CambioTasa));
        icn_CambioTasa.click();
    }

    public void ClickBotonRegistrarSeguro() {

        wait.until(ExpectedConditions.elementToBeClickable(btn_AgregarSeguro));
        btn_AgregarSeguro.click();
    }

    public void ClickAnexarCheckListCreditos() {

        wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarChecklist));
        btn_AnexarChecklist.click();
    }

    public void IngresarComentariosPropuesta() {
        List<WebElement> elementList = driver.findElements(By.tagName("textarea"));
        for (WebElement textarea : elementList) {
            textarea.sendKeys("descripcion general de la propuesta");
        }

    }

    public void IngresarCaracteristicaNegocio(String CaracteristicaNegocio) {
        txt_CaracteristicaNegocio.clear();
        txt_CaracteristicaNegocio.sendKeys(CaracteristicaNegocio);
    }

    public void IngresarClasificacionRiesgoCliente(String ClasificacionRiesgoNegocio) {
        txt_ClasificacionRiesgoCliente.clear();
        txt_ClasificacionRiesgoCliente.sendKeys(ClasificacionRiesgoNegocio);

    }

    public void IngresarClasificacionRiesgoAvales(String ClasificacionRiesgoAvales) {
        txt_ClasificacionRiesgoAval.clear();
        txt_ClasificacionRiesgoAval.sendKeys(ClasificacionRiesgoAvales);
    }

    public void IngresarAnalisisUnidadEconomicaFinanciera(String AnalisisUnidadEconomicaFinanciera) {
        txt_AnalisisUnidadFinanciera.clear();
        txt_AnalisisUnidadFinanciera.sendKeys(AnalisisUnidadEconomicaFinanciera);
    }


    public void ClickAnexarGarantias() {
        Esperar(2);
        wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarGarantias));
        btn_AnexarGarantias.click();
    }

    public void ClickEnlazarEEFF() {
        WebElement btn_EnlazarEEFF = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td/div/button"));

        String JScript = btn_EnlazarEEFF.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);

    }


    public void IngresarComentariosRatios(String ComentariosRatios) {
        txt_ComentariosRatios.clear();
        txt_ComentariosRatios.sendKeys(ComentariosRatios);
    }

    public void ClickDesenlazarInformeVisita() {
        WebElement btn_desenlazarInformeVisita = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[3]/button"));
        String JScript = btn_desenlazarInformeVisita.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void ClickDesenlazarInformeVisitaConsumo() {
        WebElement btn_desenlazarInformeVisitaConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[1]/td[3]/button"));
        String JScript = btn_desenlazarInformeVisitaConsumo.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void ClickEnlazarInformeVisita() {

        WebElement btn_enlazarInformeVisita = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[3]/button"));
        String JScript = btn_enlazarInformeVisita.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);

    }

    public void ClickEnlazarInformeVisitaConsumo() {
        WebElement btn_enlazarInformeVisitaConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[1]/td[3]/button"));
        String JScript = btn_enlazarInformeVisitaConsumo.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void ClickEnlazarInformeComercialNuevo() {
        WebElement btn_enlazarInformeComercial = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[3]/td[3]/button"));
        String JScript = btn_enlazarInformeComercial.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);

    }

    public void ClickEnlazarInformeComercialConsumo() {
        WebElement btn_enlazarInformeComercialConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[2]/td[3]/button"));
        String JScript = btn_enlazarInformeComercialConsumo.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void ClickEnlazarHojaTrabajo() {
        WebElement btn_enlazarInformeComercial = driver.findElement(By.xpath(" /html/body/form/table/tbody/tr[3]/td/div/table[16]/tbody/tr/td[3]/button"));
        String JScript = btn_enlazarInformeComercial.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void ClickMenuGrabarPropuesta() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
        Esperar(30);
    }

    public void AbrirOpcionesDictamen() {

        btn_Dictamen.click();
        Esperar(1);
    }


    public void ClickBtnAprobarPropuesta() {
        btn_AprobarPropuesta.click();
        Esperar(1);
    }

    public void ClickBtnVerificarCheckListCredito() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_VerificarCheckListCredito));
        btn_VerificarCheckListCredito.click();
    }

    //Fundamentacion credito adicionado el 29/09/2020---- inicio-----------
    public void IngresarProductosNegocio(String ProductosNegocio) {
        txt_Productos.clear();
        txt_Productos.sendKeys(ProductosNegocio);
    }

    public void IngresarPrincipalesClientes(String PrincipalesClientes) {
        txt_PrincipalesClientes.clear();
        txt_PrincipalesClientes.sendKeys(PrincipalesClientes);
    }

    public void IngresarPersonalNegocio(String PersonalNegocio) {
        txt_PersonalLaboral.clear();
        txt_PersonalLaboral.sendKeys(PersonalNegocio);
    }

    public void IngresarAnalisisSector(String AnalisisSector) {
        txt_AnalisisSector.clear();
        txt_AnalisisSector.sendKeys(AnalisisSector);
    }

    public void IngresarProyeccionesCrecimiento(String ProyeccionesCrecimiento) {
        txt_ProyeccionesCrecimiento.clear();
        txt_ProyeccionesCrecimiento.sendKeys(ProyeccionesCrecimiento);
    }
    //----------- fin de cambio 29/09/2021-----------------------


    public void ClickBtnEnlazarEEFFGrupoVinculadO() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarEEFFGrupoVinculado));
        btn_EnlazarEEFFGrupoVinculado.click();
    }


    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
