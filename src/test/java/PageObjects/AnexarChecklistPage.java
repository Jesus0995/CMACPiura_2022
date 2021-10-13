package PageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.util.List;
import java.util.Set;

public class AnexarChecklistPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresAnexarCheckList;
    private Alert MensajeAlerta;


    //Informacion basica cliente
    @FindBy(xpath = "//input[@id='item_1' and @value='2']")
    private WebElement opt_1TarjetaBasica;
    @FindBy(xpath = "//input[@id='item_2' and @value='2']")
    private WebElement opt_2CopiaFedateada;
    @FindBy(xpath = "//input[@id='item_20' and @value='2']")
    private WebElement opt_3VigenciaActualizada;
    @FindBy(xpath = "//input[@id='item_21' and @value='2']")
    private WebElement opt_4ReciboLuz;
    @FindBy(xpath = "//input[@id='item_5' and @value='2']")
    private WebElement opt_5CroquisDomicilio;
    @FindBy(xpath = "//input[@id='item_6' and @value='2']")
    private WebElement opt_6Agricolas;
    @FindBy(xpath = "//input[@id='item_7' and @value='2']")
    private WebElement opt_7FotoPanoramica;

    // Informacion del negocio
    @FindBy(xpath = "//input[@id='item_12' and @value='2']")
    private WebElement opt_8NegocioLuz;
    @FindBy(xpath = "//input[@id='item_9' and @value='2']")
    private WebElement opt_9NegocioFoto;
    @FindBy(xpath = "//input[@id='item_10' and @value='2']")
    private WebElement opt_10NegocioSustento;
    @FindBy(xpath = "//input[@id='item_11' and @value='2']")
    private WebElement opt_11NegocioInforme;

    //operaciones propuestas
    @FindBy(xpath = "//input[@id='item_15' and @value='2']")
    private WebElement opt_12OSolicitud;

    //seguro cliente
    @FindBy(xpath = "//input[@id='item_22' and @value='2']")
    private WebElement opt_13SeguroCopiaDPS;

    //seguro garantia
    @FindBy(xpath = "//input[@id='item_17' and @value='2']")
    private WebElement opt_14SeguroPolizas;

    //informacion economica financiera del cliente
    @FindBy(xpath = "//input[@id='item_23' and @value='2']")
    private WebElement opt_15EEFFSectorista;
    @FindBy(xpath = "//input[@id='item_24' and @value='2']")
    private WebElement opt_16FlujoCaja;
    //Se agrego estas opciones el dia 29/09
    @FindBy(xpath = "//input[@id='item_26' and @value='2']")
    private WebElement opt_17EstadosFinancieros;
    @FindBy(xpath = "//input[@id='item_32' and @value='2']")
    private WebElement opt_18FlujoCajaProyectado;
    @FindBy(xpath = "//input[@id='item_27' and @value='2']")
    private WebElement opt_19BalanceGeneralProyectado;
    @FindBy(xpath = "//input[@id='item_28' and @value='2']")
    private WebElement opt_20EEGGYPPAnual;
    @FindBy(xpath = "//input[@id='item_29' and @value='2']")
    private WebElement opt_21FlujoCajaHistoricoAnual;
    @FindBy(xpath = "//input[@id='item_30' and @value='2']")
    private WebElement opt_22EstadosFinancierosSemestral;
    @FindBy(xpath = "//input[@id='item_31' and @value='2']")
    private WebElement opt_23FlujoCajaHistoricoProyectado;

    //Declaracion Patrimonial nuevo 29/09
    @FindBy(xpath = "//input[@id='item_57' and @value='2']")
    private WebElement opt_24PersonasNaturalesDeudores;

    //informe verificacion previa cambio de nombre 29/09
    @FindBy(xpath = "//input[@id='item_56' and @value='2']")
    private WebElement opt_25InformeVisitaSectoristaLider;

    //reporte de unidad de riesgo - nuevo 29/09
    @FindBy(xpath = "//input[@id='item_58' and @value='2']")
    private WebElement opt_26OpinionRiesgosPropuestasIguales;

    //garantias no inscribibles
    @FindBy(xpath = "//input[@id='item_59' and @value='2']")
    private WebElement opt_27BusquedaBienes;
    @FindBy(xpath = "//input[@id='item_60' and @value='2']")
    private WebElement opt_28DocumentoPropiedad;
    @FindBy(xpath = "//input[@id='item_61' and @value='2']")
    private WebElement opt_29BoletaInformativa;
    @FindBy(xpath = "//input[@id='item_63' and @value='2']")
    private WebElement opt_30ContratoPrestamo;
    @FindBy(xpath = "//input[@id='item_64' and @value='2']")
    private WebElement opt_31DeclaracionJuradaBienes;

    //garantia con desposesion
    @FindBy(xpath = "//input[@id='item_65' and @value='2']")
    private WebElement opt_32CopiaCertificadoTasacion;
    @FindBy(xpath = "//input[@id='item_67' and @value='2']")
    private WebElement opt_33CopiasPlazoFijo;


    //garantias inscribibles
    @FindBy(xpath = "//input[@id='item_68' and @value='2']")
    private WebElement opt_34CertificadoLiteralDomicilio;
    @FindBy(xpath = "//input[@id='item_75' and @value='2']")
    private WebElement opt_35GarantiaInscribible;
    @FindBy(xpath = "//input[@id='item_76' and @value='2']")
    private WebElement opt_36TasacionBien;
    //@FindBy(xpath = "//input[@name='item_71' and @value='2']") private WebElement opt_37opinionLegal;
    @FindBy(xpath = "//input[@name='item_72' and @value='2']")
    private WebElement opt_38ContratoGarantiaMobiliaria;
    @FindBy(xpath = "//input[@name='item_73' and @value='2']")
    private WebElement opt_39ContratoPrestamoMobiliariaPreConst;
    @FindBy(xpath = "//input[@id='item_74' and @value='2']")
    private WebElement opt_40CopiaTestimonio;

    //Desembolso de credito
    @FindBy(xpath = "//input[@id='item_80' and @value='2']")
    private WebElement opt_41FichaIngresoRRPP;
    @FindBy(xpath = "//input[@id='item_81' and @value='2']")
    private WebElement opt_42CopiaLiteralPartida;


    @FindBy(id = "idSaveSend")
    private WebElement btn_guardarTerminar;

    public void AbrirVentanaAnexarCheckList() {
        identificadoresAnexarCheckList = driver.getWindowHandles();
        System.out.println(identificadoresAnexarCheckList);
        String LastHandle = "";

        for (String identificadorAnexarCheckList : identificadoresAnexarCheckList) {
            LastHandle = identificadorAnexarCheckList;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }

    public void CerrarVentanaAnexarCheckList() {
        Integer SetSize = identificadoresAnexarCheckList.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];
        for (String identificadorAnexarCheckList : identificadoresAnexarCheckList) {
            Handles[Index] = identificadorAnexarCheckList;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);

    }


    public AnexarChecklistPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void SeleccionarOpcionesCheckListCredito() {
        Esperar(7);
        try {
           List<WebElement> checks = driver.findElements(By.xpath("//input[@Title='Expediente']"));
           for (WebElement check : checks) {
               check.click();

            }
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar las opciones del check list credito" + error.getMessage());
        }


    }


    public void Seleccionar_1TarjetaInformacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_1TarjetaBasica));
        opt_1TarjetaBasica.click();

    }

    public void Seleccionar_2CopiaFedatariaDOI() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_2CopiaFedateada));
        opt_2CopiaFedateada.click();

    }

    public void Seleccionar_3VigenciaPoderActualizada() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_3VigenciaActualizada));
        opt_3VigenciaActualizada.click();

    }

    public void Seleccionar_4ReciboLuz() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_4ReciboLuz));
        opt_4ReciboLuz.click();

    }

    public void Seleccionar_5CroquisDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_5CroquisDomicilio));
        opt_5CroquisDomicilio.click();

    }

    public void Seleccionar_6GPSAgricolas() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_6Agricolas));
        opt_6Agricolas.click();

    }

    public void Seleccionar_7FotoDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_7FotoPanoramica));
        opt_7FotoPanoramica.click();

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
        wait.until(ExpectedConditions.elementToBeClickable(opt_12OSolicitud));
        opt_12OSolicitud.click();

    }

    public void Seleccionar_13CopiaDPS() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_13SeguroCopiaDPS));
        opt_13SeguroCopiaDPS.click();

    }

    public void Seleccionar_14CopiaPolizaSeguro() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_14SeguroPolizas));
        opt_14SeguroPolizas.click();

    }

    public void Seleccionar_15EstadosFinancieros() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_15EEFFSectorista));
        opt_15EEFFSectorista.click();

    }

    public void Seleccionar_16FlujodeCaja() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_16FlujoCaja));
        opt_16FlujoCaja.click();

    }

    public void Seleccionar_17EstadosFinancieros() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_17EstadosFinancieros));
        opt_17EstadosFinancieros.click();

    }

    public void Seleccionar_18FlujoCajaProyectado() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_18FlujoCajaProyectado));
        opt_18FlujoCajaProyectado.click();

    }

    public void Seleccionar_19BalanceGeneralProyectado() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_19BalanceGeneralProyectado));
        opt_19BalanceGeneralProyectado.click();

    }

    public void Seleccionar_20EEGGYPPAnual() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_20EEGGYPPAnual));
        opt_20EEGGYPPAnual.click();

    }

    public void Seleccionar_21FlujoCajaHistoricoAnual() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_21FlujoCajaHistoricoAnual));
        opt_21FlujoCajaHistoricoAnual.click();

    }

    public void Seleccionar_22EstadosFinancierosSemestral() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_22EstadosFinancierosSemestral));
        opt_22EstadosFinancierosSemestral.click();

    }

    public void Seleccionar_23FlujoCajaHistoricoProyectado() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_23FlujoCajaHistoricoProyectado));
        opt_23FlujoCajaHistoricoProyectado.click();

    }

    public void Seleccionar_24PersonasNaturalesDeudores() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_24PersonasNaturalesDeudores));
        opt_24PersonasNaturalesDeudores.click();

    }

    public void Seleccionar_25InformeVisitaSectoristaLider() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_25InformeVisitaSectoristaLider));
        opt_25InformeVisitaSectoristaLider.click();

    }

    public void Seleccionar_26OpinionRiesgosPropuestaIguales() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_26OpinionRiesgosPropuestasIguales));
        opt_26OpinionRiesgosPropuestasIguales.click();

    }

    public void Seleccionar_27VaBusquedaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_27BusquedaBienes));
        opt_27BusquedaBienes.click();

    }

    public void Seleccionar_28DocumentoPropiedad() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_28DocumentoPropiedad));
        opt_28DocumentoPropiedad.click();

    }

    public void Seleccionar_29BoletaInformativa() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_29BoletaInformativa));
        opt_29BoletaInformativa.click();

    }

    public void Seleccionar_30ContratoPrestamo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_30ContratoPrestamo));
        opt_30ContratoPrestamo.click();

    }

    public void Seleccionar_31DeclaracionJuradaBienes() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_31DeclaracionJuradaBienes));
        opt_31DeclaracionJuradaBienes.click();

    }

    public void Seleccionar_32CopiaCertificadoTasacion() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_32CopiaCertificadoTasacion));
        opt_32CopiaCertificadoTasacion.click();

    }

    public void Seleccionar_33CopiasPlazoFijo() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_33CopiasPlazoFijo));
        opt_33CopiasPlazoFijo.click();

    }


    public void Seleccionar_34CertificadoLiteralDomicilio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_34CertificadoLiteralDomicilio));
        opt_34CertificadoLiteralDomicilio.click();

    }


    public void Seleccionar_35GarantiaInscribible() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_35GarantiaInscribible));
        opt_35GarantiaInscribible.click();

    }

    public void Seleccionar_36TasacionBien() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_36TasacionBien));
        opt_36TasacionBien.click();
        //Esperar(1);

    }

    public void Seleccionar_37opinionLegal() {
    WebElement opcion37 = driver.findElement(By.xpath("//input[@id='item_71' and @value='2']"));
        try {
            Esperar(9);
            opcion37.click();

        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al seleccionar la opcion"+error.getMessage());
        }
    }

    /*
        public void Seleccionar_37opinionLegal1(){
            Esperar (3);
            try{
            String JScript = opt_37opinionLegal.getAttribute("click");
            ((JavascriptExecutor) driver).executeScript(JScript);
            } catch (Exception error) {

                error.printStackTrace();

                System.out.println(error.getMessage());

            }
        }
    */
    public void Seleccionar_38ContratoGarantiaMobiliaria() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_38ContratoGarantiaMobiliaria));
        opt_38ContratoGarantiaMobiliaria.click();

    }


    public void Seleccionar_39ContratoPrestamoMobiliariaPreConst() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_39ContratoPrestamoMobiliariaPreConst));
        opt_39ContratoPrestamoMobiliariaPreConst.click();

    }


    public void Seleccionar_40CopiaTestimonio() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_40CopiaTestimonio));
        opt_40CopiaTestimonio.click();

    }

    public void Seleccionar_41FichaIngresoRRPP() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_41FichaIngresoRRPP));
        opt_41FichaIngresoRRPP.click();

    }

    public void Seleccionar_42CopiaLiteralPartida() {
        wait.until(ExpectedConditions.elementToBeClickable(opt_42CopiaLiteralPartida));
        opt_42CopiaLiteralPartida.click();
    }

    public void ClickGuardarTerminar() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_guardarTerminar));
        btn_guardarTerminar.click();

        //Esperar (1);
    }

    public void AceptarAlerta() {

        MensajeAlerta = driver.switchTo().alert();
        System.out.println("El mensaje alerta: " + MensajeAlerta.getText());
        MensajeAlerta.accept();
        Esperar(3);

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
