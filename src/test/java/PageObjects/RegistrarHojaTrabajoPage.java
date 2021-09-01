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

public class RegistrarHojaTrabajoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Alert MensajeAlerta;


    //mapear locator
    @FindBy(xpath = "//input[@name='tiempoLaboral']") private WebElement txt_tiempoLaboral;
    @FindBy(xpath = "//input[@id='item_1001000']") private WebElement txt_ingresosBoleta;
    @FindBy(xpath = "//input[@id='item_1002000']") private WebElement txt_ingresosReciboHonorario;
    @FindBy(xpath = "//input[@id='item_2001000']") private WebElement txt_gastosAlimentacion;
    @FindBy(xpath = "//input[@id='item_2002000']") private WebElement txt_gastosTransporte;
    @FindBy(xpath = "//input[@id='item_2003000']") private WebElement txt_gastosEducacion;
    @FindBy(xpath = "//input[@id='item_2004000']") private WebElement txt_gastosVivienda;
    @FindBy(xpath = "//input[@id='item_2005000']") private WebElement txt_gastosServiciosBasicos;
    @FindBy(xpath = "//input[@id='item_2006000']") private WebElement txt_gastosOligacionesTerceros;
    @FindBy(xpath = "//input[@id='item_2008000']") private WebElement txt_descuentoBoleta;
    @FindBy(xpath = "//input[@id='item_2009000']") private WebElement txt_descuentoReciboHonorario;
    @FindBy(xpath = "//*[@id='btn_graba']") private WebElement btn_grabarHojaTrabajo;
    @FindBy(xpath = "//*[@id='btn_final']") private WebElement btn_finalizarHojaTrabajo;
    //@FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_regresarCrearHoja;

    public RegistrarHojaTrabajoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void TiempoLaboral(String TiempoLaboral){
        txt_tiempoLaboral.clear();
        txt_tiempoLaboral.sendKeys(TiempoLaboral);
    }

    public void IngresosBoleta(String IngresosBoleta){
        txt_ingresosBoleta.clear();
        txt_ingresosBoleta.sendKeys(IngresosBoleta);
    }

    public void IngresosReciboHonorario(String IngresosReciboHonorario){
        txt_ingresosReciboHonorario.clear();
        txt_ingresosReciboHonorario.sendKeys(IngresosReciboHonorario);
    }

    public void GastosAlimentacion(String GastosAlimentacion){
        txt_gastosAlimentacion.clear();
        txt_gastosAlimentacion.sendKeys(GastosAlimentacion);
    }

    public void GastosTransporte(String GastosTransporte){
        txt_gastosTransporte.clear();
        txt_gastosTransporte.sendKeys(GastosTransporte);
    }

    public void GastosEducacion(String GastosEducacion){
        txt_gastosEducacion.clear();
        txt_gastosEducacion.sendKeys(GastosEducacion);
    }

    public void GastosVivienda(String GastosVivienda){
        txt_gastosVivienda.clear();
        txt_gastosVivienda.sendKeys(GastosVivienda);
    }

    public void GastosServiciosBasicos(String GastosServiciosBasicos){
        txt_gastosServiciosBasicos.clear();
        txt_gastosServiciosBasicos.sendKeys(GastosServiciosBasicos);
    }

    public void GastosObligacionesTerceros(String GastosObligacionesTerceros){
        txt_gastosOligacionesTerceros.clear();
        txt_gastosOligacionesTerceros.sendKeys(GastosObligacionesTerceros);
    }

    public void DescuentoBoleta(String DescuentoBoleta){
        txt_descuentoBoleta.clear();
        txt_descuentoBoleta.sendKeys(DescuentoBoleta);
    }

    public void DescuentoReciboHonorario(String DescuentoReciboHonorario){
        txt_descuentoReciboHonorario.clear();
        txt_descuentoReciboHonorario.sendKeys(DescuentoReciboHonorario);
    }

    public void GrabarHojaTrabajo(){

        btn_grabarHojaTrabajo.click();
    }

    public void FinalizarHojaTrabajo(){

        btn_finalizarHojaTrabajo.click();
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