package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class ListadoPropuestaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Mapear los locator
    @FindBy(name = "criterio") private WebElement cbx_Propuesta;
    @FindBy(name = "tipoBusqueda") private WebElement cbx_TipoPropuesta;
    @FindBy(name = "valorBuscado") private WebElement txt_ValorBuscado;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_Buscar;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/div/button[1]") private WebElement btn_CrearPropuesta;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/div/button[2]") private WebElement btn_Regresar;
    @FindBy(xpath = "//select[@name='tipoBusqueda']") private WebElement cbx_BusquedaAprobacion;
    @FindBy(xpath = "//input[@name='valorBuscado']") private WebElement txt_NumeroPropuestaAprobacion;
    @FindBy(xpath = "//img[@alt='Editar']") private WebElement icn_Editar;

    public ListadoPropuestaPage(WebDriver d) {
        //Iniciar las variables
        driver = d;
        wait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }
    //crear metodo para dar click a crear propuesta
    public void ClickCrearPropuesta() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_CrearPropuesta));

        btn_CrearPropuesta.click();

    }

    public void ClickRegresar() {
        System.out.println("Inicio click regresar");
        System.out.println("Ventanas activas: " + driver.getWindowHandles());
        System.out.println("Ventana actual " + driver.getWindowHandle() + " - " + driver.getTitle());

        wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
        btn_Regresar.click();
        Esperar(2);
        System.out.println("Fin regresar");
    }


    public void ClickTipoBusquedaAprobacion() {
        Select TipoBusquedaAprobacion = new Select(cbx_BusquedaAprobacion);
        TipoBusquedaAprobacion.selectByVisibleText("NUMERO PROPUESTA");
    }

    public void IngresarNumeroPropuesta(String NumeroPropuesta) {
        txt_NumeroPropuestaAprobacion.clear();
        txt_NumeroPropuestaAprobacion.sendKeys(NumeroPropuesta);
    }

    public void ClickBtnBuscar() {
        btn_Buscar.click();
    }

    public void ClickEditarPropuesta() {
        wait.until(ExpectedConditions.elementToBeClickable(icn_Editar));
        icn_Editar.click();
        Esperar(2);
    }


    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);

        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

}
