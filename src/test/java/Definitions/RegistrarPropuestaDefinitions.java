package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class RegistrarPropuestaDefinitions {
    //crear variables de los pages
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage Servicio;
    PropuestaPage propuesta;

    //Constructor
    public RegistrarPropuestaDefinitions() {
        //Inicializar las paginas
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage( Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        Servicio = new SeleccionarServicioPage (Hooks.driver);
        }


    @Given("la web SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }
    @When("ingreso usuario y password")

    public void ingreso_usuario_y_password(DataTable user) {
        List<Map<String,String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i ++) {
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

    @And("Cerrar las ventanas emergentes")
    public void cerrarLasVentanasEmergentes() {
        menuPrincipal.CerrarPopUpImagen();
        menuPrincipal.CerrarPopUpAviso();

    }



    @And("doy click en link propuesta financiamiento")
    public void doyClickEnLinkPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();

    }

    @And("doy click en el boton crear_propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_propuestaDeLaVentanaListadoPropuesta() {
        //listadoPropuesta.AbrirVentana();
        listadoPropuesta.clickCrearPropuesta();
    }


    @And("mostrar la ventana cliente para realizar la busqueda en el tab codigo")
    public void mostrarLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        //listadoClientes.AbrirVentana();
        listadoClientes.SeleccionarTabCodigo();
    }

    @And("en la ventana cliente ingresar el codigo a buscar")
    public void enLaVentanaClienteIngresarElCodigoABuscar() {
        listadoClientes.IngresarCodigoCliente();
    }

    @And("en la ventana cliente doy click en el boton buscar")
    public void enLaVentanaClienteDoyClickEnElBotonBuscar() {
        listadoClientes.ClickBuscarCliente();

    }

    @And("en la ventana cliente hacer click en el icono propuesta")
    public void enLaVentanaClienteHacerClickEnElIconoPropuesta() {
        listadoClientes.SeleccionarIconoPropuesta();
    }

    @And("SGCRED muestra la ventana servicio y seleccionamos el servicio para generar la propuesta")
    public void sgcredMuestraLaVentanaServicioYSeleccionamosElServicioParaGenerarLaPropuesta() {
        Servicio.AbrirVentanaServicio();
        Servicio.SeleccionarServicio();
        
    }

    @And("en la ventana servicio seleccionar el Servicio credito")
    public void enLaVentanaServicioSeleccionarElServicioCredito() {
        Servicio.SeleccionarServicioCredito();
    }

    @And("en la ventana servicio seleccionar tipo de propuesta")
    public void enLaVentanaServicioSeleccionarTipoDePropuesta() {
        Servicio.SeleccionarTipoPropuesta();
    }

    @And("en la ventana servicio seleccionar subtipo de propuesta")
    public void enLaVentanaServicioSeleccionarSubtipoDePropuesta() {
        Servicio.SeleccionarSubTipoPropuesta();
    }

    @And("en la ventana servicio seleccionar promocion")
    public void enLaVentanaServicioSeleccionarPromocion() {
        Servicio.SeleccionarPromocion();
    }


    @And("en la ventana Servicio seleccionar negocio")
    public void enLaVentanaServicioSeleccionarNegocio() {
        Servicio.SeleccionarNegocio();

    }

    @And("en la ventana Servicio seleccionar tipo operacion")
    public void enLaVentanaServicioSeleccionarTipoOperacion() {
        Servicio.SeleccionarTipoOperacion();
    }
    @And("en la ventana servicio doy click en el boton cargar")
    public void enLaVentanaServicioDoyClickEnElBotonCargar() {
        Servicio.ClickCargar();
    }

    @And("en el formulario propuesta ingresar comentario en clasificacion crediticia")
    public void enElFormularioPropuestaIngresarComentarioEnClasificacionCrediticia() {
        propuesta.IngresarComentarioCrediticio();
    }

    @And("en el formulario propuesta ingresar comentario del objetivo del credito")
    public void enElFormularioPropuestaIngresarComentarioDelObjetivoDelCredito() {
        propuesta.IngresarObjetivo();
    }

    @And("en el formulario propuesta ingresar comentario justificacion del credito")
    public void enElFormularioPropuestaIngresarComentarioJustificacionDelCredito() {
        propuesta.IngresarJustificacion();
    }

    @And("en el formulario propuesta hacer click en nueva operacion")
    public void enElFormularioPropuestaHacerClickEnNuevaOperacion() {
        propuesta.ClickOperacion();

    }


}
