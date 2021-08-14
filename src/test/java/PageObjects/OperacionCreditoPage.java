package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class OperacionCreditoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresOperacionCredito;

    //Mapear objetos
    @FindBy(name = "moneda") private WebElement cbx_moneda;
    @FindBy(name ="montoOperacion") private WebElement txt_monto;
    @FindBy(xpath = "//input[@name='TasaInicial']") private WebElement txt_TasaInicial;


    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_calcular;
    @FindBy(name = "planPagos") private WebElement cbx_planPagos; //FijaVencida
    @FindBy(name = "modalidad") private WebElement cbx_modalidad; //Libre Amortizacion
    @FindBy(name = "diasPlazo") private WebElement txt_diasPlazo;
    @FindBy(name = "flgCuenta") private WebElement cbx_desembolso; //GIRO BANCO DE LA NACION
    @FindBy(id = "idDepartamento") private WebElement cbx_dptoDesembolso;
    @FindBy(id = "idProvincia") private WebElement cbx_provDesembolso;
    @FindBy(id = "idDistrito") private WebElement cbx_distDesembolso;
    @FindBy(name = "fechaProbableDesembolso") private WebElement txt_fecha;
    @FindBy(name = "notas") private WebElement txt_notas;
    @FindBy(xpath= "//button[@type=\"submit\"]") private WebElement btn_grabar; //windows onload


    public void AbrirVentanaOperacionCredito(){
        identificadoresOperacionCredito = driver.getWindowHandles();
        System.out.println(identificadoresOperacionCredito);
        String LastHandle ="";

        for (String identificadorOperacionCredito :identificadoresOperacionCredito ){
            LastHandle = identificadorOperacionCredito;
        }
        driver.switchTo().window(LastHandle);

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
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarMoneda(String moneda){
        wait.until(ExpectedConditions.elementToBeClickable(cbx_moneda));
        new Select(cbx_moneda).selectByValue(moneda);
    }
    public void IngresarMonto(String monto){
        txt_monto.clear();
        txt_monto.sendKeys(monto);
    }
    public void ClickCalcular (){

        btn_calcular.click();
    }
    public void SeleccionarPlanPagos (String planPagos){
        new Select(cbx_planPagos).selectByValue(planPagos);
    }
    public void SeleccionarModalidad (String modalidad) {
        new Select(cbx_modalidad).selectByValue(modalidad);
    }
    public void IngresarDias (String dias) {
        txt_diasPlazo.sendKeys(dias);
    }
    public void SeleccionarDesembolso (String desembolso) {
        new Select(cbx_desembolso).selectByValue(desembolso);
    }
    public void SeleccionarDpto (String dpto) {
        new Select(cbx_dptoDesembolso).selectByValue(dpto);
    }
    public void SeleccionarProv (String prov) {
        new Select (cbx_provDesembolso).selectByValue(prov);
    }
    public void SeleccionarDist (String dist) {
        new Select (cbx_distDesembolso).selectByValue(dist);
    }
    public void IngresarFecha (String fecha) {
        txt_fecha.sendKeys(fecha);
    }
    public void IngresarNotas (String notas) {
        txt_notas.sendKeys(notas);
    }
    public void ClickGrabar (){
        btn_grabar.click();
    }
}
