package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class RegistrarInformeVisitaVerificacionDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoFormatoVerificacionPage listadoFormatoVerificacion;
    ListadoClientesPage listadoClientes;
    DefinaPropuestaPage definaPropuesta;
    InformesVerificacionesPage informesVerificaciones;
    InformeVisitaVerificacionPage informeVisitaVerificacion;
    GrabarInformacionDocumentoPage grabarDocumento;


    ExcelPage excel;


    public RegistrarInformeVisitaVerificacionDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoFormatoVerificacion = new ListadoFormatoVerificacionPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        definaPropuesta = new DefinaPropuestaPage(Hooks.driver);
        informesVerificaciones = new InformesVerificacionesPage(Hooks.driver);
        informeVisitaVerificacion = new InformeVisitaVerificacionPage(Hooks.driver);
grabarDocumento = new GrabarInformacionDocumentoPage(Hooks.driver);


        excel = new ExcelPage();

    }

    @Given("la URL del SGCRED este disponible")
    public void la_url_del_sgcred_este_disponible() {
        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");

    }

    @When("se ingresa las credenciales del jefe de credito")
    public void se_ingresa_las_credenciales_del_jefe_de_credito(DataTable userjefe) {
        List<Map<String, String>> lista = userjefe.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));

        }

    }

    @When("hacemos click en el boton ingresar para visualizar el menu principal")
    public void hacemos_click_en_el_boton_ingresar_para_visualizar_el_menu_principal() {
        login.ClickSubmit();

    }

    @Then("ejecutamos los pasos definidos desde el archivo excel {string}")
    public void ejecutamos_los_pasos_definidos_desde_el_archivo_excel(String arg0) {
        String[][] datosExcel;

        datosExcel = excel.LeerArchivoExcel(arg0, 0);
        for (int i = 1; i < datosExcel.length; i++) {

            menuPrincipal.ClickInformeVisitaVerificacion();
            listadoFormatoVerificacion.ClickBtnBuscar();
            listadoFormatoVerificacion.ClickBtnIngresarNuevoFormato();
            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoClienteInformeVisita(datosExcel[i][0]);
            listadoClientes.ClickBtnBuscarCodigoClienteInformeVisita();
            listadoClientes.SeleccionarVerInformeVisita();
            definaPropuesta.AbrirVentanaDefinaPropuesta();
            definaPropuesta.ClickBtnCargar();
            definaPropuesta.CerrarVentanaDefinaPropuesta();
            informesVerificaciones.ClickBtnCrearInformeVerificacion();
            informeVisitaVerificacion.IngresarFechaInicioVisita();
            informeVisitaVerificacion.IngresarFechaFinVisita();
            informeVisitaVerificacion.IngresarHoraInicioVisita(datosExcel[i][1]);
            informeVisitaVerificacion.IngresarMinInicioVisita(datosExcel[i][2]);
            informeVisitaVerificacion.IngresarHoraFinVisita(datosExcel[i][3]);
            informeVisitaVerificacion.IngresarMinFinVisita(datosExcel[i][4]);
            informeVisitaVerificacion.IngresarHoraEmpleadaVisita(datosExcel[i][5]);
            informeVisitaVerificacion.IngresarMinEmpleadaVisita(datosExcel[i][6]);
            informeVisitaVerificacion.IngresarComentarios();
            informeVisitaVerificacion.IngresarDetalleResultado(datosExcel[i][7]);
            informeVisitaVerificacion.ClickBtnGrabar();
            grabarDocumento.AbrirVentanaGrabarPropuesta();
            grabarDocumento.ClickBtnCerrarInformacion();
            grabarDocumento.CerrarVentanaGrabarPropuesta();
            informeVisitaVerificacion.ClickBtnFinalizar();

            grabarDocumento.AbrirVentanaGrabarPropuesta();
            grabarDocumento.ClickBtnCerrarInformacion();
            grabarDocumento.CerrarVentanaGrabarPropuesta();

            listadoFormatoVerificacion.ClickBtnRegresar();

        }


    }
}
