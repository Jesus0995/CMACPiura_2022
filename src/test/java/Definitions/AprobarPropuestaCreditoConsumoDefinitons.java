package Definitions;
import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class AprobarPropuestaCreditoConsumoDefinitons {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarDocumentoPropuestaPage grabarDocumentoPropuesta;

    //Constructor
    public AprobarPropuestaCreditoConsumoDefinitons() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarDocumentoPropuestaPage(Hooks.driver);
    }

    @Given("la web SGCRED se encuentra disponible")
    public void laWebSGCREDSeEncuentraDisponible() {

        Hooks.driver.get("http://10.0.203.12:8082/propuesta/");
    }

    @When("ingreso usuario y password del perfil Administrador")
    public void ingresoUsuarioYPasswordDelPerfilAdministrador(DataTable user) {

        List<Map<String,String>> lista = user.asMaps(String.class, String.class);
        for (Map<String, String> stringStringMap : lista) {
            login.IngresarUsuario(stringStringMap.get("nombre"));
            login.IngresarPassword(stringStringMap.get("password"));
        }
    }

    @And("doy click en el boton ingresar de la web SGCRED")
    public void doyClickEnElBotonIngresarDeLaWebSGCRED() {

        login.ClickSubmit();

    }

    @And("muestra el menu principal de SGCRED")
    public void muestraElMenuPrincipalDeSGCRED() {
    }

    @And("doy click en la opcion propuesta de financiamiento")
    public void doyClickEnLaOpcionPropuestaDeFinanciamiento() {

        menuPrincipal.ClickPropuestaFinanciamiento();
    }

    @And("muestra el listado de propuestas y doy click en el boton editar propuesta")
    public void muestraElListadoDePropuestasYDoyClickEnElBotonEditarPropuesta() {

        listadoPropuesta.ClickEditarPropuestaAprobacion();

    }

    @And("doy cerrar el comunicado")
    public void doyCerrarElComunicado() {

        popUpComunicado.ValidarComunicado();

    }

    @And("muestra la propuesta de financiamiento y doy click en la opcion aprobar")
    public void muestraLaPropuestaDeFinanciamientoYDoyClickEnLaOpcionAprobar() {

        propuesta.ClickBtnAprobarPropuesta();

    }

    @And("muestra la ventana emitir dictamen ingresar observaciones y clave")
    public void muestraLaVentanaEmitirDictamenIngresarObservacionesYClave(DataTable DatosAprobacion) {

        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = DatosAprobacion.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }
    }

    @And("en la ventana emitir dictamen doy click en el boton procesar")
    public void enLaVentanaEmitirDictamenDoyClickEnElBotonProcesar() {

        aprobarDictamenPropuesta.ClickbtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }

    @And("muestra la ventana de grabar informacion y doy click en cerrar")
    public void muestraLaVentanaDeGrabarInformacionYDoyClickEnCerrar() {

        grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
        grabarDocumentoPropuesta.ClickbtnCerrar();
        grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @And("direcciona a la ventana listado de propuestas y doy click en el boton regresar")
    public void direccionaALaVentanaListadoDePropuestasYDoyClickEnElBotonRegresar() {

        listadoPropuesta.ClickRegresar();
    }

    @And("direcciona a menu principal y doy click en la opcion cerrar sesion")
    public void direccionaAMenuPrincipalYDoyClickEnLaOpcionCerrarSesion() {

        menuPrincipal.ClickCerrarSesion();

    }

    @And("direcciona a login y doy click en el boton cerrar sesion")
    public void direccionaALoginYDoyClickEnElBotonCerrarSesion() {

        login.ClickCerrarSesion();

    }
}