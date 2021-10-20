package PageObjects;

import Functions.funcionEsperar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeComercialNuevoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();

    @FindBy(xpath = "//input[@id='patrimoniopersonal']") private WebElement txt_patrimonio;
    @FindBy(xpath = "//input[@name='patrimoniopersonal']") private WebElement txt_PatrimonioComercial;
    @FindBy(xpath = "//img[@alt='Grabar']") private WebElement btn_grabar;
    @FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_regresar;

    ///html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a

    public InformeComercialNuevoPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void IngresarPatrimonio(String Patrimonio){
        txt_patrimonio.clear();
        txt_patrimonio.sendKeys(Patrimonio);
    }

    public  void IngresarPatrimonioComercial(String PatrimonioComercial){
        objFuncionEsperar.EsperarTiempo (6);
        txt_PatrimonioComercial.clear();
        txt_PatrimonioComercial.sendKeys(PatrimonioComercial);
    }


    public void ClickGrabar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_grabar));
        btn_grabar.click();
    }

    public void ClickRegresar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_regresar));
        btn_regresar.click();
    }

}
