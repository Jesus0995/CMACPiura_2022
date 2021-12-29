package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static Support.screenshot.pantallazo;

public class AprobarPropuestaCreditoEmpresarialDefinitions {

    LoginPage loginAprobar;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    AprobarCheckListCreditoPage aprobarcheckListCredito;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionDocumentoPage grabarDocumentoPropuesta;

    public AprobarPropuestaCreditoEmpresarialDefinitions() {
        loginAprobar = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarcheckListCredito = new AprobarCheckListCreditoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);

    }

    @Given("el sistema SGCRED se encuentra disponible")
    public void ElSistemaSGCREDSeEncuentraDisponible() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/logout.jsp");
    }

    @When("ingreso usuario y password del Perfil Jefe de Credito Agencia")
    public void ingresoUsuarioYPasswordDelPerfilJefeDeCreditoAgencia(DataTable datauser) {
        List<Map<String, String>> listas = datauser.asMaps(String.class, String.class);
        for (int i = 0; i < listas.size(); i++) {
            loginAprobar.IngresarUsuario(listas.get(i).get("usuario"));
            loginAprobar.IngresarPassword(listas.get(i).get("password"));
        }
    }

    @And("en la ventana doy click en el boton Ingresar de la web SGCRED")
    public void enLaVentanaDoyClickEnElBotonIngresarDeLaWebSGCRED() {

        loginAprobar.ClickSubmit();
        loginAprobar.ValidarSesionesWeb();
    }

    @Then("el sistema muestra el menu principal de SGCRED")
    public void elSistemaMuestraElMenuPrincipalDeSGCRED() { }

    @And("en el menu doy click en la opcion propuesta de financiamiento")
    public void enElMenuDoyClickEnLaOpcionPropuestaDeFinanciamiento() {

        menuPrincipal.ClickPropuestaFinanciamiento();
    }

    @And("en la ventana Listado de Propuestas seleccionar el tipo de busqueda por numero de propuesta")
    public void enLaVentanaListadoDePropuestasSeleccionarElTipoDeBusquedaPorNumeroDePropuesta() {
        listadoPropuesta.ClickTipoBusquedaAprobacion();
    }

    @And("en la ventana Listado de Propuestas ingresar el numero de propuesta {string}")
    public void enLaVentanaListadoDePropuestasIngresarElNumeroDePropuesta(String Propuesta) {
        listadoPropuesta.IngresarNumeroPropuesta(Propuesta);
    }

    @And("en la ventana Listado de Propuestas doy click en el boton Buscar")
    public void enLaVentanaListadoDePropuestasDoyClickEnElBotonBuscar() {

        listadoPropuesta.ClickBtnBuscar();
    }

    @And("en la ventana Listado de Propuestas doy click en el boton Editar")
    public void enLaVentanaListadoDePropuestasDoyClickEnElBotonEditar() {

        listadoPropuesta.ClickEditarPropuesta();
    }

    @And("el sistema muestra Comunicado y doy en cerrar")
    public void elSistemaMuestraComunicadoYDoyEnCerrar() {

        popUpComunicado.ValidarComunicado();
    }

    @And("en la ventana principal de Propuesta doy click en el boton verificar checklist credito")
    public void enLaVentanaPrincipalDePropuestaDoyClickEnElBotonVerificarChecklistCredito() {
        propuesta.ClickBtnVerificarCheckListCredito();
    }

    @And("en la ventana Anexar CheckList Credito seleccionar Aprobar e ingresar un comentario")
    public void enLaVentanaAnexarCheckListCreditoSeleccionarAprobarEIngresarUnComentario() {
        aprobarcheckListCredito.AbrirVentanaAprobarCheckListCredito();
        aprobarcheckListCredito.SeleccionarOptAprobar();
        aprobarcheckListCredito.IngresarComentarios();
    }

    @And("en la ventana Anexar CheckList Credito doy click en el boton Guardar")
    public void enLaVentanaAnexarCheckListCreditoDoyClickEnElBotonGuardar() {
        aprobarcheckListCredito.ClickBtnGuardar();

    }

    @And("en la ventana Anexar CheckList Credito doy click en el boton Cerrar")
    public void enLaVentanaAnexarCheckListCreditoDoyClickEnElBotonCerrar() {
        aprobarcheckListCredito.ClickBtnCerrar();
        aprobarcheckListCredito.CerrarVentanaAprobarCheckListCredito();
    }


    @And("en la ventana principal de Propuesta doy click en el Menu Emitir Dictamen")
    public void enLaVentanaPrincipalDePropuestaDoyClickEnElMenuEmitirDictamen() throws IOException {
        propuesta.AbrirOpcionesDictamen();
        pantallazo();
    }
    @And("en las opciones del Menu Emitir Dictamen seleccionar el boton Aprobar")
    public void enLasOpcionesDelMenuEmitirDictamenSeleccionarElBotonAprobar() throws IOException {
        propuesta.ClickBtnAprobarPropuesta();
        pantallazo();
    }

    @And("en la ventana ventana Emitir Dictamen ingresar Observaciones y Clave")
    public void enLaVentanaVentanaEmitirDictamenIngresarObservacionesYClave(DataTable AprobarData) {
        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = AprobarData.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }
    }

    @And("en la misma ventana doy click en el boton Procesar")
    public void enLaMismaVentanaDoyClickEnElBotonProcesar() {
        aprobarDictamenPropuesta.ClickBtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }

    @Then("el sistema muestra la ventana Grabar Informacion y doy click en el boton Cerrar")
    public void elSistemaMuestraLaVentanaGrabarInformacionYDoyClickEnElBotonCerrar() throws IOException {
        grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
        grabarDocumentoPropuesta.ClickBtnCerrar();
        grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
        pantallazo();



    }
    @And("el sistema direcciona al listado de propuestas y doy click en el boton Regresar")
    public void elSistemaDireccionaAlListadoDePropuestasYDoyClickEnElBotonRegresar() {
        listadoPropuesta.ClickBtnRegresar();
    }
    @And("el sistema direcciona al menu principal y le doy click en Cerrar Sesion")
    public void elSistemaDireccionaAlMenuPrincipalYLeDoyClickEnCerrarSesion() {

        menuPrincipal.ClickBtnCerrarSesion();
    }
    @And("el sistema direcciona al login y le doy click en el boton Cerrar Sesion")
    public void elSistemaDireccionaAlLoginYLeDoyClickEnElBotonCerrarSesion() {

        loginAprobar.ClickBtnCerrarSesion();
    }

    @And("cerrar el navegador")
    public void cerrarElNavegador() {

        Hooks.driver.close();
    }

}