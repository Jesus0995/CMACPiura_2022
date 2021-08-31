package PageObjects;

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

public class OperacionCreditoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresOperacionCredito;
    private Alert MensajeAlerta;

    //Mapear objetos
    @FindBy(xpath = "//select[@name='moneda']") private WebElement cbx_moneda;
    @FindBy(xpath = "//input[@name='montoOperacion']") private WebElement txt_monto;
    @FindBy(xpath = "//input[@name='TasaInicial']") private WebElement lista_TasaInicial;


    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_calcular;

    @FindBy(xpath = "//select[@name='planPagos']") private WebElement cbx_planPagos; //Fija Vencida
    @FindBy(xpath = "//select[@name='modalidad']") private WebElement cbx_modalidad; //Libre Amortizacion
    @FindBy(xpath = "//input[@name='diasPlazo']") private WebElement txt_diasPlazo;

    @FindBy(xpath = "//select[@name='opcion']") private WebElement cbx_opcionPagos;
    @FindBy(xpath = "//select[@name='pago']") private WebElement cbx_diaPagos;
    @FindBy(xpath = "//input[@name='numeroCuotas']") private WebElement txt_numeroCuotas;



    @FindBy(xpath = "//input[@name='tasaPropuesta']") private WebElement txt_TasaPreferencial;
    @FindBy(xpath = "//select[@name='flgCuenta']") private WebElement cbx_desembolso; //GIRO BANCO DE LA NACION

    @FindBy(xpath = "//select[@name='codigocuenta']") private WebElement cbx_codigoCuenta;

    @FindBy(xpath = "//select[@name='idDepartamento']") private WebElement cbx_Departamento;
    @FindBy(xpath = "//select[@name='idProvincia']") private WebElement cbx_Provincia;
    @FindBy(xpath = "//select[@name='idDistrito']") private WebElement cbx_Distrito;
    @FindBy(xpath = "//input[@name='fechaProbableDesembolso']") private WebElement txt_fechaDesembolso;
    @FindBy(xpath = "//textarea[@name='notas']") private WebElement txt_notas;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_grabar; //windows onload


    public void AbrirVentanaOperacionCredito(){
        identificadoresOperacionCredito = driver.getWindowHandles();
        System.out.println(identificadoresOperacionCredito);
        String LastHandle ="";

        for (String identificadorOperacionCredito :identificadoresOperacionCredito ){
            LastHandle = identificadorOperacionCredito;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaOperacionCredito(){
        Integer SetSize = identificadoresOperacionCredito.size();
        Integer Index=0;

        String[] Handles = new String[SetSize] ;
        for (String identificadorOperacionCredito : identificadoresOperacionCredito) {
            Handles[Index] = identificadorOperacionCredito;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public OperacionCreditoPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarMoneda(String Moneda){
        System.out.println("Handles:" + driver.getWindowHandle());
        System.out.println("Title: " + driver.getTitle());

        wait.until(ExpectedConditions.elementToBeClickable(cbx_moneda));
        new Select(cbx_moneda).selectByVisibleText(Moneda);
    }

    public void IngresarMonto(String Monto){
        txt_monto.clear();
        txt_monto.sendKeys(Monto);
    }

    public void IngresarTasaInicial(String TasaInicial){
        wait.until(ExpectedConditions.elementToBeClickable(lista_TasaInicial));
        lista_TasaInicial.sendKeys(TasaInicial);

    }

    public void ClickCalcular () throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btn_calcular));
        btn_calcular.click();
        Thread.sleep(10000);
    }



    public void SeleccionarPlanPagos (String PlanPagos)  {
        // Seleccionamos el valor textual de la opcion 'PlanPagos' en el combobox.
        cbx_planPagos.sendKeys(PlanPagos);

        // Buscamos el webelement de la opcion indicada en el xpath.
        WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + PlanPagos + "']"));

        // Obtenemos el valor del atributo 'onclick' de la opcion indicada
        String JScript = Opcion.getAttribute("onclick");

        // Ejecutamos el script del contenido 'onclick' para simular el arraque del mismo como un click humano.
        ((JavascriptExecutor) driver).executeScript(JScript);

        // Esperamos unos segundos para que aparezca el proximo combobox.
        Esperar(2);
    }

    public void SeleccionarModalidad (String Modalidad) {
        // Seleccionamos el valor textual de la opcion 'PlanPagos' en el combobox.
        cbx_modalidad.sendKeys(Modalidad);

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
        txt_diasPlazo.clear();
        txt_diasPlazo.sendKeys(Dias);
    }

    public void SeleccionarOpcionPagos(String OpcionPagos) {
        cbx_opcionPagos.sendKeys(OpcionPagos);
        WebElement Opcion = driver.findElement(By.xpath("//*[text() = '" + OpcionPagos + "']"));
        String JScript = Opcion.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(3);
    }

    public void SeleccionarDiaPagos(String DiaPagos) {
        cbx_diaPagos.sendKeys(DiaPagos);
        WebElement Opcion = driver.findElement(By.xpath("//select[@name='pago']//option[@value = '"+DiaPagos+"']"));
        String JScript = Opcion.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar(3);
    }

    public void IngresarNumeroCuotas(String NumeroCuotas) {
        txt_numeroCuotas.clear();
        txt_numeroCuotas.sendKeys(NumeroCuotas);
    }


    public void IngresarTasaPreferencial(String TasaPreferencial){
        txt_TasaPreferencial.clear();
        txt_TasaPreferencial.sendKeys(TasaPreferencial);
    }

    public void SeleccionarFormaDesembolso (String FormaDesembolso) {
        cbx_desembolso.sendKeys(FormaDesembolso);
        WebElement desembolso = driver.findElement(By.xpath("//*[text()='" + FormaDesembolso + "']"));
        String JScript = desembolso.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar (3);
    }

    public void SeleccionarCodigoCuenta(String CodigoCuenta){
        cbx_codigoCuenta.sendKeys(CodigoCuenta);
        WebElement desembolso = driver.findElement(By.xpath("//select[@name='codigocuenta']//option[@value = '"+CodigoCuenta+ "']"));
        String JScript = desembolso.getAttribute("onclick");
        ((JavascriptExecutor) driver).executeScript(JScript);
        Esperar (3);
    }

    public void SeleccionarDepartamento (String Departamento) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Departamento));
        new Select (cbx_Departamento).selectByVisibleText(Departamento);

        //String JScript = cbx_dptoDesembolso.getAttribute("click");
        //((JavascriptExecutor) driver).executeScript(JScript);
        //Esperar(1);
    }

    public void SeleccionarProvincia (String Provincia) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Provincia));
        new Select(cbx_Provincia).selectByVisibleText(Provincia);

    }

    public void SeleccionarDistrito (String Distrito) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_Distrito));
        new Select(cbx_Distrito).selectByVisibleText(Distrito);

    }

    public void IngresarFechaDesembolso (String FechaDesembolso) {
        txt_fechaDesembolso.clear();
        txt_fechaDesembolso.sendKeys(FechaDesembolso);
    }

    public void IngresarNotas (String Notas) {
        txt_notas.clear();
        txt_notas.sendKeys(Notas);
    }

    public void ClickGrabar () {
        wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
        btn_grabar.click();
        //Esperar(1);
    }
    public void ObtenerAlerta() {

        MensajeAlerta = driver.switchTo().alert();
        System.out.println("El mensaje de alerta es:" + MensajeAlerta.getText());
        MensajeAlerta.accept();

        Esperar(2);
        }



    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try{Thread.sleep(Milisegundos);}
        catch (InterruptedException e){
            e.printStackTrace();

        }
    }

}
