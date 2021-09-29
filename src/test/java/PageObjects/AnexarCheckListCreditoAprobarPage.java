package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class AnexarCheckListCreditoAprobarPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identfAnexarCheckListAprobar;


    @FindBy(xpath = "//*[@value=\"2\"]") private WebElement opt_Aprobar;
    @FindBy(xpath = "//*[@name=\"comRevisionCheck\"]") private WebElement txt_Comentarios;
    @FindBy(xpath = "//*[@name=\"idSave\"]")private WebElement btn_Guardar;

    public void AbrirVentanaAnexarCheckListAprobar(){
        identfAnexarCheckListAprobar = driver.getWindowHandles();
        System.out.println(identfAnexarCheckListAprobar);
        String LastHandle ="";

        for (String idAnexarCheckListAprobar :identfAnexarCheckListAprobar ){
            LastHandle = idAnexarCheckListAprobar;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:"+ driver.getTitle());

    }

    public void CerrarVentanaAnexarCheckListAprobar(){
        Integer SetSize = identfAnexarCheckListAprobar.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String idAnexarCheckListAprobar : identfAnexarCheckListAprobar) {
            Handles[Index] = idAnexarCheckListAprobar;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }

    public AnexarCheckListCreditoAprobarPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarOptAprobar(){
        wait.until(ExpectedConditions.elementToBeClickable(opt_Aprobar));
        opt_Aprobar.click();
    }

    public void IngresarComentarios(String ComentariosAprobacion){
        txt_Comentarios.clear();
        txt_Comentarios.sendKeys(ComentariosAprobacion);
    }


    public void ClickBtnGuardar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_Guardar));
        btn_Guardar.click();
    }





}
