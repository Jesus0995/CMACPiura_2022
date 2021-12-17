package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static Support.screenshot.pantallazo;

public class InformeComercialCreditoEmpresarialDefinitions {
    LoginPage loginSGCRED;
    MenuPrincipalPage menuPrincipal;
    ListadoInformeVisitaPage listadoInformeComercial;
    InformeVisita_SeleccionarRubroNegocioPage seleccionarRubroNegocio;
    InformeVisita_InformePage listaInformes;
    InformeComercialNuevoPage informeComercial;
    GrabarInformacionDocumentoPage grabarInformeComercial;

    public InformeComercialCreditoEmpresarialDefinitions() {
        loginSGCRED = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoInformeComercial = new ListadoInformeVisitaPage(Hooks.driver);
        seleccionarRubroNegocio = new InformeVisita_SeleccionarRubroNegocioPage(Hooks.driver);
        listaInformes = new InformeVisita_InformePage(Hooks.driver);
        informeComercial = new InformeComercialNuevoPage(Hooks.driver);
        grabarInformeComercial = new GrabarInformacionDocumentoPage(Hooks.driver);

    }

    @Given("el sistema SGCRED esta disponible para usarla")
    public void el_sistema_sgcred_esta_disponible_para_usarla() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/");

    }
    @When("en la ventana login ingreso usuario y password del perfil Asesor de negocio")
    public void en_la_ventana_login_ingreso_usuario_y_password_del_perfil_asesor_de_negocio(DataTable DatosLogin) {
        List<Map<String,String>> lista = DatosLogin.asMaps(String.class,String.class);
        for (int i=0; i< lista.size();i++){
            loginSGCRED.IngresarUsuario(lista.get(i).get("usuario"));
            loginSGCRED.IngresarPassword(lista.get(i).get("password"));
        }

    }
    @When("en la ventana Login doy click en boton ingresar al SGCRED")
    public void en_la_ventana_login_doy_click_en_boton_ingresar_al_sgcred() {
        loginSGCRED.ClickSubmit();
    }
    @When("el sistema muestra el home principal de SGCRED")
    public void el_sistema_muestra_el_home_principal_de_sgcred() {    }
    @When("en el menu principal seleccionar la opcion Informe Comercial Nuevo Formato")
    public void en_el_menu_principal_seleccionar_la_opcion_informe_comercial_nuevo_formato() {
        menuPrincipal.ClickInformeComercial();
    }
    @When("en la ventana Busqueda de Clientes seleccionar el tab por Codigo e ingresar el codigo {string}")
    public void en_la_ventana_busqueda_de_clientes_seleccionar_el_tab_por_codigo_e_ingresar_el_codigo(String CodCliente) {
        listadoInformeComercial.SeleccionarTabCodigo();
        listadoInformeComercial.IngresarCodigoCliente(CodCliente);
    }
    @When("en la ventana Busqueda de Clientes doy click en el boton Buscar")
    public void en_la_ventana_busqueda_de_clientes_doy_click_en_el_boton_buscar() {
        listadoInformeComercial.ClickBuscarCliente();
    }
    @And("en la ventana Busqueda de Clientes doy click en el icono Ver Informe")
    public void enLaVentanaBusquedaDeClientesDoyClickEnElIconoVerInforme() {
        listadoInformeComercial.SeleccionarIconoInformeComercial();
    }
    @And("el sistema direcciona a la ventana Defina el negocio y doy click en el boton Cargar")
    public void elSistemaDireccionaALaVentanaDefinaElNegocioYDoyClickEnElBotonCargar() {
        seleccionarRubroNegocio.AbrirVentanaRubroNegocio();
        seleccionarRubroNegocio.ClickBtnCargar();
        seleccionarRubroNegocio.CerrarVentanaRubroNegocio();
    }
    @And("en la ventana Informes Comerciales doy click en el boton Crear Informe Comercial")
    public void enLaVentanaInformesComercialesDoyClickEnElBotonCrearInformeComercial() {
        listaInformes.ClickBtnCrear();
    }
    @Then("el sistema muestra la ventana principal Informe Comercial para ingresar el Patrimonio Personal {string}")
    public void elSistemaMuestraLaVentanaPrincipalInformeComercialParaIngresarElPatrimonioPersonal(String PatrimonioComercial) {
        informeComercial.IngresarPatrimonioComercial(PatrimonioComercial);
    }
    @And("en la ventana principal Informe Comercial doy click en el boton grabar")
    public void enLaVentanaPrincipalInformeComercialDoyClickEnElBotonGrabar() {
        informeComercial.ClickBtnGrabar();
    }
    @And("en la ventana principal Informe Comercial doy click en el boton Regresar")
    public void enLaVentanaPrincipalInformeComercialDoyClickEnElBotonRegresar() throws IOException {
        pantallazo();
        informeComercial.ClickBtnRegresar();
    }
    @And("el sistema direcciona a la ventana listado de informes comerciales y doy click en Regresar")
    public void elSistemaDireccionaALaVentanaListadoDeInformesComercialesYDoyClickEnRegresar() {
        listaInformes.ClickBtnRegresarInformeComercial();
    }
    @And("el sistema direcciona al Menu Principal SGCRED y doy click en la opcion Cerrar Sesion")
    public void elSistemaDireccionaAlMenuPrincipalSGCREDYDoyClickEnLaOpcionCerrarSesion() {
        menuPrincipal.ClickBtnCerrarSesion();
    }
    @And("el sistema direcciona al Login y doy click en el boton Cerrar Sesion")
    public void elSistemaDireccionaAlLoginYDoyClickEnElBotonCerrarSesion() {
        loginSGCRED.ClickBtnCerrarSesion();

    }

    @And("finalmente cerrar el navegador")
    public void finalmenteCerrarElNavegador() {
        Hooks.driver.close();

    }
}
