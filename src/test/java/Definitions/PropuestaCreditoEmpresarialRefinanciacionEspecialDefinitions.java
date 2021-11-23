package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

public class PropuestaCreditoEmpresarialRefinanciacionEspecialDefinitions {
    LoginPage loginRefinanciacion;
    MenuPrincipalPage menuRefinanciacion;
    ListadoPropuestaPage listadoPropuestaRefinanciacion;
    ListadoClientesPage listadoClientesRefinanciacion;
    SeleccionarServicioPage seleccionarServicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    CondicionesRefinanciarPage condicionesRefinanciar;
    SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    OperacionCreditoPage operacionCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;

    public PropuestaCreditoEmpresarialRefinanciacionEspecialDefinitions() {
        loginRefinanciacion = new LoginPage(Hooks.driver);
        menuRefinanciacion = new MenuPrincipalPage(Hooks.driver);
        listadoPropuestaRefinanciacion = new ListadoPropuestaPage(Hooks.driver);
        listadoClientesRefinanciacion = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);


    }


    @Given("Cuando el sistema SGCRED este disponible")
    public void cuando_el_sistema_sgcred_este_disponible() {
        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");
    }

    @When("ingrese el usuario y contraseña en SGCRED")
    public void ingrese_el_usuario_y_contraseña_en_sgcred(DataTable Datalogin) {
        List<Map<String, String>> lista = Datalogin.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); i++) {
            loginRefinanciacion.IngresarUsuario(lista.get(i).get("Usuario"));
            loginRefinanciacion.IngresarPassword(lista.get(i).get("Password"));

        }
    }


    @And("seleccionar el boton ingresar")
    public void seleccionarElBotonIngresar() {
        loginRefinanciacion.ClickSubmit();

    }

    @Then("el sistema SGCRED muestra el menu principal")
    public void el_sistema_sgcred_muestra_el_menu_principal() {

    }

    @Then("en el menu principal seleccionar PROPUESTA DE FINANCIAMIENTO")
    public void en_el_menu_principal_seleccionar_propuesta_de_financiamiento() {
        menuRefinanciacion.ClickPropuestaFinanciamiento();

    }

    @Then("en Listado de propuestas seleccionar el boton crear nueva propuesta")
    public void en_listado_de_propuestas_seleccionar_el_boton_crear_nueva_propuesta() {
        listadoPropuestaRefinanciacion.ClickBtnCrearPropuesta();

    }

    @And("en Busqueda de clientes seleccionar el tab CODIGO")
    public void enBusquedaDeClientesSeleccionarElTabCODIGO() {

        listadoClientesRefinanciacion.SeleccionarTabCodigo();
    }

    @And("en Busqueda de clientes ingresar el codcli {string}")
    public void enBusquedaDeClientesIngresarElCodcli(String codCli) {
        listadoClientesRefinanciacion.IngresarCodigoCliente(codCli);
    }

    @Then("en Busqueda de clientes hacer click en el boton buscar")
    public void en_busqueda_de_clientes_hacer_click_en_el_boton_buscar() {
        listadoClientesRefinanciacion.ClickBuscarCliente();

    }

    @Then("en Busqueda de clientes seleccionar el icono informacion desactualizada")
    public void en_busqueda_de_clientes_seleccionar_el_icono_informacion_desactualizada() {
        listadoClientesRefinanciacion.SeleccionarIconoPropuesta();

    }

    @Then("en la ventana Requisitos propuesta seleccionar los siguientes campos:")
    public void en_la_ventana_requisitos_propuesta_seleccionar_los_siguientes_campos(DataTable Servicio) {
        seleccionarServicio.AbrirVentanaServicio();
        List<Map<String, String>> listadoServicio = Servicio.asMaps(String.class, String.class);
        {
            for (int i = 0; i < listadoServicio.size(); i++) {
                seleccionarServicio.SeleccionarServicio(listadoServicio.get(i).get("TipoServicio"));
                seleccionarServicio.SeleccionarServicioCredito(listadoServicio.get(i).get("ServicioCredito"));
                seleccionarServicio.SeleccionarTipoPropuesta(listadoServicio.get(i).get("TipoPropuesta"));
                seleccionarServicio.SeleccionarSubTipoPropuesta(listadoServicio.get(i).get("SubTipoPropuesta"));
                seleccionarServicio.SeleccionarPromocion(listadoServicio.get(i).get("Promocion"));
                seleccionarServicio.SeleccionarTipoOperacion(listadoServicio.get(i).get("TipoOperacion"));
            }

        }

    }


    @And("en la ventana Requisitos hacer click en el boton seleccionar pagare")
    public void enLaVentanaRequisitosHacerClickEnElBotonSeleccionarPagare() {
        seleccionarServicio.SeleccionarPagare();

    }


    @And("en la ventana Requisitos hacer click en el boton cargar")
    public void enLaVentanaRequisitosHacerClickEnElBotonCargar() {

        seleccionarServicio.ClickBtnCargar();
        seleccionarServicio.CerrarVentanaServicio();
    }

    @Then("el sistema muestra ventana propuesta y doy cierro el comunicado")
    public void elSistemaMuestraVentanaPropuestaYDoyCierroElComunicado() {
        popUpComunicado.ValidarComunicado();
    }

    @And("en la ventana propuesta seccion cancelar pagare seleccionar condiciones a refinanciar")
    public void enLaVentanaPropuestaSeccionCancelarPagareSeleccionarCondicionesARefinanciar() {
        propuesta.CapturarNumeroPropuesta();
        propuesta.ClickIconoCondicionRefinanciar();

    }


    @And("en la ventana condiciones a refinanciar ingresar el siguiente dato")
    public void enLaVentanaCondicionesARefinanciarIngresarElSiguienteDato(DataTable listadoCondicion) {
        condicionesRefinanciar.AbrirVentanaCondicionRefinanciar();

        List<Map<String, String>> lista = listadoCondicion.asMaps(String.class, String.class);
        {
            for (int i = 0; i < lista.size(); i++) {
                condicionesRefinanciar.IngresarMontoAmortizar(lista.get(i).get("MontoAmortizar"));
                condicionesRefinanciar.IngresarInteresRefinanciar(lista.get(i).get("InteresRefinanciar"));

            }


        }
    }

    @And("en la ventana condiciones a refinanciar hacer click en grabar")
    public void enLaVentanaCondicionesARefinanciarHacerClickEnGrabar() {
        condicionesRefinanciar.ClickBtnGrabar();
        condicionesRefinanciar.CerrarVentanaCondicionRefinanciar();
    }

    @And("en la ventana Propuesta doy click en el boton nueva operacion")
    public void enLaVentanaPropuestaDoyClickEnElBotonNuevaOperacion() {

        propuesta.ClickBtnOperacion();
    }

    @And("en la ventana Seleccionar Operacion Credito doy click en aceptar")
    public void enLaVentanaSeleccionarOperacionCreditoDoyClickEnAceptar() {
        seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOperacionCredito.ValidarVentanaOP();
        }catch (Exception Error){
            System.out.println("Error al hacer click en el boton aceptar" +Error.getMessage());
        }
        seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();


    }


    @And("en la ventana Operacion Credito ingresar los campos correspondientes al credito")
    public void enLaVentanaOperacionCreditoIngresarLosCamposCorrespondientesAlCredito() {
        operacionCredito.AbrirVentanaOperacionCredito();
    }

    @And("en la ventana Operacion Credito seleccionar el boton calcular tasa")
    public void enLaVentanaOperacionCreditoSeleccionarElBotonCalcularTasa() {
        operacionCredito.ClickBtnCalcularRefinanciacion();
    }

    @And("en la ventana Operacion Credito ingresar el campo plan de pagos {string}")
    public void enLaVentanaOperacionCreditoIngresarElCampoPlanDePagos(String PlanPagos) {
        operacionCredito.SeleccionarPlanPagos(PlanPagos);
    }

    @And("en la ventana Operacion Credito seleccionar el campo modalidad {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElCampoModalidad(String Modalidad) {
        operacionCredito.SeleccionarModalidad(Modalidad);
    }

    @And("en la ventana Operacion Credito seleccionar el campo opcion {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElCampoOpcion(String OpcionPagos) {
        operacionCredito.SeleccionarOpcionPagos(OpcionPagos);

    }

    @And("en la ventana Operacion Credito seleccionar el campo dias de pago {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElCampoDiasDePago(String DiaPagos) {
        operacionCredito.SeleccionarDiaPagos(DiaPagos);


    }

    @And("en la ventana Operacion Credito seleccionar el numero de cuotas {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElNumeroDeCuotas(String NumeroCuotas) {
        operacionCredito.IngresarNumeroCuotas(NumeroCuotas);

    }

    @And("en la ventana Operacion Credito ingresar el campo tasa preferencial {string}")
    public void enLaVentanaOperacionCreditoIngresarElCampoTasaPreferencial(String TasaPreferencial) {
        operacionCredito.IngresarTasaPreferencial(TasaPreferencial);


    }

    @And("en la ventana Operacion Credito seleccionar el la forma de desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarElLaFormaDeDesembolso(String FormaDesembolso) {
        operacionCredito.SeleccionarFormaDesembolso(FormaDesembolso);


    }

    @And("en la ventana Operacion Credito ingresar el campo fecha de desembolso")
    public void enLaVentanaOperacionCreditoIngresarElCampoFechaDeDesembolso() {
        operacionCredito.IngresarFechaDesembolso();

    }

    @And("en la ventana Operacion Credito ingresar el campo Notas {string}")
    public void enLaVentanaOperacionCreditoIngresarElCampoNotas(String Notas) {
        operacionCredito.IngresarNotas(Notas);

    }

    @And("en la ventana Operacion Credito hacer click en boton grabar")
    public void enLaVentanaOperacionCreditoHacerClickEnBotonGrabar() {
        operacionCredito.ClickBtnGrabar();
    }

    @And("en la ventana Operacion Credito hacer click en alerta y cerrar ventana")
    public void enLaVentanaOperacionCreditoHacerClickEnAlertaYCerrarVentana() {
        operacionCredito.ObtenerAlerta();
        operacionCredito.CerrarVentanaOperacionCredito();
    }

    @And("en la ventana principal propuesta seleccionar el boton seguros")
    public void enLaVentanaPrincipalPropuestaSeleccionarElBotonSeguros() {
        propuesta.ClickBtnRegistrarSeguro();

    }

    @And("en la ventana Selecionar seguros hacer click en confirmar")
    public void enLaVentanaSelecionarSegurosHacerClickEnConfirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

    }

    @And("en la ventana Seguros ingresar informacion correspondiente y hacer click en confirmar")
    public void enLaVentanaSegurosIngresarInformacionCorrespondienteYHacerClickEnConfirmar() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenMN();
        registrarSeguros.ObtenerNumeroAleatorioDPSSeguroDesgravamen();
        registrarSeguros.ClickBtnConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();
    }

    @And("en la ventana confirmar seguros click en confirmar y cerrar ventana")
    public void enLaVentanaConfirmarSegurosClickEnConfirmarYCerrarVentana() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickBtnCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();
    }
}
