package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionFecha;

import java.util.List;

public class InformeVisitaVerificacionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionFecha objFuncionFecha = new funcionFecha();
    private String detalleError = new String();
    
    @FindBy(name = "fechaINI") private WebElement txt_FechaInicioVisita;
    @FindBy(name = "fechaFIN") private WebElement txt_FechaFinVisita;
    @FindBy(name = "horaINI") private WebElement txt_HoraInicioVisita;
    @FindBy(name = "minINI") private WebElement txt_MinInicioVisita;
    @FindBy(name = "horaFIN") private WebElement txt_HoraFinVisita;
    @FindBy(name = "minFIN")  private WebElement txt_MinFinVisita;
    @FindBy(name = "horaEMP") private WebElement txt_HoraEmpVisita;
    @FindBy(name = "minEMP") private WebElement txt_MinEmpVisita;
    @FindBy(name = "detalleresultado") private WebElement txt_DetalleResultado;
    @FindBy(xpath = "//img[@alt=\"Grabar\"]") private WebElement btn_Grabar;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[4]") private WebElement btn_Finalizar;

    public InformeVisitaVerificacionPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);

    }

    public void IngresarFechaInicioVisita() {
        try {
            txt_FechaInicioVisita.clear();
            txt_FechaInicioVisita.sendKeys(objFuncionFecha.devolverFechaActual());

        } catch (Exception Error) {
            detalleError = "Error al ingresar la fecha inicio de visita";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void IngresarFechaFinVisita() {
        try {
            txt_FechaFinVisita.clear();
            txt_FechaFinVisita.sendKeys(objFuncionFecha.devolverFechaActual());

        } catch (Exception Error) {
            detalleError = "Error al ingresar la fecha fin de visita";
            objLogErrores.logError(detalleError, Error);

        }

    }

    public void IngresarHoraInicioVisita(String HoraInicioVisita) {
        try {
            txt_HoraInicioVisita.clear();
            txt_HoraInicioVisita.sendKeys(HoraInicioVisita);

        } catch (Exception Error) {
            detalleError = "Error al ingresar la hora inicio de visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarMinInicioVisita(String MinInicioVisita) {
        try {
            txt_MinInicioVisita.clear();
            txt_MinInicioVisita.sendKeys(MinInicioVisita);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el minuto inicio de visita";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void IngresarHoraFinVisita(String HoraFinVisita) {
        try {
            txt_HoraFinVisita.clear();
            txt_HoraFinVisita.sendKeys(HoraFinVisita);

        } catch (Exception Error) {
            detalleError = "Error al ingresar la hora fin de visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarMinFinVisita(String MinFinVisita) {
        try {
            txt_MinFinVisita.clear();
            txt_MinFinVisita.sendKeys(MinFinVisita);

        } catch (Exception Error) {
            detalleError = "Error al ingresar el minuto fin de visita";
            objLogErrores.logError(detalleError, Error);


        }
    }

    public void IngresarHoraEmpleadaVisita(String HoraEmpVisita) {
        try {
            txt_HoraEmpVisita.clear();
            txt_HoraEmpVisita.sendKeys(HoraEmpVisita);
        } catch (Exception Error) {
            detalleError = "Error al ingresar la hora empleada de la visita";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void IngresarMinEmpleadaVisita(String MinEmpVisita) {
        try {
            txt_MinEmpVisita.clear();
            txt_MinEmpVisita.sendKeys(MinEmpVisita);
        } catch (Exception Error) {
            detalleError = "Error al ingresar los minutos empleados de la visita";
            objLogErrores.logError(detalleError, Error);

        }
    }


    public void IngresarDetalleResultado(String DetalleResultado) {
        try {
            txt_DetalleResultado.clear();
            txt_DetalleResultado.sendKeys(DetalleResultado);

        } catch (Exception Error) {
            detalleError = "Error al ingresar el detalle del resultado";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void IngresarComentarios() {
        try {
            List<WebElement> elementList = driver.findElements(By.tagName("textarea"));
            for (WebElement textarea : elementList) {
                textarea.sendKeys("detalle de visita");
            }

        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios en el informe";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton Grabar";
            objLogErrores.logError(detalleError, Error);

        }


    }

    public void ClickBtnFinalizar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Finalizar));
            btn_Finalizar.click();
            objFuncionEsperar.EsperarTiempo(1);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton Finalizar";
            objLogErrores.logError(detalleError, Error);

        }
    }

}
