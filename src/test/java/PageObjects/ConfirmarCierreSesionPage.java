package PageObjects;

import Functions.funcionExcepciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmarCierreSesionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionExcepciones objFuncionExcepciones = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_ConfirmarCierre;

    public ConfirmarCierreSesionPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnConfirmarCierre(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_ConfirmarCierre));
            btn_ConfirmarCierre.click();

        } catch (Exception Error) {
            detalleError = "Error en confirmar cierre";
            objFuncionExcepciones.logError(detalleError,Error);
        }
    }

}
