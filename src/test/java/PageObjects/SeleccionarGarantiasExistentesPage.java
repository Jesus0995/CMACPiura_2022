package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
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
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btn_Aceptar;

    public void AbrirVentanaGarantiasExistentes() {
        try {
            identificadoresGarantiasExistentes = driver.getWindowHandles();
            System.out.println(identificadoresGarantiasExistentes);
            String LastHandle = "";

            for (String identificadorOperacionCredito : identificadoresGarantiasExistentes) {
                LastHandle = identificadorOperacionCredito;
            }
            driver.switchTo().window(LastHandle);

            System.out.println("Titulo:" + driver.getTitle());

        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana garantias existentes";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void CerrarVentanaGarantiasExistentes() {
        try {
            Integer SetSize = identificadoresGarantiasExistentes.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];
            for (String identificadorGarantiasExistentes : identificadoresGarantiasExistentes) {
                Handles[Index] = identificadorGarantiasExistentes;
                Index++;
            }
            System.out.println("Ventana principal: " + Handles[0]);
            driver.switchTo().window(Handles[0]);
        } catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
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
        public void SeleccionarCheckGarantiasExistentes() {

            //List<WebElement> checksGarantias = driver.findElements(By.name("garantia"));
            //List<WebElement> nombreGarantias = driver.findElements(By.xpath("//td[contains(text(),'MAQUINARIA Y EQUIPO                               ')]/preceding-sibling::td/input[@type='checkbox']"));
            //List<WebElement> checks2Garantias = driver.findElements(By.cssSelector("#frmGarantia > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td)"));
            try {
                for (WebElement Garantias : nombreGarantias) {
                        Garantias.click();
                }
            } catch (Exception error) {
                error.printStackTrace();
                System.out.println("Error al seleccionar las garantias" + error.getMessage());
            }
    */
    public void SeleccionarCheckGarantiasExistentesMaquinayEquipo() {
        List<WebElement> checkBoxGarantiaMaquinaria = driver.findElements(By.xpath("//td[contains(text(),'MAQUINARIA Y EQUIPO                               ')]/preceding-sibling::td/input[@type='checkbox']"));
        try {
            for (WebElement checkBox : checkBoxGarantiaMaquinaria) {
                checkBox.click();
            }

        } catch (Exception Error) {
            detalleError = "Error al seleccionar las garantias maquinaria y equipo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void SeleccionarCheckGarantiasExistentesCC() {
        List<WebElement> checkBoxGarantiaPersonal = driver.findElements(By.xpath("//td[contains(text(),'GARANTIA PERSONAL                                 ')]/preceding-sibling::td/input[@type='checkbox']"));
        try {
            for (WebElement checkBox : checkBoxGarantiaPersonal) {
                checkBox.click();
            }

        } catch (Exception Error) {
            detalleError = "Error al seleccionar las garantias personal";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnAceptar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Aceptar));
            btn_Aceptar.click();
            objFuncionEsperar.EsperarTiempo(1);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton aceptar";
            objLogErrores.logError(detalleError, Error);
        }
    }

}
