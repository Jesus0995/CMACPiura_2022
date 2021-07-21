package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListadoPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Mapear los locator
    @FindBy(name = "criterio") private WebElement cbx_propuesta;
    @FindBy(name = "tipoBusqueda") private WebElement cbx_tipoPropuesta;
    @FindBy(name = "valorBuscado") private WebElement txt_valorBuscado;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_buscar;
    @FindBy(xpath = "//button[@onclick=\"window.location='listaClientes.jsp'\"]") private WebElement btn_crearPropuesta;
    @FindBy(xpath = "//button[@onclick=\"window.location='login.jsp'\"]") private WebElement btn_regresar;
    @FindBy(xpath = "//button[@onclick=\"window.location='logout.jsp'\"]") private WebElement btn_cerrar;

    public ListadoPropuestaPage(WebDriver d) {
        //Iniciar las variables
        driver=d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    //crear metodo para dar click a crear propuesta
    public void clickCrearPropuesta (){
        btn_crearPropuesta.click();
    }


}
