package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnlazarEstadosFinancierosPage {

    //mapeop elementos
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_enlazar;

    public EnlazarEstadosFinancierosPage() {




    }
}
