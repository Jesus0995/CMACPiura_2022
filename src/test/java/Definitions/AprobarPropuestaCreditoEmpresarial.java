package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class AprobarPropuestaCreditoEmpresarial {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionDocumentoPage grabarDocumentoPropuesta;

    public void elSistemaSGCREDSeEncuentraDisponible() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);


    }

    @Given("el sistema SGCRED se encuentra disponible")
    public void el_sistema_sgcred_se_encuentra_disponible() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }
    @When("ingreso usuario y password del Perfil Jefe de Credito Agencia")
    public void ingreso_usuario_y_password_del_perfil_jefe_de_credito_agencia(DataTable DatosUsuario) {
        List<Map<String,String>> lista = DatosUsuario.asMaps(String.class, String.class);
        for (int i= 0; i< lista.size();i++ ) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }
    @When("en la ventana doy click en el boton Ingresar de la web SGCRED")
    public void en_la_ventana_doy_click_en_el_boton_ingresar_de_la_web_sgcred() {
        login.ClickSubmit();

    }
    @When("el sistema muestra el menu principal de SGCRED")
    public void el_sistema_muestra_el_menu_principal_de_sgcred() {


    }
    @When("en el menu doy click en la opcion propuesta de financiamiento")
    public void en_el_menu_doy_click_en_la_opcion_propuesta_de_financiamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();

    }
    @When("en la ventana Listado de Propuestas seleccionar el tipo de busqueda por numero de propuesta")
    public void en_la_ventana_listado_de_propuestas_seleccionar_el_tipo_de_busqueda_por_numero_de_propuesta() {
        listadoPropuesta.ClickTipoBusquedaAprobacion();
    }
    @When("en la ventana Listado de Propuestas ingresar el numero de propuesta {string}")
    public void en_la_ventana_listado_de_propuestas_ingresar_el_numero_de_propuesta(String Propuesta) {
        listadoPropuesta.IngresarNumeroPropuesta(Propuesta);
    }
    @When("en la ventana Listado de Propuestas doy click en el boton Buscar")
    public void en_la_ventana_listado_de_propuestas_doy_click_en_el_boton_buscar() {
        listadoPropuesta.ClickBtnBuscar();
    }
    @When("en la ventana Listado de Propuestas doy click en el boton Editar")
    public void en_la_ventana_listado_de_propuestas_doy_click_en_el_boton_editar() {
        listadoPropuesta.ClickEditarPropuesta();
    }
    @When("el sistema muestra Comunicado y doy en cerrar")
    public void el_sistema_muestra_comunicado_y_doy_en_cerrar() {
        popUpComunicado.ValidarComunicado();

    }
    @When("en la ventana Propuesta doy click en el menu Emitir Dictamen y seleccionar Aprobar")
    public void en_la_ventana_propuesta_doy_click_en_el_menu_emitir_dictamen_y_seleccionar_aprobar() {
        propuesta.ClickBtnAprobarPropuesta();

    }
    @When("en la ventana ventana Emitir Dictamen ingresar Observaciones y Clave")
    public void en_la_ventana_ventana_emitir_dictamen_ingresar_observaciones_y_clave(DataTable Datos) {

        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = Datos.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }


    }



}
