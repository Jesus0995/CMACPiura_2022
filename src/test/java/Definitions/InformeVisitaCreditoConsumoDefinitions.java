package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class InformeVisitaCreditoConsumoDefinitions {
    LoginPage loginInforme;
    MenuPrincipalPage menuPrincipal;
    ListadoInformeVisitaPage listadoInformeVisita;
    InformeVisita_SeleccionarRubroNegocioPage seleccionarRubroNegocio;
    InformeVisita_InformePage listaInformes;
    InformeVisita_CrearPage crearInformeVisita;
    GrabarInformacionDocumentoPage grabarDocumentoInformeVisita;

    public InformeVisitaCreditoConsumoDefinitions() {
        loginInforme = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoInformeVisita = new ListadoInformeVisitaPage(Hooks.driver);
        seleccionarRubroNegocio = new InformeVisita_SeleccionarRubroNegocioPage(Hooks.driver);
        listaInformes = new InformeVisita_InformePage(Hooks.driver);
        crearInformeVisita = new InformeVisita_CrearPage(Hooks.driver);
        grabarDocumentoInformeVisita = new GrabarInformacionDocumentoPage(Hooks.driver);
    }

    @Given("la pagina web SGCRED se encuentra disponible")
    public void laPaginaWebSGCREDSeEncuentraDisponible() {

        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");
    }

    @When("ingreso usuario y password del perfil Asesor de Negocios")
    public void ingresoUsuarioYPasswordDelPerfilAsesorDeNegocios(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            loginInforme.IngresarUsuario(lista.get(i).get("nombre"));
            loginInforme.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("doy click en el boton ingresar al SGCRED")
    public void doyClickEnElBotonIngresarAlSGCRED() {

        loginInforme.ClickSubmit();
        loginInforme.ValidarSesionesWeb();
    }

    @And("muestra home principal de SGCRED")
    public void muestraHomePrincipalDeSGCRED() {
    }

    @And("doy click en la opcion informe visita")
    public void doyClickEnLaOpcionInformeVisita() {

        menuPrincipal.ClickInformeVisita();
    }

    @And("muestra la ventana busqueda de clientes y realizar la busqueda en el tab codigo")
    public void muestraLaVentanaBusquedaDeClientesYRealizarLaBusquedaEnElTabCodigo() {
        listadoInformeVisita.SeleccionarTabCodigo();
    }

    @And("en la ventana busqueda de clientes digitar el codigo a buscar {string}")
    public void enLaVentanaBusquedaDeClientesDigitarElCodigoABuscar(String CodCliente) {
        listadoInformeVisita.IngresarCodigoCliente(CodCliente);
    }

    @And("en la ventana busqueda de clientes y doy click en el boton buscar")
    public void enLaVentanaBusquedaDeClientesYDoyClickEnElBotonBuscar() {

        listadoInformeVisita.ClickBuscarCliente();
    }

    @And("en la ventana busqueda de clientes y doy click en el icono informe visita")
    public void enLaVentanaBusquedaDeClientesYDoyClickEnElIconoInformeVisita() {
        listadoInformeVisita.SeleccionarIconoInformeVisita();
    }

    @And("muestra ventana seleccionar rubro y doy click en el boton cargar")
    public void muestraVentanaSeleccionarRubroYDoyClickEnElBotonCargar() {
        seleccionarRubroNegocio.AbrirVentanaRubroNegocio();
        seleccionarRubroNegocio.ClickBtnCargar();
        seleccionarRubroNegocio.CerrarVentanaRubroNegocio();
    }

    @And("muestra la ventana lista de informes y doy click en el boton crear informe")
    public void muestraLaVentanaListaDeInformesYDoyClickEnElBotonCrearInforme() {

        listaInformes.ClickBtnCrear();
    }

    @And("muestra la ventana informe e ingreso la fecha de visita")
    public void muestraLaVentanaInformeEIngresoLaFechaDeVisita() {

        crearInformeVisita.ObtenerFechaVisita();
    }

    @And("en la ventana informe de visita e ingresar datos de visita")
    public void enLaVentanaInformeDeVisitaEIngresarDatosDeVisita(DataTable DatosVisita) {

        List<Map<String, String>> lista = DatosVisita.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            crearInformeVisita.IngresarHoraVisita(lista.get(i).get("HoraVisita"));
            crearInformeVisita.IngresarMinutoVisita(lista.get(i).get("MinutoVisita"));
            crearInformeVisita.IngresarFranjaHoraria(lista.get(i).get("FranjaHora"));
        }
    }

    @And("en la ventana informe de visita ingresar datos de verificacion domiciliaria")
    public void enLaVentanaInformeDeVisitaIngresarDatosDeVerificacionDomiciliaria(DataTable DatosDomicilio) {
        List<Map<String, String>> lista = DatosDomicilio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            crearInformeVisita.IngresarNroInteg(lista.get(i).get("NumeroIntegrantes"));
            crearInformeVisita.SeleccionarRelacion(lista.get(i).get("Relacion"));
            crearInformeVisita.SeleccionarHabitos(lista.get(i).get("Habitos"));
            crearInformeVisita.SeleccionarOtrosIngresos(lista.get(i).get("OtrosIngresos"));
        }
    }

    @And("en la ventana informe de visita ingresar datos de verificacion del negocio")
    public void enLaVentanaInformeDeVisitaIngresarDatosDeVerificacionDelNegocio(DataTable DatosTrabajo) {
        List<Map<String, String>> lista = DatosTrabajo.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            crearInformeVisita.SeleccionarRelacionLaboral(lista.get(i).get("RelacionLaboral"));
            crearInformeVisita.SeleccionarDocumentoSustento(lista.get(i).get("DocumentoSustento"));
        }
    }

    @And("en la ventana informe de visita seleccionar el tipo de evaluacion")
    public void enLaVentanaInformeDeVisitaSeleccionarElTipoDeEvaluacion() {

        crearInformeVisita.SeleccionarConforme();
    }

    @And("en la ventana informe de visita seleccionar la declaracion de SPLAFT")
    public void enLaVentanaInformeDeVisitaSeleccionarLaDeclaracionDeSPLAFT() {
        crearInformeVisita.SeleccionarNoLavado();
        crearInformeVisita.SeleccionarAlerta();
        crearInformeVisita.SeleccionarLegal();
    }

    @And("en la ventana informe de visita ingresar la observacion {string}")
    public void enLaVentanaInformeDeVisitaIngresarLaObservacion(String Observacion) {
        crearInformeVisita.IngresarObservacion(Observacion);
    }

    @And("en la ventana informe de visita doy clik en el boton grabar")
    public void enLaVentanaInformeDeVisitaDoyClikEnElBotonGrabar() {

        crearInformeVisita.ClickBtnGrabar();
    }

    @And("muestra la ventana grabar informacion y doy click en el boton cerrar")
    public void muestraLaVentanaGrabarInformacionYDoyClickEnElBotonCerrar() throws InterruptedException {
        grabarDocumentoInformeVisita.AbrirVentanaGrabarPropuesta();
        grabarDocumentoInformeVisita.ClickBtnCerrarInformacion();
        grabarDocumentoInformeVisita.CerrarVentanaGrabarPropuesta();
    }

    @And("el sistema direcciona a informe de visita y doy click en el boton regresar")
    public void elSistemaDireccionaAInformeDeVisitaYDoyClickEnElBotonRegresar() {

        crearInformeVisita.ClickBtnRegresar();
    }

    @And("muestra la ventana lista de informes y doy click en el boton regresar")
    public void muestraLaVentanaListaDeInformesYDoyClickEnElBotonRegresar() {

        listaInformes.ClickBtnRegresar();
    }

    @And("el sistema direcciona a menu principal y doy click en la opcion cerrar sesion")
    public void elSistemaDireccionaAMenuPrincipalYDoyClickEnLaOpcionCerrarSesion() {

        menuPrincipal.ClickBtnCerrarSesion();
    }

    @And("direcciona en login y doy click en el boton cerrar sesion")
    public void direccionaEnLoginYDoyClickEnElBotonCerrarSesion() {

        loginInforme.ClickBtnCerrarSesion();
    }

    @And("cierro navegador")
    public void cierroNavegador() {

        Hooks.driver.close();
    }
}
