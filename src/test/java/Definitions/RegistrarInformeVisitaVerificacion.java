package Definitions;

import PageObjects.ListadoClientesPage;
import PageObjects.ListadoFormatoVerificacionPage;
import PageObjects.LoginPage;
import PageObjects.MenuPrincipalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class RegistrarInformeVisitaVerificacion {
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoFormatoVerificacionPage listadoFormatoVerificacion;
    ListadoClientesPage listadoClientes;


    public RegistrarInformeVisitaVerificacion() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoFormatoVerificacion = new ListadoFormatoVerificacionPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);

    }

    @Given("la URL del SGCRED este disponible")
    public void la_url_del_sgcred_este_disponible() {
        Hooks.driver.get("http://10.0.203.16:8082/propuesta/");

    }
    @When("se ingresa las credenciales del jefe de credito")
    public void se_ingresa_las_credenciales_del_jefe_de_credito(DataTable userjefe) {


    }
    @When("hacemos click en el boton ingresar para visualizar el menu principal")
    public void hacemos_click_en_el_boton_ingresar_para_visualizar_el_menu_principal() {
        login.ClickSubmit();

    }
    @Then("ejecutamos los pasos definidos desde el archivo excel {string}")
    public void ejecutamos_los_pasos_definidos_desde_el_archivo_excel(String arg0) {

    }



}
