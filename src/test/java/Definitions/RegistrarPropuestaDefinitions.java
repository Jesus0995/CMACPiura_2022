package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import static Support.screenshot.pantallazo;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class RegistrarPropuestaDefinitions {
    //crear variables de los pages
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage Servicio;
    PopUpComunicadoPage PopUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOpeCred;
    OperacionCreditoPage operacioncredito;

    //Constructor
    public RegistrarPropuestaDefinitions() {
        //Inicializar las paginas
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        Servicio = new SeleccionarServicioPage(Hooks.driver);
        PopUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOpeCred = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacioncredito = new OperacionCreditoPage(Hooks.driver);
    }


    @Given("la web SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {

        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("ingreso usuario y password")

    public void ingreso_usuario_y_password(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }

    @When("doy clic en boton ingresar")
    public void doy_click_en_boton_ingresar() {
        login.ClickSubmit();

    }

    @And("Mostrar home de SGCRED")
    public void mostrarHomeDeSGCRED() {


    }

    // @And("Cerrar las ventanas emergentes")
    // public void cerrarLasVentanasEmergentes() {
    //     menuPrincipal.CerrarPopUpImagen();
    //     menuPrincipal.CerrarPopUpAviso();

    //}


    @And("doy click en link propuesta financiamiento")
    public void doyClickEnLinkPropuestaFinanciamiento() throws IOException {
        menuPrincipal.ClickPropuestaFinanciamiento();
        pantallazo();

    }

    @And("doy click en el boton crear_propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_propuestaDeLaVentanaListadoPropuesta() throws IOException {
        //listadoPropuesta.AbrirVentana();
        listadoPropuesta.clickCrearPropuesta();
        pantallazo();
    }


    @And("mostrar la ventana cliente para realizar la busqueda en el tab codigo")
    public void mostrarLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        //listadoClientes.AbrirVentana();
        listadoClientes.SeleccionarTabCodigo();
    }

    @And("en la ventana cliente ingresar el codigo a buscar {string}")
    public void enLaVentanaClienteIngresarElCodigoABuscar(String CodCliente) throws IOException {
        listadoClientes.IngresarCodigoCliente(CodCliente);
        pantallazo();
    }

    @And("en la ventana cliente doy click en el boton buscar")
    public void enLaVentanaClienteDoyClickEnElBotonBuscar() {
        listadoClientes.ClickBuscarCliente();

    }

    @And("en la ventana cliente hacer click en el icono propuesta")
    public void enLaVentanaClienteHacerClickEnElIconoPropuesta() {

        listadoClientes.SeleccionarIconoPropuesta();
    }

    @And("el sistema muestra la ventana de servicio e ingresamos la informacion")
    public void elSistemaMuestraLaVentanaDeServicioEIngresamosLaInformacion(DataTable tipoServicio) throws IOException {

        Servicio.AbrirVentanaServicio();

        List<Map<String, String>> lista = tipoServicio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            Servicio.SeleccionarServicio(lista.get(i).get("TipoServicio"));
            Servicio.SeleccionarServicioCredito(lista.get(i).get("ServicioCredito"));
            Servicio.SeleccionarTipoPropuesta(lista.get(i).get("TipoPropuesta"));
            Servicio.SeleccionarSubTipoPropuesta(lista.get(i).get("SubTipoPropuesta"));
            Servicio.SeleccionarPromocion(lista.get(i).get("Promocion"));
            //Servicio.SeleccionarNegocio(lista.get(i).get("Negocio"));
            //Servicio.SeleccionarTipoOperacion(lista.get(i).get("TipoOperacion"));
        }

        try {
            Servicio.ClickCargar();
        } catch (Exception Error) {

        }

        Servicio.CerrarVentanaServicio();

    }

    @And("en la ventana servicio doy click en el boton cargar")

    public void enLaVentanaServicioDoyClickEnElBotonCargar() throws InterruptedException {

        Servicio.ClickCargar();
    }

    @And("validar el mensaje del popup Comunicado")
    public void validarElMensajeDelPopupComunicado(){
       // PopUpComunicado.UbicarVentanaComunicado();
        PopUpComunicado.ValidarComunicado();


    }

    @And("en la ventana propuesta ingresar clasificacion crediticia {string}")
    public void enLaVentanaPropuestaIngresarClasificacionCrediticia(String clasificacion) {
        propuesta.IngresarClasificacionCrediticia(clasificacion);

    }

    @And("en la ventana propuesta ingresar objetivo del credito {string}")
    public void enLaVentanaPropuestaIngresarObjetivoDelCredito(String objetivo) {
        propuesta.IngresarObjetivoCredito(objetivo);

    }

    @And("en la ventana propuesta ingresar justificacion del credito {string}")
    public void enLaVentanaPropuestaIngresarJustificacionDelCredito(String justificacion) {
        propuesta.IngresarJustificacionCredito(justificacion);
    }

    @And("en la ventana propuesta doy click en el boton nueva operacion")
    public void enLaVentanaPropuestaDoyClickEnElBotonNuevaOperacion()
    {
        propuesta.ClickBotonOperacion();
    }


    @And("validar la ventana seleccionar operacion de credito luego doy click en boton aceptar")
    public void validarLaVentanaSeleccionarOperacionDeCreditoLuegoDoyClickEnBotonAceptar() {
        seleccionarOpeCred.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOpeCred.ValidarVentanaOP();
        } catch(Exception Error){

        }

        seleccionarOpeCred.CerrarVentanaSeleccionarOP();

    }


    @And("posicionarse en la ventana Operacion Credito e ingresar la informacion")
    public void posicionarseEnLaVentanaOperacionCreditoEIngresarLaInformacion() {
        operacioncredito.AbrirVentanaOperacionCredito();



    }
}

