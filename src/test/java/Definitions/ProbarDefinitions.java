package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import Functions.funcionExcel;

public class ProbarDefinitions {

    PropuestaPage propuesta;
    SeleccionarSegurosPage selecseguros;
    RegistrarSegurosPage registroseg;
    CondicionesRefinanciarPage condicionesRefinanciar;
    OperacionCreditoPage operacionCredito;
    InformeEEFFConsolidadoGrupoVinculadoPage informe;
    GrabarInformacionDocumentoPage grabardocumento;
    ExcelPage excel;


    private funcionExcel objExcel = new funcionExcel();

    public ProbarDefinitions() {
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        informe = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        grabardocumento = new GrabarInformacionDocumentoPage(Hooks.driver);
        excel = new ExcelPage();


    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/Users/Usuario/Documents/Sistema%20de%20Gestion%20de%20Creditos-Propuesta.html");

    }


    @When("pruebaa")
    public void pruebaa() {
        propuesta.CapturarMontoLiquidacion();


    }

}








