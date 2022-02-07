package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.record.PaneRecord;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialAmpliacionDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage seleccionarServicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    OperacionCreditoPage operacionCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSegurosSeleccionados;
    AnexarChecklistPage anexarChecklist;
    CerrarAnexarCheckListCreditoAprobarPage cerrarAnexarCheckListCreditoAprobar;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    InformeEEFFConsolidadoGrupoVinculadoPage informeEEFFConsolidadoGrupoVinculado;
    GrabarInformacionDocumentoPage grabarInformacionDocumento;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;
    String Valor;
    String ValorResultado;

    public ExcelCreditoEmpresarialAmpliacionDefinitions() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSegurosSeleccionados = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarChecklist = new AnexarChecklistPage(Hooks.driver);
        cerrarAnexarCheckListCreditoAprobar = new CerrarAnexarCheckListCreditoAprobarPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        informeEEFFConsolidadoGrupoVinculado = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        grabarInformacionDocumento = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        excel = new ExcelPage();
    }

    @Given("que la pagina web deL SGCRED está disponible")
    public void queLaPaginaWebDeLSGCREDEstáDisponible() {

        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");


    }

    @When("ingreso el usuario y clave del asesor")
    public void ingresoElUsuarioYClaveDelAsesor(DataTable user) {

        List<Map<String, String>> Lista = user.asMaps(String.class, String.class);
        for (int i = 0; i<Lista.size(); i++) {
            login.IngresarUsuario(Lista.get(i).get("nombre"));
            login.IngresarPassword(Lista.get(i).get("password"));
        }
    }

    @And("doy click en el botón Ingresar y muestra el menu principal")
    public void doyClickEnElBotónIngresarYMuestraElMenuPrincipal() {

        login.ClickSubmit();
        login.ValidarSesionesWeb();

    }

    @Then("registrar las propuestas de ampliación de créditos desde Excel {string}")
    public void registrarLasPropuestasDeAmpliaciónDeCréditosDesdeExcel(String arg0) {
        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i< datosExcel.length; i++){

            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickBtnCrearPropuesta();
            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();

            seleccionarServicio.AbrirVentanaServicio();
            seleccionarServicio.SeleccionarServicio(datosExcel[i][1]);
            seleccionarServicio.SeleccionarServicioCredito(datosExcel[i][2]);
            seleccionarServicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            seleccionarServicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);
            seleccionarServicio.SeleccionarPromocion(datosExcel[i][5]);
            seleccionarServicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            seleccionarServicio.SeleccionarPagare(datosExcel[i][7]);
            seleccionarServicio.ClickBtnSeleccionarPagare();
            seleccionarServicio.ClickBtnCargar();
            seleccionarServicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();

            propuesta.ClickBtnOperacion();
            seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
            seleccionarOperacionCredito.ValidarVentanaOP();
            seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();

            operacionCredito.AbrirVentanaOperacionCredito();
            operacionCredito.IngresarMonto(datosExcel[i][8]);
            operacionCredito.IngresarTasaInicial(datosExcel[i][9]);
            operacionCredito.ClickBtnCalcular();
            operacionCredito.SeleccionarPlanPagos(datosExcel[i][10]);
            operacionCredito.SeleccionarModalidad(datosExcel[i][11]);
            operacionCredito.SeleccionarOpcionPagos(datosExcel[i][12]);;
            operacionCredito.SeleccionarDiaPagos(datosExcel[i][13]);
            operacionCredito.IngresarNumeroCuotas(datosExcel[i][14]);
            operacionCredito.IngresarTasaPreferencial(datosExcel[i][15]);
            operacionCredito.SeleccionarFormaDesembolso(datosExcel[i][16]);
            operacionCredito.SeleccionarDepartamento(datosExcel[i][17]);
            operacionCredito.SeleccionarProvincia(datosExcel[i][18]);
            operacionCredito.SeleccionarDistrito(datosExcel[i][19]);
            operacionCredito.IngresarFechaDesembolso();
            operacionCredito.IngresarNotas(datosExcel[i][20]);
            operacionCredito.ClickBtnGrabar();
            operacionCredito.ObtenerAlerta();
            operacionCredito.CerrarVentanaOperacionCredito();

            propuesta.ClickBtnRegistrarSeguro();
            //seleccionarSeguros.AbrirVentanaSeleccionarSeguros(Seguros);
            //seleccionarSeguros.ClickbtnConfirmar();
            //seleccionarSeguros.CerrarVentanaSeleccionarSeguros();
            registrarSeguros.AbrirVentanaRegistrarSeguros();
            registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
            registrarSeguros.IngresarDPSeguroRiesgoPlanPymes();
            registrarSeguros.ClickBtnConfirmar();
            registrarSeguros.CerrarVentanaRegistrarSeguros();
            confirmarSegurosSeleccionados.AbrirVentanaConfirmacionSeguros();
            confirmarSegurosSeleccionados.ClickBtnCerrar();
            confirmarSegurosSeleccionados.CerrarVentanaConfirmacionSeguros();

            propuesta.ClickAnexarCheckListCreditos();
            anexarChecklist.AbrirVentanaAnexarCheckList();
            anexarChecklist.SeleccionarOpcionesCheckListCredito();
            anexarChecklist.Seleccionar_37opinionLegal();
            anexarChecklist.ClickBtnGuardarTerminar();
            anexarChecklist.AceptarAlerta();
            anexarChecklist.CerrarVentanaAnexarCheckList();

            cerrarAnexarCheckListCreditoAprobar.AbrirVentanaCerrarAnexarCheckListAprobar();
            cerrarAnexarCheckListCreditoAprobar.ClickBtnCerrar();
            cerrarAnexarCheckListCreditoAprobar.CerrarVentanaCerrarAnexarCheckListAprobar();

            propuesta.ClickAnexarGarantias();
            seleccionarGarantia.AbrirVentanaGarantia();
            seleccionarGarantia.ClickRegistrarGarantia();
            seleccionarGarantia.CerrarVentanaGarantia();
            seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
            seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesMaquinariayEquipo();
            seleccionarGarantiasExistentes.ClickBtnAceptar();
            seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();

            propuesta.ClickEnlazarEEFF();
            enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
            enlazarEstadosFinancieros.ClickbtnEnlazar();
            enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

            propuesta.ClickDesenlazarInformeVisita();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();

            propuesta.ClickEnlazarInformeVisita();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();

            propuesta.ClickEnlazarInformeComercialReprogramacion();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();

            propuesta.IngresarComentariosPropuesta();

            informeEEFFConsolidadoGrupoVinculado.AbrirVentanaInformeEstadoFinancieroConsolidadoGrupo();
            informeEEFFConsolidadoGrupoVinculado.IngresarComentarios();
            informeEEFFConsolidadoGrupoVinculado.IngresarAnalisis();
            informeEEFFConsolidadoGrupoVinculado.IngresarConducta();
            informeEEFFConsolidadoGrupoVinculado.ClickBtnGrabar();
            informeEEFFConsolidadoGrupoVinculado.ClickBtnFinalizar();
            informeEEFFConsolidadoGrupoVinculado.CerrarVentanaInformeEstadoFinancieroConsolidadoGrupo();

            propuesta.ClickMenuGrabarPropuesta();
            grabarInformacionDocumento.AbrirVentanaGrabarPropuesta();
            grabarInformacionDocumento.ClickBtnCerrarInformacion();
            grabarInformacionDocumento.CerrarVentanaGrabarPropuesta();

            Valor = propuesta.CapturarNumeroPropuesta();
            excel.EscribirExcel(arg0, 0, i, 23, Valor);

            propuesta.AbrirOpcionesDictamen();
            propuesta.ClickBtnAprobarPropuesta();
            aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
            aprobarDictamenPropuesta.IngresarObservaciones(datosExcel[i][21]);
            aprobarDictamenPropuesta.IngresarContrasena(datosExcel[i][22]);
            aprobarDictamenPropuesta.ClickBtnProcesar();
            aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();

            grabarInformacionDocumento.AbrirVentanaGrabarPropuesta();
            ValorResultado = grabarInformacionDocumento.CapturarMensajeDerivacion();
            excel.EscribirExcel(arg0,0,i,24,ValorResultado);
            grabarInformacionDocumento.ClickBtnCerrar();
            grabarInformacionDocumento.CerrarVentanaGrabarPropuesta();

            if (ValorResultado.equals("El Documento ha sido derivado satisfactoriamente")){
                listadoPropuesta.ClickBtnRegresar();
            }
            else {
                propuesta.ClickBtnRegresar();
                listadoPropuesta.ClickBtnRegresar();
            }

        }

        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();

    }
}
