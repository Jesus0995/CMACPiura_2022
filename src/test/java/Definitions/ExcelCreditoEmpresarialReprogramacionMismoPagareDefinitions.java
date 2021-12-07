package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialReprogramacionMismoPagareDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage servicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    CondicionesReprogramacionPage condicionesReprogramacion;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    GrabarInformacionDocumentoPage grabarPropuesta;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    ExcelPage excel;
    String Valor;

    public ExcelCreditoEmpresarialReprogramacionMismoPagareDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        servicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesReprogramacion = new CondicionesReprogramacionPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        excel = new ExcelPage();
    }

    @Given("la pagina web SGCRED esta apto")
    public void laPaginaWebSGCREDEstaApto() {

        Hooks.driver.get("http://10.0.203.16:8082/propuesta/index.jsp");
    }

    @When("digito el usuario y password")
    public void digitoElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }

    @And("se da click el boton ingresar y muestra el SGCRED")
    public void seDaClickElBotonIngresarYMuestraElSGCRED() {

        login.ClickSubmit();

    }

    @Then("registrar propuestas de reprogramacion de creditos desde Excel {string}")
    public void registrarPropuestasDeReprogramacionDeCreditosDesdeExcel(String arg0) throws InterruptedException {

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
            servicio.SeleccionarTipoOperacion(datosExcel[i][5]);
            servicio.SeleccionarPagare(datosExcel[i][6]);
            servicio.ClickBtnSeleccionarPagare();
            servicio.ClickBtnCargar();
            servicio.CerrarVentanaServicio();

            popUpComunicado.ValidarComunicado();

            propuesta.ClickBtnSolicitarReprogramacion();

            condicionesReprogramacion.AbrirVentanaCondicionesReprogramacion();
            condicionesReprogramacion.IngresarAmortizacionReprogramacion(datosExcel[i][7]);
            condicionesReprogramacion.SeleccionarCambioTasaReprogramacion(datosExcel[i][8]);
            condicionesReprogramacion.ClickBtnSiguienteReprogramacion();
            condicionesReprogramacion.SeleccionarTipoCronograma(datosExcel[i][10]);
            condicionesReprogramacion.SeleccionarModalidadAmortizacion(datosExcel[i][11]);
            condicionesReprogramacion.SeleccionarModalidadPago(datosExcel[i][12]);
            condicionesReprogramacion.SeleccionarTipoCalculo(datosExcel[i][13]);
            condicionesReprogramacion.IngresarNumeroCuotas(datosExcel[i][14]);
            condicionesReprogramacion.IngresarFechaPago(datosExcel[i][15]);
            condicionesReprogramacion.IngresarInforme(datosExcel[i][9]);
            condicionesReprogramacion.ClickBtnGrabar();
            condicionesReprogramacion.ObtenerAlerta();
            condicionesReprogramacion.CerrarVentanaCondicionesReprogramacion();

            propuesta.ClickEnlazarEEFF();
            enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
            enlazarEstadosFinancieros.ClickbtnEnlazar();
            enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

            propuesta.ClickDesenlazarInformeVisitaReprogramacion();
            desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
            desenlazarInformeVisita.ClickBtnRealizar();
            desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();

            propuesta.ClickEnlazarInformeVisitaReprogramacion();
            enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
            enlazarInformeVisita.ClickBtnRealizar();
            enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();

            propuesta.ClickEnlazarInformeComercialReprogramacion();
            enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
            enlazarInformeComercialNuevo.ClickBtnRealizar();
            enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();

            propuesta.IngresarComentariosPropuesta();

            propuesta.ClickMenuGrabarPropuesta();
            grabarPropuesta.AbrirVentanaGrabarPropuesta();
            grabarPropuesta.ClickBtnCerrarInformacion();
            grabarPropuesta.CerrarVentanaGrabarPropuesta();

            Valor = propuesta.CapturarNumeroPropuesta();
            excel.EscribirExcel(arg0, 0, i, 18, Valor);

            propuesta.ClickBtnRegresar();
            listadoPropuesta.ClickBtnRegresar();
        }

        menuPrincipal.ClickBtnCerrarSesion();
        login.ClickBtnCerrarSesion();
        Hooks.driver.close();
    }

}
