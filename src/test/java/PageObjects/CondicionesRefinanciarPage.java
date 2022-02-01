package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionVentana;
import Functions.funcionExcepciones;
import Functions.funcionEsperar;

import java.util.Set;

public class CondicionesRefinanciarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresCondicionRefinanciar;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private String ventanaUltima;
    private String detalleError;
    private Alert MensajeAlerta;


    @FindBy(id = "monto_amortizar") private WebElement txt_MontoAmortizar;
    @FindBy(name = "amortz") private WebElement txt_MontoAmortizarMismoPagare;
    @FindBy(xpath = "//input[@ value ='2']") private WebElement opt_CambioTasa;
    @FindBy(id = "interes_refinanciar") private WebElement txt_InteresRefinanciar;
    @FindBy(id = "grabar") private WebElement btn_Grabar;
    @FindBy(xpath = "//button[@type  = 'submit']") private WebElement btn_Siguiente;

    @FindBy(name = "tipoCronograma") private WebElement cbx_TipoCronograma;
    @FindBy(name = "modalidad") private WebElement cbx_ModalidadAmortizacion;
    @FindBy(name = "opcion") private WebElement cbx_ModalidadPago;
    @FindBy(name = "tipoCalculo") private WebElement cbx_TipoCalculo;
    @FindBy(name = "numeroCuotas") private WebElement txt_NumeroCuota;
    @FindBy(name = "fecha") private WebElement txt_FechaPago;


    public void AbrirVentanaCondicionRefinanciar() {
        try {
            objFuncionEsperar.EsperarTiempo(3);
            identificadoresCondicionRefinanciar = driver.getWindowHandles();
            System.out.println(identificadoresCondicionRefinanciar);
            String LastHandle = "";

            for (String identificadorCondicionRefinanciar : identificadoresCondicionRefinanciar) {
                LastHandle = identificadorCondicionRefinanciar;

            }
            driver.switchTo().window(LastHandle);
            System.out.println("Titulo : " + driver.getTitle());
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana garantia";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void CerrarVentanaCondicionRefinanciar() {
        try {
            Integer SetSize = identificadoresCondicionRefinanciar.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];

            for (String identificadorCondicionRefinanciar : identificadoresCondicionRefinanciar) {
                Handles[Index] = identificadorCondicionRefinanciar;
                Index++;

            }
            System.out.println(Handles[0]);
            driver.switchTo().window(Handles[0]);

        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public CondicionesRefinanciarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void IngresarMontoAmortizar(String MontoAmortizar) {
        try {
            objFuncionEsperar.EsperarTiempo(2);
            txt_MontoAmortizar.sendKeys(Keys.CONTROL,"A");
            txt_MontoAmortizar.sendKeys(MontoAmortizar);
        } catch (Exception Error) {
            detalleError = "Error al ingresar monto amortizar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarMontoAmortizarMismoPagare(String MontoAmortizar) {
        try {
            objFuncionEsperar.EsperarTiempo(2);
            txt_MontoAmortizarMismoPagare.sendKeys(Keys.CONTROL,"A");
            txt_MontoAmortizarMismoPagare.sendKeys(MontoAmortizar);
        } catch (Exception Error) {
            detalleError = "Error al ingresar monto amortizar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarInteresRefinanciar(String InteresRefinanciar) {
        try {
            objFuncionEsperar.EsperarTiempo(2);
            txt_InteresRefinanciar.sendKeys(Keys.CONTROL,"A");
            txt_InteresRefinanciar.sendKeys(InteresRefinanciar);
            } catch (Exception Error) {
            detalleError = "Error al ingresar interes a refinanciar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarCambioTasaRefinanciacion(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_CambioTasa));
            opt_CambioTasa.click();
            objFuncionEsperar.EsperarTiempo(1);
        }
        catch (Exception Error){
            detalleError = "Error al seleccionar opción de Cambio de Tasa";
            objLogErrores.logError(detalleError, Error);
        }
    }

//------------------------ Condiciones ----------------------------------------

    public void SeleccionarTipoCronograma(String Cronograma){
        try {
            cbx_TipoCronograma.sendKeys(Cronograma);
            WebElement OpcionCronograma = driver.findElement(By.xpath("//select[@name='tipoCronograma']//option[contains(text(),'"+Cronograma+"')]"));
            String JScript = OpcionCronograma.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(1);
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón Tipo Cronograma";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void SeleccionarModalidadAmortizacion(String Modalidad){
        try {
            cbx_ModalidadAmortizacion.sendKeys(Modalidad);
            objFuncionEsperar.EsperarTiempo(2);
            WebElement OpcionModalidad = driver.findElement(By.xpath("//select[@name='modalidad']//option[contains(text(),'"+Modalidad+"')]"));
            String JScript = OpcionModalidad.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(1);
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón Modalidad de Amortización";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void SeleccionarModalidadPago(String ModalidadPago){
        try {
            cbx_ModalidadPago.sendKeys(ModalidadPago);
            objFuncionEsperar.EsperarTiempo(1);
            WebElement OpcionPago = driver.findElement(By.xpath("//select[@name='opcion']//option[contains(text(),'"+ModalidadPago+"')]"));
            String JScript = OpcionPago.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(1);
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón de Modalidad de Pago";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarTipoCalculo(String TipoCalculo){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cbx_TipoCalculo));
            new Select(cbx_TipoCalculo).selectByVisibleText(TipoCalculo);
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón Tipo de Calculo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarNumeroCuotas(String NumeroCuotas){
        try {
            txt_NumeroCuota.clear();
            txt_NumeroCuota.sendKeys(NumeroCuotas);
        }
        catch (Exception Error){
            detalleError = "Error al ingresar Número de Cuotas";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarFechaPago(String FechaPago){
        try {
            objFuncionEsperar.EsperarTiempo(3);
            txt_FechaPago.clear();
            txt_FechaPago.sendKeys(FechaPago);
        }
        catch (Exception Error){
            detalleError = "Error al registar Fecha de Pago";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(3);


        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton grabar";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickBtnSiguiente() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Siguiente));
            btn_Siguiente.click();
            objFuncionEsperar.EsperarTiempo(3);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton Siguiente";
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
