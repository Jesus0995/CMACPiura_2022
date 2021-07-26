package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MenuPrincipalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapear los locator
    @FindBy(partialLinkText = "PROPUESTA") private WebElement lnk_propuestaFinanciamiento;
    @FindBy(linkText = "INFORME DE VISITA") private WebElement lnk_informeVisita;
    @FindBy(linkText = "INFORME COMERCIAL NUEVO FORMATO") private WebElement lnk_informeComercial;
    @FindBy(partialLinkText = "CERRAR") private WebElement lnk_cerrarSesion;
    @FindBy(xpath = "/html/body/table/tbody/tr[1]/td/table[1]/tbody/tr/td[2]/h2/strong/font") private WebElement lbl_titulo;

    //Metodo Abrir ventana
    public void UbicarVentana(){
        Set<String> identificadores =driver.getWindowHandles();
        for (String identificador : identificadores){
            driver.switchTo().window(identificador);
        }

    }



    //constructor
    public MenuPrincipalPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickPropuestaFinanciamiento (){
        lnk_propuestaFinanciamiento.click();
    }




    }



