package PageObjects;

import Functions.funcionEsperar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeVisita_InformePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();


    @FindBy(xpath = "//td[@class='Invisible']//button[1]") private WebElement btn_crearVisita;
    @FindBy(xpath = "//td[@class='Invisible']//button[2]") private WebElement btn_regresar;
    @FindBy(xpath = "//td[@class='Invisible']//button[1]") private WebElement btn_regresarInformeComercial;


    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/div/table[2]/tbody/tr[8]/td/button") private WebElement btn_RegresarCE;

    public InformeVisita_InformePage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnCrear() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btn_crearVisita.click();
        objFuncionEsperar.EsperarTiempo(2);

    }

    public void ClickBtnRegresar() {
        objFuncionEsperar.EsperarTiempo(40);
        wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
        btn_regresar.click();
        objFuncionEsperar.EsperarTiempo(5);

    }

    public void ClickBtnRegresarInformeComercial() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_regresarInformeComercial));
        btn_regresarInformeComercial.click();
    }

    public void ClickBtnRegresarCE() {
        objFuncionEsperar.EsperarTiempo(60);
        wait.until(ExpectedConditions.elementToBeClickable(btn_RegresarCE));
        btn_RegresarCE.click();

    }


}