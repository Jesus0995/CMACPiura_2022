package Definitions;


import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class CreditoConsumoDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage Servicio;
    PopUpComunicadoPage PopUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOpeCred;
    OperacionCreditoPage operacioncredito;
    SeleccionarSegurosPage seleccionarSeguros;
    CambioTasaCreditoPage cambioTasaCredito;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;

    //Constructor
    public CreditoConsumoDefinitions() {
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
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
    }

    @Given("la pagina web SGCRED esta disponible")
    public void laPaginaWebSGCREDEstaDisponible() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("se completa el usuario y password")
    public void seCompletaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("doy click en el boton ingresar")
    public void doyClickEnElBotonIngresar() {
        login.ClickSubmit();
        //pantallazo();
    }

    @And("muestra el home de SGCRED")
    public void muestraElHomeDeSGCRED() {
    }

    @And("doy click en el link propuesta financiamiento")
    public void doyClickEnElLinkPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();
        //pantallazo();
    }

    @And("doy click en el boton Crear_Propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_PropuestaDeLaVentanaListadoPropuesta() {
        listadoPropuesta.clickCrearPropuesta();
        //pantallazo();
    }

    @And("muestra la ventana cliente para realizar la busqueda en el tab codigo")
    public void muestraLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        listadoClientes.SeleccionarTabCodigo();
        //pantallazo();
    }

    @And("en la ventana cliente digitar el codigo a buscar {string}")
    public void enLaVentanaClienteDigitarElCodigoABuscar(String CodCliente) {
        listadoClientes.IngresarCodigoCliente(CodCliente);
        //pantallazo();
    }

    @And("en la ventana cliente se da click en el boton buscar")
    public void enLaVentanaClienteSeDaClickEnElBotonBuscar() {
        listadoClientes.ClickBuscarCliente();
        //pantallazo();
    }

    @And("en la ventana cliente se da click en el icono propuesta")
    public void enLaVentanaClienteSeDaClickEnElIconoPropuesta() {
        listadoClientes.SeleccionarIconoPropuesta();
        //pantallazo();
    }

    @And("el sistema muestra la ventana de requisitos de propuesta e ingresamos la informacion")
    public void elSistemaMuestraLaVentanaDeRequisitosDePropuestaEIngresamosLaInformacion(DataTable tipoServicio) throws IOException {

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
        } catch (Exception Error){
            System.out.println(Error.getMessage());
        }
        Servicio.CerrarVentanaServicio();
        //pantallazo();
    }

    @And("en la ventana requisitos de propuesta se da click en el boton cargar")
    public void enLaVentanaRequisitosDePropuestaSeDaClickEnElBotonCargar()  {
    }

    @And("validar el popup Comunicado")
    public void ValidarElPopupComunicado() throws IOException {

        try {
            PopUpComunicado.ValidarComunicado();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana propuesta de financiamiento ingresar la clasificacion crediticia {string}")
    public void enLaVentanaPropuestaDeFinanciamientoIngresarLaClasificacionCrediticia(String clasificacion) {
        propuesta.IngresarClasificacionCrediticia(clasificacion);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento ingresar el objetivo de credito {string}")
    public void enLaVentanaPropuestaDeFinanciamientoIngresarElObjetivoDeCredito(String Objetivo) {
        propuesta.IngresarObjetivoCredito(Objetivo);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento ingresar la justificacion de credito {string}")
    public void enLaVentanaPropuestaDeFinanciamientoIngresarLaJustificacionDeCredito(String Justificacion) {
        propuesta.IngresarJustificacionCredito(Justificacion);
        //pantallazo();
    }

    @And("en la ventana propuesta de financiamiento doy clik al botón nueva operacion")
    public void enLaVentanaPropuestaDeFinanciamientoDoyClikAlBotónNuevaOperacion() {
        propuesta.ClickBotonOperacion();
        //pantallazo();
    }

    @And("el sistema muestra la ventana seleccionar operacion credito")
    public void elSistemaMuestraLaVentanaSeleccionarOperacionCredito() {
    }

    @And("en la ventana seleccionar operacion credito doy click en el boton aceptar")
    public void enLaVentanaSeleccionarOperacionCreditoDoyClickEnElBotonAceptar() throws IOException{
        seleccionarOpeCred.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOpeCred.ValidarVentanaOP();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
        seleccionarOpeCred.CerrarVentanaSeleccionarOP();
        //pantallazo();
    }

    @And("el sistema muestra la ventana operacion credito")
    public void elSistemaMuestraLaVentanaOperacionCredito() {
    }

    @And("en la ventana operacion credito ingresar el monto, la tasa inicial luego click en el boton calcular")
    public void enLaVentaOperacionCreditoIngresarElMontoLaTasaInicialLuegoClickEnElBotonCalcular(DataTable OperacionCredito) throws InterruptedException {

            operacioncredito.AbrirVentanaOperacionCredito();

            List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
            for (int i = 0; i < lista.size(); i++) {
                operacioncredito.IngresarMonto(lista.get(i).get("Monto"));
                operacioncredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));
            }

            operacioncredito.ClickCalcular();


    }

    @And("en la ventana operacion credito seleccionar el plan de pagos {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElPlanDePagos(String PlanPagos) {
        try {
            operacioncredito.SeleccionarPlanPagos(PlanPagos);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }

    }

    @And("en la ventana operacion credito seleccionar la modalidad de amortizacion {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaModalidadDeAmortizacion(String Modalidad) {
        try {
            operacioncredito.SeleccionarModalidad(Modalidad);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito seleccionar la opcion de pago {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaOpcionDePago(String OpcionPagos) {
        try {
            operacioncredito.SeleccionarOpcionPagos(OpcionPagos);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito ingresar el dia de pago {string}")
    public void enLaVentanaOperacionCreditoIngresarElDiaDePago(String DiaPagos) {
        try {
            operacioncredito.SeleccionarDiaPagos(DiaPagos);
            //pantallazo();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito seleccionar el numero de cuotas {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElNumeroDeCuotas(String NumeroCuotas) {
        try {
            operacioncredito.IngresarNumeroCuotas(NumeroCuotas);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito ingresar la tasa preferencial {string}")
    public void enLaVentanaOperacionCreditoIngresarLaTasaPreferencial(String TasaPreferencial) {
        try {
            operacioncredito.IngresarTasaPreferencial(TasaPreferencial);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito seleccionar la forma desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaFormaDesembolso(String FormaDesembolso) {
        try {
            operacioncredito.SeleccionarFormaDesembolso(FormaDesembolso);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito seleccionar el codigo de cuenta {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElNumeroDeCuenta(String CodigoCuenta) {
        try {
            operacioncredito.SeleccionarCodigoCuenta(CodigoCuenta);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito seleccionar la fecha desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarLaFechaDesembolso(String FechaDesembolso) {
        try {
            operacioncredito.IngresarFechaDesembolso(FechaDesembolso);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito ingresar una nota {string}")
    public void enLaVentanaOperacionCreditoIngresarUnaNota(String Notas) {
        try {
            operacioncredito.IngresarNotas(Notas);
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito doy click en el boton grabar")
    public void enLaVentanaOperacionCreditoDoyClickEnElBotonGrabar() {
        try {
            operacioncredito.ClickGrabar();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }

    @And("en la ventana operacion credito aceptar la alerta")
    public void enLaVentanaOperacionCreditoAceptarLaAlerta() {
        try {
            operacioncredito.ObtenerAlerta();
            operacioncredito.CerrarVentanaOperacionCredito();
        }
        catch (Exception Error){
            System.out.println(Error.getMessage());
        }
    }
}
