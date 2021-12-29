package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import Functions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class ProbarDefinitions {

    LoginPage login;
    LoginPage URL;
    PropuestaPage propuesta;
    SeleccionarSegurosPage selecseguros;
    RegistrarSegurosPage registroseg;
    CondicionesRefinanciarPage condicionesRefinanciar;
    OperacionCreditoPage operacionCredito;
    InformeEEFFConsolidadoGrupoVinculadoPage informe;
    GrabarInformacionDocumentoPage grabardocumento;
    ExcelPage excel;
    String url;
    funcionEsperar funcionEsperar = new funcionEsperar();
    funcionVentana ventana = new funcionVentana();

    private funcionExcel objExcel = new funcionExcel();

    public ProbarDefinitions() {
        login = new LoginPage(Hooks.driver);
        //URL = new LoginPage(Hooks.driver1);
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        informe = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        grabardocumento = new GrabarInformacionDocumentoPage(Hooks.driver);
        excel = new ExcelPage();


    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/");

    }


   @When("escribo usuario y password")
    public void escriboUsuarioYPassword(DataTable user) {

           List<Map<String,String>> lista = user.asMaps(String.class, String.class);
           for (Map<String, String> stringStringMap : lista) {
               login.IngresarUsuario(stringStringMap.get("nombre"));
               login.IngresarPassword(stringStringMap.get("password"));
           }
    }

    @And("presionar boton ingresar")
    public void presionarBotonIngresar() {
        login.ClickSubmit();

    }

    @And("situa en home de SGCRED")
    public void situaEnHomeDeSGCRED() {

        funcionEsperar.EsperarTiempo(2);
        ventana.cerrarVentanaID();

        //url = "Problemas al cargar la página";
        //Hooks.driver1.navigate().to(url);
        //Hooks.driver1.getTitle();
        /*WebDriver driver1 = new FirefoxDriver();
        SessionId session = ((FirefoxDriver)driver1).getSessionId();
        System.out.println("Session id: " + session.toString());*/
        /*Hooks.driver.quit();
        if(Hooks.driver1.getTitle().equals(url)){
            Hooks.driver1.quit();
            System.out.println("Se cerró 2do controlador");
        }
        else{
            System.out.println("No se puede cerrar 2do controlador");
        }
        //Hooks.driver1.close();


        //Cerrar último Id: http://10.0.203.21:18080/SCORING-war/login/*/






    }
}








