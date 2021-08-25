package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MenuPrincipalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapear los locator
    @FindBy(partialLinkText = "PROPUESTA") private WebElement lnk_propuestaFinanciamiento;
    @FindBy(linkText = "INFORME DE VISITA") private WebElement lnk_informeVisita;
    @FindBy(linkText = "INFORME COMERCIAL NUEVO FORMATO") private WebElement lnk_informeComercial;
    @FindBy(linkText = "HOJA DE TRABAJO") private WebElement lnk_hojaTrabajo;
    @FindBy(partialLinkText = "CERRAR") private WebElement lnk_cerrarSesion;
    @FindBy(xpath = "/html/body/table/tbody/tr[1]/td/table[1]/tbody/tr/td[2]/h2/strong/font") private WebElement lbl_titulo;
    //@FindBy(xpath = "/html/body/div[2]/div[1]/a/span") private WebElement popup_imagen;
    //@FindBy(xpath = "/html/body/div[1]/div[1]/a/span") private WebElement popup_aviso;


    //constructor
    public MenuPrincipalPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickPropuestaFinanciamiento (){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_propuestaFinanciamiento));
        lnk_propuestaFinanciamiento.click();
    }

    public void ClickInformeVisita(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_informeVisita));
        lnk_informeVisita.click();
    }

    public void ClickHojaTrabajo(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_hojaTrabajo));
        lnk_hojaTrabajo.click();
    }


    }



