package Definitions;

import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;


public class LoginDefinitions {

    //Crear Variables de Menu Page
    LoginPage formulario;
    ConfirmarCierreSesionPage CierreSesion;
    LogoutPage Logout;

    //crear constructor
    public LoginDefinitions() {

        formulario = new LoginPage(Hooks.driver);
        CierreSesion = new ConfirmarCierreSesionPage(Hooks.driver);
        Logout = new LogoutPage(Hooks.driver);
    }

    @Given("La web esta disponible")
    public void la_web_esta_disponible() {

        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("ingrese Usuario como {string} y Password como {string}")
    public void ingreseUsuarioComoYPasswordComo(String Usuario, String Password) {
        formulario.IngresarUsuario(Usuario);
        formulario.IngresarPassword(Password);

    }


    @And("doy click en boton ingresar")
    public void doy_click_en_boton_ingresar() {

        formulario.ClickSubmit();
    }

    @And("me muestra el home page")
    public void memuestra_el_home_page() {

    }


    @Then("doy click en cerrar sesion")
    public void doyClickEnCerrarSesion() {
        formulario.ClickBtnCerrarSesion();

    }


    @And("confirmo el cierre de sesion")
    public void confirmoElCierreDeSesion() {

        CierreSesion.ClickBtnConfirmarCierre();
    }


    @Then("puedo iniciar nueva sesion")
    public void puedoIniciarNuevaSesion() {
        Logout.ClickIniciarNuevaSesion();

    }
}

