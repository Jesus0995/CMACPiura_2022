package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage seleccionarServicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    OperacionCreditoPage operacioncredito;
    CambioTasaCreditoPage cambioTasaCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    CancelandoPagaresPage cancelandoPagares;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;
    String ValorPropuesta;
    String ValorResultado;

    public ExcelCreditoEmpresarialDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacioncredito = new OperacionCreditoPage(Hooks.driver);
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        cancelandoPagares = new CancelandoPagaresPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        excel = new ExcelPage();
    }

    @Given("la pagina web SGCRED lista para utilizar")
    public void laPaginaWebSGCREDListaParaUtilizar() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/logout.jsp");
    }

    @When("se ingresa el usuario y password")
    public void seIngresaElUsuarioYPassword(DataTable usuario) {
        List<Map<String, String>> lista = usuario.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("hacer click en el boton ingresar y muestra el Home SGCRED")
    public void hacerClickEnElBotonIngresarYMuestraElHomeSGCRED() {
        login.ClickSubmit();

    }

    @Then("ejecutar los registros de propuestas de Credito Empresarial desde Excel {string}")
    public void ejecutarLosRegistrosDePropuestasDeCreditoEmpresarialDesdeExcel(String arg0) throws InterruptedException {

        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++) {

            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickBtnCrearPropuesta();
            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            System.out.println("lectura del codigo:" + datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();

            seleccionarServicio.AbrirVentanaServicio();
            seleccionarServicio.SeleccionarServicio(datosExcel[i][1]);
            System.out.println("lectura de servicio:" + datosExcel[i][1]);
            seleccionarServicio.SeleccionarServicioCredito(datosExcel[i][2]);
            seleccionarServicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            seleccionarServicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);
            seleccionarServicio.SeleccionarPromocion(datosExcel[i][5]);
            seleccionarServicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            seleccionarServicio.ClickBtnCargar();
            seleccionarServicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();
            propuesta.ClickBtnOperacion();

            seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
            seleccionarOperacionCredito.ValidarVentanaOP();
            seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();

            operacioncredito.AbrirVentanaOperacionCredito();
            operacioncredito.SeleccionarMoneda(datosExcel[i][7]);
            operacioncredito.IngresarMonto(datosExcel[i][8]);
            operacioncredito.IngresarTasaInicial(datosExcel[i][9]);
            operacioncredito.ClickBtnCalcular();
            operacioncredito.SeleccionarPlanPagos(datosExcel[i][10]);
            operacioncredito.SeleccionarModalidad(datosExcel[i][11]);
            operacioncredito.IngresarDias(datosExcel[i][12]);
            operacioncredito.IngresarTasaPreferencial(datosExcel[i][13]);
            operacioncredito.SeleccionarFormaDesembolso(datosExcel[i][14]);
            operacioncredito.SeleccionarDepartamento(datosExcel[i][15]);
            operacioncredito.SeleccionarProvincia(datosExcel[i][16]);
            operacioncredito.SeleccionarDistrito(datosExcel[i][17]);
            operacioncredito.IngresarFechaDesembolso();
            operacioncredito.IngresarNotas(datosExcel[i][18]);
            operacioncredito.ClickBtnGrabar();
            operacioncredito.ObtenerAlerta();
            operacioncredito.CerrarVentanaOperacionCredito();

            propuesta.ClickBtnRegistrarSeguro();
            seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
            seleccionarSeguros.ClickbtnConfirmar();
            seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

            registrarSeguros.AbrirVentanaRegistrarSeguros();
            registrarSeguros.ClickCheckSeguroDesgravamenMN();
            registrarSeguros.IngresarDPSSeguroDesgravamen();
            registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
            registrarSeguros.IngresarDPSeguroRiesgoPlanPymes();
            registrarSeguros.ClickBtnConfirmar();
            registrarSeguros.CerrarVentanaRegistrarSeguros();

            confirmarSeguros.AbrirVentanaConfirmacionSeguros();
            confirmarSeguros.ClickBtnCerrar();
            confirmarSeguros.CerrarVentanaConfirmacionSeguros();

            propuesta.ClickAnexarCheckListCreditos();

            anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
            anexarCheckListCreditos.SeleccionarOpcionesCheckListCredito();
            anexarCheckListCreditos.Seleccionar_37opinionLegal();
            anexarCheckListCreditos.ClickBtnGuardarTerminar();
            anexarCheckListCreditos.CerrarVentanaAnexarCheckList();

            confirmarCheckList.AbrirVentanaConfirmacionCheckList();
            confirmarCheckList.ClickBtnCerrar();
            confirmarCheckList.CerrarVentanaConfirmacionCheckList();

            propuesta.IngresarComentariosPropuesta();
            propuesta.IngresarCaracteristicaNegocio();
            propuesta.ClickAnexarGarantias();

            seleccionarGarantia.AbrirVentanaGarantia();
            seleccionarGarantia.ClickRegistrarGarantia();
            seleccionarGarantia.CerrarVentanaGarantia();

            seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
            seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesMaquinayEquipo();
            seleccionarGarantiasExistentes.ClickBtnAceptar();
            seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();

            cancelandoPagares.AbrirVentanaCancelandoPagares();
            cancelandoPagares.CerrarVentanaCancelandoPagares();

            propuesta.ClickEnlazarEEFF();
            enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
            enlazarEstadosFinancieros.ClickbtnEnlazar();
            enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

            propuesta.ClickDesenlazarInformeVisita();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();

            propuesta.ClickEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();

            propuesta.ClickEnlazarInformeVisita();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();

            propuesta.IngresarComentariosRatios(datosExcel[i][19]);

            ValorPropuesta = propuesta.CapturarNumeroPropuesta();
            excel.EscribirExcel(arg0,0,i,22,ValorPropuesta);

            propuesta.ClickMenuGrabarPropuesta();

            grabarPropuesta.AbrirVentanaGrabarPropuesta();
            grabarPropuesta.ClickBtnCerrarInformacion();
            grabarPropuesta.CerrarVentanaGrabarPropuesta();

            propuesta.AbrirOpcionesDictamen();
            propuesta.ClickBtnAprobarPropuesta();

            aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
            aprobarDictamenPropuesta.IngresarObservaciones(datosExcel[i][20]);
            aprobarDictamenPropuesta.IngresarContrasena(datosExcel[i][21]);
            aprobarDictamenPropuesta.ClickBtnProcesar();
            aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();

            grabarPropuesta.AbrirVentanaGrabarPropuesta();
            ValorResultado = grabarPropuesta.CapturarMensajeDerivacion();
            excel.EscribirExcel(arg0,0,i,23,ValorResultado);
            grabarPropuesta.ClickBtnCerrarInformacion();
            grabarPropuesta.CerrarVentanaGrabarPropuesta();

            listadoClientes.ClickBtnRegresar();
            listadoPropuesta.ClickBtnRegresar();

        }
        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();
    }

}
