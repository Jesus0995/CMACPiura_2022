package Definitions;


import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class PropuestaCreditoConsumoDefinitions {
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

    //Constructor
    public PropuestaCreditoConsumoDefinitions() {
        //Inicializar las paginas
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
    }

    @Given("la pagina web SGCRED esta disponible")
    public void laPaginaWebSGCREDEstaDisponible() {

        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }

    @When("se completa el usuario y password")
    public void seCompletaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("doy click en el boton ingresar")
    public void doyClickEnElBotonIngresar() {
        login.ClickSubmit();
        //pantallazo();
    }

    @And("muestra el home de SGCRED")
    public void muestraElHomeDeSGCRED() {
    }

    @And("doy click en el link propuesta financiamiento")
    public void doyClickEnElLinkPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();
        //pantallazo();
    }

    @And("doy click en el boton Crear_Propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_PropuestaDeLaVentanaListadoPropuesta() {
        listadoPropuesta.ClickCrearPropuesta();
        //pantallazo();
    }

    @And("muestra la ventana cliente para realizar la busqueda en el tab codigo")
    public void muestraLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        listadoClientes.SeleccionarTabCodigo();
        //pantallazo();
    }

    @And("en la ventana cliente digitar el codigo a buscar {string}")
    public void enLaVentanaClienteDigitarElCodigoABuscar(String CodCliente) {
        listadoClientes.IngresarCodigoCliente(CodCliente);
        //pantallazo();
    }

    @And("en la ventana cliente se da click en el boton buscar")
    public void enLaVentanaClienteSeDaClickEnElBotonBuscar() {
        listadoClientes.ClickBuscarCliente();
        //pantallazo();
    }

    @And("en la ventana cliente se da click en el icono propuesta")
    public void enLaVentanaClienteSeDaClickEnElIconoPropuesta() {
        listadoClientes.SeleccionarIconoPropuesta();
        //pantallazo();
    }

    @And("el sistema muestra la ventana de requisitos de propuesta e ingresamos la informacion")
    public void elSistemaMuestraLaVentanaDeRequisitosDePropuestaEIngresamosLaInformacion(DataTable TipoServicio) throws IOException {

        servicio.AbrirVentanaServicio();

        List<Map<String, String>> lista = TipoServicio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            servicio.SeleccionarServicio(lista.get(i).get("TipoServicio"));
            servicio.SeleccionarServicioCredito(lista.get(i).get("ServicioCredito"));
            servicio.SeleccionarTipoPropuesta(lista.get(i).get("TipoPropuesta"));
            servicio.SeleccionarSubTipoPropuesta(lista.get(i).get("SubTipoPropuesta"));
            servicio.SeleccionarPromocion(lista.get(i).get("Promocion"));
            //Servicio.SeleccionarNegocio(lista.get(i).get("Negocio"));
            //Servicio.SeleccionarTipoOperacion(lista.get(i).get("TipoOperacion"));
        }

        try {
            servicio.ClickBtnCargar();
        } catch (Exception Error){
            System.out.println(Error.getMessage());
        }
        servicio.CerrarVentanaServicio();
        //pantallazo();
    }

    @And("en la ventana requisitos de propuesta se da click en el boton cargar")
    public void enLaVentanaRequisitosDePropuestaSeDaClickEnElBotonCargar()  {
    }

    @And("validar el popup Comunicado")
    public void ValidarElPopupComunicado() throws IOException {

        try {
            popUpComunicado.ValidarComunicado();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana propuesta de financiamiento doy clik al boton nueva operacion")
    public void enLaVentanaPropuestaDeFinanciamientoDoyClikAlBotonNuevaOperacion() {
        propuesta.ClickBtnOperacion();
        //pantallazo();
    }

    @And("muestra la ventana seleccionar operacion credito doy click en el boton aceptar")
    public void muestraLaVentanaSeleccionarOperacionCreditoDoyClickEnElBotonAceptar() throws IOException{
        seleccionarOpeCred.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOpeCred.ValidarVentanaOP();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
        seleccionarOpeCred.CerrarVentanaSeleccionarOP();
        //pantallazo();
    }

    @And("muestra la ventana operacion credito ingresar el monto, la tasa inicial luego click en el boton calcular")
    public void muestraLaVentaOperacionCreditoIngresarElMontoLaTasaInicialLuegoClickEnElBotonCalcular(DataTable OperacionCredito) throws InterruptedException {

        operacioncredito.AbrirVentanaOperacionCredito();

        List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacioncredito.IngresarMonto(lista.get(i).get("Monto"));
            operacioncredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));
        }
        operacioncredito.ClickBtnCalcular();

    }

    @And("en la ventana operacion credito seleccionar el plan de pagos {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElPlanDePagos(String PlanPagos) {
        operacioncredito.SeleccionarPlanPagos(PlanPagos);
    }

    @And("en la ventana operacion credito seleccionar la modalidad de amortizacion {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaModalidadDeAmortizacion(String Modalidad) {
        operacioncredito.SeleccionarModalidad(Modalidad);
    }

    @And("en la ventana operacion credito seleccionar la opcion de pago {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaOpcionDePago(String OpcionPagos) {
        operacioncredito.SeleccionarOpcionPagos(OpcionPagos);
    }

    @And("en la ventana operacion credito ingresar el dia de pago {string}")
    public void enLaVentanaOperacionCreditoIngresarElDiaDePago(String DiaPagos) {
        operacioncredito.SeleccionarDiaPagos(DiaPagos);
        //pantallazo();
    }

    @And("en la ventana operacion credito seleccionar el numero de cuotas {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElNumeroDeCuotas(String NumeroCuotas) {
        operacioncredito.IngresarNumeroCuotas(NumeroCuotas);
    }

    @And("en la ventana operacion credito ingresar la tasa preferencial {string}")
    public void enLaVentanaOperacionCreditoIngresarLaTasaPreferencial(String TasaPreferencial) {
        operacioncredito.IngresarTasaPreferencial(TasaPreferencial);
    }

    @And("en la ventana operacion credito seleccionar la forma desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaFormaDesembolso(String FormaDesembolso) {
        operacioncredito.SeleccionarFormaDesembolso(FormaDesembolso);
    }

    @And("en la ventana operacion credito seleccionar el codigo de cuenta")
    public void enLaVentanaOperacionCreditoSeleccionarElNumeroDeCuenta() {
        operacioncredito.SeleccionarCodigoCuenta();
    }

    @And("en la ventana operacion credito seleccionar la fecha desembolso")
    public void enLaVentanaOperacionCreditoSeleccionarLaFechaDesembolso() {
        operacioncredito.IngresarFechaDesembolso();
    }

    @And("en la ventana operacion credito ingresar una nota {string}")
    public void enLaVentanaOperacionCreditoIngresarUnaNota(String Notas) {

        operacioncredito.IngresarNotas(Notas);
    }

    @And("en la ventana operacion credito doy click en el boton grabar")
    public void enLaVentanaOperacionCreditoDoyClickEnElBotonGrabar() {

        operacioncredito.ClickBtnGrabar();
    }

    @And("en la ventana operacion credito aceptar la alerta")
    public void enLaVentanaOperacionCreditoAceptarLaAlerta() {
        operacioncredito.ObtenerAlerta();
        operacioncredito.CerrarVentanaOperacionCredito();
    }

    @And("el sistema direcciona a la ventana propuesta y doy clik en el boton registro de seguro")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClikEnElBotonRegistroDeSeguro() {
        propuesta.ClickBtnRegistrarSeguro();
    }

    @And("muestra la ventana seleccionar seguros y doy click en el boton confirmar")
    public void muestraLaVentanaSeleccionarSegurosYDoyClickEnElBotonConfirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();
    }

    @And("muestra la ventana registrar seguros y doy check en el seguro desgravamen al saldo capital")
    public void muestraLaVentanaRegistrarSegurosYDoyCheckEnElSeguroDesgravamenAlSaldoCapital() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenSaldo();
    }

    @And("en la ventana registrar seguros ingresar el numero DPS del seguro desgravamen")
    public void enLaVentanaRegistrarSegurosIngresarElNumeroDPSDelSeguroDesgravamen() {
        registrarSeguros.IngresarSeguroDesgravamenSaldo();
    }

    @And("en la ventana registrar seguros doy check en el seguro vida plan1")
    public void enLaVentanaRegistrarSegurosDoyCheckEnElSeguroVidaPlan1() {
        registrarSeguros.ClickCheckSeguroVidaPlan1();
    }

    @And("en la ventana registrar seguros ingresar el numero DPS del seguro vida plan1")
    public void enLaVentanaRegistrarSegurosIngresarElNumeroDPSDelSeguroVidaPlan1() {
        registrarSeguros.IngresarSeguroVidaPlan1();
    }

    @And("en la ventana registrar seguros doy click en el boton confirmar")
    public void enLaVentanaRegistrarSegurosDoyClickEnElBotonConfirmar() {
        registrarSeguros.ClickBtnConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();
    }

    @And("muestra la ventana seguros seleccionados y doy click en el boton cerrar")
    public void muestraLaVentanaSegurosSeleccionadosYDoyClickEnElBotonCerrar() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();
    }

    @And("el sistema direcciona a la ventana propuesta y doy click en el boton anexar garantias")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClickEnElBotonAnexarGarantias() {
        propuesta.ClickAnexarGarantias();
    }

    @And("muestra la ventana seleccionar garantia y doy click en el boton registrar garantia")
    public void muestraLaVentanaSeleccionarGarantiaYDoyClickEnElBotonRegistrarGarantia() {
        seleccionarGarantia.AbrirVentanaGarantia();
        seleccionarGarantia.ClickRegistrarGarantia();
        seleccionarGarantia.CerrarVentanaGarantia();
    }

    @And("muestra la ventana garantias existentes y doy check a garantia personal")
    public void muestraLaVentanaGarantiasExistentesYDoyCheckAGarantiaPersonal() {
        seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
        seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesCC();
    }

    @And("en la ventana garantias existentes doy click al boton aceptar")
    public void enLaVentanaGarantiasExistentesDoyClickAlBotonAceptar() {
        seleccionarGarantiasExistentes.ClickBtnAceptar();
        seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();
    }


    @And("el sistema direcciona a la venta propuesta y doy clik en el boton enlazar de la hoja de trabajo")
    public void elSistemaDireccionaALaVentaPropuestaYDoyClikEnElBotonEnlazarDeLaHojaDeTrabajo() {
        propuesta.ClickEnlazarHojaTrabajo();
    }

    @And("muestra la ventana evaluacion economica y doy click en el boton realizar")
    public void muestraLaVentanaEvaluacionEconomicaYDoyClickEnElBotonRealizar() {
        enlazarEvaluacionEconomica.AbrirVentanaEvaluacionEconomica();
        enlazarEvaluacionEconomica.ClickBtnRealizar();
        enlazarEvaluacionEconomica.CerrarVentanaEvaluacionEconomica();
    }

    @And("el sistema direcciona a la ventana propuesta y doy click en boton desenlazar informe visita")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClickEnBotonDesenlazarInformeVisita() {
        propuesta.ClickDesenlazarInformeVisitaConsumo();
    }

    @And("muestra la ventana desenlazar informe visita y doy click en el boton realizar")
    public void muestraLaVentanaDesenlazarInformeVisitaYDoyClickEnElBotonRealizar() {
        desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
        desenlazarInformeVisita.ClickBtnRealizar();
        desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();
    }

    @And("el sistema direcciona a la ventana propuesta y doy clik en el boton enlazar informe visita")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClikEnElBotonEnlazarInformeVisita() {
        propuesta.ClickEnlazarInformeVisitaConsumo();
    }

    @And("muestra la ventana enlazar informe visita y doy click en el boton realizar")
    public void muestraLaVentanaEnlazarInformeVisitaYDoyClickEnElBotonRealizar() {
        enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
        enlazarInformeVisita.ClickBtnRealizar();
        enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();
    }

    @And("el sistema direcciona a la ventana propuesta y doy clik en el boton enlazar informe comercial")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClikEnElBotonEnlazarInformeComercial() {
        propuesta.ClickEnlazarInformeComercialConsumo();
    }

    @And("muestra la ventana enlazar informe comercial y doy click en el boton realizar")
    public void muestraLaVentanaEnlazarInformeComercialYDoyClickEnElBotonRealizar() {
        enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
        enlazarInformeComercialNuevo.ClickBtnRealizar();
        enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();
    }

    @And("direcciona a la ventana propuesta de financiamiento ingresar la clasificacion crediticia {string}")
    public void direccionaALaVentanaPropuestaDeFinanciamientoIngresarLaClasificacionCrediticia(String clasificacion) {
        propuesta.IngresarClasificacionCrediticia(clasificacion);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento ingresar el objetivo de credito {string}")
    public void enLaVentanaPropuestaDeFinanciamientoIngresarElObjetivoDeCredito(String Objetivo) {
        propuesta.IngresarObjetivoCredito(Objetivo);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento ingresar la justificacion de credito {string}")
    public void enLaVentanaPropuestaDeFinanciamientoIngresarLaJustificacionDeCredito(String Justificacion) {
        propuesta.IngresarJustificacionCredito(Justificacion);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento doy clik en el boton grabar")
    public void enLaVentanaPropuestaDeFinanciamientoDoyClikEnElBotonGrabar() {

        propuesta.ClickMenuGrabarPropuesta();
    }

    @And("muestra ventana grabar informacion y doy click en el boton cerrar")
    public void muestraVentanaGrabarInformacionYDoyClickEnElBotonCerrar() {
        grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
        grabarDocumentoPropuesta.ClickBtnCerrarInformacion();
        grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @And("en la ventana propuesta de financiamiento doy clik al boton emitir dictamen")
    public void enLaVentanaPropuestaDeFinanciamientoDoyClikAlBotonEmitirDictamen() {
        propuesta.AbrirOpcionesDictamen();

    }

    @And("en la tabla de emitir dictamen seleccionar la opcion aprobar")
    public void enLaTablaDeEmitirDictamenSeleccionarLaOpcionAprobar()
    {
        propuesta.ClickBtnAprobarPropuesta();
    }

    @And("muestra la ventana emitir dictamen propuesta ingresar observaciones y contrasena del usuario")
    public void muestraLaVentanaEmitirDictamenPropuestaIngresarObservacionesYContrasenaDelUsuario(DataTable DatosAprobacion) {
        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = DatosAprobacion.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }
    }

    @And("en la ventana emitir dictamen propuesta doy click en el boton procesar")
    public void enLaVentanaEmitirDictamenPropuestaDoyClickEnElBotonProcesar() {
        aprobarDictamenPropuesta.ClickBtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }

    @And("muestra a la ventana grabar informacion y doy click en el boton cerrar")
    public void muestraALaVentanaGrabarInformacionYDoyClickEnElBotonCerrar() {
        grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
        grabarDocumentoPropuesta.ClickBtnCerrarInformacion();
        grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @And("direcciona a la ventana listado propuesta y doy click en el boton regresar")
    public void direccionaALaVentanaListadoPropuestaYDoyClickEnElBotonRegresar() {

        listadoPropuesta.ClickRegresar();
    }

    @And("direcciona al menu principal y doy click en la opcion cerrar sesion")
    public void direccionaAlMenuPrincipalYDoyClickEnLaOpcionCerrarSesion() {
        menuPrincipal.ClickCerrarSesion();
    }

    @And("direcciona al login y doy click en el boton cerrar sesion")
    public void direccionaAlLoginYDoyClickEnElBotonCerrarSesion() {

        login.ClickCerrarSesion();
    }

    @And("cierro sesion de navegador")
    public void cierroSesionDeNavegador() {

        Hooks.driver.close();

    }


}
