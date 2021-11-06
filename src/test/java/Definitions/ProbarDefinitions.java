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
        selecseguros = new SeleccionarSegurosPage(Hooks.driver);
        registroseg = new RegistrarSegurosPage(Hooks.driver);
    }

    @Given("la pagina esta disponible")
    public void la_pagina_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");

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

    @When("pruebaa de excel")
    public void pruebaaDeExcel() {
        objExcel.LeerExcel("Matriz.xlsx",0);
        objExcel.LeerCeldaExcel("Matriz.xlsx",0,2,1);

    }
}







