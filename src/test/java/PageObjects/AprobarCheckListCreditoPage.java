package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionEsperar;

import java.util.Set;

public class AprobarCheckListCreditoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identfAnexarCheckListAprobar;
    private funcionEsperar objFuncionEsperar;

    @FindBy(xpath = "//*[@value=\"2\"]")
    private WebElement opt_Aprobar;
    @FindBy(xpath = "//*[@name=\"comRevisionCheck\"]")
    private WebElement txt_Comentarios;
    @FindBy(xpath = "//*[@name=\"idSave\"]")
    private WebElement btn_Guardar;
    @FindBy(xpath = "/html/body/fieldset/form/table/tbody/tr[2]/td/button")
    private WebElement btn_Cerrar;

    public void AbrirVentanaAprobarCheckListCredito() {
        try {
            identfAnexarCheckListAprobar = driver.getWindowHandles();
            System.out.println(identfAnexarCheckListAprobar);
            String LastHandle = "";

            for (String idAnexarCheckListAprobar : identfAnexarCheckListAprobar) {
                LastHandle = idAnexarCheckListAprobar;
            }
            driver.switchTo().window(LastHandle);
            System.out.println("Titulo:" + driver.getWindowHandle() + '-' + driver.getTitle());

        } catch (Exception error) {
            System.out.println("Error al abrir ventana Aprobar CheckList Credito: " + error.getMessage());

        }
    }

    public void CerrarVentanaAprobarCheckListCredito() {
        try {
            Integer SetSize = identfAnexarCheckListAprobar.size();
            Integer Index = 0;
            String[] Handles = new String[SetSize];
            for (String idAnexarCheckListAprobar : identfAnexarCheckListAprobar) {
                Handles[Index] = idAnexarCheckListAprobar;
                Index++;
            }
            System.out.println("Ventana Principal: " + Handles[0]);
            driver.switchTo().window(Handles[0]);

        } catch (Exception error) {
            System.out.println("Error al cerrar ventana Aprobar CheckList Credito:" + error.getMessage());

        }
    }

    public AprobarCheckListCreditoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);


    }

    public void SeleccionarOptAprobar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opt_Aprobar));
            opt_Aprobar.click();
        } catch (Exception error) {
            System.out.println("Error al seleccionar la Opcion Aprobar:" + error.getMessage());
        }
    }

    public void IngresarComentarios() {
        txt_Comentarios.clear();
        txt_Comentarios.sendKeys("Se aprueba el checklist");
    }


    public void ClickBtnGuardar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Guardar));
        btn_Guardar.click();

    }

    public void ClickBtnCerrar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
        btn_Cerrar.click();

    }

}
