package PageObjects;


import org.openqa.selenium.Alert;
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
    private Alert MensajeAlerta;

    //Informacion basica cliente
    @FindBy(xpath = "//input[@id='item_1' and @value='2']") private WebElement opt_1cliTarjetaBasica;
    @FindBy(xpath = "//input[@id='item_2' and @value='2']") private WebElement opt_2cliCopiaFedateada;
    @FindBy(xpath = "//input[@id='item_3' and @value='2']") private WebElement opt_3cliVigenciaActualizada;
    @FindBy(xpath = "//input[@id='item_4' and @value='2']") private WebElement opt_4cliReciboLuz;
    @FindBy(xpath = "//input[@id='item_5' and @value='2']") private WebElement opt_5cliCroquisDomic;
    @FindBy(xpath = "//input[@id='item_6' and @value='2']") private WebElement opt_6cliAgricolas;
    @FindBy(xpath = "//input[@id='item_7' and @value='2']") private WebElement opt_7cliFotoPanoramica;

// Informacion del negocio
    @FindBy(xpath = "//input[@id='item_8' and @value='2']") private WebElement opt_8NegocioLuz;
    @FindBy(xpath = "//input[@id='item_9' and @value='2']") private WebElement opt_9NegocioFoto;
    @FindBy(xpath = "//input[@id='item_10' and @value='2']") private WebElement opt_10NegocioSustento;
    @FindBy(xpath = "//input[@id='item_11' and @value='2']") private WebElement opt_11NegocioInforme;

