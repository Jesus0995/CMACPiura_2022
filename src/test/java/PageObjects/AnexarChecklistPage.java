package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnexarChecklistPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Informacion basica cliente

    @FindBy(id = "item_1") private WebElement opt_cliTarjetaBasica;
    @FindBy(id = "item_2") private WebElement opt_cliCopiaFedateada;
    @FindBy(id = "item_3") private WebElement opt_cliVigenciaActualizada;
    @FindBy(id = "item_4") private WebElement opt_cliReciboLuz;
    @FindBy(id = "item_5") private WebElement opt_cliCroquisDomic;
    @FindBy(id = "item_6") private WebElement opt_cliAgricolas;
    @FindBy(id = "item_7") private WebElement opt_cliFotoPanoramica;

// Informacion del negocio

    @FindBy(id = "item_9") private WebElement opt_NegocioLuz;
    @FindBy(id = "item_10") private WebElement opt_NegocioFoto;
    @FindBy(id = "item_11") private WebElement opt_NegocioSustento;
    @FindBy(id = "item_12") private WebElement opt_NegocioInforme;

//operaciones propuestas


    @FindBy(id = "item_15") private WebElement opt_OperSolicitud;

    //seguro cliente
    @FindBy(id = "item_16") private WebElement opt_SegCopiaDPS;

    //seguro garantia

    @FindBy(id = "item_17") private WebElement opt_SegPolizas;

    //informacion economica financiera del cliente

    @FindBy(id = "item_18") private WebElement opt_EEFFSectorista;
    @FindBy(id = "item_19") private WebElement opt_flujoCaja;

    //informe verificacion previa

    @FindBy(id = "item_56") private WebElement opt_clienteTarjeta;

    //garantias no inscribibles

    @FindBy(id = "item_59") private WebElement opt_busquedaBienes;
    @FindBy(id = "item_60") private WebElement opt_docPropiedad;
    @FindBy(id = "item_62") private WebElement opt_bolInformativa;
    @FindBy(id = "item_63") private WebElement opt_contPrestamo;
    @FindBy(id = "item_64") private WebElement opt_decJuradaBienes;

    //garantia con desposesion

    @FindBy(id = "item_65") private WebElement opt_tasacion;

    @FindBy(id = "item_66") private WebElement opt_copiaPlazoFijo;


    //garantias inscribibles
    @FindBy(id = "item_68") private WebElement opt_certLiteralDom;
    @FindBy(id = "item_69") private WebElement opt_garantiasInscr;
    @FindBy(id = "item_70") private WebElement opt_valuacion;
    @FindBy(id = "item_71") private WebElement opt_opinionLegal;
    @FindBy(id = "item_72") private WebElement opt_mobiliConst;
    @FindBy(id = "item_73") private WebElement opt_mobiliPreConst;
    @FindBy(id = "item_74") private WebElement opt_testimonio;

    //Desembolso de credito

    @FindBy(id = "item_80") private WebElement opt_fichaIngresoRRPP;
    @FindBy(id = "item_81") private WebElement opt_copiaPartida;

    @FindBy(id="idSaveSend") private WebElement btn_guardarTerminar;

    public AnexarChecklistPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void SeleccionarOpcion1() {opt_cliTarjetaBasica.click();}
    public void SeleccionarOpcion2() {opt_cliCopiaFedateada.click();}
    public void SeleccionarOpcion3() {opt_cliVigenciaActualizada.click();}
    public void SeleccionarOpcion4() {opt_cliReciboLuz.click();}
    public void SeleccionarOpcion5() {opt_cliCroquisDomic.click();}
    public void SeleccionarOpcion6() {opt_cliAgricolas.click();}
    public void SeleccionarOpcion7() {opt_cliFotoPanoramica.click();}

    public void SeleccionarOpcion9() {opt_NegocioLuz.click();}
    public void SeleccionarOpcion10() {opt_NegocioFoto.click();}
    public void SeleccionarOpcion11() {opt_NegocioSustento.click();}
    public void SeleccionarOpcion12() {opt_NegocioInforme.click();}

    public void SeleccionarOpcion15() {opt_OperSolicitud.click();}

    public void SeleccionarOpcion16() {opt_SegCopiaDPS.click();}

    public void SeleccionarOpcion17() {opt_SegPolizas.click();}

    public void SeleccionarOpcion18() {opt_EEFFSectorista.click();}
    public void SeleccionarOpcion19() {opt_flujoCaja.click();}

    public void SeleccionarOpcion56() {opt_clienteTarjeta.click();}

    public void SeleccionarOpcion59() {opt_busquedaBienes.click();}
    public void SeleccionarOpcion60() {opt_docPropiedad.click();}
    public void SeleccionarOpcion62() {opt_bolInformativa.click();}
    public void SeleccionarOpcion63() {opt_contPrestamo.click();}
    public void SeleccionarOpcion64() {opt_decJuradaBienes.click();}


    public void SeleccionarOpcion65() {opt_tasacion.click();}
    public void SeleccionarOpcion66() {opt_copiaPlazoFijo.click();}

    public void SeleccionarOpcion68() {opt_certLiteralDom.click();}
    public void SeleccionarOpcion69() {opt_garantiasInscr.click();}

    public void SeleccionarOpcion70() {opt_valuacion.click();}
    public void SeleccionarOpcion71() {opt_opinionLegal.click();}


    public void SeleccionarOpcion72() {opt_mobiliConst.click();}
    public void SeleccionarOpcion73() {opt_mobiliPreConst.click();}

    public void SeleccionarOpcion74() {opt_testimonio.click();}

    public void SeleccionarOpcion80() {opt_fichaIngresoRRPP.click();}
    public void SeleccionarOpcion81() {opt_copiaPartida.click();}

    public void ClickGuardarTerminar (){btn_guardarTerminar.click();}



}
