package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ListadoPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Mapear los locator
    @FindBy(name = "criterio") private WebElement cbx_propuesta;
    @FindBy(name = "tipoBusqueda") private WebElement cbx_tipoPropuesta;
    @FindBy(name = "valorBuscado") private WebElement txt_valorBuscado;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_buscar;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/button[1]") private WebElement btn_crearPropuesta;
    @FindBy(xpath = "//button[@onclick=\"window.location='login.jsp'\"]") private WebElement btn_regresar;
    @FindBy(xpath = "//button[@onclick=\"window.location='logout.jsp'\"]") private WebElement btn_cerrar;

    //crear meotodo para abrir ventana
    //public void AbrirVentana(){
    //    Set<String> identificadores =driver.getWindowHandles();
    //    for (String identificador : identificadores){
    //        driver.switchTo().window(identificador);
    //    }
    //    }

    public ListadoPropuestaPage(WebDriver d) {
        //Iniciar las variables
        driver=d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    //crear metodo para dar click a crear propuesta
    public void clickCrearPropuesta (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_crearPropuesta));

        btn_crearPropuesta.click();

    }


}
