package Definitions;

import PageObjects.*;

public class ExcelCreditoEmpresarialRefinanciacion {

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

    public ExcelCreditoEmpresarialRefinanciacion() {
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




}
