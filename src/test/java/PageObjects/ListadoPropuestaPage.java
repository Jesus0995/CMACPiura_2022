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
    @FindBy(name = "criterio") private WebElement cbx_Propuesta;
    @FindBy(name = "tipoBusqueda") private WebElement cbx_TipoPropuesta;
    @FindBy(name = "valorBuscado") private WebElement txt_ValorBuscado;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_buscar;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/div/button[1]") private WebElement btn_CrearPropuesta;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/div/button[2]") private WebElement btn_Regresar;


    public ListadoPropuestaPage(WebDriver d) {
        //Iniciar las variables
        driver=d;
        wait = new WebDriverWait(driver,50);
        PageFactory.initElements(driver,this);
    }
    //crear metodo para dar click a crear propuesta

    public void clickCrearPropuesta (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_CrearPropuesta));

        btn_CrearPropuesta.click();

    }

    public void clickRegresar (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
        btn_Regresar.click();
    }


}
