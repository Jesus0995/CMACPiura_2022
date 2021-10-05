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
    AnexarCheckListCreditoAprobarPage aprobarcheckListCredito;
    CerrarAnexarCheckListCreditoAprobarPage cerrarAprobarCheckListCredito;

    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionDocumentoPage grabarDocumentoPropuesta;


    public AprobarPropuestaCreditoEmpresarialDefinitions() {
        loginAprobar = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarcheckListCredito = new AnexarCheckListCreditoAprobarPage(Hooks.driver);
        cerrarAprobarCheckListCredito = new CerrarAnexarCheckListCreditoAprobarPage(Hooks.driver);

        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);

    }

    @Given("el sistema SGCRED se encuentra disponible")
    public void ElSistemaSGCREDSeEncuentraDisponible() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }

    @When("ingreso usuario y password del Perfil Jefe de Credito Agencia")
    public void ingresoUsuarioYPasswordDelPerfilJefeDeCreditoAgencia(DataTable datauser) {
        List<Map<String, String>> listas = datauser.asMaps(String.class, String.class);
        for (int i = 0; i < listas.size(); i++) {
            loginAprobar.IngresarUsuario(listas.get(i).get("nombre"));
            loginAprobar.IngresarPassword(listas.get(i).get("password"));
        }
    }

    @And("en la ventana doy click en el boton Ingresar de la web SGCRED")
    public void enLaVentanaDoyClickEnElBotonIngresarDeLaWebSGCRED() {
        loginAprobar.ClickSubmit();
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

    @And("en la ventana Propuesta doy click en el Boton Verificar CheckListCredito")
    public void enLaVentanaPropuestaDoyClickEnElBotonVerificarCheckListCredito() {
        propuesta.ClickBtnVerificarCheckListCredito();
    }
    @And("el sistema muestra la ventana Anexar Checklist Credito y doy click en la Opcion Aprobar")
    public void elSistemaMuestraLaVentanaAnexarChecklistCreditoYDoyClickEnLaOpcionAprobar() {
        aprobarcheckListCredito.AbrirVentanaAnexarCheckListAprobar();
        aprobarcheckListCredito.SeleccionarOptAprobar();

    }
    @And("en la misma ventana Anexar ingreso un comentario de aprobacion {string}")
    public void enLaMismaVentanaAnexarIngresoUnComentarioDeAprobacion(String ComentariosAprobacion) {
        aprobarcheckListCredito.IngresarComentarios(ComentariosAprobacion);

    }
    @And("en la misma ventana Anexar doy click en el boton Guardar")
    public void enLaMismaVentanaAnexarDoyClickEnElBotonGuardar() {
        aprobarcheckListCredito.ClickBtnGuardar();
        //aprobarcheckListCredito.CerrarVentanaAnexarCheckListAprobar();
    }

    @And("el sistema me direcciona a la misma ventana y doy click en el boton cerrar")
    public void elSistemaMeDireccionaALaMismaVentanaYDoyClickEnElBotonCerrar() {
        cerrarAprobarCheckListCredito.AbrirVentanaCerrarAnexarCheckListAprobar();
        cerrarAprobarCheckListCredito.ClickBtnCerrar();
        cerrarAprobarCheckListCredito.CerrarVentanaCerrarAnexarCheckListAprobar();
    }
    @And("en la ventana principal de Propuesta doy click en el Menu Emitir Dictamen")
    public void enLaVentanaPrincipalDePropuestaDoyClickEnElMenuEmitirDictamen() {
        propuesta.AbrirOpcionesDictamen();
    }
    @And("en las opciones del Menu Emitir Dictamen seleccionar el boton Aprobar")
    public void enLasOpcionesDelMenuEmitirDictamenSeleccionarElBotonAprobar() {
        propuesta.ClickBtnAprobarPropuesta();
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
        aprobarDictamenPropuesta.ClickbtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }

    @Then("el sistema muestra la ventana Grabar Informacion y doy click en el boton Cerrar")
    public void elSistemaMuestraLaVentanaGrabarInformacionYDoyClickEnElBotonCerrar() throws IOException {
        grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
        grabarDocumentoPropuesta.ClickbtnCerrar();
        grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();
        pantallazo();
    }
    @And("el sistema direcciona al listado de propuestas y doy click en el boton Regresar")
    public void elSistemaDireccionaAlListadoDePropuestasYDoyClickEnElBotonRegresar() {
        listadoPropuesta.ClickRegresar();
    }
    @And("el sistema direcciona al menu principal y le doy click en Cerrar Sesion")
    public void elSistemaDireccionaAlMenuPrincipalYLeDoyClickEnCerrarSesion() {
        menuPrincipal.ClickCerrarSesion();
    }
    @And("el sistema direcciona al login y le doy click en el boton Cerrar Sesion")
    public void elSistemaDireccionaAlLoginYLeDoyClickEnElBotonCerrarSesion() {
        loginAprobar.ClickCerrarSesion();
    }

}