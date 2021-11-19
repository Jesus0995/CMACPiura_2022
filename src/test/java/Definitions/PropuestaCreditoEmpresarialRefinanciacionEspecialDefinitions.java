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


    public PropuestaCreditoEmpresarialRefinanciacionEspecialDefinitions() {
        loginRefinanciacion = new LoginPage(Hooks.driver);
        menuRefinanciacion = new MenuPrincipalPage(Hooks.driver);
        listadoPropuestaRefinanciacion = new ListadoPropuestaPage(Hooks.driver);
        listadoClientesRefinanciacion = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);

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
        List<Map<String,String>> listadoServicio = Servicio.asMaps(String.class,String.class);{
            for(int i=0 ;i < listadoServicio.size();i++){
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


    }

    @And("en la ventana condiciones a refinanciar ingresar el siguiente dato")
    public void enLaVentanaCondicionesARefinanciarIngresarElSiguienteDato() {
    }
}
