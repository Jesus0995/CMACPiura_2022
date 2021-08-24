package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class RegistrarSegurosPage {
    //2. crear variables

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRegistrarSeguros;

    //Mapear los locator de la pagina
    @FindBy(xpath = "//input[@name=\"seguro\" and @value=\"4_02201\"]") private WebElement chk_SeguroDesgravamenFlatMN;
    @FindBy(xpath = "//input[@id='dps02201']") private WebElement txt_SeguroDesgravamenFlatMN;
    @FindBy(xpath = "//input[@id='5_13501' and @value='5_13501']") private WebElement chk_SeguroRiesgoPlanPymes;
    @FindBy(xpath = "//input[@id='dps13501']") private WebElement txt_SeguroRiesgoPlanPymes;
    @FindBy(xpath ="//button[@type=\"submit\"]") private WebElement btn_confirmar;

    public void AbrirVentanaRegistrarSeguros(){
        identificadoresRegistrarSeguros = driver.getWindowHandles();
        System.out.println(identificadoresRegistrarSeguros);
        String LastHandle ="";

        for (String identificadorRegistrarSeguros :identificadoresRegistrarSeguros ){
            LastHandle = identificadorRegistrarSeguros;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaRegistrarSeguros(){
        Integer SetSize = identificadoresRegistrarSeguros.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorRegistrarSeguros : identificadoresRegistrarSeguros) {
            Handles[Index] = identificadorRegistrarSeguros;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    //1.Constructor
    public RegistrarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickCheckSeguroDesgravamenMN (){
        wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroDesgravamenFlatMN));
        chk_SeguroDesgravamenFlatMN.click();

    }

    public void IngresarSeguroDesgravamenMN (String seguroDesgravameMN){
        //wait.until(ExpectedCondition.visibilityof(txt_segdesgrnmdps));
        txt_SeguroDesgravamenFlatMN.clear();
        txt_SeguroDesgravamenFlatMN.sendKeys(seguroDesgravameMN);

    }

    public void ClickCheckSeguroRiesgoPlanPymes() {
        wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroRiesgoPlanPymes));
        chk_SeguroRiesgoPlanPymes.click(); }

    public void IngresarSeguroRiesgoPlanPymes (String seguroRiesgoPlanPymes) {
        txt_SeguroRiesgoPlanPymes.click();
        txt_SeguroRiesgoPlanPymes.sendKeys(seguroRiesgoPlanPymes);
    }

    public void ClickConfirmar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_confirmar));
        btn_confirmar.click();
    }

}
