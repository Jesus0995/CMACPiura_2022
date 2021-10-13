package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InformeVisita_CrearPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//input[@name=\"fechaINI\"]")
    private WebElement txt_fechaVisita;
    @FindBy(xpath = "//input[@name=\"horaINI\"]")
    private WebElement txt_hora;
    @FindBy(xpath = "//input[@name=\"minINI\"]")
    private WebElement txt_minutos;
    @FindBy(xpath = "//select[@name=\"meridianoINI\"]")
    private WebElement cbx_franjaHoraria;

    //@FindBy(xpath = "") private WebElement cbo_direccionDomicilio;
    @FindBy(name = "numeroIntegrantes")
    private WebElement txt_nroIntegrantes;
    @FindBy(xpath = "//select[@name=\"relacionMiembros\"]")
    private WebElement cbx_relacionIntegrantes;
    @FindBy(xpath = "//select[@name=\"habitosMiembros\"]")
    private WebElement cbx_habitos;
    @FindBy(xpath = "//select[@name=\"hayGeneracionIngresos\"]")
    private WebElement cbx_otrosIngresos;

    //@FindBy(xpath = "") private WebElement cbx_direccionTrabajo;
    @FindBy(xpath = "//select[@name=\"estadoGarantia\"]")
    private WebElement cbx_relacionLaboral;
    @FindBy(xpath = "//select[@name=\"documentacionGarantia\"]")
    private WebElement cbx_documentoSustento;


    //verificacion del negocio;
    @FindBy(xpath = "//select[@name='esDireccionCorrecta1']")
    private WebElement cbx_DireccionNegocio;
    @FindBy(xpath = "//select[@name='estadoGarantia']")
    private WebElement cbx_EstadoGarantia;
    @FindBy(xpath = "//select[@name='documentacionGarantia']")
    private WebElement cbx_DocumentoGarantia;


    @FindBy(name = "valuacionPerito")
    private WebElement opt_conforme;
    @FindBy(name = "lavact1")
    private WebElement opt_lavadoActivo;
    @FindBy(name = "lavact2")
    private WebElement opt_senalesAlerta;
    @FindBy(name = "lavact3")
    private WebElement opt_legal;
    @FindBy(name = "observaciones")
    private WebElement txt_observacion;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/a/img")
    private WebElement btn_grabar;
    @FindBy(css = "td.P:nth-child(10) > a:nth-child(1)")
    private WebElement btn_regresar;
    @FindBy(xpath = "//img[@alt='Regresar']")
    private WebElement btn_RegresarCE;

    public InformeVisita_CrearPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ObtenerFechaVisita() {

        Date Date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        txt_fechaVisita.clear();
        txt_fechaVisita.sendKeys(fecha.format(Date));
        Esperar(1);
        /*
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String Fecha = formatter.format(date);
        txt_fechaVisita.clear();
        txt_fechaVisita.sendKeys(Fecha);
        Esperar(1);
        */

    }

    public void IngresarFechaVisita (String FechaVisita){
        txt_fechaVisita.clear();
        txt_fechaVisita.sendKeys(FechaVisita);
    }

    public void IngresarHoraVisita(String HoraVisita) {
        txt_hora.clear();
        txt_hora.sendKeys(HoraVisita);
    }

    public void IngresarMinutoVisita(String MinutoVisita) {
        txt_minutos.clear();
        txt_minutos.sendKeys(MinutoVisita);
    }

    public void IngresarFranjaHoraria(String FranjaHora) {
        cbx_franjaHoraria.sendKeys(FranjaHora);
        Esperar(3);
        try {
            WebElement franjaHora = driver.findElement(By.xpath("//select[@name='meridianoINI']//option[text()='" + FranjaHora + "']"));
            String JScript = franjaHora.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void IngresarNroInteg(String NumeroIntegrantes) {
        txt_nroIntegrantes.clear();
        txt_nroIntegrantes.sendKeys(NumeroIntegrantes);
    }

    public void SeleccionarRelacion(String Relacion) {
        cbx_relacionIntegrantes.sendKeys(Relacion);
        Esperar(3);
        try {
            WebElement relacion = driver.findElement(By.xpath("//select[@name='relacionMiembros']//option[text()='" + Relacion + "']"));
            String JScript = relacion.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void SeleccionarHabitos(String Habitos) {
        cbx_habitos.sendKeys(Habitos);
        Esperar(3);
        try {
            WebElement habitos = driver.findElement(By.xpath("//select[@name='habitosMiembros']//option[text()='" + Habitos + "']"));
            String JScript = habitos.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void SeleccionarOtrosIngresos(String OtrosIngresos) {
        cbx_habitos.sendKeys(OtrosIngresos);
        Esperar(3);
        try {
            WebElement otrosIngresos = driver.findElement(By.xpath("//select[@name='hayGeneracionIngresos']//option[text()='" + OtrosIngresos + "']"));
            String JScript = otrosIngresos.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void SeleccionarRelacionLaboral(String RelacionLaboral) {
        cbx_relacionLaboral.sendKeys(RelacionLaboral);
        Esperar(3);
        try {
            WebElement relacionLaboral = driver.findElement(By.xpath("//select[@name='estadoGarantia']//option[text()='" + RelacionLaboral + "']"));
            String JScript = relacionLaboral.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void SeleccionarDocumentoSustento(String DocumentoSustento) {
        cbx_documentoSustento.sendKeys(DocumentoSustento);
        Esperar(3);
        try {
            WebElement documentoSustento = driver.findElement(By.xpath("//select[@name='documentacionGarantia']//option[text()='" + DocumentoSustento + "']"));
            String JScript = documentoSustento.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void SeleccionarDireccionCorrecta(String DireccionNegocio) {
        cbx_DireccionNegocio.sendKeys(DireccionNegocio);
        Esperar(3);
        try {
            WebElement direccionNegocio = driver.findElement(By.xpath("//select[@name='esDireccionCorrecta1']//option[text()='" + DireccionNegocio + "']"));
            String JScript = direccionNegocio.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);

        } catch (Exception error) {
            System.out.println(error.getMessage());

        }

    }


    public void SeleccionarEstadoGarantia(String EstadoGarantia) {
        cbx_EstadoGarantia.sendKeys(EstadoGarantia);
        Esperar(3);
        try {
            WebElement estadoGarantia = driver.findElement(By.xpath("//select[@name='estadoGarantia']//option[text()='" + EstadoGarantia + "']"));
            String JScript = estadoGarantia.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);

        } catch (Exception error) {
            System.out.println(error.getMessage());

        }

    }

    public void SeleccionarDocumentoGarantia(String DocumentoGarantia) {
        cbx_DocumentoGarantia.sendKeys(DocumentoGarantia);
        Esperar(2);
        try {
            WebElement documentoGarantia = driver.findElement(By.xpath("//select[@name='documentacionGarantia']//option[text()='" + DocumentoGarantia + "']"));
            String JScript = documentoGarantia.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);

        } catch (Exception error) {
            System.out.println(error.getMessage());

        }

    }

    public void SeleccionarConforme() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_conforme));
        opt_conforme.click();
    }

    public void SeleccionarNoLavado() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_lavadoActivo));
        opt_lavadoActivo.click();
    }

    public void SeleccionarAlerta() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_senalesAlerta));
        opt_senalesAlerta.click();
    }

    public void SeleccionarLegal() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_legal));
        opt_legal.click();
    }

    public void IngresarObservacion(String Observacion) {
        txt_observacion.clear();
        txt_observacion.sendKeys(Observacion);
    }

    public void ClickGrabar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
        btn_grabar.click();
    }

    public void ClickRegresar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
        btn_regresar.click();
        //Esperar(1);
    }

    public void ClickBtnRegresarCE() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_RegresarCE));
        btn_RegresarCE.click();
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
