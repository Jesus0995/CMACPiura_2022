package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrarSegurosPage {
    //2. crear variables

    private WebDriver driver;
    private WebDriverWait wait;

    //Mapear los locator de la pagina
    @FindBy(xpath = "//input[@name=\"seguro\" and @value=\"4_02201\"]") private WebElement chk_SeguroDesgravamenFlatMN;
    @FindBy(xpath = "//input[@id='dps02201']") private WebElement txt_SeguroDesgravamenFlatMN;
    @FindBy(xpath = "//input[@id='5_13501' and @value='5_13501']") private WebElement chk_SeguroPlanPymes;
    @FindBy(xpath = "//input[@id='dps13501']") private WebElement txt_SeguroPlanPymes;
    @FindBy(xpath ="//button[@type=\"submit\"]") private WebElement btn_confirmar;


    //1.Constructor
    public RegistrarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarSeguroDesgravamenMN (){
        //wait.until(ExpectedCondition.elementToBeClickable(chk_segdesgrnm));
        chk_SeguroDesgravamenFlatMN.click();

    }

    public void IngresarSeguroDesgravamenMN (String desgravamenm){
        //wait.until(ExpectedCondition.visibilityof(txt_segdesgrnmdps));
        txt_SeguroDesgravamenFlatMN.clear();
        txt_SeguroDesgravamenFlatMN.sendKeys(desgravamenm);

    }

    public void SeleccionarSeguroPlanPymes() {
        chk_SeguroPlanPymes.click(); }

    public void IngresarSeguroPlanPymes (String planpymes) {
        txt_SeguroPlanPymes.click();
        txt_SeguroPlanPymes.sendKeys(planpymes);
    }

    public void ClickConfirmar() {
        btn_confirmar.click();
    }

}
