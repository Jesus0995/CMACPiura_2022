package Definitions;

import PageObjects.InformeVisita_CrearPage;
import PageObjects.RegistrarSegurosPage;
import PageObjects.SeleccionarGarantiasExistentesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ProbarDefinitions {

    InformeVisita_CrearPage informevisita;

    public ProbarDefinitions() {
        informevisita = new InformeVisita_CrearPage(Hooks.driver);

    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/Users/Usuario/Documents/InformeVisita.html");

    }
    @When("pruebaa")
    public void pruebaa(DataTable DatosDomicilio) {

        List<Map<String, String>> lista = DatosDomicilio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            informevisita.SeleccionarRelacion(lista.get(i).get("Relacion"));
            informevisita.SeleccionarHabitos(lista.get(i).get("Habitos"));


        }
    }






}
