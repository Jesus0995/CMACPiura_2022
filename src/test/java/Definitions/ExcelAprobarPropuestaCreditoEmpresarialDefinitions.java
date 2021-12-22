package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class ExcelAprobarPropuestaCreditoEmpresarialDefinitions {

    LoginPage loginAprobar;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    AprobarCheckListCreditoPage aprobarcheckListCredito;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionDocumentoPage grabarDocumentoPropuesta;
    ExcelPage excel;
    String ValorResultado;

    public ExcelAprobarPropuestaCreditoEmpresarialDefinitions() {
        loginAprobar = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarcheckListCredito = new AprobarCheckListCreditoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarDocumentoPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        excel = new ExcelPage();

    }

    @Given("la URL del sistema SGCRED este disponible")
    public void la_url_del_sistema_sgcred_este_disponible() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/logout.jsp");

    }

    @When("se ingresa las credenciales correspondientes del aprobador")
    public void se_ingresa_las_credenciales_correspondientes_del_aprobador(DataTable dataUser) {
        List<Map<String, String>> listado = dataUser.asMaps(String.class, String.class);
        for (int i = 0; i < listado.size(); i++) {
            loginAprobar.IngresarUsuario(listado.get(i).get("usuario"));
            loginAprobar.IngresarPassword(listado.get(i).get("password"));
        }

    }

    @When("hacer click en el boton ingresar para que nos muestre el menu principal")
    public void hacer_click_en_el_boton_ingresar_para_que_nos_muestre_el_menu_principal() {
        loginAprobar.ClickSubmit();

    }

    @Then("se ejecuta los siguientes pasos para aprobar desde archivo excel {string}")
    public void se_ejecuta_los_siguientes_pasos_para_aprobar_desde_archivo_excel(String arg0) {
        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++) {

            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickTipoBusquedaAprobacion();
            listadoPropuesta.IngresarNumeroPropuesta(datosExcel[i][20]);
            listadoPropuesta.ClickBtnBuscar();
            listadoPropuesta.ClickEditarPropuesta();
            popUpComunicado.ValidarComunicado();
            /*
            propuesta.ClickBtnVerificarCheckListCredito();

            aprobarcheckListCredito.AbrirVentanaAprobarCheckListCredito();
            aprobarcheckListCredito.SeleccionarOptAprobar();
            aprobarcheckListCredito.IngresarComentarios();
            aprobarcheckListCredito.ClickBtnGuardar();
            aprobarcheckListCredito.ClickBtnCerrar();
            aprobarcheckListCredito.CerrarVentanaAprobarCheckListCredito();
            */
            propuesta.AbrirOpcionesDictamen();

            propuesta.ClickBtnAprobarPropuesta();
            aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
            aprobarDictamenPropuesta.IngresarObservaciones(datosExcel[i][18]);
            aprobarDictamenPropuesta.IngresarContrasena(datosExcel[i][19]);

            aprobarDictamenPropuesta.ClickBtnProcesar();
            aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();

            grabarDocumentoPropuesta.AbrirVentanaGrabarPropuesta();
            ValorResultado = grabarDocumentoPropuesta.CapturarMensajeDerivacion();
            excel.EscribirExcel(arg0,0,i,22,ValorResultado);
            grabarDocumentoPropuesta.ClickBtnCerrar();
            grabarDocumentoPropuesta.CerrarVentanaGrabarPropuesta();

            listadoPropuesta.ClickBtnRegresar();

        }

        menuPrincipal.ClickBtnCerrarSesion();
        loginAprobar.ClickBtnCerrarSesion();

        Hooks.driver.close();
    }
}




