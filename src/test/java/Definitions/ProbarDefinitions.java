package Definitions;

import PageObjects.RegistrarSegurosPage;
import PageObjects.SeleccionarGarantiasExistentesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ProbarDefinitions {

    RegistrarSegurosPage seleccionarseguros;

    public ProbarDefinitions() {
        seleccionarseguros = new RegistrarSegurosPage(Hooks.driver);

    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/SegurosWeb/Pagina1.html");

    }
    @When("pruebaa")
    public void pruebaa() {
        seleccionarseguros.ObtenerNumeroAleatorioDPSSeguroDesgravamen();
        seleccionarseguros.ObtenerNumeroAleatorioDPSeguroRiesgoPlanPymes();

    }






}
