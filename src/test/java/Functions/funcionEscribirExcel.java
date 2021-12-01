package Functions;

import Definitions.Hooks;
import PageObjects.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class funcionEscribir {

    private static LoginPage login;

    private static MenuPrincipalPage menuPrincipal;
    private static ListadoPropuestaPage listadoPropuesta;
    private static ListadoClientesPage listadoClientes;
    private static SeleccionarServicioPage seleccionarServicio;
    private static  PopUpComunicadoPage popUpComunicado;
    private static PropuestaPage propuesta;
    private static CondicionesRefinanciarPage condicionesRefinanciar;
    private static SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    private static OperacionCreditoPage operacionCredito;
    private static  SeleccionarSegurosPage seleccionarSeguros;
    private static  RegistrarSegurosPage registrarSeguros;
    private static  ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    private static AnexarChecklistPage anexarCheckListCreditos;
    private static ConfirmacionChecklistPage confirmarCheckList;
    private static  SeleccionarGarantiaPage seleccionarGarantia;
    private static  SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    private static CancelandoPagaresPage cancelandoPagares;

    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    InformeEEFFConsolidadoGrupoVinculadoPage informeEEFFConsolidadoGrupoVinculado;
    GrabarInformacionDocumentoPage grabarPropuesta;

    public funcionEscribir() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);

        cancelandoPagares = new CancelandoPagaresPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        informeEEFFConsolidadoGrupoVinculado = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        

    }

    public static void main(String args[])  {
        

        try {


            File archivoExcel = new File("C:\\CajaPiuraCMAC2021\\target\\DatosExcel\\DatosCreditoEmpresarialRefinanciacionEspecial.xlsx");
            FileInputStream inputStreamExcel = new FileInputStream(archivoExcel);
            // Obtenemos Libro
            XSSFWorkbook libroExcel = new XSSFWorkbook(inputStreamExcel);
            // Obtenemos numero de Hoja
            XSSFSheet hojaExcel = libroExcel.getSheetAt(0);

            // hojaExcel.getRow(1).createCell(20).setCellValue(2222222);

            int rowCount = hojaExcel.getLastRowNum()-hojaExcel.getFirstRowNum();

            Hooks.driver.get("http://10.0.203.16:8082/propuesta/");

            login.IngresarUsuario("ALPAMA");
            login.IngresarPassword("prueba");




            FileOutputStream outputStream = new FileOutputStream(archivoExcel);
            libroExcel.write(outputStream);
            outputStream.close();


        } catch (Exception Error) {
            System.out.println(Error.getMessage());
        }

    }

}
