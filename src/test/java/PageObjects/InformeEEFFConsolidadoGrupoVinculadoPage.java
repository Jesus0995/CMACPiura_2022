package PageObjects;

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
    funcionEsperar objFuncionEsperar;

    @FindBy(xpath = "//a[@id='btn_graba']") private WebElement btn_Grabar;
    @FindBy(xpath = "//a[@id='btn_final']") private WebElement btn_Finalizar;
    @FindBy(xpath = "//a[@title='Cerrar']") private WebElement btn_Cerrar;


    public void AbrirVentanaInformeEstadoFinancieroConsolidadoGrupo(){
        identificadoresInformeEEFFConsolidadoGrupoVinculado = driver.getWindowHandles();

        String LastHandle = "";

        for(String identificadorInformeEEFFConsolidadoGrupoVinculado:identificadoresInformeEEFFConsolidadoGrupoVinculado){
            LastHandle = identificadorInformeEEFFConsolidadoGrupoVinculado;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo de Ventana:"+driver.getWindowHandle()+"-" +driver.getTitle());
    }


    public void CerrarVentanaInformeEstadoFinancieroConsolidadoGrupo(){
        Integer SetSize = identificadoresInformeEEFFConsolidadoGrupoVinculado.size();
        Integer Index = 0;
        String[]Handles = new String[SetSize];
        for (String identificadorInformeEEFFConsolidadoGrupoVinculado: identificadoresInformeEEFFConsolidadoGrupoVinculado){
            Handles[Index] = identificadorInformeEEFFConsolidadoGrupoVinculado;
            Index++;
        }
        System.out.println("Ventana Principal:"+Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public InformeEEFFConsolidadoGrupoVinculadoPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void IngresarComentarios() {
        List<WebElement> elementList = driver.findElements(By.tagName("textarea"));
        for (WebElement textarea : elementList) {
            textarea.sendKeys("La descripcion de los analisis correspondientes del informe estados financieros del grupo vinculados");
        }
    }

    public void ClickBtnGrabar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
        btn_Grabar.click();
        //objFuncionEsperar.EsperarTiempo(3);
        }

    public void ClickBtnFinalizar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Finalizar));
        btn_Finalizar.click();
        //objFuncionEsperar.EsperarTiempo(3);
    }

    public void ClickBtnCerrar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
        btn_Cerrar.click();
        //objFuncionEsperar.EsperarTiempo(3);

    }


}
