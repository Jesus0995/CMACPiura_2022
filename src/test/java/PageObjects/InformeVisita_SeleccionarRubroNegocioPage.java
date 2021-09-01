package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformeVisita_SeleccionarRubroNegocioPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[4]/td/button[1]") private WebElement btn_cargar;

    public InformeVisita_SeleccionarRubroNegocioPage(WebDriver d) {
        //iniciar variables
        driver = d;
        wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCargar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_cargar));
        btn_cargar.click();
    }
}
