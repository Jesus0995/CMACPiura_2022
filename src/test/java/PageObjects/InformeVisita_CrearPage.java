package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionFecha;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InformeVisita_CrearPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionFecha objFuncionFecha = new funcionFecha();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//input[@name=\"fechaINI\"]") private WebElement txt_fechaVisita;
    @FindBy(xpath = "//input[@name=\"horaINI\"]")  private WebElement txt_hora;
    @FindBy(xpath = "//input[@name=\"minINI\"]")   private WebElement txt_minutos;
    @FindBy(xpath = "//select[@name=\"meridianoINI\"]") private WebElement cbx_franjaHoraria;

    //@FindBy(xpath = "") private WebElement cbo_direccionDomicilio;
    @FindBy(name = "numeroIntegrantes") private WebElement txt_nroIntegrantes;
    @FindBy(xpath = "//select[@name=\"relacionMiembros\"]") private WebElement cbx_relacionIntegrantes;
    @FindBy(xpath = "//select[@name=\"habitosMiembros\"]") private WebElement cbx_habitos;
    @FindBy(xpath = "//select[@name=\"hayGeneracionIngresos\"]") private WebElement cbx_otrosIngresos;

    //@FindBy(xpath = "") private WebElement cbx_direccionTrabajo;
    @FindBy(xpath = "//select[@name=\"estadoGarantia\"]") private WebElement cbx_relacionLaboral;
    @FindBy(xpath = "//select[@name=\"documentacionGarantia\"]") private WebElement cbx_documentoSustento;


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
    @FindBy(name = "observaciones") private WebElement txt_observacion;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/a/img") private WebElement btn_grabar;
    @FindBy(css = "td.P:nth-child(10) > a:nth-child(1)") private WebElement btn_regresar;
    @FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_RegresarCE;

    public InformeVisita_CrearPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ObtenerFechaVisita (){
        try {
            txt_fechaVisita.clear();
            objFuncionEsperar.EsperarTiempo(1);
            txt_fechaVisita.sendKeys(objFuncionFecha.devolverFechaActual());

        } catch (Exception Error) {
            detalleError = "Error al ingresar Fecha";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarHoraVisita(String HoraVisita) {
        try {
            txt_hora.clear();
            txt_hora.sendKeys(HoraVisita);
        } catch (Exception Error) {
            detalleError = "Error al ingresar Hora";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarMinutoVisita(String MinutoVisita) {
        try {
            txt_minutos.clear();
            txt_minutos.sendKeys(MinutoVisita);
        } catch (Exception Error) {
            detalleError = "Error al ingresar Minutos";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarFranjaHoraria(String FranjaHora) {
        try {
        cbx_franjaHoraria.sendKeys(FranjaHora);
        objFuncionEsperar.EsperarTiempo(1);

            /*
            WebElement franjaHora = driver.findElement(By.xpath("//select[@name='meridianoINI']//option[text()='" + FranjaHora + "']"));
            String JScript = franjaHora.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            */

        } catch (Exception Error) {
            detalleError = "Error al ingresar Franja Horaria";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarNroInteg(String NumeroIntegrantes) {
        try {
            txt_nroIntegrantes.clear();
            txt_nroIntegrantes.sendKeys(NumeroIntegrantes);
        } catch (Exception Error) {
            detalleError = "Error al ingresar Número de Integrantes";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarRelacion(String Relacion) {
        try {
        cbx_relacionIntegrantes.sendKeys(Relacion);
        objFuncionEsperar.EsperarTiempo(3);
      /*
            WebElement relacion = driver.findElement(By.xpath("//select[@name='relacionMiembros']//option[text()='" + Relacion + "']"));
            String JScript = relacion.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
       */
        } catch (Exception Error) {
            detalleError = "Error al seleccionar Relación";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void SeleccionarHabitos(String Habitos) {
        try {
        cbx_habitos.sendKeys(Habitos);
        objFuncionEsperar.EsperarTiempo(3);
        /*
            WebElement habitos = driver.findElement(By.xpath("//select[@name='habitosMiembros']//option[text()='" + Habitos + "']"));
            String JScript = habitos.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */
        } catch (Exception Error) {
            detalleError = "Error al seleccionar Hábitos";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarOtrosIngresos(String OtrosIngresos) {
        try {
        cbx_habitos.sendKeys(OtrosIngresos);
        objFuncionEsperar.EsperarTiempo(3);
     /*
            WebElement otrosIngresos = driver.findElement(By.xpath("//select[@name='hayGeneracionIngresos']//option[text()='" + OtrosIngresos + "']"));
            String JScript = otrosIngresos.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */
        } catch (Exception Error) {
            detalleError = "Error al seleccionar Otros Ingresos";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarRelacionLaboral(String RelacionLaboral) {
        try {
        cbx_relacionLaboral.sendKeys(RelacionLaboral);
        objFuncionEsperar.EsperarTiempo(3);
        /*
            WebElement relacionLaboral = driver.findElement(By.xpath("//select[@name='estadoGarantia']//option[text()='" + RelacionLaboral + "']"));
            String JScript = relacionLaboral.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */
        } catch (Exception Error) {
            detalleError = "Error al seleccionar Relación Laboral";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarDocumentoSustento(String DocumentoSustento) {
        try {
        cbx_documentoSustento.sendKeys(DocumentoSustento);
        objFuncionEsperar.EsperarTiempo(3);
     /*
            WebElement documentoSustento = driver.findElement(By.xpath("//select[@name='documentacionGarantia']//option[text()='" + DocumentoSustento + "']"));
            String JScript = documentoSustento.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */
        } catch (Exception Error) {
            detalleError = "Error al seleccionar Documento de Sustento";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarDireccionCorrecta(String DireccionNegocio) {
        try {
        cbx_DireccionNegocio.sendKeys(DireccionNegocio);
        objFuncionEsperar.EsperarTiempo(3);
     /*
            WebElement direccionNegocio = driver.findElement(By.xpath("//select[@name='esDireccionCorrecta1']//option[text()='" + DireccionNegocio + "']"));
            String JScript = direccionNegocio.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */

        } catch (Exception Error) {
            detalleError = "Error al seleccionar Direccion Correcta";
            objLogErrores.logError(detalleError,Error);
        }
    }


    public void SeleccionarEstadoGarantia(String EstadoGarantia) {
        try {
        cbx_EstadoGarantia.sendKeys(EstadoGarantia);
        objFuncionEsperar.EsperarTiempo(3);
        /*
            WebElement estadoGarantia = driver.findElement(By.xpath("//select[@name='estadoGarantia']//option[text()='" + EstadoGarantia + "']"));
            String JScript = estadoGarantia.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */

        } catch (Exception Error) {
            detalleError = "Error al seleccionar Estado de Garantía";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void SeleccionarDocumentoGarantia(String DocumentoGarantia) {
        try {
        cbx_DocumentoGarantia.sendKeys(DocumentoGarantia);
        objFuncionEsperar.EsperarTiempo(2);
      /*
            WebElement documentoGarantia = driver.findElement(By.xpath("//select[@name='documentacionGarantia']//option[text()='" + DocumentoGarantia + "']"));
            String JScript = documentoGarantia.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript); */

        } catch (Exception Error) {
            detalleError = "Error al seleccionar Documento de Garantía";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void SeleccionarConforme() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_conforme));
            opt_conforme.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar evaluación Conforme";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void SeleccionarNoLavado() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_lavadoActivo));
            opt_lavadoActivo.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar declaración No Lavado";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarAlerta() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_senalesAlerta));
            opt_senalesAlerta.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar declaración Señales de Alerta";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void SeleccionarLegal() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_legal));
            opt_legal.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar declaración Actividad Económica Legal";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarObservacion(String Observacion) {
        try {
            txt_observacion.clear();
            txt_observacion.sendKeys(Observacion);
        } catch (Exception Error) {
            detalleError = "Error al ingresar Observación";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
            btn_grabar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Grabar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnRegresar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
            btn_regresar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Regresar";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickBtnRegresarCE() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_RegresarCE));
            btn_RegresarCE.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Regresar";
            objLogErrores.logError(detalleError,Error);
        }
    }

}
