package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionFecha;
import Functions.funcionVentana;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OperacionCreditoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresOperacionCredito;
    private Alert MensajeAlerta;
    private funcionFecha objFuncionFecha = new funcionFecha();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //Mapear objetos
    @FindBy(xpath = "//select[@name='moneda']")
    private WebElement cbx_Moneda;
    @FindBy(xpath = "//input[@name='montoOperacion']")
    private WebElement txt_Monto;
    @FindBy(xpath = "//input[@name='TasaInicial']")
    private WebElement lista_TasaInicial;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Calcular;

    @FindBy(xpath = "//select[@name='planPagos']")
    private WebElement cbx_PlanPagos; //Fija Vencida
    @FindBy(xpath = "//select[@name='modalidad']")
    private WebElement cbx_Modalidad; //Libre Amortizacion
    @FindBy(xpath = "//input[@name='diasPlazo']")
    private WebElement txt_DiasPlazo;

    @FindBy(xpath = "//select[@name='opcion']")
    private WebElement cbx_OpcionPagos;
    @FindBy(xpath = "//select[@name='pago']")
    private WebElement cbx_DiaPagos;
    @FindBy(xpath = "//input[@name='numeroCuotas']")
    private WebElement txt_NumeroCuotas;

    @FindBy(xpath = "//input[@name='tasaPropuesta']")
    private WebElement txt_TasaPreferencial;
    @FindBy(xpath = "//select[@name='flgCuenta']")
    private WebElement cbx_Desembolso; //GIRO BANCO DE LA NACION

    @FindBy(xpath = "//select[@name='codigocuenta']//option[2]")
    private WebElement cbx_CodigoCuenta;

    @FindBy(xpath = "//select[@name='idDepartamento']")
    private WebElement cbx_Departamento;
    @FindBy(xpath = "//select[@name='idProvincia']")
    private WebElement cbx_Provincia;
    @FindBy(xpath = "//select[@name='idDistrito']")
    private WebElement cbx_Distrito;
    @FindBy(xpath = "//input[@name='fechaProbableDesembolso']")
    private WebElement txt_FechaDesembolso;
    @FindBy(xpath = "//textarea[@name='notas']")
    private WebElement txt_Notas;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Grabar; //windows onload

    public void AbrirVentanaOperacionCredito() {
        try {
            identificadoresOperacionCredito = driver.getWindowHandles();
            System.out.println(identificadoresOperacionCredito);
            String LastHandle = "";

            for (String identificadorOperacionCredito : identificadoresOperacionCredito) {
                LastHandle = identificadorOperacionCredito;
            }
            System.out.println(driver.getWindowHandles());
            driver.switchTo().window(LastHandle);
            System.out.println("Ultimo handle: " + driver.getWindowHandle() + "-" + driver.getTitle());
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana operacion credito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaOperacionCredito() {
        try {
            Integer SetSize = identificadoresOperacionCredito.size();
            Integer Index = 0;

            String[] Handles = new String[SetSize];
            for (String identificadorOperacionCredito : identificadoresOperacionCredito) {
                Handles[Index] = identificadorOperacionCredito;
                Index++;
            }
            driver.switchTo().window(Handles[0]);
            System.out.println("Handle inicial: " + Handles[0] + "-" + driver.getTitle());
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public OperacionCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    public void SeleccionarMoneda(String Moneda) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Moneda));
            new Select(cbx_Moneda).selectByVisibleText(Moneda);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el tipo moneda";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarMonto(String Monto) {
        try {
            txt_Monto.clear();
            txt_Monto.sendKeys(Monto);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el monto del credito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarTasaInicial(String TasaInicial) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lista_TasaInicial));
            lista_TasaInicial.sendKeys(TasaInicial);

        } catch (Exception Error) {
            detalleError = "Error al ingresar el porcentaje de tasa inicial";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnCalcular() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Calcular));
            btn_Calcular.click();
            objFuncionEsperar.EsperarTiempo(60);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton calcular";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarPlanPagos(String PlanPagos) {
        try {
            cbx_PlanPagos.sendKeys(PlanPagos);
            WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + PlanPagos + "']"));
            String JScript = Opcion.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar plan de pagos";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarModalidad(String Modalidad) {
        try {
            // Seleccionamos el valor textual de la opcion 'PlanPagos' en el combobox.
            cbx_Modalidad.sendKeys(Modalidad);

            // Buscamos el webelement de la opcion indicada en el xpath.
            WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + Modalidad + "']"));

            // Obtenemos el valor del atributo 'onclick' de la opcion indicada
            String JScript = Opcion.getAttribute("onclick");

            // Ejecutamos el script del contenido 'onclick' para simular el arraque del mismo como un click humano.
            ((JavascriptExecutor) driver).executeScript(JScript);

            // Esperamos unos segundos para que aparezca el proximo combobox.
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar modalidad de pago";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarDias(String Dias) {
        try {
            txt_DiasPlazo.clear();
            txt_DiasPlazo.sendKeys(Dias);
        } catch (Exception Error) {
            detalleError = "Error al ingresar dias";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarOpcionPagos(String OpcionPagos) {
        try {
            cbx_OpcionPagos.sendKeys(OpcionPagos);
            WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + OpcionPagos + "']"));
            String JScript = Opcion.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar opcion de pagos del credito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarDiaPagos(String DiaPagos) {
        try {
            Select Opcion = new Select(driver.findElement(By.xpath("//select[@name='pago']")));
            Opcion.selectByVisibleText(DiaPagos);
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton nueva operacion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarNumeroCuotas(String NumeroCuotas) {
        try {
            txt_NumeroCuotas.clear();
            txt_NumeroCuotas.sendKeys(NumeroCuotas);
        } catch (Exception Error) {
            detalleError = "Error al ingresar numero de cuotas";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarTasaPreferencial(String TasaPreferencial) {
        try {
            txt_TasaPreferencial.clear();
            txt_TasaPreferencial.sendKeys(TasaPreferencial);
        } catch (Exception Error) {
            detalleError = "Error al ingresar tasa preferencial";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarFormaDesembolso(String FormaDesembolso) {
        try {
            cbx_Desembolso.sendKeys(FormaDesembolso);
            WebElement desembolso = driver.findElement(By.xpath("//*[text()='" + FormaDesembolso + "']"));
            String JScript = desembolso.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar forma de desembolso";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarCodigoCuenta() {
        try {
            cbx_CodigoCuenta.click();
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar codigo de cuentas bancarias";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarDepartamento(String Departamento) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Departamento));
            new Select(cbx_Departamento).selectByVisibleText(Departamento);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar departamento";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarProvincia(String Provincia) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Provincia));
            new Select(cbx_Provincia).selectByVisibleText(Provincia);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar provincia";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarDistrito(String Distrito) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_Distrito));
            new Select(cbx_Distrito).selectByVisibleText(Distrito);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar distrito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ObtenerFechaDesembolso() {
        try {
            txt_FechaDesembolso.clear();
            txt_FechaDesembolso.sendKeys(objFuncionFecha.devolverFechaActual());
            objFuncionEsperar.EsperarTiempo(1);

        } catch (Exception Error) {
            detalleError = "Error al obtener fecha de desembolso";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarFechaDesembolso() {
        try {
            txt_FechaDesembolso.clear();
            txt_FechaDesembolso.sendKeys(objFuncionFecha.devolverFechaActual());
        } catch (Exception Error) {
            detalleError = "Error al ingresar fecha desembolso";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarNotas(String Notas) {
        try {
            txt_Notas.clear();
            txt_Notas.sendKeys(Notas);
        } catch (Exception Error) {
            detalleError = "Error al ingresar notas";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton grabar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ObtenerAlerta() {
        try {
            MensajeAlerta = driver.switchTo().alert();
            System.out.println("El mensaje de alerta es:" + MensajeAlerta.getText());
            MensajeAlerta.accept();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al aceptar alertas";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
