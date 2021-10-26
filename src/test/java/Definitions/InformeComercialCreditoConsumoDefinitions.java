package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class InformeComercialCreditoConsumoDefinitions {
    LoginPage loginInforme;
    MenuPrincipalPage menuPrincipal;
    ListadoInformeVisitaPage listadoInformeComercial;
    InformeVisita_SeleccionarRubroNegocioPage seleccionarNegocio;
    InformeVisita_InformePage listaInformes;
    InformeComercialNuevoPage informeComercialNuevo;

    public InformeComercialCreditoConsumoDefinitions(){
        loginInforme = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoInformeComercial = new ListadoInformeVisitaPage(Hooks.driver);
        seleccionarNegocio = new InformeVisita_SeleccionarRubroNegocioPage(Hooks.driver);
        listaInformes = new InformeVisita_InformePage(Hooks.driver);
        informeComercialNuevo = new InformeComercialNuevoPage(Hooks.driver);
    }

    @Given("la pagina web del SGCRED se encuentra disponible")
    public void laPaginaWebDelSGCREDSeEncuentraDisponible() {

        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }

    @When("ingreso usuario y password del Asesor de Negocios")
    public void ingresoUsuarioYPasswordDelAsesorDeNegocios(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            loginInforme.IngresarUsuario(lista.get(i).get("nombre"));
            loginInforme.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("doy click en el boton ingresar del login")
    public void doyClickEnElBotonIngresarDelLogin() {
        loginInforme.ClickSubmit();
    }

    @And("muestra el home principal de SGCRED")
    public void muestraElHomePrincipalDeSGCRED() {
    }

    @And("doy click en la opcion informe comercial")
    public void doyClickEnLaOpcionInformeComercial() {
        menuPrincipal.ClickInformeComercial();
    }

    @And("muestra la busqueda de clientes y realizar la busqueda en el tab codigo")
    public void muestraLaBusquedaDeClientesYRealizarLaBusquedaEnElTabCodigo() {
        listadoInformeComercial.SeleccionarTabCodigo();
    }

    @And("en la ventana busqueda de clientes digitar el codigo {string}")
    public void enLaVentanaBusquedaDeClientesDigitarElCodigo(String CodCliente) {
        listadoInformeComercial.IngresarCodigoCliente(CodCliente);
    }

    @And("en la ventana busqueda de clientes y doy click en boton buscar")
    public void enLaVentanaBusquedaDeClientesYDoyClickEnBotonBuscar() {
        listadoInformeComercial.ClickBuscarCliente();
    }

    @And("en la ventana busqueda de clientes y doy click en el icono informe comercial")
    public void enLaVentanaBusquedaDeClientesYDoyClickEnElIconoInformeComercial() {
        listadoInformeComercial.SeleccionarIconoInformeComercial();
    }

    @And("muestra ventana definir negocio y doy click en el boton cargar")
    public void muestraVentanaDefinirNegocioYDoyClickEnElBotonCargar() {
        seleccionarNegocio.AbrirVentanaRubroNegocio();
        seleccionarNegocio.ClickBtnCargar();
        seleccionarNegocio.CerrarVentanaRubroNegocio();
    }

    @And("muestra la ventana informes comerciales y doy click en el boton crear informe")
    public void muestraLaVentanaInformesComercialesYDoyClickEnElBotonCrearInforme() {

        listaInformes.ClickBtnCrear();
    }

    @And("muestra la ventana nuevo informe comercial e ingresar datos el patrimonio {string}")
    public void muestraLaVentanaNuevoInformeComercialEIngresarDatosElPatrimonio(String Patrimonio) {
        informeComercialNuevo.IngresarPatrimonio(Patrimonio);
    }

    @And("en la ventana nuevo informe comercial doy clik en el boton grabar")
    public void enLaVentanaNuevoInformeComercialDoyClikEnElBotonGrabar() {

        informeComercialNuevo.ClickBtnGrabar();
    }

    @And("en la ventana nuevo informe comercial doy clik en el boton regresar")
    public void enLaVentanaNuevoInformeComercialDoyClikEnElBotonRegresar() {

        informeComercialNuevo.ClickBtnRegresar();
    }

    @And("muestra la ventana informes comerciales y doy click en el boton regresar")
    public void muestraLaVentanaInformesComercialesYDoyClickEnElBotonRegresar() {

        listaInformes.ClickBtnRegresarInformeComercial();
    }

    @And("posiciona en menu principal y doy click en la opcion cerrar sesion")
    public void posicionaEnMenuPrincipalYDoyClickEnLaOpcionCerrarSesion() {

        menuPrincipal.ClickBtnCerrarSesion();
    }

    @And("posiciona en login y doy click en el boton cerrar sesion")
    public void posicionaEnLoginYDoyClickEnElBotonCerrarSesion() {

        loginInforme.ClickBtnCerrarSesion();
    }

    @And("se cierra el navegador")
    public void seCierraElNavegador() {

        Hooks.driver.close();
    }
}
