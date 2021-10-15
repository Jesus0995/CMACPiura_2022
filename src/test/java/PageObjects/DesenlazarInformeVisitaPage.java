package PageObjects;

import Functions.funcionEsperar;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class DesenlazarInformeVisitaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresDesenlazarInformeVisita;
    private funcionEsperar objFuncionEsperar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_Realizar;

    public void AbrirVentanaDesenlazarInformeVisita() {
        objFuncionEsperar.EsperarTiempo(2);
        identificadoresDesenlazarInformeVisita = driver.getWindowHandles();
        String LastHandle = "";

        for (String identificadorDesenlazarInformeVisita : identificadoresDesenlazarInformeVisita) {
            LastHandle = identificadorDesenlazarInformeVisita;

        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());
    }


    public void CerrarVentanaDesenlazarInformeVisita() {
        Integer SetSize = identificadoresDesenlazarInformeVisita.size();
        Integer Index = 0;

        String[] Handles = new String[SetSize];

        for (String identificadorDesenlazarInformeVisita : identificadoresDesenlazarInformeVisita) {
            Handles[Index] = identificadorDesenlazarInformeVisita;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
    }


    public DesenlazarInformeVisitaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickBtnRealizar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Realizar));
        btn_Realizar.click();
        objFuncionEsperar.EsperarTiempo(2);
    }
}
