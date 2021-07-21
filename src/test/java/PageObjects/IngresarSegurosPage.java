package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarSegurosPage {
    //2. crear variables

    private WebDriver driver;
    private WebDriverWait wait;

    //Mapear los locator de la pagina
    @FindBy(id = "dps02201") private WebElement chk_segdesgrnm;
    @FindBy(id = "dps02201") private WebElement txt_segdesgrnmdps;
    @FindBy(id = "5_13501") private WebElement chk_planpymes;
    @FindBy(id = "dps13501") private WebElement txt_planpymesdps;
    @FindBy(xpath ="//button[@type=\"submit\"]") private WebElement btn_confirmar;
    @FindBy(xpath = "//button[@type=\"button\"]") private WebElement btn_cancelar;

    //1.Constructor
    public SeleccionarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void SeleccionarSeguroDesgravamennm (){
        //wait.until(ExpectedCondition.elementToBeClickable(chk_segdesgrnm));
        chk_segdesgrnm.click();

    }

    public void IngresarSeguroDesgravamennmdps (String segurosdesgravamen){
        //wait.until(ExpectedCondition.visibilityof(txt_segdesgrnmdps));
        txt_segdesgrnmdps.clear();
        txt_segdesgrnmdps.sendKeys(segurosdesgravamen);

    }

    public void SeleccionarPlanPymes(){
        chk_planpymes.click();

    }
    public void IngresarPlanPymes (String planpymes) {
        txt_planpymesdps.click();
        txt_planpymesdps.sendKeys(planpymes);
    }

    public void ClickConfirmar(){
        btn_confirmar.click();
    }



}
