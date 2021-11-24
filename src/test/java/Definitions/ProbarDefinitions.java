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


    private funcionExcel objExcel = new funcionExcel();

    public ProbarDefinitions() {
        propuesta = new PropuestaPage(Hooks.driver);
        condicionesRefinanciar = new CondicionesRefinanciarPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);


    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/Users/Usuario/Documents/Condiciones%20a%20refinanciar.html");

    }


    @When("pruebaa {string}")
    public void pruebaa(String MontoAmortizar) {
        condicionesRefinanciar.IngresarMontoAmortizar(MontoAmortizar);

    }

    @Then("pruebaaa {string}")
    public void pruebaaa(String InteresRefinanciar) {
        condicionesRefinanciar.IngresarInteresRefinanciar(InteresRefinanciar);
    }
}








