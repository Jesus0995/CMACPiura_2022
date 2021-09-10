package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrabarInformacionErroresPage {


    @FindBy(xpath = "//button[@type='button']") private WebElement btn_Cerrar;


    public GrabarInformacionErroresPage() {
    }
}
