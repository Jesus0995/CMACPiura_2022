package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapear los locator
    @FindBy(partialLinkText = "PROPUESTA") private WebElement lnk_propuestaFinanciamiento;
    @FindBy(partialLinkText = "CERRAR") private WebElement lnk_cerrarSesion;

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
    public void CerrarSesion(){
        lnk_cerrarSesion.click();
    }

}
