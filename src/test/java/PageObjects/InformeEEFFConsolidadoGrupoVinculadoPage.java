package PageObjects;

import Functions.funcionExcepciones;
import Functions.funcionVentana;
import jdk.internal.org.objectweb.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import Functions.funcionEsperar;

public class InformeEEFFConsolidadoGrupoVinculadoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresInformeEEFFConsolidadoGrupoVinculado;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private String ventanaUltima;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError;

    @FindBy(xpath = "//a[@id='btn_graba']") private WebElement btn_Grabar;
    @FindBy(xpath = "//a[@id='btn_final']") private WebElement btn_Finalizar;
    @FindBy(xpath = "//a[@title='Cerrar']") private WebElement btn_Cerrar;
    @FindBy(xpath = "//*[@id=\"txt_analisis\"]") private WebElement txt_Analisis;
    @FindBy(xpath = "//*[@id=\"txt_conducta\"]") private WebElement txt_Conducta;
    @FindBy(xpath = "/html/body/div[3]/div[1]") private WebElement lbl_Estado;

    public void AbrirVentanaInformeEstadoFinancieroConsolidadoGrupo() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaNueva();
            ventanaUltima = driver.getWindowHandle();
            System.out.println("Titulo de a ventana "+driver.getTitle());
        } catch (Exception Error) {
            detalleError = "Error al abrir ventana Informe de EEFF Consolidado";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void CerrarVentanaInformeEstadoFinancieroConsolidadoGrupo() {
        try {
            System.out.println(driver.getWindowHandles());
            objFuncionVentana.cambiarVentanaInicial();
            System.out.println("Fin cerrar ventana");
        } catch (Exception Error) {
            detalleError = "Error al cerrar ventana Informe de EEFF Consolidado";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public InformeEEFFConsolidadoGrupoVinculadoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);

    }

    public void IngresarComentarios() {
        try {
            List<WebElement> elementList = driver.findElements(By.tagName("textarea"));
            for (WebElement textarea : elementList) {
                textarea.sendKeys("La descripcion de los analisis correspondientes del informe estados financieros del grupo vinculados");
            }
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarAnalisis() {
        try {
            txt_Analisis.clear();
            txt_Analisis.sendKeys("La descripcion de los analisis correspondientes del informe estados financieros del grupo vinculados");

        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios en el analisis financiero";
            objLogErrores.logError(detalleError,Error);
        }

    }

    public void IngresarConducta() {
        try {
            txt_Conducta.clear();
            txt_Conducta.sendKeys("La descripcion de los analisis correspondientes del informe estados financieros del grupo vinculados");
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios en la conducta de pago";
            objLogErrores.logError(detalleError,Error);

        }

    }

    public void ClickBtnGrabar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el bot??n Grabar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnFinalizar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Finalizar));
            btn_Finalizar.click();
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el bot??n Finalizar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnCerrar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();
            objFuncionEsperar.EsperarTiempo(3);
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el bot??n Cerrar";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ObtenerEtiqueta(){
        wait.until(ExpectedConditions.visibilityOf(lbl_Estado));
        lbl_Estado.getAttribute("value");
        System.out.println(lbl_Estado);
    }


}
