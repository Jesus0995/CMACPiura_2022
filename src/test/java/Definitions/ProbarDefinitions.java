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
    private funcionExcel objExcel = new funcionExcel();

    public ProbarDefinitions() {
        propuesta = new PropuestaPage(Hooks.driver);

    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/Users/Usuario/Documents/Sistema%20de%20Gestion%20de%20Creditos.html");

    }

    @When("pruebaa")
    public void pruebaa() {
        propuesta.CapturarNumeroPropuesta();



    }

}







