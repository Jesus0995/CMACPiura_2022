package PageObjects;

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

    //Mapear objetos
    @FindBy(xpath = "//select[@name='moneda']") private WebElement cbx_Moneda;
    @FindBy(xpath = "//input[@name='montoOperacion']") private WebElement txt_Monto;
    @FindBy(xpath = "//input[@name='TasaInicial']") private WebElement lista_TasaInicial;

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_Calcular;

    @FindBy(xpath = "//select[@name='planPagos']") private WebElement cbx_PlanPagos; //Fija Vencida
    @FindBy(xpath = "//select[@name='modalidad']") private WebElement cbx_Modalidad; //Libre Amortizacion
    @FindBy(xpath = "//input[@name='diasPlazo']") private WebElement txt_DiasPlazo;

    @FindBy(xpath = "//select[@name='opcion']") private WebElement cbx_OpcionPagos;
    @FindBy(xpath = "//select[@name='pago']") private WebElement cbx_DiaPagos;
    @FindBy(xpath = "//input[@name='numeroCuotas']") private WebElement txt_NumeroCuotas;

    @FindBy(xpath = "//input[@name='tasaPropuesta']") private WebElement txt_TasaPreferencial;
    @FindBy(xpath = "//select[@name='flgCuenta']") private WebElement cbx_Desembolso; //GIRO BANCO DE LA NACION

    @FindBy(xpath = "//select[@name='codigocuenta']") private WebElement cbx_CodigoCuenta;

    @FindBy(xpath = "//select[@name='idDepartamento']") private WebElement cbx_Departamento;
    @FindBy(xpath = "//select[@name='idProvincia']") private WebElement cbx_Provincia;
    @FindBy(xpath = "//select[@name='idDistrito']") private WebElement cbx_Distrito;
    @FindBy(xpath = "//input[@name='fechaProbableDesembolso']") private WebElement txt_FechaDesembolso;
    @FindBy(xpath = "//textarea[@name='notas']") private WebElement txt_Notas;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_Grabar; //windows onload


    public void AbrirVentanaOperacionCredito(){
        identificadoresOperacionCredito = driver.getWindowHandles();
        System.out.println(identificadoresOperacionCredito);
        String LastHandle ="";

        for (String identificadorOperacionCredito :identificadoresOperacionCredito ){
            LastHandle = identificadorOperacionCredito;
        }
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(LastHandle);
        System.out.println("Ultimo handle: "+driver.getWindowHandle()+"-"+driver.getTitle());

    }

    public void CerrarVentanaOperacionCredito(){
        Integer SetSize = identificadoresOperacionCredito.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorOperacionCredito : identificadoresOperacionCredito) {
            Handles[Index] = identificadorOperacionCredito;
            Index++;
        }
        driver.switchTo().window(Handles[0]);
        System.out.println("Handle inicial: "+Handles[0]+"-"+driver.getTitle());
    }


    public OperacionCreditoPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarMoneda(String Moneda){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Moneda));
        new Select(cbx_Moneda).selectByVisibleText(Moneda);
    }

    public void IngresarMonto(String Monto){
        txt_Monto.clear();
        txt_Monto.sendKeys(Monto);
    }

    public void IngresarTasaInicial(String TasaInicial){
        wait.until(ExpectedConditions.elementToBeClickable(lista_TasaInicial));
        lista_TasaInicial.sendKeys(TasaInicial);

    }

    public void ClickCalcular () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Calcular));
        btn_Calcular.click();
        Esperar(60);
    }

    public void SeleccionarPlanPagos (String PlanPagos) {
        cbx_PlanPagos.sendKeys(PlanPagos);
        WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + PlanPagos + "']"));
        String JScript = Opcion.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(2);
    }

    public void SeleccionarModalidad (String Modalidad) {
        // Seleccionamos el valor textual de la opcion 'PlanPagos' en el combobox.
        cbx_Modalidad.sendKeys(Modalidad);

        // Buscamos el webelement de la opcion indicada en el xpath.
        WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + Modalidad + "']"));

        // Obtenemos el valor del atributo 'onclick' de la opcion indicada
        String JScript = Opcion.getAttribute("onclick");

        // Ejecutamos el script del contenido 'onclick' para simular el arraque del mismo como un click humano.
        ((JavascriptExecutor) driver).executeScript(JScript);

        // Esperamos unos segundos para que aparezca el proximo combobox.
        Esperar(2);

    }

    public void IngresarDias (String Dias) {
        txt_DiasPlazo.clear();
        txt_DiasPlazo.sendKeys(Dias);
    }

    public void SeleccionarOpcionPagos(String OpcionPagos) {
        cbx_OpcionPagos.sendKeys(OpcionPagos);
        WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + OpcionPagos + "']"));
        String JScript = Opcion.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(3);
    }

    public void SeleccionarDiaPagos(String DiaPagos) {
        Select Opcion = new Select(driver.findElement(By.xpath("//select[@name='pago']")));
        Opcion.selectByVisibleText(DiaPagos);
        Esperar(3);
    }

    public void IngresarNumeroCuotas(String NumeroCuotas) {
        txt_NumeroCuotas.clear();
        txt_NumeroCuotas.sendKeys(NumeroCuotas);
    }


    public void IngresarTasaPreferencial(String TasaPreferencial){
        txt_TasaPreferencial.clear();
        txt_TasaPreferencial.sendKeys(TasaPreferencial);
    }

    public void SeleccionarFormaDesembolso (String FormaDesembolso) {
        cbx_Desembolso.sendKeys(FormaDesembolso);
        WebElement desembolso = driver.findElement(By.xpath("//*[text()='" + FormaDesembolso + "']"));
        String JScript = desembolso.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar (3);
    }

    public void SeleccionarCodigoCuenta(String CodigoCuenta){
        Select Cuenta = new Select(driver.findElement(By.xpath("//select[@name='codigocuenta']")));
        Cuenta.selectByVisibleText(CodigoCuenta);
        Esperar (3);
    }

    public void SeleccionarDepartamento (String Departamento) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Departamento));
        new Select (cbx_Departamento).selectByVisibleText(Departamento);
    }

    public void SeleccionarProvincia (String Provincia) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Provincia));
        new Select(cbx_Provincia).selectByVisibleText(Provincia);

    }

    public void SeleccionarDistrito (String Distrito) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Distrito));
        new Select(cbx_Distrito).selectByVisibleText(Distrito);

    }

    public void ObtenerFechaDesembolso(){
        Date Date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        txt_FechaDesembolso.clear();
        txt_FechaDesembolso.sendKeys(fecha.format(Date));
        Esperar(1);

    }

    public void IngresarFechaDesembolso (String FechaDesembolso) {
        txt_FechaDesembolso.clear();
        txt_FechaDesembolso.sendKeys(FechaDesembolso);
    }

    public void IngresarNotas (String Notas) {
        txt_Notas.clear();
        txt_Notas.sendKeys(Notas);
    }

    public void ClickGrabar () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
    }

    public void ObtenerAlerta() {
        MensajeAlerta = driver.switchTo().alert();
        System.out.println("El mensaje de alerta es:" + MensajeAlerta.getText());
        MensajeAlerta.accept();
        Esperar(2);
    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try{
            Thread.sleep(Milisegundos);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
