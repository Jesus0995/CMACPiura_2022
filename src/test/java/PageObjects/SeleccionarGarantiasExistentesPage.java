package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class SeleccionarGarantiasExistentesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresGarantiasExistentes;
    protected static String Maquinaria;

    //mapeo objetos

    //@FindBy(xpath = "//input[@name='garantia']") private WebElement chk_GarantiasExistentes;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Aceptar;

    //@FindBy(xpath = "//table/tbody/tr[4]/td[5]") private WebElement lbl_MaquinariaEquipo;

    public void AbrirVentanaGarantiasExistentes() {
        identificadoresGarantiasExistentes = driver.getWindowHandles();
        System.out.println(identificadoresGarantiasExistentes);
        String LastHandle = "";

        for (String identificadorOperacionCredito : identificadoresGarantiasExistentes) {
            LastHandle = identificadorOperacionCredito;
        }
        driver.switchTo().window(LastHandle);

        System.out.println("Titulo : " + driver.getTitle());

    }

    public void CerrarVentanaGarantiasExistentes() {
        Integer SetSize = identificadoresGarantiasExistentes.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];
        for (String identificadorGarantiasExistentes : identificadoresGarantiasExistentes) {
            Handles[Index] = identificadorGarantiasExistentes;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public SeleccionarGarantiasExistentesPage(WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
/*
    public void ValidarTipoGarantiaMaquinaria(String MaquinariaEquipo){
        wait.until(ExpectedConditions.visibilityOf(lbl_MaquinariaEquipo));
        Assert.assertEquals(MaquinariaEquipo,lbl_MaquinariaEquipo.getText());
        System.out.println("El tipo de garantia es:"+lbl_MaquinariaEquipo.getText());
        }
*/

    public void SeleccionarCheckGarantiasExistentes() {

        List<WebElement> allGarantias = driver.findElements(By.name("garantia"));
        try {
            for (WebElement Garantias : allGarantias) {
                Garantias.click();
            }
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar las garantias" + error.getMessage());
        }
    }

    /*
    public void SeleccionarCheckGarantiaMaquinaria(){
        wait.until(ExpectedConditions.elementToBeClickable(chk_GarantiaMaquinaria));
        chk_GarantiaMaquinaria.click();
    }*/

    public void ClickBtnAceptar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Aceptar));
        btn_Aceptar.click();
        //Esperar(1);
    }

    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;

        try {
            Thread.sleep(Milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
