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

    //crear constructor
    public LoginDefinitions() {
        formulario = new LoginPage(Hooks.driver);
    }

    @Given("La web esta disponible")
    public void la_web_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("ingrese usuario y password")
    public void ingreseusuarioypassword(DataTable usuarios) {
        List<Map<String, String>> lista = usuarios.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            formulario.IngresarUsuario(lista.get(i).get("nombre"));
            formulario.IngresarPassword(lista.get(i).get("password"));

        }
    }
    @And("doy click en boton ingresar")
    public void doy_click_en_boton_ingresar() {
            formulario.ClickSubmit();
    }
    @Then("me muestra el home page")
    public void memuestra_el_home_page() {

    }



}


