package Definitions;

import PageObjects.ListadoClientesPage;
import PageObjects.ListadoPropuestaPage;
import PageObjects.LoginPage;
import PageObjects.MenuPrincipalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;

    public ExcelCreditoEmpresarialReprogramacionOtroPagareDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
    }

    @Given("la pagina web SGCRED es correcto")
    public void laPaginaWebSGCREDEsCorrecto() {
        Hooks.driver.get("http://10.0.203.16:8083/propuesta/");
    }

    @When("digita el usuario y password")
    public void digitaElUsuarioYPassword(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("se da click en el boton ingresar y muestra el SGCRED")
    public void seDaClickEnElBotonIngresarYMuestraElSGCRED() {

        login.ClickSubmit();

    }

    @Then("registrar las propuestas de reprogramacion de creditos desde Excel {string}")
    public void registrarLasPropuestasDeReprogramacionDeCreditosDesdeExcel(String arg0) {
    }

}
