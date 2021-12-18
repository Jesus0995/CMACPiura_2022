package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage servicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;

    /*AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;*/
    ExcelPage excel;
    String Valor;

    public ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        servicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);

        /*anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);*/
        excel = new ExcelPage();
    }

    @Given("la pagina web SGCRED es correcto")
    public void laPaginaWebSGCREDEsCorrecto() {

        Hooks.driver.get("http://10.0.203.16:8083/propuesta/");

    }

    @When("digita el usuario y password")
    public void digitaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("se da click en el boton ingresar y muestra el SGCRED")
    public void seDaClickEnElBotonIngresarYMuestraElSGCRED() {

        login.ClickSubmit();

    }

    @Then("registrar las propuestas de reprogramacion de creditos desde Excel {string}")
    public void registrarLasPropuestasDeReprogramacionDeCreditosDesdeExcel(String arg0) {
        String[][] datosExcel;
        datosExcel = excel.LeerArchivoExcel(arg0, 0);

        for (int i = 1; i < datosExcel.length; i++) {
            menuPrincipal.ClickPropuestaFinanciamiento();

            listadoPropuesta.ClickBtnCrearPropuesta();

            listadoClientes.SeleccionarTabCodigo();
            listadoClientes.IngresarCodigoCliente(datosExcel[i][0]);
            System.out.println("lectura cliente desde excel:" + datosExcel[i][0]);
            listadoClientes.ClickBuscarCliente();
            listadoClientes.SeleccionarIconoPropuesta();

            servicio.AbrirVentanaServicio();
            servicio.SeleccionarServicio(datosExcel[i][1]);
            servicio.SeleccionarServicioCredito(datosExcel[i][2]);
            servicio.SeleccionarTipoPropuesta(datosExcel[i][3]);
            servicio.SeleccionarSubTipoPropuesta(datosExcel[i][4]);
            servicio.SeleccionarPromocion(datosExcel[i][5]);
            servicio.SeleccionarTipoOperacion(datosExcel[i][6]);
            servicio.SeleccionarPagare(datosExcel[i][7]);
            servicio.ClickBtnSeleccionarPagare();
            servicio.ClickBtnCargar();
            servicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();
        }

    }
}