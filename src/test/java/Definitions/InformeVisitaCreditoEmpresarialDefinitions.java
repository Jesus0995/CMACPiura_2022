package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class InformeVisitaCreditoEmpresarialDefinitions {

    MenuPrincipalPage menuPrincipal;
    LoginPage loginInforme;
    ListadoClientesPage listadoClientes;
    SeleccionarRubroNegocioPage seleccionarRubroNegocio;
    InformeVisita_InformePage listaInformes;


    public InformeVisitaCreditoEmpresarialDefinitions() {
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        loginInforme = new LoginPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarRubroNegocio = new SeleccionarRubroNegocioPage(Hooks.driver);
        listaInformes = new InformeVisita_InformePage(Hooks.driver);


    }

    @Given("la web SGCRED esta disponible para usarla")
    public void laWebSGCREDEstaDisponibleParaUsarla() {
        Hooks.driver.get("http://10.0.203.12:8082/propuesta/");
    }

    @When("ingreso usuario y password del perfil Asesor de Finanzas Empresariales")
    public void ingresoUsuarioYPasswordDelPerfilAsesorDeFinanzasEmpresariales(DataTable usuario) {
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
    public void mostrarHomePrincipalDeSGCRED() {
        
    }

    @And("doy click en el menu informe visita")
    public void doyClickEnElMenuInformeVisita() {

        menuPrincipal.ClickInformeVisita();
    }

    @And("en la ventana busqueda de clientes seleccionar el tab por Codigo e ingresar el codigo {string}")
    public void enLaVentanaBusquedaDeClientesSeleccionarElTabPorCodigoEIngresarElCodigo(String CodClienteIV) {
        listadoClientes.SeleccionarTabCodigo();
        listadoClientes.IngresarCodClienteIV(CodClienteIV);

    }

    @And("en la ventana busqueda de clientes doy click en el boton buscar")
    public void enLaVentanaBusquedaDeClientesDoyClickEnElBotonBuscar() {
        listadoClientes.ClickbtnBuscarClienteIV();
    }

    @And("en la grilla de la ventana seleccionar el icono informe visita")
    public void enLaGrillaDeLaVentanaSeleccionarElIconoInformeVisita() {
        listadoClientes.SeleccionarIconoInformeVisita();
    }

    @Then("el sistema direcciona a la ventana SeleccionarRubroNegocio y doy click en boton Cargar")
    public void elSistemaDireccionaALaVentanaSeleccionarRubroNegocioYDoyClickEnBotonCargar() {
        seleccionarRubroNegocio.AbrirVentanaRubroNegocio();
        seleccionarRubroNegocio.ClickBtnCargar();
        seleccionarRubroNegocio.CerrarVentanaRubroNegocio();
    }

    @And("en la ventana lista de informes visita doy click en el boton crear informe visita")
    public void enLaVentanaListaDeInformesVisitaDoyClickEnElBotonCrearInformeVisita() {

        listaInformes.ClickCrear();
        
    }

    @And("el sistema muestra la ventana principal informe de visita e ingresar datos de visita")
    public void elSistemaMuestraLaVentanaPrincipalInformeDeVisitaEIngresarDatosDeVisita() {
        
    }

    @And("en la ventana principal informe de visita ingresar datos de verificacion domiciliaria")
    public void enLaVentanaPrincipalInformeDeVisitaIngresarDatosDeVerificacionDomiciliaria() {
        
    }

    @And("en la ventana principal informe de visita ingresar datos de verificacion del negocio")
    public void enLaVentanaPrincipalInformeDeVisitaIngresarDatosDeVerificacionDelNegocio() {
        
    }

    @And("en la ventana principal informe de visita la evaluacion del perito")
    public void enLaVentanaPrincipalInformeDeVisitaLaEvaluacionDelPerito() {
        
    }

    @And("en la ventana principal informe de visita seleccionar declaracion Prevencion de Lavado de Activo")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarDeclaracionPrevencionDeLavadoDeActivo() {
        
    }

    @And("en la ventana principal informe de visita seleccionar Senales de Alerta")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarSenalesDeAlerta() {
        
    }

    @And("en la ventana principal informe de visita seleccionar Actividad economica del cliente tiene fundamento legal")
    public void enLaVentanaPrincipalInformeDeVisitaSeleccionarActividadEconomicaDelClienteTieneFundamentoLegal() {
        
    }

    @And("en la ventana principal informe de visita registrar observaciones {string}")
    public void enLaVentanaPrincipalInformeDeVisitaRegistrarObservaciones(String arg0) {
        
    }

    @And("en la ventana principal informe de visita doy click en el boton grabar")
    public void enLaVentanaPrincipalInformeDeVisitaDoyClickEnElBotonGrabar() {
        
    }

    @And("en la ventana principal informe de visita doy click en el boton regresar")
    public void enLaVentanaPrincipalInformeDeVisitaDoyClickEnElBotonRegresar() {
        
    }

    @And("el sistema direcciona a ventana listado informe de visita y doy click en el boton regresar")
    public void elSistemaDireccionaAVentanaListadoInformeDeVisitaYDoyClickEnElBotonRegresar() {
        
    }

    @And("el sistema direcciona a menu principal y doy click al menu cerrar sesion")
    public void elSistemaDireccionaAMenuPrincipalYDoyClickAlMenuCerrarSesion() {
        
    }

    @And("direcciona a la ventana login y doy click en el boton cerrar sesion")
    public void direccionaALaVentanaLoginYDoyClickEnElBotonCerrarSesion() {
    }
}
