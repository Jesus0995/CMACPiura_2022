package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaClientesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapear locator
    @FindBy(xpath = "//td[@id=\"tab-bg:1\"]") private WebElement tab_codigo;
    @FindBy(id = "valorCodigo") private WebElement txt_codigo;
    @FindBy(xpath ="//button[@type=\"submit\"]") private WebElement btn_buscar;
    @FindBy(xpath = "//img[@alt=\"Nueva Propuesta\"]") private WebElement icn_nuevaPropuesta;


    public ListaClientesPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarTabCodigo(){
        tab_codigo.click();

    }

    public void IngresarCodigoCliente(String codigo){
        txt_codigo.clear();
        txt_codigo.sendKeys(codigo);

    }

    public void SeleccionarBuscarCliente(){
        btn_buscar.click();
    }
    public void SeleccionarIconoPropuesta(){
        icn_nuevaPropuesta.click();
    }
}
