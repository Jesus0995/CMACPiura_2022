package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static Support.screenshot.pantallazo;

public class ExcelEmitirDictamenPropuestaCreditoDefinitions {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionDocumentoPage grabarPropuesta;
    String Valor;
    ExcelPage excel;



    public ExcelEmitirDictamenPropuestaCreditoDefinitions() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        excel = new ExcelPage();

    }

    @Given("el sistema SGCRED se encuentra disponible para su uso")
    public void el_sistema_sgcred_se_encuentra_disponible_para_su_uso() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/logout.jsp");

    }

    @When("el usuario y password del perfil ADN tengan las credenciales correctas")
    public void el_usuario_y_password_del_perfil_adn_tengan_las_credenciales_correctas(DataTable userEmitir) {
        List<Map<String, String>> lista = userEmitir.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }

    @And("hacer click en el boton ingresar y el sistema muestra el menu principal")
    public void hacer_click_en_el_boton_ingresar_y_el_sistema_muestra_el_menu_principal() {
        login.ClickSubmit();
        login.ValidarSesionesWeb();

    }

    @Then("ejecutar todos los pasos para la emision de dictamen desde excel {string};")
    public void ejecutar_todos_los_pasos_para_la_emision_de_dictamen_desde_excel(String arg0) {
        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);
        for (int i = 1; i < datosExcel.length; i++) {
            menuPrincipal.ClickPropuestaFinanciamiento();
            listadoPropuesta.ClickTipoBusquedaAprobacion();
            listadoPropuesta.IngresarNumeroPropuesta(datosExcel[i][20]);
            System.out.println("El numero de propuesta es " + datosExcel[i][20]);
            listadoPropuesta.ClickBtnBuscar();
            listadoPropuesta.ClickEditarPropuesta();
            popUpComunicado.ValidarComunicado();
            propuesta.AbrirOpcionesDictamen();
            propuesta.ClickBtnAprobarPropuesta();

            aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
            aprobarDictamenPropuesta.IngresarObservaciones(datosExcel[i][18]);
            aprobarDictamenPropuesta.IngresarContrasena(datosExcel[i][19]);
            aprobarDictamenPropuesta.ClickBtnProcesar();
            aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();

            grabarPropuesta.AbrirVentanaGrabarPropuesta();
            Valor = grabarPropuesta.CapturarMensajeDerivacion();
            excel.EscribirExcel(arg0,0,i,21,Valor);

            grabarPropuesta.ClickBtnCerrarInformacion();
            grabarPropuesta.CerrarVentanaGrabarPropuesta();

            if (Valor.equals("El Documento ha sido derivado satisfactoriamente")){
                listadoPropuesta.ClickBtnRegresar();
            }
            else {
                propuesta.ClickBtnRegresar();

                listadoPropuesta.ClickBtnRegresar();
            }
        }
        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();

    }


}
