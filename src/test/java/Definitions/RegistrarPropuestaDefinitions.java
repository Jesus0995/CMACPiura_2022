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


    @And("doy click en propuesta financiamiento")
    public void doyClickEnPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();
        //menuPrincipal.CerrarVentana();
    }

    @And("doy click en crear propuesta de la ventana Listado Propuesta")
    public void doyClickEnCrearPropuestaDeLaVentanaListadoPropuesta() {
        //listadoPropuesta.AbrirVentana();
        listadoPropuesta.clickCrearPropuesta();


    }

    @And("realizar busqueda de cliente para crear propuesta")
    public void realizarBusquedaDeClienteParaCrearPropuesta() {
        listadoClientes.AbrirVentana();
        listadoClientes.SeleccionarTabCodigo();
        listadoClientes.IngresarCodigoCliente();
        listadoClientes.ClickBuscarCliente();
        listadoClientes.SeleccionarIconoPropuesta();
    }

    @And("ingresar operaciones de credito")
    public void ingresarOperacionesDeCredito() {
        Servicio.AbrirVentana();
        Servicio.SeleccionarServicio();
        Servicio.SeleccionarServicioCredito();
        Servicio.SeleccionarTipoPropuesta();
        Servicio.SeleccionarSubTipoPropuesta();
        Servicio.SeleccionarPromocion();

    }
}
