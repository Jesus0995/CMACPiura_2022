package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionVentana;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class EnlazarEstadosFinancierosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresEnlazarEstadosFinancieros;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;

    //mapeo elementos
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Enlazar;

    public void AbrirVentanaEnlazarEstadosFinancieros() {
        identificadoresEnlazarEstadosFinancieros = driver.getWindowHandles();
        System.out.println(identificadoresEnlazarEstadosFinancieros);
        String LastHandle = "";

        for (String identificadorEnlazarEstadosFinancieros : identificadoresEnlazarEstadosFinancieros) {
            LastHandle = identificadorEnlazarEstadosFinancieros;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());
        ventanaUltima = driver.getWindowHandle();
    }

    public void CerrarVentanaEnlazarEstadosFinancieros() {
       /*
        Integer SetSize = identificadoresEnlazarEstadosFinancieros.size();
        Integer Index = 0;

        String[] Handles = new String[SetSize];

        for (String identificadorEnlazarEstadosFinancieros : identificadoresEnlazarEstadosFinancieros) {
            Handles[Index] = identificadorEnlazarEstadosFinancieros;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
*/
        System.out.println(driver.getWindowHandles());
        objFuncionEsperar.EsperarCierreVentana(ventanaUltima);
        objFuncionVentana.cambiarVentanaInicial();
        System.out.println("Fin cerrar ventana");

    }

    public EnlazarEstadosFinancierosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void ClickbtnEnlazar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Enlazar));
        btn_Enlazar.click();
        objFuncionEsperar.EsperarTiempo(2);
    }

}
