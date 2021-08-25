package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.cucumber.messages.Messages;

import static Support.screenshot.pantallazo;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
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
    SeleccionarSegurosPage seleccionarSeguros;
    CambioTasaCreditoPage cambioTasaCredito;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;


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
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
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
    public void doyClickEnLinkPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();
        //pantallazo();

    }

    @And("doy click en el boton crear_propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_propuestaDeLaVentanaListadoPropuesta(){
        //listadoPropuesta.AbrirVentana();
        listadoPropuesta.clickCrearPropuesta();
        //pantallazo();
    }


    @And("mostrar la ventana cliente para realizar la busqueda en el tab codigo")
    public void mostrarLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        //listadoClientes.AbrirVentana();
        listadoClientes.SeleccionarTabCodigo();
    }

    @And("en la ventana cliente ingresar el codigo a buscar {string}")
    public void enLaVentanaClienteIngresarElCodigoABuscar(String CodCliente)  {
        listadoClientes.IngresarCodigoCliente(CodCliente);
        //pantallazo();
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


    @And("posicionarse en la ventana Operacion Credito e ingresar la Operacion y doy click en Calcular")

    public void posicionarseEnLaVentanaOperacionCreditoEIngresarlaOperacionYDoyClickEnCalcular(DataTable OperacionCredito) throws InterruptedException {

        operacioncredito.AbrirVentanaOperacionCredito();

        List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacioncredito.SeleccionarMoneda(lista.get(i).get("Moneda"));
            operacioncredito.IngresarMonto(lista.get(i).get("Monto"));
            operacioncredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));

        }

        operacioncredito.ClickCalcular();

    }


    @And("en la ventana Operacion Credito seleccionar plan de pagos {string}")
    public void enLaVentanaOperacionCreditoSeleccionarPlanDePagos(String PlanPagos) {
        operacioncredito.SeleccionarPlanPagos(PlanPagos);

    }

    @And("en la ventana Operacion Credito seleccionar modalidad {string}")
    public void enLaVentanaOperacionCreditoSeleccionarModalidad(String Modalidad) {
        operacioncredito.SeleccionarModalidad(Modalidad);

    }

    @And("en la ventana Operacion Credito Ingresar los dias {string}")
    public void enLaVentanaOperacionCreditoIngresarLosDias(String Dias) {
        operacioncredito.IngresarDias(Dias);
    }

    @And("en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial {string}")
    public void enLaVentanaOperacionCreditoIngresarPorcentajeDeTasaPreferencial(String TasaPreferencial) {
        operacioncredito.IngresarTasaPreferencial(TasaPreferencial);

    }

    @And("en la ventana Operacion Credito seleccionar forma de desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarFormaDeDesembolso(String FormaDesembolso) {
        operacioncredito.SeleccionarFormaDesembolso(FormaDesembolso);

        
    }

    @And("en la ventana Operacion Credito seleccionar plaza de desembolso")
    public void enLaVentanaOperacionCreditoSeleccionarPlazaDeDesembolso(DataTable PlazaDesembolso) {

        List<Map<String,String>> lista = PlazaDesembolso.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacioncredito.SeleccionarDepartamento(lista.get(i).get("Departamento"));
            operacioncredito.SeleccionarProvincia(lista.get(i).get("Provincia"));
            operacioncredito.SeleccionarDistrito(lista.get(i).get("Distrito"));


        }


    }

    @And("en la ventana Operacion Credito ingresar fecha probable del desembolso {string}")
    public void enLaVentanaOperacionCreditoIngresarFechaProbableDelDesembolso(String FechaDesembolso) {
        operacioncredito.IngresarFechaDesembolso(FechaDesembolso);

    }

    @And("en la ventana Operacion Credito Ingresar notas {string}")
    public void enLaVentanaOperacionCreditoIngresarNotas(String Notas) {
        operacioncredito.IngresarNotas(Notas);


    }

    @And("en la ventana Operacion Credito doy click en grabar")
    public void enLaVentanaOperacionCreditoDoyClickEnGrabar() {
        operacioncredito.ClickGrabar();



    }

    @And("en la ventana Operacion Credito aceptar la alerta")
    public void enLaVentanaOperacionCreditoAceptarLaAlerta() {
        operacioncredito.ObtenerAlerta();

        operacioncredito.CerrarVentanaOperacionCredito();
    }

    @Then("el sistema direcciona a ventana Propuesta y doy click icono cambio de tasa")
    public void elSistemaDireccionaAVentanaPropuestaYDoyClickIconoCambioDeTasa() {
        propuesta.ClickIcnCambioTasa();

    }

    @And("en la ventana Cambio Tasa de credito registro el comentario de solicitud {string}")
    public void enLaVentanaCambioTasaDeCreditoRegistroElComentarioDeSolicitud(String ComentarioCambioTasa) {
        cambioTasaCredito.AbrirVentanaCambioTasaCredito();
        cambioTasaCredito.IngresarComentarioCambio(ComentarioCambioTasa);

    }

    @And("en la ventana Cambio Tasa de Credito doy click en boton Grabar")
    public void enLaVentanaCambioTasaDeCreditoDoyClickEnBotonGrabar() {
        cambioTasaCredito.ClickGrabar();
        cambioTasaCredito.CerrarVentanaCambioTasaCredito();

    }


    @Then("el sistema direcciona a la propuesta y doy click al boton Registro de seguros")
    public void elSistemaDireccionaALaPropuestaYDoyClickAlBotonRegistroDeSeguros() {
        propuesta.ClickBotonRegistrarSeguro();

    }

    @And("en la ventana Seleccion de seguros doy click en boton Confirmar")
    public void enLaVentanaSeleccionDeSegurosDoyClickEnBotonConfirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

    }


    @And("el sistema direcciona a la ventana Registro Seguros y check en seguro desgravamen flat MN")
    public void elSistemaDireccionaALaVentanaRegistroSegurosYCheckEnSeguroDesgravamenFlatMN() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenMN();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS {string}")
    public void enLaVentanaRegistroSegurosIngresarElNumeroDPS(String seguroDesgravameMN) {
        registrarSeguros.IngresarSeguroDesgravamenMN(seguroDesgravameMN);
    }

    @And("en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes")
    public void enLaVentanaRegistroSegurosHacerCheckEnSeguroTodoRiesgoPlanPymes() {
        registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS {string} del seguro Plan Pymes")
    public void enLaVentanaRegistroSegurosIngresarElNumeroDPSDelSeguroPlanPymes(String seguroRiesgoPlanPymes) {
        registrarSeguros.IngresarSeguroRiesgoPlanPymes(seguroRiesgoPlanPymes);
    }


    @And("en la ventana Registro Seguros doy click en Confirmar")
    public void enLaVentanaRegistroSegurosDoyClickEnConfirmar() {
        registrarSeguros.ClickConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();
        
    }


    @And("en la ventana seguros seleccionados visualizar información y doy click en cerrar")
    public void enLaVentanaSegurosSeleccionadosVisualizarInformaciónYDoyClickEnCerrar() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();

    }

    @Then("el sistema direcciona a la propuesta y doy click en Anexar CheckList creditos")
    public void elSistemaDireccionaALaPropuestaYDoyClickEnAnexarCheckListCreditos() {
        propuesta.ClickAnexarCheckListCreditos();
    }

    @And("en la ventana CheckList seccion informacion basica del cliente seleccionar los expedientes del uno al siete")
    public void enLaVentanaCheckListSeccionInformacionBasicaDelClienteSeleccionarLosExpedientesDelUnoAlSiete() {
        anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
        anexarCheckListCreditos.Seleccionar1_TarjetaInformacion();
        anexarCheckListCreditos.Seleccionar2_CopiaFedatariaDOI();

    }
}