//operaciones propuestas
    @FindBy(xpath = "//input[@id='item_15' and @value='2']") private WebElement opt_12OperSolicitud;

    //seguro cliente
    @FindBy(xpath = "//input[@id='item_16' and @value='2']") private WebElement opt_13SegCopiaDPS;

    //seguro garantia
    @FindBy(xpath = "//input[@id='item_17' and @value='2']") private WebElement opt_14SegPolizas;

    //informacion economica financiera del cliente
    @FindBy(xpath = "//input[@id='item_18' and @value='2']") private WebElement opt_15EEFFSectorista;
    @FindBy(xpath = "//input[@id='item_19' and @value='2']") private WebElement opt_16flujoCaja;

    //informe verificacion previa
    @FindBy(xpath = "//input[@id='item_56' and @value='2']") private WebElement opt_17clienteTarjeta;

    //garantias no inscribibles
    @FindBy(xpath = "//input[@id='item_59' and @value='2']") private WebElement opt_18busquedaBienes;
    @FindBy(xpath = "//input[@id='item_60' and @value='2']") private WebElement opt_19docPropiedad;
    @FindBy(xpath = "//input[@id='item_62' and @value='2']") private WebElement opt_20bolInformativa;
    @FindBy(xpath = "//input[@id='item_63' and @value='2']") private WebElement opt_21contPrestamo;
    @FindBy(xpath = "//input[@id='item_64' and @value='2']") private WebElement opt_22decJuradaBienes;

    //garantia con desposesion
    @FindBy(xpath = "//input[@id='item_65' and @value='2']") private WebElement opt_23tasacion;
    @FindBy(xpath = "//input[@id='item_66' and @value='2']") private WebElement opt_24copiaPlazoFijo;


    //garantias inscribibles
    @FindBy(xpath = "//input[@id='item_68' and @value='2']") private WebElement opt_25certLiteralDom;
    @FindBy(xpath = "//input[@id='item_69' and @value='2']") private WebElement opt_26garantiasInscr;
    @FindBy(xpath = "//input[@id='item_70' and @value='2']") private WebElement opt_27valuacion;
    @FindBy(xpath = "//input[@id='item_71' and @value='2']") private WebElement opt_28opinionLegal;
    @FindBy(xpath = "//input[@id='item_72' and @value='2']") private WebElement opt_29mobiliConst;
    @FindBy(xpath = "//input[@id='item_73' and @value='2']") private WebElement opt_30mobiliPreConst;
    @FindBy(xpath = "//input[@id='item_74' and @value='2']") private WebElement opt_31testimonio;

    //Desembolso de credito
    @FindBy(xpath = "//input[@id='item_80' and @value='2']") private WebElement opt_32fichaIngresoRRPP;
    @FindBy(xpath = "//input[@id='item_81' and @value='2']") private WebElement opt_33copiaPartida;

    @FindBy(id="idSaveSend") private WebElement btn_guardarTerminar;

    public void AbrirVentanaAnexarCheckList(){
        identificadoresAnexarCheckList = driver.getWindowHandles();
        System.out.println(identificadoresAnexarCheckList);
        String LastHandle ="";

        for (String identificadorAnexarCheckList :identificadoresAnexarCheckList ){
            LastHandle = identificadorAnexarCheckList;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:"+ driver.getTitle());

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

    public void Seleccionar_1TarjetaInformacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_1cliTarjetaBasica));
        opt_1cliTarjetaBasica.click();
    }

    public void Seleccionar_2CopiaFedatariaDOI() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_2cliCopiaFedateada));
        opt_2cliCopiaFedateada.click();
    }

    public void Seleccionar_3VigenciaPoderActualizada() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_3cliVigenciaActualizada));
        opt_3cliVigenciaActualizada.click();
    }

    public void Seleccionar_4ReciboLuz() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_4cliReciboLuz));
        opt_4cliReciboLuz.click();
    }

    public void Seleccionar_5CroquisDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_5cliCroquisDomic));
        opt_5cliCroquisDomic.click();
    }

    public void Seleccionar_6GPSAgricolas() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_6cliAgricolas));
        opt_6cliAgricolas.click();
    }

    public void Seleccionar_7FotoDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_7cliFotoPanoramica));
        opt_7cliFotoPanoramica.click();
    }


    public void Seleccionar_8ReciboSSBB() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_8NegocioLuz));
        opt_8NegocioLuz.click();
    }

    public void Seleccionar_9FotoNegocio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_9NegocioFoto));
        opt_9NegocioFoto.click();
    }

    public void Seleccionar_10SustentoVigencia() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_10NegocioSustento));
        opt_10NegocioSustento.click();
    }

    public void Seleccionar_11InformeComercial() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_11NegocioInforme));
        opt_11NegocioInforme.click();
    }

    public void Seleccionar_12SolicitudCredito() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_12OperSolicitud));
        opt_12OperSolicitud.click();
    }

    public void Seleccionar_13CopiaDPS() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_13SegCopiaDPS));
        opt_13SegCopiaDPS.click();
    }

    public void Seleccionar_14CopiaPolizaSeguro() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_14SegPolizas));
        opt_14SegPolizas.click();
    }

    public void Seleccionar_15EstadosFinancieros() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_15EEFFSectorista));
        opt_15EEFFSectorista.click();
    }

    public void Seleccionar_16FlujodeCaja() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_16flujoCaja));
        opt_16flujoCaja.click();
    }

    public void Seleccionar_17InformeVisitaSectorista() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_17clienteTarjeta));
        opt_17clienteTarjeta.click();
    }

    public void Seleccionar_18BusquedaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_18busquedaBienes));
        opt_18busquedaBienes.click();
    }

    public void Seleccionar_19DocumentosSustentatorios() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_19docPropiedad));
        opt_19docPropiedad.click();
    }

    public void Seleccionar_20BoletaInformativa() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_20bolInformativa));
        opt_20bolInformativa.click();
    }

    public void Seleccionar_21ContratoPrestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_21contPrestamo));
        opt_21contPrestamo.click();
    }

    public void Seleccionar_22DeclaracionJuradaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_22decJuradaBienes));
        opt_22decJuradaBienes.click();
    }

    public void Seleccionar_23CopiaCertificadoTasacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_23tasacion));
        opt_23tasacion.click();
    }

    public void Seleccionar_24CopiaCertificadoPlazoFijo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_24copiaPlazoFijo));
        opt_24copiaPlazoFijo.click();
    }

    public void Seleccionar_25CertificadoLiteral() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_25certLiteralDom));
        opt_25certLiteralDom.click();
    }

    public void Seleccionar_26CertificadoLiteral() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_26garantiasInscr));
        opt_26garantiasInscr.click();
    }

    public void Seleccionar_27ValuacionDelBien() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_27valuacion));
        opt_27valuacion.click();
    }

    public void Seleccionar_28OpinionLegal() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_28opinionLegal));
        opt_28opinionLegal.click();
    }

    public void Seleccionar_29ContratoPrestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_29mobiliConst));
        opt_29mobiliConst.click();
    }

    public void Seleccionar_30ContratoPrestamoPre() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_30mobiliPreConst));
        opt_30mobiliPreConst.click();
    }

    public void Seleccionar_31Testimonio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_31testimonio));
        opt_31testimonio.click();
    }

    public void Seleccionar_32FichaIngresoRRPP() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_32fichaIngresoRRPP));
        opt_32fichaIngresoRRPP.click();
    }

    public void Seleccionar_33CopiaLiteralPartida() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_33copiaPartida));
        opt_33copiaPartida.click();
    }

    public void ClickGuardarTerminar(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_guardarTerminar));
        btn_guardarTerminar.click();
        //Esperar (1);
    }

    public void AceptarAlerta(){
        MensajeAlerta = driver.switchTo().alert();
        System.out.println("El mensaje alerta: " + MensajeAlerta.getText());
        MensajeAlerta.accept();
        Esperar(1);

    }

    private void Esperar(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos); }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }


}
