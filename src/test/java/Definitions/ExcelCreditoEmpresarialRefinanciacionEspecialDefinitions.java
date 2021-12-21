package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialRefinanciacionEspecialDefinitions {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage seleccionarServicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    CondicionesRefinanciarPage condicionesRefinanciar;
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
    InformeEEFFConsolidadoGrupoVinculadoPage informeEEFFConsolidadoGrupoVinculado;
    GrabarInformacionDocumentoPage grabarPropuesta;
    String Valor;

    ExcelPage excel;


    public ExcelCreditoEmpresarialRefinanciacionEspecialDefinitions() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
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
        informeEEFFConsolidadoGrupoVinculado = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);


        excel = new ExcelPage();

    }


    @Given("la pagina web SGCRED esta disponible para su uso")
    public void la_pagina_web_sgcred_esta_disponible_para_su_uso() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/logout.jsp");

    }

    @When("el usuario y password tengan lo siguiente")
    public void el_usuario_y_password_tengan_lo_siguiente(DataTable users) {
        List<Map<String, String>> lista = users.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));

        }

    }

    @When("hacer click en el boton ingresar y muestra el menu principal")
    public void hacer_click_en_el_boton_ingresar_y_muestra_el_menu_principal() {
        login.ClickSubmit();

    }

    @Then("ejecutar los registros de propuestas de Credito Empresarial Refinanciacion Especial desde Excel {string}")
    public void ejecutar_los_registros_de_propuestas_de_credito_empresarial_refinanciacion_especial_desde_excel(String arg0) {

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
            seleccionarServicio.SeleccionarPromocion(datosExcel[i][5]);
            seleccionarServicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            seleccionarServicio.ClickBtnSeleccionarPagare();
            seleccionarServicio.ClickBtnCargar();
            seleccionarServicio.CerrarVentanaServicio();
            popUpComunicado.ValidarComunicado();

            propuesta.ClickIconoCondicionRefinanciar();
            condicionesRefinanciar.AbrirVentanaCondicionRefinanciar();
            condicionesRefinanciar.IngresarMontoAmortizar(datosExcel[i][7]);
            condicionesRefinanciar.IngresarInteresRefinanciar(datosExcel[i][8]);
            condicionesRefinanciar.ClickBtnGrabar();
            condicionesRefinanciar.CerrarVentanaCondicionRefinanciar();

            propuesta.ClickBtnOperacion();

            seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
            seleccionarOperacionCredito.ValidarVentanaOP();
            seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();
            operacionCredito.AbrirVentanaOperacionCredito();
            operacionCredito.ClickBtnCalcularRefinanciacion();
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

            /*
            propuesta.ClickBtnEnlazarEEFFGrupoVinculadO();
            informeEEFFConsolidadoGrupoVinculado.AbrirVentanaInformeEstadoFinancieroConsolidadoGrupo();
            informeEEFFConsolidadoGrupoVinculado.ObtenerEtiqueta();
            informeEEFFConsolidadoGrupoVinculado.IngresarAnalisis();
            informeEEFFConsolidadoGrupoVinculado.IngresarConducta();
            informeEEFFConsolidadoGrupoVinculado.ClickBtnGrabar();
            informeEEFFConsolidadoGrupoVinculado.ClickBtnFinalizar();
            informeEEFFConsolidadoGrupoVinculado.ClickBtnCerrar();
            informeEEFFConsolidadoGrupoVinculado.CerrarVentanaInformeEstadoFinancieroConsolidadoGrupo();
            */
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
