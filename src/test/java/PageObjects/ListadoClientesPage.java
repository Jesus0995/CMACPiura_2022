package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class ListadoClientesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapear locator
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)") private WebElement tab_Codigo;
    @FindBy(xpath = "//*[@id=\"valorCodigo\"]") private WebElement txt_Codigo;
    @FindBy(css ="#form2 > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)") private WebElement btn_Buscar;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td/div[2]/form/table/tbody/tr[1]/td[2]/input") private WebElement txt_CodClienteIV;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td/div[2]/form/table/tbody/tr[2]/td/button[1]") private WebElement btn_BuscarClienteIV;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[2]/tbody/tr[2]/td[6]/span/img") private  WebElement icn_InformeVisita;


    public ListadoClientesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,50);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarTabCodigo(){
        wait.until(ExpectedConditions.elementToBeClickable(tab_Codigo));
        tab_Codigo.click();
    }

    public void IngresarCodigoCliente(String CodCliente) {
        txt_Codigo.clear();
        txt_Codigo.sendKeys(CodCliente);
    }

    public void IngresarCodClienteIV(String CodClienteIV){
        txt_CodClienteIV.clear();
        txt_CodClienteIV.sendKeys(CodClienteIV);
    }

    public void ClickBuscarCliente(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Buscar));
        btn_Buscar.click();
    }

    public void SeleccionarIconoPropuesta(){

        WebElement icn_nuevaPropuesta = driver.findElement(By.xpath("//img[@alt='Nueva Propuesta']"));
        icn_nuevaPropuesta.click();
    }

    public void ClickbtnBuscarClienteIV(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_BuscarClienteIV));
        btn_BuscarClienteIV.click();
    }

    public void SeleccionarIconoInformeVisita(){
        String JScript = icn_InformeVisita.getAttribute("onclick");
        ((JavascriptExecutor)driver).executeScript(JScript);
    }

}
