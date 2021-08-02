package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ListadoClientesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapear locator
    @FindBy(css = "#tab-bg\\:1 > i:nth-child(1)") private WebElement tab_codigo;
    @FindBy(xpath = "//*[@id=\"valorCodigo\"]") private WebElement txt_codigo;
    @FindBy(css ="#form2 > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > button:nth-child(1)") private WebElement btn_buscar;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr[2]/td[6]/div/span/img") private WebElement icn_nuevaPropuesta;

    //crear meotodo para abrir ventana
    //public void AbrirVentana(){
    //    Set<String> identificadores =driver.getWindowHandles();
    //    for (String identificador : identificadores){
    //        driver.switchTo().window(identificador);
    //    }
    //    }


    public ListadoClientesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }


    public void SeleccionarTabCodigo(){
        tab_codigo.click();

    }

    public void IngresarCodigoCliente(){
        txt_codigo.clear();
        txt_codigo.sendKeys("97941041");

    }

    public void ClickBuscarCliente(){
        btn_buscar.click();
    }
    public void SeleccionarIconoPropuesta(){
        icn_nuevaPropuesta.click();
    }
   // public void CerrarVentana(){
   //     driver.close();
   // }


}
