package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Visita_InformePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/div/table[2]/tbody/tr[3]/td/button[1]") private WebElement btn_crearVisita;

    public Visita_InformePage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void ClickCrear(){btn_crearVisita.click();}
}