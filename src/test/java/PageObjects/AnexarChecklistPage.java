package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class AnexarChecklistPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresAnexarCheckList;

    //Informacion basica cliente

    @FindBy(xpath = "//input[@id='item_1' and @value='2']") private WebElement opt_cliTarjetaBasica;
    @FindBy(xpath = "//input[@id='item_2' and @value='2']") private WebElement opt_cliCopiaFedateada;
    @FindBy(xpath = "//input[@id='item_3' and @value='2']") private WebElement opt_cliVigenciaActualizada;
    @FindBy(xpath = "//input[@id='item_4' and @value='2']") private WebElement opt_cliReciboLuz;
    @FindBy(xpath = "//input[@id='item_5' and @value='2']") private WebElement opt_cliCroquisDomic;
    @FindBy(xpath = "//input[@id='item_6' and @value='2']") private WebElement opt_cliAgricolas;
    @FindBy(xpath = "//input[@id='item_7' and @value='2']") private WebElement opt_cliFotoPanoramica;

// Informacion del negocio

    @FindBy(xpath = "//input[@id='item_8' and @value='2']") private WebElement opt_NegocioLuz;
    @FindBy(xpath = "//input[@id='item_9' and @value='2']") private WebElement opt_NegocioFoto;
    @FindBy(xpath = "//input[@id='item_10' and @value='2']") private WebElement opt_NegocioSustento;
    @FindBy(xpath = "//input[@id='item_11' and @value='2']") private WebElement opt_NegocioInforme;

