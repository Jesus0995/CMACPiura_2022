package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeVisita_InformePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//td[@class='Invisible']//button[1]") private WebElement btn_crearVisita;
    @FindBy(xpath = "//button[@type='button']") private WebElement btn_regresar;

    @FindBy(xpath = "//button[@onclick=\"window.location='login.jsp'\"]") private WebElement btn_RegresarCE;

    public InformeVisita_InformePage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickCrear() {
        //wait.until(ExpectedConditions.elementToBeClickable(btn_crearVisita));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btn_crearVisita.click();
        Esperar(2);

    }

    public void ClickRegresar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
        btn_regresar.click();

    }


    public void ClickBtnRegresarCE(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_RegresarCE));
        btn_RegresarCE.click();

    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

}