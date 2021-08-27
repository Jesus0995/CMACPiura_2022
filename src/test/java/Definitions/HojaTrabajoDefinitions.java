package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import static Support.screenshot.pantallazo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HojaTrabajoDefinitions {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoHojaTrabajoPage listadoHojaTrabajo;
    CrearHojaTrabajoPage crearHojaTrabajo;
    RegistrarHojaTrabajoPage registrarHojaTrabajo;
    GrabarDocumentoHojaTrabajoPage grabarDocumentoHojaTrabajoPage;



    //Constructor
    public HojaTrabajoDefinitions() {
        //Inicializar las paginas
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoHojaTrabajo = new ListadoHojaTrabajoPage( Hooks.driver);
        crearHojaTrabajo = new CrearHojaTrabajoPage( Hooks.driver);
        registrarHojaTrabajo = new RegistrarHojaTrabajoPage( Hooks.driver);
        grabarDocumentoHojaTrabajoPage = new GrabarDocumentoHojaTrabajoPage(Hooks.driver);
    }

    @Given("la pagina SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {

        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("se ingresa usuario y password")
    public void ingreso_usuario_y_password(DataTable user) {
        List<Map<String,String>> lista = user.asMaps(String.class, String.class);
        for (Map<String, String> stringStringMap : lista) {
            login.IngresarUsuario(stringStringMap.get("nombre"));
            login.IngresarPassword(stringStringMap.get("password"));
        }
    }

    @When("se da click en boton ingresar")
    public void doy_click_en_boton_ingresar() {

        login.ClickSubmit();
    }


    @And("me muestra el home de SGCRED")
    public void meMuestraElHomeDeSGCRED() {
    }

    @And("doy click en link Hoja de Trabajo")
    public void doyClickEnLinkHojaDeTrabajo() throws IOException {
        menuPrincipal.ClickHojaTrabajo();
        pantallazo();
    }

    @And("me muestra la ventana listado de hojas de trabajo para realizar la busqueda en el tab codigo")
    public void meMuestraLaVentanaListadoDeHojasDeTrabajoParaRealizarLaBusquedaEnElTabCodigo() {
        listadoHojaTrabajo.SeleccionarTabCodigo();
    }

    @And("en la ventana listado de hojas de trabajo ingresar el codigo a buscar {string}")
    public void enLaVentanaListadoDeHojasDeTrabajoIngresarElCodigoABuscar(String CodCliente) throws IOException {
        listadoHojaTrabajo.IngresarCodigoCliente(CodCliente);
        pantallazo();
    }

    @And("en la ventana listado de hojas de trabajo doy click en el boton buscar")
    public void enLaVentanaListadoDeHojasDeTrabajoDoyClickEnElBotonBuscar() {

        listadoHojaTrabajo.ClickBuscarCliente();
    }

    @And("en la ventana listado de hojas de trabajo hacer click en el icono hoja de trabajo")
    public void enLaVentanaListadoDeHojasDeTrabajoHacerClickEnElIconoHojaDeTrabajo() {
        listadoHojaTrabajo.SeleccionarIconoHojaTrabajo();
    }

    @And("me muestra la ventana hojas de trabajo")
    public void meMuestraLaVentanaHojasDeTrabajo() {
    }

    @And("en la ventana hojas de trabajo doy click en el boton crear hoja de trabajo")
    public void enLaVentanaHojasDeTrabajoDoyClickEnElBotonCrearHojaDeTrabajo() {

        crearHojaTrabajo.CrearHojaTrabajo();
    }

    @And("me muestra la ventana Hoja de Trabajo")
    public void meMuestraLaVentanaHojaDeTrabajo() {
    }

    @And("en la ventana Hoja de Trabajo se ingresa los datos de trabajo")
    public void enLaVentanaHojaDeTrabajoSeIngresaLosDatosDeTrabajo(DataTable tipoMonto) {

        List<Map<String, String>> lista = tipoMonto.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size(); i++) {
            registrarHojaTrabajo.TiempoLaboral(lista.get(i).get("TiempoLaboral"));
            registrarHojaTrabajo.IngresosBoleta(lista.get(i).get("IngresosBoleta"));
            registrarHojaTrabajo.IngresosReciboHonorario(lista.get(i).get("IngresosReciboHonorario"));
            registrarHojaTrabajo.GastosAlimentacion(lista.get(i).get("GastosAlimentacion"));
            registrarHojaTrabajo.GastosTransporte(lista.get(i).get("GastosTransporte"));
            registrarHojaTrabajo.GastosEducacion(lista.get(i).get("GastosEducacion"));
            registrarHojaTrabajo.GastosVivienda(lista.get(i).get("GastosVivienda"));
            registrarHojaTrabajo.GastosObligacionesTerceros(lista.get(i).get("GastosObligacionesTerceros"));
            registrarHojaTrabajo.DescuentoBoleta(lista.get(i).get("DescuentoBoleta"));
            registrarHojaTrabajo.DescuentoReciboHonorario(lista.get(i).get("DescuentoReciboHonorario"));
        }

    }

    @And("en la ventana Hoja de Trabajo doy click en el botón grabar")
    public void enLaVentanaHojaDeTrabajoDoyClickEnElBotónGrabar() {

        registrarHojaTrabajo.GrabarHojaTrabajo();
    }


    @And("en la ventana Hoja de Trabajo doy click en el boton finalizar")
    public void enLaVentanaHojaDeTrabajoDoyClickEnElBotonFinalizar() {
        registrarHojaTrabajo.FinalizarHojaTrabajo();

    }

    @And("en la ventana Hoja de Trabajo doy click en aceptar la alerta")
    public void enLaVentanaHojaDeTrabajoDoyClickEnAceptarLaAlerta() {
        registrarHojaTrabajo.ObtenerAlerta();
    }

    @And("en la ventana grabar documento hoja de trabajo doy click en el botón cerrar")
    public void enLaVentanaGrabarDocumentoHojaDeTrabajoDoyClickEnElBotónCerrar() throws IOException {
        grabarDocumentoHojaTrabajoPage.AbrirVentanaGrabarDocumento();
        try {
            grabarDocumentoHojaTrabajoPage.GrabarDocumentoHojaTrabajo();
        } catch (Exception Error) {
                System.out.println(Error.getMessage());
        }
        grabarDocumentoHojaTrabajoPage.CerrarVentanaGrabarDocumento();
    }

    @And("en la ventana hojas de trabajo doy click en el boton regresar")
    public void enLaVentanaHojasDeTrabajoDoyClickEnElBotonRegresar() {

        crearHojaTrabajo.RegresarListado();
    }

}
