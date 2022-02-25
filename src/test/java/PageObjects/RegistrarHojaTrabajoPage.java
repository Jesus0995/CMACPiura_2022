package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class RegistrarHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Alert MensajeAlerta;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();


    //mapear locator
    @FindBy(xpath = "//input[@name='tiempoLaboral']")
    private WebElement txt_tiempoLaboral;
    @FindBy(xpath = "//input[@id='item_1001000']")
    private WebElement txt_ingresosBoleta;
    @FindBy(xpath = "//input[@id='item_1002000']")
    private WebElement txt_ingresosReciboHonorario;
    @FindBy(xpath = "//input[@id='item_2001000']")
    private WebElement txt_gastosAlimentacion;
    @FindBy(xpath = "//input[@id='item_2002000']")
    private WebElement txt_gastosTransporte;
    @FindBy(xpath = "//input[@id='item_2003000']")
    private WebElement txt_gastosEducacion;
    @FindBy(xpath = "//input[@id='item_2004000']")
    private WebElement txt_gastosVivienda;
    @FindBy(xpath = "//input[@id='item_2005000']")
    private WebElement txt_gastosServiciosBasicos;
    @FindBy(xpath = "//input[@id='item_2006000']")
    private WebElement txt_gastosOligacionesTerceros;
    @FindBy(xpath = "//input[@id='item_2008000']")
    private WebElement txt_descuentoBoleta;
    @FindBy(xpath = "//input[@id='item_2009000']")
    private WebElement txt_descuentoReciboHonorario;
    @FindBy(xpath = "//*[@id='btn_graba']")
    private WebElement btn_grabarHojaTrabajo;
    @FindBy(xpath = "//*[@id='btn_final']")
    private WebElement btn_finalizarHojaTrabajo;
    //@FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_regresarCrearHoja;

    public RegistrarHojaTrabajoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void TiempoLaboral(String TiempoLaboral) {
        try {
            txt_tiempoLaboral.clear();
            txt_tiempoLaboral.sendKeys(TiempoLaboral);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el tiempo laboral";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresosBoleta(String IngresosBoleta) {
        try {
            txt_ingresosBoleta.clear();
            txt_ingresosBoleta.sendKeys(IngresosBoleta);
        } catch (Exception Error) {
            detalleError = "Error al ingresar boletas";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresosReciboHonorario(String IngresosReciboHonorario) {
        try {
            txt_ingresosReciboHonorario.clear();
            txt_ingresosReciboHonorario.sendKeys(IngresosReciboHonorario);
        } catch (Exception Error) {
            detalleError = "Error al ingresar recibo honorarios";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void GastosAlimentacion(String GastosAlimentacion) {
        try {
            txt_gastosAlimentacion.clear();
            txt_gastosAlimentacion.sendKeys(GastosAlimentacion);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos alimentacion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void GastosTransporte(String GastosTransporte) {
        try {
            txt_gastosTransporte.clear();
            txt_gastosTransporte.sendKeys(GastosTransporte);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos de transportes";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void GastosEducacion(String GastosEducacion) {
        try {
            txt_gastosEducacion.clear();
            txt_gastosEducacion.sendKeys(GastosEducacion);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos educacion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void GastosVivienda(String GastosVivienda) {
        try {
            txt_gastosVivienda.clear();
            txt_gastosVivienda.sendKeys(GastosVivienda);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos vivienda";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void GastosServiciosBasicos(String GastosServiciosBasicos) {
        try {
            txt_gastosServiciosBasicos.clear();
            txt_gastosServiciosBasicos.sendKeys(GastosServiciosBasicos);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos de servicios basicos";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void GastosObligacionesTerceros(String GastosObligacionesTerceros) {
        try {
            txt_gastosOligacionesTerceros.clear();
            txt_gastosOligacionesTerceros.sendKeys(GastosObligacionesTerceros);
        } catch (Exception Error) {
            detalleError = "Error al ingresar gastos obligaciones terceros";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void DescuentoBoleta(String DescuentoBoleta) {
        try {
            txt_descuentoBoleta.clear();
            txt_descuentoBoleta.sendKeys(DescuentoBoleta);
        } catch (Exception Error) {
            detalleError = "Error al ingresar descuento boleta";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void DescuentoReciboHonorario(String DescuentoReciboHonorario) {
        try {
            txt_descuentoReciboHonorario.clear();
            txt_descuentoReciboHonorario.sendKeys(DescuentoReciboHonorario);
        } catch (Exception Error) {
            detalleError = "Error al ingresar descuento recibo honorarios";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void GrabarHojaTrabajo() {
        try {
            btn_grabarHojaTrabajo.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en grabar hoja trabajo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void FinalizarHojaTrabajo() {
        try {
            btn_finalizarHojaTrabajo.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en finalizar hoja de trabajo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ObtenerAlerta() {
        try {
            MensajeAlerta = driver.switchTo().alert();
            System.out.println("El mensaje de alerta es:" + MensajeAlerta.getText());
            MensajeAlerta.accept();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al obtener la alerta";
            objLogErrores.logError(detalleError, Error);
        }
    }

}