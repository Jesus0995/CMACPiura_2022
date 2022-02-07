package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage servicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    OperacionCreditoPage operacionCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSegurosSeleccionados;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;
    String ValorPropuesta;
    String ValorTasa;

    public ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        servicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSegurosSeleccionados = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        excel = new ExcelPage();
    }

    @Given("la pagina web SGCRED es correcto")
    public void laPaginaWebSGCREDEsCorrecto() {

        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");

    }

    @When("digita el usuario y password")
    public void digitaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("se da click en el boton ingresar y muestra el SGCRED")
    public void seDaClickEnElBotonIngresarYMuestraElSGCRED() {

        login.ClickSubmit();
        login.ValidarSesionesWeb();

    }

    @Then("registrar las propuestas de reprogramacion de creditos desde Excel {string}")
    public void registrarLasPropuestasDeReprogramacionDeCreditosDesdeExcel(String arg0) {
        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++) {

            menuPrincipal.ClickPropuestaFinanciamiento();

            listadoPropuesta.ClickBtnCrearPropuesta();

            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            System.out.println("lectura cliente desde excel:" + datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();

            servicio.AbrirVentanaServicio();
            servicio.SeleccionarServicio(datosExcel[i][1]);
            servicio.SeleccionarServicioCredito(datosExcel[i][2]);
            servicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            servicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);
            servicio.SeleccionarPromocion(datosExcel[i][5]);
            servicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            servicio.SeleccionarPagare(datosExcel[i][7]);
            servicio.ClickBtnSeleccionarPagare();
            servicio.ClickBtnCargar();
            servicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();

            propuesta.ClickBtnOperacion();
            seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
            seleccionarOperacionCredito.ValidarVentanaOP();
            seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();

            ValorTasa = propuesta.CapturarTasaPreferencial();

            operacionCredito.AbrirVentanaOperacionCredito();
            operacionCredito.IngresarMonto(datosExcel[i][8]);
            operacionCredito.ClickBtnCalcular();
            operacionCredito.SeleccionarPlanPagos(datosExcel[i][9]);
            operacionCredito.SeleccionarModalidad(datosExcel[i][10]);
            operacionCredito.SeleccionarOpcionPagos(datosExcel[i][11]);
            operacionCredito.SeleccionarDiaPagos(datosExcel[i][12]);
            operacionCredito.IngresarNumeroCuotas(datosExcel[i][13]);
            operacionCredito.IngresarTasaPreferencial(ValorTasa);
            operacionCredito.SeleccionarFormaDesembolso(datosExcel[i][15]);
            operacionCredito.IngresarFechaDesembolso();
            operacionCredito.IngresarNotas(datosExcel[i][17]);
            operacionCredito.ClickBtnGrabar();
            operacionCredito.ObtenerAlerta();
            operacionCredito.CerrarVentanaOperacionCredito();

            propuesta.ClickBtnRegistrarSeguro();
            seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
            seleccionarSeguros.ClickbtnConfirmar();
            seleccionarSeguros.CerrarVentanaSeleccionarSeguros();
            registrarSeguros.AbrirVentanaRegistrarSeguros();
            registrarSeguros.ClickCheckSeguroDesgravamenSaldoCapital();
            registrarSeguros.IngresarSeguroDesgravamenSaldoCapital();
            registrarSeguros.ClickBtnConfirmar();
            registrarSeguros.CerrarVentanaRegistrarSeguros();
            confirmarSegurosSeleccionados.AbrirVentanaConfirmacionSeguros();
            confirmarSegurosSeleccionados.ClickBtnCerrar();
            confirmarSegurosSeleccionados.CerrarVentanaConfirmacionSeguros();

            /*propuesta.ClickAnexarCheckListCreditos();
            anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
            anexarCheckListCreditos.SeleccionarOpcionesCheckListCredito();
            anexarCheckListCreditos.Seleccionar_37opinionLegal();
            anexarCheckListCreditos.ClickBtnGuardarTerminar();
            anexarCheckListCreditos.AceptarAlerta();
            anexarCheckListCreditos.CerrarVentanaAnexarCheckList();

            confirmarCheckList.AbrirVentanaConfirmacionCheckList();
            confirmarCheckList.ClickBtnCerrar();
            confirmarCheckList.CerrarVentanaConfirmacionCheckList();*/

            propuesta.ClickAnexarGarantias();
            seleccionarGarantia.AbrirVentanaGarantia();
            seleccionarGarantia.ClickRegistrarGarantia();
            seleccionarGarantia.CerrarVentanaGarantia();
            seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
            seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesPromoCreditoAlToque();
            seleccionarGarantiasExistentes.ClickBtnAceptar();
            seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();

            propuesta.ClickEnlazarEEFF();
            enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
            enlazarEstadosFinancieros.ClickbtnEnlazar();
            enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

            propuesta.ClickDesenlazarInformeVisitaReprogramacion();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();

            propuesta.ClickEnlazarInformeVisitaReprogramacion();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();

            propuesta.ClickEnlazarInformeComercialReprogramacion();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();

            propuesta.IngresarComentariosPropuesta();

            propuesta.ClickMenuGrabarPropuesta();
            grabarPropuesta.AbrirVentanaGrabarPropuesta();
            grabarPropuesta.ClickBtnCerrarInformacion();
            grabarPropuesta.CerrarVentanaGrabarPropuesta();

            ValorPropuesta = propuesta.CapturarNumeroPropuesta();
            excel.EscribirExcel(arg0, 0, i, 20, ValorPropuesta);

            propuesta.ClickBtnRegresar();
            listadoPropuesta.ClickBtnRegresar();

        }

        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();

    }
}