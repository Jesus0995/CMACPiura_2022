package PageObjects;


import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class PopUpComunicadoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    public PopUpComunicadoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ValidarComunicado() {
        //wait.until(ExpectedConditions.elementToBeClickable(vtn_comunicado));
        // @FindBy(xpath = "//span[test() = 'close' or.= 'close')]") private WebElement vtn_comunicado;
        try {
            System.out.println("Handle: " + driver.getWindowHandle());
            System.out.println("Titulo: " + driver.getTitle());
            WebElement linkComunicadoClose = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span"));
            objFuncionEsperar.EsperarTiempo(3);
            System.out.println(linkComunicadoClose);
            linkComunicadoClose.click();
            objFuncionEsperar.EsperarTiempo(1);

        } catch (Exception Error) {
            detalleError = "Error al cerrar e popup comunicado";
            objLogErrores.logError(detalleError, Error);
        }
    }

}


//vtn_comunicado.click();

// Assert.assertEquals(Comunicado,lbl_Comunicado.getText());
// System.out.println("los textos son iguales");
// wait = new WebDriverWait(driver,120);

// Robot r = new Robot();
// r.keyPress(KeyEvent.VK_ESCAPE);