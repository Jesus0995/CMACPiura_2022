package PageObjects;

import org.apache.xalan.transformer.XalanProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;

public class DefinaPropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ultimaVentana;
    private String detalleError = new String();

    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_Cargar;


    public DefinaPropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }





}