//operaciones propuestas


    @FindBy(xpath = "//input[@id='item_15' and @value='2']") private WebElement opt_OperSolicitud;

    //seguro cliente
    @FindBy(xpath = "//input[@id='item_16' and @value='2']") private WebElement opt_SegCopiaDPS;

    //seguro garantia

    @FindBy(xpath = "//input[@id='item_17' and @value='2']") private WebElement opt_SegPolizas;

    //informacion economica financiera del cliente

    @FindBy(xpath = "//input[@id='item_18' and @value='2']") private WebElement opt_EEFFSectorista;
    @FindBy(xpath = "//input[@id='item_19' and @value='2']") private WebElement opt_flujoCaja;

    //informe verificacion previa

    @FindBy(xpath = "//input[@id='item_56' and @value='2']") private WebElement opt_clienteTarjeta;

    //garantias no inscribibles

    @FindBy(xpath = "//input[@id='item_59' and @value='2']") private WebElement opt_busquedaBienes;
    @FindBy(xpath = "//input[@id='item_60' and @value='2']") private WebElement opt_docPropiedad;
    @FindBy(xpath = "//input[@id='item_62' and @value='2']") private WebElement opt_bolInformativa;
    @FindBy(xpath = "//input[@id='item_63' and @value='2']") private WebElement opt_contPrestamo;
    @FindBy(xpath = "//input[@id='item_64' and @value='2']") private WebElement opt_decJuradaBienes;

    //garantia con desposesion

    @FindBy(xpath = "item_65") private WebElement opt_tasacion;

    @FindBy(xpath = "item_66") private WebElement opt_copiaPlazoFijo;


    //garantias inscribibles
    @FindBy(xpath = "item_68") private WebElement opt_certLiteralDom;
    @FindBy(xpath = "item_69") private WebElement opt_garantiasInscr;
    @FindBy(xpath = "item_70") private WebElement opt_valuacion;
    @FindBy(xpath = "item_71") private WebElement opt_opinionLegal;
    @FindBy(xpath = "item_72") private WebElement opt_mobiliConst;
    @FindBy(xpath = "item_73") private WebElement opt_mobiliPreConst;
    @FindBy(xpath = "item_74") private WebElement opt_testimonio;

    //Desembolso de credito

    @FindBy(xpath = "item_80") private WebElement opt_fichaIngresoRRPP;
    @FindBy(xpath = "item_81") private WebElement opt_copiaPartida;

    @FindBy(id="idSaveSend") private WebElement btn_guardarTerminar;

    public void AbrirVentanaAnexarCheckList(){
        identificadoresAnexarCheckList = driver.getWindowHandles();
        System.out.println(identificadoresAnexarCheckList);
        String LastHandle ="";

        for (String identificadorAnexarCheckList :identificadoresAnexarCheckList ){
            LastHandle = identificadorAnexarCheckList;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaAnexarCheckList(){
        Integer SetSize = identificadoresAnexarCheckList.size();
        Integer Index=0;
        String[] Handles = new String[SetSize] ;
        for (String identificadorAnexarCheckList : identificadoresAnexarCheckList) {
            Handles[Index] = identificadorAnexarCheckList;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public AnexarChecklistPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void Seleccionar1_TarjetaInformacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliTarjetaBasica));
        opt_cliTarjetaBasica.click();}

    public void Seleccionar2_CopiaFedatariaDOI() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliCopiaFedateada));
        opt_cliCopiaFedateada.click();}

    public void Seleccionar3_VigenciaPoderActualizada() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliVigenciaActualizada));
        opt_cliVigenciaActualizada.click();}

    public void Seleccionar4_ReciboLuz() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliReciboLuz));
        opt_cliReciboLuz.click();}

    public void Seleccionar5_CroquisDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliCroquisDomic));
        opt_cliCroquisDomic.click();}

    public void Seleccionar6_GPSAgricolas() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliAgricolas));
        opt_cliAgricolas.click();}

    public void Seleccionar7_FotoDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_cliFotoPanoramica));
        opt_cliFotoPanoramica.click();}


    public void Seleccionar8_ReciboSSBB() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_NegocioLuz));
        opt_NegocioLuz.click();}

    public void Seleccionar9_FotoNegocio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_NegocioFoto));
        opt_NegocioFoto.click();}

    public void Seleccionar10_SustentoVigencia() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_NegocioSustento));
        opt_NegocioSustento.click();}

    public void Seleccionar11_InformeComercial() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_NegocioInforme));
        opt_NegocioInforme.click();}


    public void Seleccionar12_SolicitudCredito() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_OperSolicitud));
        opt_OperSolicitud.click();}

    public void Seleccionar13_CopiaDPS() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_SegCopiaDPS));
        opt_SegCopiaDPS.click();}

    public void Seleccionar14_CopiaPolizaSeguro() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_SegPolizas));
        opt_SegPolizas.click();}

    public void Seleccionar15_EstadosFinancieros() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_EEFFSectorista));
        opt_EEFFSectorista.click();}

    public void Seleccionar16_FlujodeCaja() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_flujoCaja));
        opt_flujoCaja.click();}

    public void Seleccionar17_InformeVisitaSectorista() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_clienteTarjeta));
        opt_clienteTarjeta.click();}

    public void Seleccionar18_BusquedaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_busquedaBienes));
        opt_busquedaBienes.click();}

    public void Seleccionar19_DocumentosSustentatorios() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_docPropiedad));
        opt_docPropiedad.click();}

    public void Seleccionar20_BoletaInformativa() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_bolInformativa));
        opt_bolInformativa.click();}

    public void Seleccionar21_ContratoPrestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_contPrestamo));
        opt_contPrestamo.click();}

    public void Seleccionar22_DeclaracionJuradaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_decJuradaBienes));
        opt_decJuradaBienes.click();}


    public void Seleccionar23_CopiaCertificadoTasacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_tasacion));
        opt_tasacion.click();}

    public void Seleccionar24_CopiaCertificadoPlazoFijo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_copiaPlazoFijo));
        opt_copiaPlazoFijo.click();}

    public void Seleccionar25_CertificadoLiteral() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_certLiteralDom));
        opt_certLiteralDom.click();}

    public void Seleccionar26_CertificadoLiteral() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_garantiasInscr));
        opt_garantiasInscr.click();}

    public void Seleccionar27_ValuacionDelBien() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_valuacion));
        opt_valuacion.click();}

    public void Seleccionar28_OpinionLegal() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_opinionLegal));
        opt_opinionLegal.click();}


    public void Seleccionar29_ContratoPrestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_mobiliConst));
        opt_mobiliConst.click();}

    public void Seleccionar30_ContratoPrestamoPre() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_mobiliPreConst));
        opt_mobiliPreConst.click();}

    public void Seleccionar31_Testimonio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_testimonio));
        opt_testimonio.click();}

    public void Seleccionar31_FichaIngreso() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_fichaIngresoRRPP));
        opt_fichaIngresoRRPP.click();}

    public void Seleccionar32_CopiaLiteralPartida() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_copiaPartida));
        opt_copiaPartida.click();}

    public void ClickGuardarTerminar (){
        wait.until(ExpectedConditions.elementToBeClickable(btn_guardarTerminar));
        btn_guardarTerminar.click();}


}
