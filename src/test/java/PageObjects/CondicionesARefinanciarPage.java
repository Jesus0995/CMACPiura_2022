package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CondicionesARefinanciarPage {

    private WebDriver driver;
    private WebDriverWait wait;

@FindBy(xpath = "//*[@id=\"monto_amortizar\"]") private WebElement txt_AmortizarDeuda;



    public CondicionesARefinanciarPage(WebDriver d) {
        driver = d;
        wait =  new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);

    }



}
