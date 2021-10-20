package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import Support.screenshot;

import static Support.screenshot.pantallazo;

public class InformeVisitaCreditoEmpresarialDefinitions {

    MenuPrincipalPage menuPrincipal;
    LoginPage loginInforme;
    ListadoInformeVisitaPage listadoInformeVisita;
    SeleccionarRubroNegocioPage seleccionarRubroNegocio;
    InformeVisita_InformePage listaInformes;
    InformeVisita_CrearPage crearInformeVisita;
    GrabarInformacionDocumentoPage grabarInformeVisita;

    public InformeVisitaCreditoEmpresarialDefinitions() {
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        loginInforme = new LoginPage(Hooks.driver);
        listadoInformeVisita = new ListadoInformeVisitaPage(Hooks.driver);
        seleccionarRubroNegocio = new SeleccionarRubroNegocioPage(Hooks.driver);
        listaInformes = new InformeVisita_InformePage(Hooks.driver);
        crearInformeVisita = new InformeVisita_CrearPage(Hooks.driver);
        grabarInformeVisita = new GrabarInformacionDocumentoPage(Hooks.driver);
    }

    @Given("la web SGCRED esta disponible para usarla")
    public void laWebSGCREDEstaDisponibleParaUsarla() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }
    @When("ingreso usuario y password del perfil Asesor de Negocio")
    public void ingresoUsuarioYPasswordDelPerfilAsesorDeNegocio(DataTable usuario) {
        List<Map<String, String>> lista = usuario.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            loginInforme.IngresarUsuario(lista.get(i).get("nombre"));
            loginInforme.IngresarPassword(lista.get(i).get("password"));
        }
    }
    @And("doy click en boton ingresar al SGCRED")
    public void doyClickEnBotonIngresarAlSGCRED() {
        loginInforme.ClickSubmit();
    }
    @And("Mostrar home principal de SGCRED")
    public void mostrarHomePrincipalDeSGCRED() {    }
    @And("doy click en el menu informe visita")
    public void doyClickEnElMenuInformeVisita() {
        menuPrincipal.ClickInformeVisita();
    }
    @And("en la ventana busqueda de clientes seleccionar el tab por Codigo e ingresar el codigo {string}")
    public void enLaVentanaBusquedaDeClientesSeleccionarElTabPorCodigoEIngresarElCodigo(String CodCliente) {
        listadoInformeVisita.SeleccionarTabCodigo();
        listadoInformeVisita.IngresarCodigoCliente(CodCliente);
    }
    @And("en la ventana busqueda de cliente doy click en el boton Buscar")
    public void enLaVentanaBusquedaDeClienteDoyClickEnElBotonBuscar() {
        listadoInformeVisita.ClickBuscarCliente();
    }

    @And("en la grilla de la ventana seleccionar el icono informe visita")
    public void enLaGrillaDeLaVentanaSeleccionarElIconoInformeVisita() {
        listadoInformeVisita.SeleccionarIconoInformeVisita();
    }
    @Then("el sistema direcciona a la ventana SeleccionarRubroNegocio y doy click en boton Cargar")
    public void elSistemaDireccionaALaVentanaSeleccionarRubroNegocioYDoyClickEnBotonCargar() {
        seleccionarRubroNegocio.AbrirVentanaRubroNegocio();
        seleccionarRubroNegocio.ClickBtnCargar();
        seleccionarRubroNegocio.CerrarVentanaRubroNegocio();
    }
    @And("en la ventana lista de informes visita doy click en el boton crear informe visita")
    public void enLaVentanaListaDeInformesVisitaDoyClickEnElBotonCrearInformeVisita() {
        listaInformes.ClickBtnCrear();
    }
    @And("el sistema muestra la ventana principal informe de visita e ingresar datos de visita")
    public void elSistemaMuestraLaVentanaPrincipalInformeDeVisitaEIngresarDatosDeVisita(DataTable DatosInformeVisita) {
        crearInformeVisita.ObtenerFechaVisita();
        List<Map<String,String>> listado = DatosInformeVisita.asMaps(String.class,String.class);
        for (int i = 0; i < listado.size(); i++) {
            crearInformeVisita.IngresarHoraVisita(listado.get(i).get("HoraVisita"));
            crearInformeVisita.IngresarMinutoVisita(listado.get(i).get("MinutoVisita"));
            crearInformeVisita.IngresarFranjaHoraria(listado.get(i).get("FranjaHora"));
        }
    }

    @And("en la ventana principal informe de visita ingresar datos de verificacion domiciliaria")
    public void enLaVentanaPrincipalInformeDeVisitaIngresarDatosDeVerificacionDomiciliaria(DataTable DatosDomicilio) {
        List<Map<String, String>> lista = DatosDomicilio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            crearInformeVisita.IngresarNroInteg(lista.get(i).get("NumeroIntegrantes"));
            crearInformeVisita.SeleccionarRelacion(lista.get(i).get("Relacion"));
            crearInformeVisita.SeleccionarHabitos(lista.get(i).get("Habitos"));
            crearInformeVisita.SeleccionarOtrosIngresos(lista.get(i).get("OtrosIngresos"));
        }
    }

    @And("en la ventana principal informe de visita ingresar datos de verificacion del negocio")
    public void enLaVentanaPrincipalInformeDeVisitaIngresarDatosDeVerificacionDelNegocio(DataTable DatosNegocio) {
        List<Map<String,String>> lista = DatosNegocio.asMaps(String.class,String.class);
        for (int i=0;i<lista.size();i++ ){
            crearInformeVisita.SeleccionarDireccionCorrecta(lista.get(i).get("DireccionNegocio"));
            crearInformeVisita.SeleccionarEstadoGarantia(lista.get(i).get("EstadoGarantia"));
            crearInformeVisita.SeleccionarDocumentoGarantia(lista.get(i).get("DocumentoGarantia"));
        }
    }

    @And("en la ventana principal informe de visita la evaluacion del perito es:")
    public void enLaVentanaPrincipalInformeDeVisitaLaEvaluacionDelPeritoEs() {
        crearInformeVisita.SeleccionarConforme();
    }

    @And("en la ventana principal informe de visita seleccionar declaracion Prevencion de Lavado de Activo")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarDeclaracionPrevencionDeLavadoDeActivo() {
        crearInformeVisita.SeleccionarNoLavado();
    }
    @And("en la ventana principal informe de visita seleccionar Senales de Alerta")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarSenalesDeAlerta() {
        crearInformeVisita.SeleccionarAlerta();
    }
    @And("en la ventana principal informe de visita seleccionar Actividad economica del cliente tiene fundamento legal")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarActividadEconomicaDelClienteTieneFundamentoLegal() {
        crearInformeVisita.SeleccionarLegal();
    }
    @And("en la ventana principal informe de visita registrar observaciones {string}")
    public void enLaVentanaPrincipalInformeDeVisitaRegistrarObservaciones(String Observacion) {
        crearInformeVisita.IngresarObservacion(Observacion);
    }
    @And("en la ventana principal informe de visita doy click en el boton grabar")
    public void enLaVentanaPrincipalInformeDeVisitaDoyClickEnElBotonGrabar() {
        crearInformeVisita.ClickBtnGrabar();

    }
    @And("en la ventana Grabar Documento doy click en el boton Cerrar")
    public void enLaVentanaGrabarDocumentoDoyClickEnElBotonCerrar() {
        grabarInformeVisita.AbrirVentanaGrabarPropuesta();
        grabarInformeVisita.ClickBtnCerrarInformacion();
        grabarInformeVisita.CerrarVentanaGrabarPropuesta();
    }
    @And("en la ventana principal informe de visita doy click en el boton regresar")
    public void enLaVentanaPrincipalInformeDeVisitaDoyClickEnElBotonRegresar() throws IOException {
        pantallazo();
        crearInformeVisita.ClickBtnRegresarCE();
    }
    @And("el sistema direcciona a ventana listado informe de visita y doy click en el boton regresar")
    public void elSistemaDireccionaAVentanaListadoInformeDeVisitaYDoyClickEnElBotonRegresar() {

        listaInformes.ClickBtnRegresar();
    }

    @And("el sistema direcciona a menu principal y doy click al menu cerrar sesion")
    public void elSistemaDireccionaAMenuPrincipalYDoyClickAlMenuCerrarSesion()
    {
        menuPrincipal.ClickCerrarSesion();
    }

    @And("direcciona a la ventana login y doy click en el boton cerrar sesion")
    public void direccionaALaVentanaLoginYDoyClickEnElBotonCerrarSesion() {
        loginInforme.ClickCerrarSesion();
    }

    @And("finalmente cerramos el navegador")
    public void finalmenteCerramosElNavegador() {
        Hooks.driver.close();
    }
}
