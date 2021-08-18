package PageObjects;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//select[@name='moneda']") private WebElement cbx_moneda;
    @FindBy(xpath = "//input[@name='montoOperacion']") private WebElement txt_monto;
    @FindBy(xpath = "//input[@name='TasaInicial']") private WebElement lista_TasaInicial;


    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_calcular;

    @FindBy(xpath = "//select[@name='planPagos']") private WebElement cbx_planPagos; //Fija Vencida
    @FindBy(xpath = "//select[@name='modalidad']") private WebElement cbx_modalidad; //Libre Amortizacion
    @FindBy(xpath = "//input[@name='diasPlazo']") private WebElement txt_diasPlazo;
    @FindBy(xpath = "//input[@name='tasaPropuesta']") private WebElement txt_TasaPreferencial;
    @FindBy(xpath = "//select[@name='flgCuenta']") private WebElement cbx_desembolso; //GIRO BANCO DE LA NACION
    @FindBy(xpath = "//select[@name='idDepartamento']") private WebElement cbx_dptoDesembolso;
    @FindBy(xpath = "//select[@name='idProvincia']") private WebElement cbx_provDesembolso;
    @FindBy(xpath = "//select[@name='idDistrito']") private WebElement cbx_distDesembolso;
    @FindBy(xpath = "//input[@name='fechaProbableDesembolso']") private WebElement txt_fecha;
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

    }
/*
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

*/
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
        Thread.sleep(30000);
    }



    public void SeleccionarPlanPagos () throws InterruptedException {

        //Esperar(2);
       //Select cbx_planPagos = new Select(driver.findElement(By.xpath("//select[@name='planPagos']")));

        //cbx_planPagos.selectByVisibleText("Fija Vencida");
        //cbx_planPagos.SelectIndex(1);

        //Esperar(3);
        //WebElement cbx_planPagos = driver.findElement(By.xpath("//select[@name='planPagos']"));
        //new Select(cbx_planPagos).selectByVisibleText("Fija Vencida");

        //Select pagos = new Select(driver.findElement(By.xpath("//select[@name='planPagos']")));
        //String selectedComboValue = pagos.getFirstSelectedOption().getText();
        //System.out.println("Selected combo value." + selectedComboValue);

        wait.until(ExpectedConditions.elementToBeClickable(cbx_planPagos));
        cbx_planPagos.click();
        new Select(cbx_planPagos).selectByVisibleText("Fija Vencida");



    }

    public void SeleccionarModalidad () {
        //wait.until(ExpectedConditions.elementToBeClickable(cbx_modalidad));
        new Select(cbx_modalidad).selectByVisibleText("Libre Amortizacion");


        //Esperar(5);
    }

    public void IngresarDias (String Dias) {
        txt_diasPlazo.clear();
        txt_diasPlazo.sendKeys(Dias);
    }

    public void IngresarTasaPreferencial(String TasaPreferencial){
        txt_TasaPreferencial.clear();
        txt_TasaPreferencial.sendKeys(TasaPreferencial);
    }

    public void SeleccionarFormaDesembolso (String FormaDesembolso) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_desembolso));
        new Select(cbx_desembolso).selectByVisibleText(FormaDesembolso);
    }

    public void SeleccionarDepartamento (String Departamento) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_dptoDesembolso));
        new Select(cbx_dptoDesembolso).selectByValue(Departamento);
    }

    public void SeleccionarProvincia (String Provincia) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_provDesembolso));
        new Select (cbx_provDesembolso).selectByVisibleText(Provincia);
    }

    public void SeleccionarDistrito (String Distrito) {
        wait.until(ExpectedConditions.elementToBeClickable(cbx_distDesembolso));
        new Select (cbx_distDesembolso).selectByVisibleText(Distrito);
    }

    public void IngresarFechaDesembolso (String FechaDesembolso) {
        txt_fecha.clear();
        txt_fecha.sendKeys(FechaDesembolso);
    }

    public void IngresarNotas (String Notas) {
        txt_notas.clear();
        txt_notas.sendKeys(Notas);
    }

    public void ClickGrabar (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
        btn_grabar.click();
        Esperar(3);
    }


    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try{Thread.sleep(Milisegundos);}
        catch (InterruptedException e){
            e.printStackTrace();

        }
    }

}
