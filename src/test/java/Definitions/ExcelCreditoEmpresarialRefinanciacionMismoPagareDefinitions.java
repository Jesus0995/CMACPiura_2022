package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialRefinanciacionMismoPagareDefinitions {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage servicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    CondicionesRefinanciarPage condicionesRefinanciar;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;
    String Valor;

    public ExcelCreditoEmpresarialRefinanciacionMismoPagareDefinitions() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        servicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
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

    @Given("la web SGCRED esta disponible para su uso")
    public void laWebSGCREDEstaDisponibleParaSuUso() {
        login.IngresarPagina();
        //Hooks.driver.get("http://10.0.203.16:8082/propuesta/logout.jsp");

    }

    @When("se ingresa las credencial correspondiente")
    public void seIngresaLasCredencialCorrespondiente(DataTable dataUser) {
        List<Map<String, String>> lista = dataUser.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("da click en ingresar para mostrar el menu principal")
    public void daClickEnIngresarParaMostrarElMenuPrincipal() {

        login.ClickSubmit();
        login.ValidarSesionesWeb();

    }

    @Then("se ejecuta todos los pasos corresondientes al flujo Refinanciacion Mismo Pagare desde excel {string};")
    public void seEjecutaTodosLosPasosCorresondientesAlFlujoRefinanciacionMismoPagareDesdeExcel(String arg0) {

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
            servicio.SeleccionarTipoOperacion(datosExcel[i][5]);
            servicio.SeleccionarPagare(datosExcel[i][6]);
            servicio.ClickBtnSeleccionarPagare();
            servicio.ClickBtnCargar();
            servicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();

            propuesta.ClickBtnOperacion();

            condicionesRefinanciar.AbrirVentanaCondicionRefinanciar();
            condicionesRefinanciar.IngresarMontoAmortizarMismoPagare(datosExcel[i][7]);
            condicionesRefinanciar.SeleccionarCambioTasaRefinanciacion();
            condicionesRefinanciar.ClickBtnSiguiente();
            condicionesRefinanciar.SeleccionarTipoCronograma(datosExcel[i][9]);
            condicionesRefinanciar.SeleccionarModalidadAmortizacion(datosExcel[i][10]);
            condicionesRefinanciar.SeleccionarModalidadPago(datosExcel[i][11]);
            condicionesRefinanciar.SeleccionarTipoCalculo(datosExcel[i][12]);
            condicionesRefinanciar.IngresarNumeroCuotas(datosExcel[i][13]);
            condicionesRefinanciar.IngresarFechaPago(datosExcel[i][14]);
            condicionesRefinanciar.ClickBtnSiguiente();
            condicionesRefinanciar.ObtenerAlerta();
            condicionesRefinanciar.CerrarVentanaCondicionRefinanciar();

            /*propuesta.ClickBtnRegistrarSeguro();

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
            confirmarSeguros.CerrarVentanaConfirmacionSeguros();*/


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

            Valor = propuesta.CapturarNumeroPropuesta();
            excel.EscribirExcel(arg0, 0, i, 20, Valor);

            propuesta.ClickBtnRegresar();
            listadoPropuesta.ClickBtnRegresar();
        }
        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();
    }

}
