package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //mapeo de locator
    @FindBy(id = "txtComenCalifCred") private WebElement txt_comentarioCred;
    @FindBy(id = "txtobjetivo") private WebElement txt_objetivo;
    @FindBy(id = "justificacion") private WebElement txt_justificacion;
    @FindBy(name = "btnEnviar") private WebElement btn_nuevaOperacion;
    @FindBy(name = "btnEnviar2") private WebElement btn_seguro;
    @FindBy(xpath = "//button[@onclick=\"window.open('anexaCheckList.jsp', 'Anexo Check List 93F33861F69D989C9B85816814AEAA8A', 'toolbar=no,scrollbars=yes,location=no,status=no,menubar=no,resizable=yes,width=690,height=500,dependent=yes');\"]") private WebElement btn_checklist;
    @FindBy(id = "txtcaracter") private WebElement txt_caracteristica;
    @FindBy(id = "txtclasificac") private WebElement txt_clasificacion;
    @FindBy(id = "txtclasificaAval") private WebElement txt_clasifaval;
    @FindBy(id="txtanalisisUEF") private WebElement txt_clasifecon;
    @FindBy(name = "btnGaranExist") private WebElement btn_garantias;
    @FindBy(xpath = "//button[@onclick=\"window.open('actualizaEEFFP.jsp?accion=enlazar&nroProp=4689701', 'Enlazar EEFF 7F01BEA3229E1DE020B289CFDBF03BF1', 'toolbar=no,scrollbars=yes,location=,statusbar=no,menubar=no,resizable=yes,width=400,height=250,dependent=yes');\"]") private WebElement btn_estadosfin;


    public PropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void IngresarComentario (){txt_comentarioCred.sendKeys("prueba");}
    public void IngresarObjetivo () {txt_objetivo.sendKeys("prueba");}
    public void IngresarJustificacion (){txt_justificacion.sendKeys("prueba");}
    public void ClickOperacion (){btn_nuevaOperacion.click();}
    public void ClickSeguro (){btn_seguro.click();}
    public void CickAnexarCheckList (){btn_checklist.click();}

    public void IngresarCaracteristica (){txt_caracteristica.sendKeys("prueba");}
    public void IngresarClasificacion (){txt_clasificacion.sendKeys("prueba");}
    public void IngresarClasifAval (){txt_clasifaval.sendKeys("prueba");}
    public void IngresarClasifEcon () {txt_clasifecon.sendKeys("prueba");}
    public void ClickAnexarGarantias () {btn_garantias.click();}
    public void ClickEstadosFinan () {btn_estadosfin.click();}


}
