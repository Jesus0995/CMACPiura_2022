package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialRefinanciacionEspecial {

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

    ExcelPage excel;


    public ExcelCreditoEmpresarialRefinanciacionEspecial() {

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

        excel = new ExcelPage();

    }




    @Given("la pagina web SGCRED esta disponible para su uso")
    public void la_pagina_web_sgcred_esta_disponible_para_su_uso() {
        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");

    }
    @When("el usuario y password tengan lo siguiente")
    public void el_usuario_y_password_tengan_lo_siguiente(DataTable users) {
        List<Map<String, String>> lista = users.asMaps(String.class, String.class);

        for (int i = 0; i < lista.size(); i++) {
            loginRefinanciacion.IngresarUsuario(lista.get(i).get("Usuario"));
            loginRefinanciacion.IngresarPassword(lista.get(i).get("Password"));

        }

    }
    @When("hacer click en el boton ingresar y muestra el menu principal")
    public void hacer_click_en_el_boton_ingresar_y_muestra_el_menu_principal() {
        loginRefinanciacion.ClickSubmit();

    }
    @Then("ejecutar los registros de propuestas de Credito Empresarial Refinanciacion Especial desde Excel {string}")
    public void ejecutar_los_registros_de_propuestas_de_credito_empresarial_refinanciacion_especial_desde_excel(String string) {
        menuRefinanciacion.ClickPropuestaFinanciamiento();

        listadoPropuestaRefinanciacion.ClickBtnCrearPropuesta();
        listadoClientesRefinanciacion.SeleccionarTabCodigo();
        listadoClientesRefinanciacion.IngresarCodigoCliente(codCli);
        listadoClientesRefinanciacion.ClickBuscarCliente();
        listadoClientesRefinanciacion.SeleccionarIconoPropuesta();
        seleccionarServicio.AbrirVentanaServicio();
        seleccionarServicio.SeleccionarServicio(listadoServicio.get(i).get("TipoServicio"));
        seleccionarServicio.SeleccionarServicioCredito(listadoServicio.get(i).get("ServicioCredito"));
        seleccionarServicio.SeleccionarTipoPropuesta(listadoServicio.get(i).get("TipoPropuesta"));
        seleccionarServicio.SeleccionarSubTipoPropuesta(listadoServicio.get(i).get("SubTipoPropuesta"));
        seleccionarServicio.SeleccionarPromocion(listadoServicio.get(i).get("Promocion"));
        seleccionarServicio.SeleccionarTipoOperacion(listadoServicio.get(i).get("TipoOperacion"));

    }


}
