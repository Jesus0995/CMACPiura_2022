package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleccionarSegurosPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (xpath = "//button[@type=\"submit\"]") private WebElement btn_confirmar;

    public SeleccionarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }
    private void ClickConfirmar ()
    {btn_confirmar.click();}

}
