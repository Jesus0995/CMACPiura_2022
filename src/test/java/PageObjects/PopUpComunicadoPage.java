package PageObjects;

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

    public PopUpComunicadoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

        }

        public void ValidarComunicado() {
            //wait.until(ExpectedConditions.elementToBeClickable(vtn_comunicado));
            // @FindBy(xpath = "//span[test() = 'close' or.= 'close')]") private WebElement vtn_comunicado;

            System.out.println("Handle: " + driver.getWindowHandle());
            System.out.println("Titulo: " + driver.getTitle());

            WebElement linkComunicadoClose = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span"));
            System.out.println(linkComunicadoClose);

            linkComunicadoClose.click();

            Esperar(3);

            //vtn_comunicado.click();

            // Assert.assertEquals(Comunicado,lbl_Comunicado.getText());
            // System.out.println("los textos son iguales");
            // wait = new WebDriverWait(driver,120);

            // Robot r = new Robot();
            // r.keyPress(KeyEvent.VK_ESCAPE);

        }

        private void Esperar(Integer Segundos) {
            Integer Milisegundos = Segundos * 1000;

            try {
                Thread.sleep(Milisegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
