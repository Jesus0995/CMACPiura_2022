package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ProbarDefinitions {

    PropuestaPage propuesta;
    SeleccionarSegurosPage selecseguros;
    RegistrarSegurosPage registroseg;

    public ProbarDefinitions() {
        propuesta = new PropuestaPage(Hooks.driver);
        selecseguros = new SeleccionarSegurosPage(Hooks.driver);
        registroseg = new RegistrarSegurosPage(Hooks.driver);
    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("file:///C:/Users/Usuario/Documents/Propuesta.html");

    }
    @When("pruebaa")
    public void pruebaa() {
 propuesta.ClickBtnRegistrarSeguro();
 selecseguros.AbrirVentanaSeleccionarSeguros();
 selecseguros.ClickbtnConfirmar();
 selecseguros.CerrarVentanaSeleccionarSeguros();
 registroseg.AbrirVentanaRegistrarSeguros();
 registroseg.ClickCheckSeguroDesgravamenMN();
 registroseg.ObtenerNumeroAleatorioDPSSeguroDesgravamen();
 registroseg.ClickCheckSeguroRiesgoPlanPymes();
 registroseg.ObtenerNumeroAleatorioDPSeguroRiesgoPlanPymes();
 registroseg.CerrarVentanaRegistrarSeguros();
 propuesta.ClickAnexarCheckListCreditos();







        }
    }







