package Definitions;
import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoConsumoDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage servicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOpeCred;
    OperacionCreditoPage operacioncredito;
    CambioTasaCreditoPage cambioTasaCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    EnlazarEvaluacionEconomicaPage enlazarEvaluacionEconomica;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarDocumentoPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;

    public ExcelCreditoConsumoDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        servicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOpeCred = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacioncredito = new OperacionCreditoPage(Hooks.driver);
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        enlazarEvaluacionEconomica = new EnlazarEvaluacionEconomicaPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        excel = new ExcelPage();
    }


    @Given("la pagina web SGCRED esta habilitado")
    public void laPaginaWebSGCREDEstaHabilitado() {

        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");

    }

    @When("completa el usuario y password")
    public void completaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("se presiona el boton ingresar y muestra el SGCRED")
    public void sePresionaElBotonIngresarYMuestraElSGCRED() {
        login.ClickSubmit();
    }

    @Then("ejecutar los registros de propuestas de credito desde Excel {string}")
    public void ejecutarLosRegistrosDePropuestasDeCreditoDesdeExcel(String arg0) {

        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++){

            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickBtnCrearPropuesta();
            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            System.out.println("lectura del dato:"+datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();
            servicio.SeleccionarServicio(datosExcel[i][1]);
            servicio.SeleccionarServicioCredito(datosExcel[i][2]);
            servicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            servicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);
            servicio.SeleccionarPromocion(datosExcel[i][5]);
            /*popUpComunicado.ValidarComunicado();
            propuesta.ClickBtnOperacion();
            seleccionarOpeCred.AbrirVentanaSeleccionarOP();
            seleccionarOpeCred.ValidarVentanaOP();
            seleccionarOpeCred.CerrarVentanaSeleccionarOP();
            operacioncredito.AbrirVentanaOperacionCredito();
            operacioncredito.IngresarMonto(datosExcel[i][6]);
            operacioncredito.IngresarTasaInicial(datosExcel[i][7]);
            operacioncredito.ClickBtnCalcular();
            operacioncredito.SeleccionarPlanPagos(datosExcel[i][8]);
            operacioncredito.SeleccionarModalidad(datosExcel[i][9]);
            operacioncredito.SeleccionarOpcionPagos(datosExcel[i][10]);
            operacioncredito.SeleccionarDiaPagos(datosExcel[i][11]);
            operacioncredito.IngresarNumeroCuotas(datosExcel[i][12]);
            operacioncredito.IngresarTasaPreferencial(datosExcel[i][13]);
            operacioncredito.SeleccionarFormaDesembolso(datosExcel[i][14]);
            operacioncredito.SeleccionarCodigoCuenta();
            operacioncredito.IngresarFechaDesembolso();
            operacioncredito.IngresarNotas(datosExcel[i][15]);
            operacioncredito.ClickBtnGrabar();
            operacioncredito.ObtenerAlerta();
            operacioncredito.CerrarVentanaOperacionCredito();
            propuesta.ClickBtnRegistrarSeguro();
            seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
            seleccionarSeguros.ClickbtnConfirmar();
            seleccionarSeguros.CerrarVentanaSeleccionarSeguros();
            registrarSeguros.AbrirVentanaRegistrarSeguros();
            registrarSeguros.ClickCheckSeguroDesgravamenSaldo();
            registrarSeguros.IngresarSeguroDesgravamenSaldo();
            registrarSeguros.ClickCheckSeguroVidaPlan1();
            registrarSeguros.IngresarSeguroVidaPlan1();
            registrarSeguros.ClickBtnConfirmar();
            registrarSeguros.CerrarVentanaRegistrarSeguros();
            confirmarSeguros.AbrirVentanaConfirmacionSeguros();
            confirmarSeguros.ClickBtnCerrar();
            confirmarSeguros.CerrarVentanaConfirmacionSeguros();
            propuesta.ClickAnexarGarantias();
            seleccionarGarantia.AbrirVentanaGarantia();
            seleccionarGarantia.ClickRegistrarGarantia();
            seleccionarGarantia.CerrarVentanaGarantia();
            seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
            seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesCC();
            seleccionarGarantiasExistentes.ClickBtnAceptar();
            seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();
            propuesta.ClickEnlazarHojaTrabajo();
            enlazarEvaluacionEconomica.AbrirVentanaEvaluacionEconomica();
            enlazarEvaluacionEconomica.ClickBtnRealizar();
            enlazarEvaluacionEconomica.CerrarVentanaEvaluacionEconomica();
            propuesta.ClickDesenlazarInformeVisitaConsumo();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();
            propuesta.ClickEnlazarInformeVisitaConsumo();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();
            propuesta.ClickEnlazarInformeComercialConsumo();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();
            propuesta.IngresarClasificacionCrediticia(datosExcel[i][16]);
            propuesta.IngresarObjetivoCredito(datosExcel[i][17]);
            propuesta.IngresarJustificacionCredito(datosExcel[i][18]);
            propuesta.ClickMenuGrabarPropuesta();
            grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
            grabarDocumentoPropuesta.ClickBtnCerrarInformacion();
            grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
            propuesta.AbrirOpcionesDictamen();
            propuesta.ClickBtnAprobarPropuesta();
            aprobarDictamenPropuesta.IngresarObservaciones(datosExcel[i][19]);
            aprobarDictamenPropuesta.IngresarContrasena(datosExcel[i][20]);
            aprobarDictamenPropuesta.ClickBtnProcesar();
            aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
            grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
            grabarDocumentoPropuesta.ClickBtnCerrarInformacion();
            grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();*/
            listadoClientes.ClickBtnRegresar();
            listadoPropuesta.ClickBtnRegresar();
        }
    }

}
