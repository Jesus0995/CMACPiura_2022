package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionFecha;
import Functions.funcionVentana;
import org.apache.xpath.operations.Variable;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class CondicionesReprogramacionPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String detalleError;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionFecha objFuncionFecha = new funcionFecha();
    private String ventanaUltima;
    private Alert MensajeAlerta;

    @FindBy(name = "amortz") private WebElement txt_Amortizacion;
    @FindBy(xpath= "//button[@type='submit']") private WebElement btn_Siguiente;
    @FindBy(id = "nroinforme") private WebElement txt_Informe;
    @FindBy(xpath = "//select[@name='tipoCronograma']") private WebElement cbx_TipoCronograma;
    @FindBy(xpath = "//select[@name='modalidad']") private WebElement cbx_ModalidadAmortizacion;
    @FindBy(name = "opcion") private WebElement cbx_ModalidadPago;
    @FindBy(name = "tipoCalculo") private WebElement cbx_TipoCalculo;
    @FindBy(name = "numeroCuotas") private WebElement txt_NumeroCuota;
    @FindBy(xpath = "//input[@id='fecha']") private WebElement txt_FechaPago;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Grabar;


    public void AbrirVentanaCondicionesReprogramacion(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarTiempo(2);
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Operación Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void CerrarVentanaCondicionesReprogramacion(){
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");

        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Operación Crédito";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public CondicionesReprogramacionPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void IngresarAmortizacionReprogramacion(String Amortizacion){
        try {
            objFuncionEsperar.EsperarTiempo(1);
            txt_Amortizacion.clear();
            txt_Amortizacion.sendKeys(Amortizacion);
        }
        catch (Exception Error){
            detalleError = "Error al ingresar monto de Amortización";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarCambioTasaReprogramacion(String OpcionCambio){
        try {
            WebElement opt_CambioTasa = driver.findElement(By.xpath("//td[@Class=\"Invisible\"]//b[contains(text(),'"+OpcionCambio+"')]/following::td[1]//input[@type='radio']"));
            opt_CambioTasa.click();
            objFuncionEsperar.EsperarTiempo(1);
        }
        catch (Exception Error){
            detalleError = "Error al seleccionar opción de Cambio de Tasa";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnSiguienteReprogramacion(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Siguiente));
            btn_Siguiente.click();
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón Siguiente";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarInforme(String Informe){
        try {
            txt_Informe.clear();
            txt_Informe.sendKeys(Informe);
        }
        catch (Exception Error){
            detalleError = "Error al ingresar informe";
            objLogErrores.logError(detalleError, Error);
        }
    }

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
            detalleError = "Error al ingresar Fecha de Pago";
            objLogErrores.logError(detalleError, Error);
            txt_FechaPago.sendKeys(objFuncionFecha.FormatoFecha(FechaPago));
        }
    }

    public void ClickBtnGrabar(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(2);
        }
        catch (Exception Error){
            detalleError = "Error al hacer click en el botón Cargar";
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
