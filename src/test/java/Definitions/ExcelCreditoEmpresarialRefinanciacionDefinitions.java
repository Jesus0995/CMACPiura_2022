package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialRefinanciacionDefinitions {

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
    ExcelPage excel;
    String Valor;
    String TextoPromocion;

    public ExcelCreditoEmpresarialRefinanciacionDefinitions() {
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
        excel = new ExcelPage();

    }

    @Given("la web SGCRED esta disponible para su uso optimo")
    public void la_web_sgcred_esta_disponible_para_su_uso_optimo() {

        Hooks.driver.get("http://10.0.203.16:8082/propuesta/logout.jsp");

    }

    @When("se ingresa las credencial del usuario correspondiente")
    public void se_ingresa_las_credencial_del_usuario_correspondiente(DataTable dataUser) {
        List<Map<String, String>> lista = dataUser.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }

    @And("hacemos click en ingresar para mostrar el menu principal")
    public void hacemos_click_en_ingresar_para_mostrar_el_menu_principal() {

        login.ClickSubmit();
        login.ValidarSesionesWeb();
    }

    @Then("se ejecuta todos los pasos corresondientes al flujo Refinanciacion desde excel {string};")
    public void se_ejecuta_todos_los_pasos_corresondientes_al_flujo_refinanciacion_desde_excel(String arg0) {

        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++) {

            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickBtnCrearPropuesta();
            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            System.out.println("Mostrar codigo del cliente " + datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();

            seleccionarServicio.AbrirVentanaServicio();
            seleccionarServicio.SeleccionarServicio(datosExcel[i][1]);
            seleccionarServicio.SeleccionarServicioCredito(datosExcel[i][2]);
            seleccionarServicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            seleccionarServicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);

            seleccionarServicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            seleccionarServicio.SeleccionarPagare(datosExcel[i][7]);
            seleccionarServicio.ClickBtnSeleccionarPagare();
            seleccionarServicio.ClickBtnCargar();
            seleccionarServicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();

            propuesta.TextoPromocion();
            TextoPromocion = propuesta.TextoPromocion();

            propuesta.ClickBtnOperacion();
            seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
            seleccionarOperacionCredito.ValidarVentanaOP();
            seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();

            operacionCredito.AbrirVentanaOperacionCredito();
            operacionCredito.IngresarMonto(datosExcel[i][8]);
            operacionCredito.ClickBtnCalcular();
            operacionCredito.SeleccionarPlanPagos(datosExcel[i][9]);
            operacionCredito.SeleccionarModalidad(datosExcel[i][10]);
            operacionCredito.SeleccionarOpcionPagos(datosExcel[i][11]);
            operacionCredito.SeleccionarDiaPagos(datosExcel[i][12]);
            operacionCredito.IngresarNumeroCuotas(datosExcel[i][13]);
            operacionCredito.IngresarTasaPreferencial(datosExcel[i][14]);
            operacionCredito.SeleccionarFormaDesembolso(datosExcel[i][15]);
            operacionCredito.IngresarFechaDesembolso();
            operacionCredito.IngresarNotas(datosExcel[i][16]);
            operacionCredito.ClickBtnGrabar();
            operacionCredito.ObtenerAlerta();
            operacionCredito.CerrarVentanaOperacionCredito();

            propuesta.ClickBtnRegistrarSeguro();
            seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
            seleccionarSeguros.ClickbtnConfirmar();
            seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

            registrarSeguros.AbrirVentanaRegistrarSeguros();
            registrarSeguros.ClickCheckSeguroDesgravamenSaldoCapital();
            registrarSeguros.IngresarDPSSeguroDesgravamenSaldoCapital();
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
            anexarCheckListCreditos.AceptarAlerta();
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
            switch (TextoPromocion)
            {
                case ("PROMO MYPE"):
                    seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesPromoMype();

                case ("CAMPAÑA CRECE MUJER"):
                    seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentePromoCampanaCrecerMujer();
            }
            seleccionarGarantiasExistentes.ClickBtnAceptar();
            seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();

            cancelandoPagares.AbrirVentanaCancelandoPagares();
            cancelandoPagares.CerrarVentanaCancelandoPagares();

            propuesta.ClickEnlazarEEFF();
            enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
            enlazarEstadosFinancieros.ClickbtnEnlazar();
            enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

            propuesta.IngresarComentariosPropuesta();
            propuesta.ClickDesenlazarInformeVisita();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();

            propuesta.ClickEnlazarInformeComercialReprogramacion();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();

            propuesta.ClickEnlazarInformeVisitaReprogramacion();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();

            propuesta.IngresarComentariosRatios(datosExcel[i][17]);
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
