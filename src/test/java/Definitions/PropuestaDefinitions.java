package Definitions;

import PageObjects.ListadoPropuestaPage;
import PageObjects.LoginPage;
import PageObjects.MenuPrincipalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class PropuestaDefinitions {
    //crear variables de los pages
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;

    //Constructor
    public PropuestaDefinitions() {
        //Inicializar las paginas
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage( Hooks.driver);
        }


    @Given("la web SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }
    @When("ingreso usuario y password")
    public void ingreso_usuario_y_password(DataTable user) {
        List<Map<String,String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i ++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }
    @When("doy clic en boton ingresar")
    public void doy_click_en_boton_ingresar() {
        login.ClickSubmit();

    }
    @When("seleccionar link propuesta de financiamiento")
    public void seleccionar_link_propuesta_de_financiamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();

    }




}
