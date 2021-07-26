package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnlazarEstadosFinancierosPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //mapeop elementos
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_enlazar;

    public EnlazarEstadosFinancierosPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCerrar(){btn_enlazar.click(); }

}
