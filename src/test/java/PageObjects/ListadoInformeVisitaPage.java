package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListadoInformeVisitaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapear locator
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)") private WebElement tab_codigo;
    @FindBy(css = "#tab-body\\:1 > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input") private WebElement txt_codigo;
    @FindBy(css = "#tab-body\\:1 > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)") private WebElement btn_buscar;


    public ListadoInformeVisitaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,50);
        PageFactory.initElements(driver,this);
    }


    public void SeleccionarTabCodigo(){
        wait.until(ExpectedConditions.elementToBeClickable(tab_codigo));
        tab_codigo.click();
    }

    public void IngresarCodigoCliente(String CodCliente) {
        txt_codigo.clear();
        txt_codigo.sendKeys(CodCliente);
    }

    public void ClickBuscarCliente(){

        btn_buscar.click();
    }

    public void SeleccionarIconoInformeVisita(){

        WebElement icn_informeVisita = driver.findElement(By.xpath("//img[@alt='Ver Informes de Visitas']"));
        System.out.println(icn_informeVisita);
        icn_informeVisita.click();
    }

    public void SeleccionarIconoInformeComercial(){

        WebElement icn_informeComercial = driver.findElement(By.xpath("//img[@alt='Ver Informes Comerciales']"));
        System.out.println(icn_informeComercial);
        icn_informeComercial.click();
    }


}
